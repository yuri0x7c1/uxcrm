package com.github.yuri0x7c1.uxerp.devtools.entity.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelKeyMap;
import org.apache.ofbiz.entity.model.ModelRelation;
import org.atteo.evo.inflector.English;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxerp.devtools.generator.util.GeneratorUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EntityBaseServiceGenerator implements EntityGenerator {

	public static final String TYPE_ONE = "one";
	public static final String TYPE_ONE_NOFK = "one-nofk";
	public static final String TYPE_MANY = "many";

	@Autowired
	private ModelOfbiz ofbizInstance;

	@Autowired
	private Environment env;

	@Autowired
	private GeneratorUtil generatorUtil;

	private JavaClassSource createServiceClass(ModelEntity entity) {
		JavaClassSource serviceClass = Roaster.create(JavaClassSource.class)
				.setName(entity.getEntityName() + "BaseService");

		serviceClass.addAnnotation(SuppressWarnings.class).setStringValue("unchecked");

		serviceClass.addField()
			.setName("executeFindService")
			.setType(ExecuteFindService.class.getName())
			.setPrivate()
			.addAnnotation(Autowired.class);

		return serviceClass;
	}


	/**
	 * Create find method
	 * @param entity
	 * @param serviceClass
	 * @return
	 */
	private MethodSource<JavaClassSource> createFindMethod(ModelEntity entity, JavaClassSource serviceClass) {
		MethodSource<JavaClassSource> findMethod = serviceClass.addMethod()
				.setName("find")
				.setPublic()
				.setReturnType("List<" + entity.getEntityName() + ">");

		findMethod.addParameter("Integer", "start");
		findMethod.addParameter("Integer", "number");
		findMethod.addParameter("String", "orderBy");
		findMethod.addParameter(EntityConditionList.class.getName(), "conditions");

		findMethod.setBody(String.format("	List<%s> entityList = new ArrayList<>();" +
				"		In in = new In();" +
				"		in.setEntityName(entityName);" +
				"		in.setNoConditionFind(conditions == null ? FindUtil.Y : FindUtil.N);" +
				"		Out out = executeFindService.runSync(in);" +
				"		try {" +
				"			if (out.getListIt() != null) {" +
				"				return out.getListIt().getPartialList(start, number);" +
				"			}" +
				"		}" +
				"		catch (GenericEntityException e) {" +
				"			log.error(e.getMessage(), e);" +
				"		}" +
				"		return %s.fromValues(entityList);",
				entity.getEntityName(),
				entity.getEntityName(),
				entity.getEntityName()
		));
		return findMethod;
	}

	/**
	 * Create count method
	 * @param entity
	 * @param serviceClass
	 * @return
	 */
	private MethodSource<JavaClassSource> createCountMethod(ModelEntity entity, JavaClassSource serviceClass) {
		MethodSource<JavaClassSource> countMethod = serviceClass.addMethod()
				.setName("count")
				.setPublic()
				.setReturnType(Integer.class);

		countMethod.addParameter("Map<String, String>", "inputFields");

		countMethod.setBody(String.format("		return performFindListService.runSync(\n" +
				"			PerformFindListService.In.builder()\n" +
				"				.entityName(%s.NAME)\n" +
				"				.viewIndex(1)\n" +
				"				.viewSize(1)\n" +
				"				.inputFields(inputFields != null ? inputFields : Collections.EMPTY_MAP)\n" +
				"				.noConditionFind(MapUtils.isNotEmpty(inputFields) ? FindUtil.N : FindUtil.Y)\n" +
				"				.build()\n" +
				"			).getListSize();", entity.getEntityName()));
		return countMethod;
	}

	/**
	 * Create fine one method
	 * @param entity
	 * @param serviceClass
	 * @return
	 */
	private MethodSource<JavaClassSource> createFindOneMethod(ModelEntity entity, JavaClassSource serviceClass) {
		MethodSource<JavaClassSource> findOneMethod = serviceClass.addMethod()
				.setName("findOne")
				.setPublic()
				.setReturnType(entity.getEntityName());

		List<String> conditionList = new ArrayList<>();

		for (String pkName : entity.getPkFieldNames()) {
			// add method param
			findOneMethod.addParameter("String", pkName);

			// create conditions
			conditionList.add(String.format("new EntityExpr(\"%s\", EntityOperator.EQUALS, %s)", pkName, pkName));
		}

		String conditions = "Arrays.asList(" + StringUtils.join(conditionList, ", ") + ")";

		findOneMethod.setBody(String.format("List<%s> entityList = null;" +
				"		In in = new In();" +
				"		in.setEntityName(%s.NAME);" +
				"		in.setEntityConditionList(" +
				"			new EntityConditionList<>(" +
				"				%s," +
				"				EntityOperator.AND" +
				"			)" +
				"		);" +
				"		Out out = executeFindService.runSync(in);" +
				"		try {" +
				"			if (out.getListIt() != null) {" +
				"				entityList = %s.fromValues(out.getListIt().getCompleteList());" +
				"			}" +
				"		} catch (GenericEntityException e) {" +
				"			log.error(e.getMessage(), e);" +
				"		}" +
				"		if (CollectionUtils.isNotEmpty(entityList)) {" +
				"			return entityList.get(0);" +
				"		}" +
				"		return null;",
				entity.getEntityName(),
				entity.getEntityName(),
				conditions,
				entity.getEntityName()
		));

		return findOneMethod;
	}

	/**
	 * Create relation methods
	 * @param entity
	 * @param serviceClass
	 */
	public void createRelationMethods(ModelEntity entity, JavaClassSource serviceClass) {
		for (ModelRelation relation : entity.getRelationsList(true, true, true)) {
			log.info("\tGenerate relation field for entity {}", relation.getRelEntityName());
			ModelEntity relationEntity = ofbizInstance.getEntities().get(relation.getRelEntityName());
			if (relationEntity == null) {
				log.error("\tError get relation object for entity {}. Skipping relation.", relation.getRelEntityName());
			}
			else {
				String relationType = generatorUtil.getPackageName(relationEntity) + "." + relationEntity.getEntityName();
				serviceClass.addImport(relationType);

				if (TYPE_ONE.equals(relation.getType()) ||
						TYPE_ONE_NOFK.equals(relation.getType())) {

					MethodSource<JavaClassSource> getOneRelationMethod = serviceClass.addMethod()
							.setName("get" + StringUtils.capitalize(generatorUtil.getRelationFieldName(relation)))
							.setPublic()
							.setReturnType(relationType);

					String entityVariableName = StringUtils.uncapitalize(entity.getEntityName());
					getOneRelationMethod.addParameter(entity.getEntityName(), entityVariableName);

					StringBuilder inputFields = new StringBuilder("");

					for (ModelKeyMap keyMap : relation.getKeyMaps()) {
						String fieldName = keyMap.getFieldName();
						String relFieldName = keyMap.getRelFieldName() != null ? keyMap.getRelFieldName() : fieldName;
						inputFields.append(
							String.format(
								".addInputField(%s.Fields.%s.name(), FindUtil.OPTION_EQUALS, false, %s)\n",
								relationEntity.getEntityName(),
								relFieldName,
								entityVariableName + ".get" + StringUtils.capitalize(fieldName) + "()"
							)
						);

						getOneRelationMethod.setBody(String.format("		return %s.fromValue(\n" +
								"			performFindItemService.runSync(\n" +
								"				PerformFindItemService.In.builder()\n" +
								"					.entityName(%s.NAME)\n" +
								"					.inputFields(\n" +
								"						new InputFieldBuilder()\n" +
								"							%s\n" +
								"							.build()\n" +
								"					).build()\n" +
								"			).getItem()\n" +
								"		);", relationEntity.getEntityName(), relationEntity.getEntityName(), inputFields));
					}
				}
				else if(TYPE_MANY.equals(relation.getType())) {
					MethodSource<JavaClassSource> getManyRelationMethod = serviceClass.addMethod()
							.setName("get" + StringUtils.capitalize(English.plural(generatorUtil.getRelationFieldName(relation))))
							.setPublic()
							.setReturnType("List<" + relationType + ">");

					String entityVariableName = StringUtils.uncapitalize(entity.getEntityName());
					getManyRelationMethod.addParameter(entity.getEntityName(), entityVariableName);
					getManyRelationMethod.addParameter("Integer", "viewIndex");
					getManyRelationMethod.addParameter("Integer", "viewSize");
					getManyRelationMethod.addParameter("String", "orderBy");

					StringBuilder inputFields = new StringBuilder("");

					for (ModelKeyMap keyMap : relation.getKeyMaps()) {
						String fieldName = keyMap.getFieldName();
						String relFieldName = keyMap.getRelFieldName() != null ? keyMap.getRelFieldName() : fieldName;
						inputFields.append(
							String.format(
								".addInputField(%s.Fields.%s.name(), FindUtil.OPTION_EQUALS, false, %s)\n",
								relationEntity.getEntityName(),
								relFieldName,
								entityVariableName + ".get" + StringUtils.capitalize(fieldName) + "()"
							)
						);

						getManyRelationMethod.setBody(String.format("		return %s.fromValues(\n" +
								"			performFindListService.runSync(\n" +
								"				PerformFindListService.In.builder()\n" +
								"				.viewIndex(viewIndex)\n" +
								"				.viewSize(viewSize)\n" +
								"					.inputFields(\n" +
								"						new InputFieldBuilder()\n" +
								"							%s\n" +
								"							.build()\n" +
								"				).build()\n" +
								"			).getList()\n" +
								"		);", relationEntity.getEntityName(), inputFields, relationEntity.getEntityName()));

						// getManyRelationMethod.setBody("return null;");
					}

				}
			}
		}
	}

	/**
	 * Generate code
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public String generate(ModelEntity entity) throws Exception {
		log.info("Generating entity base service: {}", entity.getEntityName());

		// create service class
		final JavaClassSource serviceClass = createServiceClass(entity);

		// add some imports
		serviceClass.addImport(Collections.class);
		serviceClass.addImport(List.class);
		serviceClass.addImport(Map.class);
		serviceClass.addImport(MapUtils.class);
		serviceClass.addImport("com.github.yuri0x7c1.uxerp.common.find.util.FindUtil");

		serviceClass.addImport(generatorUtil.getPackageName(entity) + "." + entity.getEntityName());

		// create find method
		createFindMethod(entity, serviceClass);

		// create count method
		// createCountMethod(entity, serviceClass);

		// create find one method
		createFindOneMethod(entity, serviceClass);

		// create relations methods
		// createRelationMethods(entity, serviceClass);

		String destinationPath = env.getProperty("generator.destination_path");

		File src = new File(FilenameUtils.concat(destinationPath, GeneratorUtil.packageNameToPath(generatorUtil.getPackageName(entity))), serviceClass.getName() + ".java");

		FileUtils.writeStringToFile(src,  serviceClass.toString());

		return serviceClass.toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "EntityBaseService";
	}
}
