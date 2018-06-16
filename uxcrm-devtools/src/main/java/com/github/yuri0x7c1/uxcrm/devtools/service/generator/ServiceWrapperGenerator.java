package com.github.yuri0x7c1.uxcrm.devtools.service.generator;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ofbiz.service.ModelParam;
import org.apache.ofbiz.service.ModelService;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.github.yuri0x7c1.uxcrm.devtools.config.DevtoolsConfiguration.ModelOfbiz;
import com.github.yuri0x7c1.uxcrm.devtools.generator.util.GeneratorUtil;
import com.github.yuri0x7c1.uxcrm.devtools.service.util.ServiceUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ServiceWrapperGenerator implements ServiceGenerator {
	@Autowired
	private ModelOfbiz ofbiz;

	@Autowired
	private Environment env;

	@Autowired
	private ServiceUtil serviceUtil;

	public String getPackageName(ModelService service) {
		return serviceUtil.locationToPackageName(service.location);
	}

	public String getTypeName(ModelService service) {
		return StringUtils.capitalize(service.name) + "Service";
	}

	public String getFullTypeName(ModelService service) {
		return getPackageName(service) + "." + getTypeName(service);
	}

	public String getVariableName(ModelService service) {
		return StringUtils.uncapitalize(getTypeName(service));
	}

	public String generate(ModelService service) throws Exception {
		if (service == null ) throw new Exception("Service must not be null");

		String packageName = serviceUtil.locationToPackageName(service.location);
		log.info("package name {}", packageName);

		String serviceClassName = getTypeName(service);
		JavaClassSource serviceSource = Roaster.create(JavaClassSource.class)
			.setName(serviceClassName)
			.setPackage(packageName);

		// add caption
		serviceSource.getJavaDoc().setFullText(GeneratorUtil.createCaptionFromCamelCase(service.name));

		// some imports
		serviceSource.addImport(Getter.class);
		serviceSource.addImport(Setter.class);
		serviceSource.addImport(NoArgsConstructor.class);

		serviceSource.addAnnotation(Component.class);
		serviceSource.addAnnotation(Slf4j.class);

		// add serialization stuff
		serviceSource.addInterface(Serializable.class);
		serviceSource.addField()
		  .setName("serialVersionUID")
		  .setType(long.class)
		  .setLiteralInitializer(String.valueOf(RandomUtils.nextLong(0, Long.MAX_VALUE-1)) + "L")
		  .setPublic()
		  .setStatic(true)
		  .setFinal(true);

		// add static service name field
		serviceSource.addField()
			.setName("NAME")
			.setType(String.class)
			.setStringInitializer(service.name)
			.setPublic()
			.setStatic(true)
			.setFinal(true);

		// add dispatcher autowired field
		serviceSource.addField()
			.setName("dispatcher")
			.setType("org.apache.ofbiz.service.LocalDispatcher")
			.setPrivate()
			.addAnnotation(Autowired.class);

		List<ModelParam> inParams = service.getInModelParamList();
		List<ModelParam> outParams = serviceUtil.getOutParamList(service);


		/* process service IN params */

		// crate In nested type
		JavaClassSource inTypeSource = Roaster.create(JavaClassSource.class).setName("In");
		inTypeSource.addAnnotation(NoArgsConstructor.class);

		if (!inParams.isEmpty()) {
			// some outer class imports
			serviceSource.addImport(Map.class);
			serviceSource.addImport(HashMap.class);
			serviceSource.addImport(List.class);

			// toMap method body
			StringBuilder toMapMethodBody = new StringBuilder("Map<String, Object> map = new HashMap<>();");
			StringBuilder fromMapMethodBody = new StringBuilder();

			// create In type fields
			for (ModelParam param : inParams) {
				String paramName = param.getName();
				String paramKey = param.getName();
				if ("login.username".equals(param.getName())) {
					paramName = "loginUsername";
				}
				else if ("login.password".equals(param.getName())) {
					paramName = "loginPassword";
				}

				String fieldJavaTypeName = serviceUtil.getParamJavaTypeName(param.getType());

				if (StringUtils.split(fieldJavaTypeName, ".").length > 1) {
					serviceSource.addImport(fieldJavaTypeName);
				}

				FieldSource<JavaClassSource> fieldSource = inTypeSource.addField()
					.setName(paramName)
					.setType(fieldJavaTypeName)
					.setPrivate();

				// add field caption
				fieldSource.getJavaDoc().setFullText(GeneratorUtil.createCaptionFromCamelCase(param.getName()));

				fieldSource.addAnnotation(Getter.class);
				fieldSource.addAnnotation(Setter.class);

				// append param to "toMap()" body
				toMapMethodBody.append(String.format("map.put(\"%s\", %s);", paramKey, paramName));

				// append param to "fromMap()" body
				fromMapMethodBody.append(String.format("%s = %s map.get(\"%s\");",
						paramName,
						"(" + fieldJavaTypeName + ")",
						paramKey));
			}

			// add "toMap() method return value
			toMapMethodBody.append("return map;");

			// add "toMap()" method to nested "In" type
			inTypeSource.addMethod()
				.setName("toMap")
				.setReturnType("Map<String, Object>")
				.setPublic()
				.setBody(toMapMethodBody.toString());

			// add "fromMap()" method to nested "In" type
			MethodSource<JavaClassSource> fromMapSource = inTypeSource.addMethod()
				.setName("fromMap")
				.setPublic()
				.setBody(fromMapMethodBody.toString());
			fromMapSource.addParameter("Map<String, Object>", "map");

			// add constructor
			inTypeSource.addMethod()
				.setConstructor(true)
				.setBody("fromMap(map);")
				.setPublic()
				.addParameter("Map<String, Object>", "map");

			// add In nested type to service class
			serviceSource.addNestedType(inTypeSource)
				.setPublic()
				.setStatic(true);
		}

		/* process service OUT params */

		// crate Out nested type
		JavaClassSource outTypeSource = Roaster.create(JavaClassSource.class).setName("Out");
		outTypeSource.addAnnotation(NoArgsConstructor.class);

		if (!outParams.isEmpty()) {

			// some outer class imports
			serviceSource.addImport(Map.class);
			serviceSource.addImport(HashMap.class);
			serviceSource.addImport(List.class);

			// toMap method body
			StringBuilder toMapMethodBody = new StringBuilder("Map<String, Object> map = new HashMap<>();");
			StringBuilder fromMapMethodBody = new StringBuilder("Out result = new Out();");

			// create In type fields
			for (ModelParam param : outParams) {
				String fieldJavaTypeName = serviceUtil.getParamJavaTypeName(param.getType());

				if (StringUtils.split(fieldJavaTypeName, ".").length > 1) {
					serviceSource.addImport(fieldJavaTypeName);
				}

				FieldSource<JavaClassSource> fieldSource = outTypeSource.addField()
					.setName(param.getName())
					.setType(fieldJavaTypeName)
					.setPrivate();

				// add field caption
				fieldSource.getJavaDoc().setFullText(GeneratorUtil.createCaptionFromCamelCase(param.getName()));

				fieldSource.addAnnotation(Getter.class);
				fieldSource.addAnnotation(Setter.class);

				// append param to "toMap()" body
				toMapMethodBody.append(String.format("map.put(\"%s\", %s);", param.getName(), param.getName()));

				// append param to "fromMap()" body
				fromMapMethodBody.append(String.format("%s = %s map.get(\"%s\");",
						param.getName(),
						"(" + fieldJavaTypeName + ")",
						param.getName()));
			}

			// add "toMap() method return value
			toMapMethodBody.append("return map;");

			// add "toMap()" method to nested "Out" type
			outTypeSource.addMethod()
				.setName("toMap")
				.setReturnType("Map<String, Object>")
				.setPublic()
				.setBody(toMapMethodBody.toString());

			// add "fromMap()" method to nested "Out" type
			MethodSource<JavaClassSource> fromMapSource = outTypeSource.addMethod()
				.setName("fromMap")
				.setPublic()
				.setBody(fromMapMethodBody.toString());
			fromMapSource.addParameter("Map<String, Object>", "map");

			// add constructor
			outTypeSource.addMethod()
				.setConstructor(true)
				.setBody("fromMap(map);")
				.setPublic()
				.addParameter("Map<String, Object>", "map");

			// add Out nested type to service class
			serviceSource.addNestedType(outTypeSource)
				.setPublic()
				.setStatic(true);
		}

		/* add "runSync()" method */
		serviceSource.addMethod()
			.setName("runSync")
			.setPublic()
			.setBody("Map<String, Object> result = null;"
				+ "try {"
				+ "	result = dispatcher.runSync(NAME, in.toMap());"
				+ "}"
				+ "catch (Exception e) {"
				+ "	log.error(\"Error\", e);"
				+ "}"
				+ "return new Out(result);"
			)
			.setReturnType(outTypeSource)
			.addParameter(inTypeSource, "in");

		String destinationPath = env.getProperty("generator.destination_path");

		File src = new File(FilenameUtils.concat(destinationPath, GeneratorUtil.packageNameToPath(packageName)), serviceClassName + ".java");

		FileUtils.writeStringToFile(src,  serviceSource.toString());

		return serviceSource.toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Service";
	}
}
