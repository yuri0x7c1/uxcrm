package com.github.yuri0x7c1.uxerp.devtools.generator.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.ofbiz.entity.model.ModelEntity;
import org.apache.ofbiz.entity.model.ModelRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;

@Component
public class GeneratorHelper {
	@Autowired
	private ModelOfbiz ofbiz;

	@Autowired
	private Environment env;

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

		name.setCharAt(0, Character.toLowerCase(name.charAt(0)));
		if (relation.getKeyMaps().size() == 1) {
			if (name.toString().equals(relation.getKeyMaps().get(0).getFieldName())) {
				name.append("Relation");
			}
		}

		return StringUtils.uncapitalize(name.toString());
	}
}
