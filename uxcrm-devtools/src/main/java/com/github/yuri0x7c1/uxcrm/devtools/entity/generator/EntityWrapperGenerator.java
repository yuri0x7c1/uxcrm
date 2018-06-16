package com.github.yuri0x7c1.uxcrm.devtools.entity.generator;

import static com.github.yuri0x7c1.uxcrm.devtools.generator.util.GeneratorUtil.GENERIC_VALUE_CLASS_NAME;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelField;
import org.apache.ofbiz.entity.model.ModelRelation;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.EnumConstantSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.JavaEnumSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxcrm.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxcrm.devtools.generator.util.GeneratorUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EntityWrapperGenerator implements EntityGenerator {

	@Autowired
	private ModelOfbiz ofbiz;

	@Autowired
	private Environment env;

	@Autowired
	private GeneratorUtil generatorUtil;

	/**
	 * Create entity class
	 * @param entity
	 * @return
	 */
	private JavaClassSource createEntityClass(ModelEntity entity) {
		// create entity class
		final JavaClassSource entityClass = Roaster.create(JavaClassSource.class);
		entityClass.setPackage(generatorUtil.getPackageName(entity))
			.setName(entity.getEntityName());

		// comment
		entityClass.getJavaDoc().setFullText(GeneratorUtil.createCaptionFromCamelCase(entity.getEntityName()));

		// add serialization stuff
		entityClass.addInterface(Serializable.class);
		entityClass.addField()
		  .setName("serialVersionUID")
		  .setType(long.class)
		  .setLiteralInitializer(String.valueOf(RandomUtils.nextLong(0, Long.MAX_VALUE-1)) + "L")
		  .setPublic()
		  .setStatic(true)
		  .setFinal(true);

		// add static entity name field
		entityClass.addField()
			.setName("NAME")
			.setType(String.class)
			.setStringInitializer(entity.getEntityName())
			.setPublic()
			.setStatic(true)
			.setFinal(true);

		// create columns
		for (ModelField field : entity.getFieldsUnmodifiable()) {
			Class<?> fieldJavaType = FieldType.find(field).getJavaType();
			FieldSource<JavaClassSource> entityField = entityClass.addField()
				.setName(field.getName())
				.setType(fieldJavaType)
				.setPrivate();

			// add comment
			entityField.getJavaDoc().setFullText(GeneratorUtil.createCaptionFromCamelCase(field.getName()));

			// add lombok getters an setters
			entityField.addAnnotation(Getter.class);
			entityField.addAnnotation(Setter.class);
		}

		return entityClass;
	}

	/**
	 * Create constructor with GenericValue entity parameter
	 * @param entity
	 * @param entityClass
	 */
	private void createConstructorWithGenericValueParameter(ModelEntity entity, JavaClassSource entityClass) {
		// create columns
		StringBuilder constructorBody = new StringBuilder();

		// constructor body
		for (ModelField field : entity.getFieldsUnmodifiable()) {
			// append param to "fromValue()" body
			constructorBody.append(String.format("%s = %s value.get(Fields.%s.name());",
				field.getName(),
				"(" + FieldType.find(field).getJavaType().getSimpleName() + ")",
				field.getName()));
		}

		MethodSource<JavaClassSource> constructor = entityClass.addMethod()
			.setConstructor(true)
			.setPublic()
			.setBody(constructorBody.toString());

		constructor.addParameter(GENERIC_VALUE_CLASS_NAME, "value");
	}

	/**
	 * Create fromValue static method
	 * @param entity
	 * @param entityClass
	 */
	private void createFromValueStaticMethod(ModelEntity entity, JavaClassSource entityClass) {
		String fromValueMethodBody = "return new " + entityClass.getName() + "(value);";

		MethodSource<JavaClassSource> fromValueMethod = entityClass.addMethod()
			.setName("fromValue")
			.setPublic()
			.setStatic(true)
			.setReturnType(entityClass)
			.setBody(fromValueMethodBody);

		fromValueMethod.addParameter(GENERIC_VALUE_CLASS_NAME, "value");
	}

	/**
	 * Create fromValues static method
	 * @param entity
	 * @param entityClass
	 */
	private void createFromValuesStaticMethod(ModelEntity entity, JavaClassSource entityClass) {
		entityClass.addImport(List.class);
		entityClass.addImport(ArrayList.class);

		String fromValuesMethodBody = String.format("List<%s> entities = new ArrayList<>();"
				+ "for (GenericValue value : values) {"
				+ "		entities.add(new %s(value));"
				+ "}"
				+ "return entities;", entityClass.getName(), entityClass.getName());

		MethodSource<JavaClassSource> fromValuesMethod = entityClass.addMethod()
			.setName("fromValues")
			.setPublic()
			.setStatic(true)
			.setReturnType("List<" + entityClass.getName() + ">")
			.setBody(fromValuesMethodBody);

			fromValuesMethod.addParameter("List<GenericValue>", "values");
	}

	/**
	 * Create fields enum
	 * @param entity
	 * @param entityClass
	 */
	private void createFieldsEnum(ModelEntity entity, JavaClassSource entityClass) {
		JavaEnumSource fieldsEnum = Roaster.create(JavaEnumSource.class);
		fieldsEnum.setName("Fields");

		for (ModelField field : entity.getFieldsUnmodifiable()) {
			EnumConstantSource fieldConstant = fieldsEnum.addEnumConstant(field.getName());
		}

		entityClass.addNestedType(fieldsEnum);
	}

	/**
	 * Create relations enum
	 * @param entity
	 * @param entityClass
	 */
	private void createRelationsEnum(ModelEntity entity, JavaClassSource entityClass) {
		entityClass.addImport(AllArgsConstructor.class);

		JavaEnumSource fieldsEnum = Roaster.create(JavaEnumSource.class);
		fieldsEnum.setName("Relations")
			.setStatic(true)
			.addAnnotation(AllArgsConstructor.class);
		fieldsEnum.addField()
			.setName("type")
			.setType(String.class)
			.setPrivate()
			.addAnnotation(Getter.class);

		for (ModelRelation relation : entity.getRelationsList(true, true, true)) {
			EnumConstantSource fieldConstant = fieldsEnum.addEnumConstant(relation.getRelEntityName())
					.setConstructorArguments("\"" + relation.getType() + "\"");
		}

		entityClass.addNestedType(fieldsEnum);
	}

	/**
	 * Generate code
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public String generate(ModelEntity entity) throws Exception {
		log.info("Generate entity: {}", entity.getEntityName());

		// create entity class
		final JavaClassSource entityClass = createEntityClass(entity);

		// create fields enum
		createFieldsEnum(entity, entityClass);

		// create relations enum
		// createRelationsEnum(entity, entityClass);

		// create constructor
		createConstructorWithGenericValueParameter(entity, entityClass);

		// create fromValue static method
		createFromValueStaticMethod(entity, entityClass);

		// create fromValues static method
		createFromValuesStaticMethod(entity, entityClass);

		String destinationPath = env.getProperty("generator.destination_path");

		File src = new File(FilenameUtils.concat(destinationPath, GeneratorUtil.packageNameToPath(generatorUtil.getPackageName(entity))), entity.getEntityName() + ".java");

		FileUtils.writeStringToFile(src,  entityClass.toString());

		return entityClass.toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Entity";
	}
}
