package com.github.yuri0x7c1.uxerp.devtools.service.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ofbiz.service.ModelParam;
import org.apache.ofbiz.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxerp.devtools.config.DevtoolsConfiguration.ModelOfbiz;

@Component
public class ServiceUtil {
	public static final String LOCATION_PACKAGE = "org.apache.ofbiz";
	public static final String LOCATION_COMPONENT = "component://";

	@Autowired
	private Environment env;

	@Autowired
	private ModelOfbiz ofbiz;


	public String locationToPackageName(String location) {
			String basePackage = env.getProperty("generator.base_package");
			String packageName = basePackage;

			if (location != null) {
				if (location.startsWith(LOCATION_PACKAGE)) {
					packageName = basePackage + location.substring(LOCATION_PACKAGE.length(), location.lastIndexOf('.'));
				}
				else if (location.startsWith(LOCATION_COMPONENT)) {
					packageName = basePackage + "." + location.substring(LOCATION_COMPONENT.length(), location.lastIndexOf('/')).replace('/', '.');
				}
			}

			String servicePackage = env.getProperty("generator.service.package");
			if (servicePackage != null) {
				packageName += "." + servicePackage;
			}

			return packageName;
		}

	public List<ModelParam> getOutParamList(ModelService service) {
		List<ModelParam> outParamList = new ArrayList<>();
		for (String outParamName : service.getOutParamNames()) {
			outParamList.add(service.getParam(outParamName));
		}
		return outParamList;
	}



	public String getParamJavaTypeName(String type) {
		if ("String".equals(type)) {
			return "String";
		}
		else if ("Integer".equals(type)) {
			return  "Integer";
		}
		else if ("Long".equals(type)) {
			return "Long";
		}
		else if ("Double".equals(type)) {
			return "Double";
		}
		else if ("BigDecimal".equals(type)) {
			return "java.math.BigDecimal";
		}
		else if ("Boolean".equals(type)) {
			return "Boolean";
		}
		else if ("Timestamp".equals(type)) {
			return "java.sql.Timestamp";
		}
		else if ("List".equals(type)) {
			return "java.util.List";
		}
		else if ("List<String>".equals(type)) {
			return "List<String>";
		}
		else if ("Map".equals(type)) {
			return "java.util.Map";
		}
		else if ("Set".equals(type)) {
			return "java.util.Set";
		}
		else if ("Object".equals(type)) {
			return "Object";
		}
		else if ("Locale".equals(type)) {
			return "java.util.Locale";
		}
		else if ("GenericEntity".equals(type)) {
			return "org.apache.ofbiz.entity.GenericEntity";
		}
		else if ("GenericPK".equals(type)) {
			return "org.apache.ofbiz.entity.GenericPK";
		}
		else if ("GenericValue".equals(type)) {
			return "org.apache.ofbiz.entity.GenericValue";
		}
		else if (StringUtils.split(type, ".").length > 1) {
			return type;
		}
		return "Object";
	}

	public boolean isJavaLangType(String type) {
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

	public boolean isTextType(String typeName) {
		if (typeName.equals("String")) {
			return true;
		}
		return false;
	}

	public  boolean isNumericType(String typeName) {
		String javaType = typeName;
		if (javaType.equals("Integer") || javaType.equals("Long") || javaType.equals("Double") ||
				javaType.equals("Float") || javaType.equals("java.math.BigDecimal")) {
			return true;
		}
		return false;
	}

	public boolean isBooleanType(String typeName) {
		if (typeName.equals("Boolean")) {
			return true;
		}
		return false;
	}

	public boolean isTemporalType(String typeName) {
		if (typeName.equals("java.sql.Timestamp")) {
			return true;
		}
		return false;
	}

	public String getterFieldName(String fieldName) {
		return "get" + StringUtils.capitalize(fieldName);
	}

	public String setteFieldrName(String fieldName) {
		return "set" + StringUtils.capitalize(fieldName);
	}
}

