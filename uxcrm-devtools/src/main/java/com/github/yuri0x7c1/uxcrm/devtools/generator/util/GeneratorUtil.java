package com.github.yuri0x7c1.uxcrm.devtools.generator.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxcrm.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxcrm.devtools.entity.generator.EntityGenerator;
import com.github.yuri0x7c1.uxcrm.devtools.service.generator.ServiceGenerator;

@Component
public class GeneratorUtil {

	@Autowired
	private ModelOfbiz ofbiz;

	@Autowired
	private Environment env;

	@Autowired
	private ApplicationContext applicationContext;

	public static final String GENERIC_VALUE_CLASS_NAME = "org.apache.ofbiz.entity.GenericValue";

	public String getPackageName(ModelEntity entity) {
		String packageName = entity.getPackageName().replace("return", "_return").replace("enum", "_enum");

		String basePackage = env.getProperty("generator.base_package");
		if (basePackage != null && !basePackage.equals("org.apache.ofbiz")) {
			packageName = packageName.replace("org.apache.ofbiz", basePackage);
		}

		String entityPackage = env.getProperty("generator.entity.package");
		if (entityPackage != null) {
			packageName += "." + entityPackage;
		}
		return  packageName;
	}

	public String getRelationFieldName(ModelRelation relation) {
		StringBuilder name = new StringBuilder();
		if (!StringUtils.isBlank(relation.getTitle())) {
			name.append(relation.getTitle())
				.append(relation.getRelEntityName());
		}
		else {
			name.append(relation.getRelEntityName());
		}

		/* this was necessary for jpa generator ?
		name.setCharAt(0, Character.toLowerCase(name.charAt(0)));
		if (relation.getKeyMaps().size() == 1) {
			if (name.toString().equals(relation.getKeyMaps().get(0).getFieldName())) {
				name.append("Relation");
			}
		}
		*/

		return StringUtils.uncapitalize(name.toString());
	}

	/*
	public Map<String, IEntityGenerator> getAllEntityGenerators() {
		return applicationContext.getBeansOfType(IEntityGenerator.class);
	}

	public Map<String, IServiceGenerator> getAllServiceGenerators() {
		return applicationContext.getBeansOfType(IServiceGenerator.class);
	}
	*/

	public static String underscoredFromCamelCaseLower(String camelCaseString) {
		String[] words = StringUtils.splitByCharacterTypeCamelCase(camelCaseString);
		return StringUtils.join(words, "_").toLowerCase();
	}

	public static String underscoredFromCamelCaseUpper(String camelCaseString) {
		String[] words = StringUtils.splitByCharacterTypeCamelCase(camelCaseString);
		return StringUtils.join(words, "_").toUpperCase();
	}

	/**
	 * Converts package name to file system path
	 * @param packageName
	 * @return
	 */
	public static String packageNameToPath(String packageName) {
		return packageName.replaceAll("\\.", "/");
	}

	/**
	 * Create phrase from camel case
	 * @param name
	 * @return
	 */
	public static String createPhraseFromCamelCase(String name) {
		String[] words = StringUtils.splitByCharacterTypeCamelCase(name);
		StringBuilder phrase = new StringBuilder();
		for (int c = 0; c < words.length; c++) {
			phrase.append(words[c].toLowerCase());
			if (c != words.length-1) {
				phrase.append(' ');
			}
		}
		return phrase.toString();
	}

	/**
	 * Create caption from camel case
	 * @param name
	 * @return
	 */
	public static String createCaptionFromCamelCase(String name) {
		String[] words = StringUtils.splitByCharacterTypeCamelCase(name);
		StringBuilder phrase = new StringBuilder();
		for (int c = 0; c < words.length; c++) {
			phrase.append(StringUtils.capitalize(words[c].toLowerCase()));
			if (c != words.length-1) {
				phrase.append(' ');
			}
		}
		return phrase.toString();
	}

	public static boolean isJavaLangType(String type) {
		if (type.equals("Object") ||
				type.equals("String") ||
				type.equals("Integer") ||
				type.equals("Long") ||
				type.equals("Float") ||
				type.equals("Char") ||
				type.equals("Double") ||
				type.equals("Boolean")
			) {
			return true;
		}
		return false;
	}
	
	/**
	 * Convert camel case field name to field name conxtant
	 * from lombok/src/core/lombok/core/handlers/HandlerUtil.java
	 * @param fieldName
	 * @return
	 */
	public static String camelCaseToConstant(String fieldName) {
		if (fieldName == null || fieldName.isEmpty()) return "";
		StringBuilder b = new StringBuilder();
		b.append(Character.toUpperCase(fieldName.charAt(0)));
		for (int i = 1; i < fieldName.length(); i++) {
			char c = fieldName.charAt(i);
			if (Character.isUpperCase(c)) b.append('_');
			b.append(Character.toUpperCase(c));
		}
		return b.toString();
}
}
