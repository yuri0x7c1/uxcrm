package com.github.yuri0x7c1.uxerp.devtools.entity.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ofbiz.common.ExecuteFindService;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelField;
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
import com.github.yuri0x7c1.uxerp.devtools.service.util.ServiceUtil;

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

	@Autowired
	private ServiceUtil serviceUtil;

	private JavaClassSource createServiceClass(ModelEntity entity) {
		JavaClassSource serviceClass = Roaster.create(JavaClassSource.class)
				.setPackage(generatorUtil.getPackageName(entity))
				.setName(entity.getEntityName() + "BaseService");

		serviceClass.addAnnotation(Slf4j.class);
		serviceClass.addAnnotation(Component.class);
		serviceClass.addAnnotation(SuppressWarnings.class).setStringValue("unchecked");

		serviceClass.addImport(ExecuteFindService.class.getName() + "." + ExecuteFindService.In.class.getSimpleName());
		serviceClass.addImport(ExecuteFindService.class.getName() + "." + ExecuteFindService.Out.class.getSimpleName());

		serviceClass.addField()
			.setName("executeFindService")
			.setType(ExecuteFindService.class.getName())
			.setPrivate()
			.addAnnotation(Autowired.class);

		return serviceClass;
	}

	/**
	 * Create find method body
	 * @param entityName
	 * @param conditionString
	 * @return
	 */
	private String createFindMethodBody(String entityName, String conditionString) {
		String conditions = null;
		if (conditionString == null) {
			conditions =
					"		if (conditions == null) {" +
					"			in.setNoConditionFind(FindUtil.Y);" +
					"		}" +
					"		else {" +
					"			in.setEntityConditionList(conditions);" +
					"		}";
		}
		else {
			conditions = String.format(
			"		in.setEntityConditionList(" +
			"			new EntityConditionList<>(" +
			"				%s," +
			"				EntityOperator.AND" +
			"			)" +
			"		);", conditionString);
		}

		return String.format(
				"		List<%s> entityList = new ArrayList<>();" +
				"		In in = new In();" +
				"		in.setEntityName(%s.NAME);" +
				"		in.setOrderByList(orderBy);" +
				"%s" +
				"		Out out = executeFindService.runSync(in);" +
				"		try {" +
				"			if (out.getListIt() != null) {" +
				"				return %s.fromValues(out.getListIt().getPartialList(start, number));" +
				"			}" +
				"		}" +
				"		catch (GenericEntityException e) {" +
				"			log.error(e.getMessage(), e);" +
				"		}" +
				"		return entityList;",
				entityName,
				entityName,
				conditions,
				entityName
		);
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

		findMethod.getJavaDoc().setFullText("Find " + English.plural(entity.getEntityName()));

		findMethod.addParameter("Integer", "start");
		findMethod.addParameter("Integer", "number");
		findMethod.addParameter("List<String>", "orderBy");
		findMethod.addParameter(EntityConditionList.class.getSimpleName(), "conditions");

		findMethod.setBody(createFindMethodBody(entity.getEntityName(), null));
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

		countMethod.getJavaDoc().setFullText("Count " + English.plural(entity.getEntityName()));

		countMethod.addParameter(EntityConditionList.class.getSimpleName(), "conditions");

		countMethod.setBody(String.format(
				"		In in = new In();" +
				"		in.setEntityName(%s.NAME);" +
				"		if (conditions == null) {" +
				"			in.setNoConditionFind(FindUtil.Y);" +
				"		}" +
				"		else {" +
				"			in.setEntityConditionList(conditions);" +
				"		}" +
				"		Out out = executeFindService.runSync(in);\n" +
				"		return out.getListSize();", entity.getEntityName()));
		return countMethod;
	}

	/**
	 * Create findOne method body
	 * @param entityName
	 * @param conditions
	 * @return
	 */
	private String createFindOneMethodBody(String entityName, String conditions) {
		return String.format(
			"		List<%s> entityList = null;" +
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
			entityName,
			entityName,
			conditions,
			entityName
		);
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

		findOneMethod.getJavaDoc().setFullText("Fine one " + entity.getEntityName());

		List<String> conditionList = new ArrayList<>();
		for (ModelField pkField : entity.getPkFields()) {
			// add method param
			findOneMethod.addParameter(serviceUtil.getParamJavaTypeName(pkField.getType()), pkField.getName());

			// add condition
			conditionList.add(String.format(
				"new EntityExpr(\"%s\", EntityOperator.EQUALS, %s)",
				pkField.getName(),
				pkField.getName()
			));
		}
		String conditions = "Arrays.asList(" + StringUtils.join(conditionList, ", ") + ")";

		// create method body
		findOneMethod.setBody(createFindOneMethodBody(entity.getEntityName(), conditions));

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

					String methodName = "get" + StringUtils.capitalize(generatorUtil.getRelationFieldName(relation));

					// create method
					MethodSource<JavaClassSource> getOneRelationMethod = serviceClass.addMethod()
							.setName(methodName)
							.setPublic()
							.setReturnType(relationType);

					// set javadoc
					getOneRelationMethod.getJavaDoc().setFullText(StringUtils.capitalize(generatorUtil.createPhraseFromCamelCase(methodName)));

					String entityVariableName = StringUtils.uncapitalize(entity.getEntityName());
					getOneRelationMethod.addParameter(entity.getEntityName(), entityVariableName);

					List<String> conditionList = new ArrayList<>();

					for (ModelKeyMap keyMap : relation.getKeyMaps()) {
						String fieldName = keyMap.getFieldName();
						String relFieldName = keyMap.getRelFieldName() != null ? keyMap.getRelFieldName() : fieldName;

						// add condition
						conditionList.add(String.format(
							"new EntityExpr(\"%s\", EntityOperator.EQUALS, %s)",
							relFieldName,
							entityVariableName + ".get" + StringUtils.capitalize(fieldName) + "()"
						));
					}
					String conditions = "Arrays.asList(" + StringUtils.join(conditionList, ", ") + ")";
					getOneRelationMethod.setBody(createFindOneMethodBody(relation.getRelEntityName(), conditions));
				}
				else if(TYPE_MANY.equals(relation.getType())) {
					String methodName = "get" + StringUtils.capitalize(English.plural(generatorUtil.getRelationFieldName(relation)));

					// create method
					MethodSource<JavaClassSource> getManyRelationMethod = serviceClass.addMethod()
							.setName(methodName)
							.setPublic()
							.setReturnType("List<" + relationType + ">");

					// add javadoc
					getManyRelationMethod.getJavaDoc().setFullText(StringUtils.capitalize(generatorUtil.createPhraseFromCamelCase(methodName)));

					String entityVariableName = StringUtils.uncapitalize(entity.getEntityName());
					getManyRelationMethod.addParameter(entity.getEntityName(), entityVariableName);
					getManyRelationMethod.addParameter("Integer", "start");
					getManyRelationMethod.addParameter("Integer", "number");
					getManyRelationMethod.addParameter("List<String>", "orderBy");

					StringBuilder inputFields = new StringBuilder("");

					List<String> conditionList = new ArrayList<>();

					for (ModelKeyMap keyMap : relation.getKeyMaps()) {
						String fieldName = keyMap.getFieldName();
						String relFieldName = keyMap.getRelFieldName() != null ? keyMap.getRelFieldName() : fieldName;

						// add condition
						conditionList.add(String.format(
							"new EntityExpr(\"%s\", EntityOperator.EQUALS, %s)",
							relFieldName,
							entityVariableName + ".get" + StringUtils.capitalize(fieldName) + "()"
						));
					}
					String conditions = "Arrays.asList(" + StringUtils.join(conditionList, ", ") + ")";

					getManyRelationMethod.setBody(createFindMethodBody(relation.getRelEntityName(), conditions));
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
		serviceClass.addImport(Arrays.class);
		serviceClass.addImport(ArrayList.class);
		serviceClass.addImport(List.class);
		serviceClass.addImport(CollectionUtils.class);

		serviceClass.addImport(GenericEntityException.class);
		serviceClass.addImport(EntityConditionList.class);
		serviceClass.addImport(EntityExpr.class);
		serviceClass.addImport(EntityOperator.class);

		serviceClass.addImport("com.github.yuri0x7c1.uxerp.common.find.util.FindUtil");

		serviceClass.addImport(generatorUtil.getPackageName(entity) + "." + entity.getEntityName());

		// create count method
		createCountMethod(entity, serviceClass);

		// create find method
		createFindMethod(entity, serviceClass);

		// create find one method
		createFindOneMethod(entity, serviceClass);

		// create relations methods
		createRelationMethods(entity, serviceClass);

		String destinationPath = env.getProperty("generator.destination_path");

		File src = new File(FilenameUtils.concat(destinationPath, GeneratorUtil.packageNameToPath(generatorUtil.getPackageName(entity))), serviceClass.getName() + ".java");

		FileUtils.writeStringToFile(src, serviceClass.toString());

		return serviceClass.toString();
	}

	@Override
	public String getName() {
		return "EntityBaseService";
	}
}
