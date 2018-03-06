package org.apache.ofbiz.entity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Java Resource
 */
public class JavaResource implements Serializable {

	public static final long serialVersionUID = 2954848960681107456L;
	public static final String NAME = "JavaResource";
	/**
	 * Resource Name
	 */
	@Getter
	@Setter
	private String resourceName;
	/**
	 * Resource Value
	 */
	@Getter
	@Setter
	private byte[] resourceValue;

	public enum Fields {
		resourceName, resourceValue
	}

	public JavaResource(GenericValue value) {
		resourceName = (String) value.get(Fields.resourceName.name());
		resourceValue = (byte[]) value.get(Fields.resourceValue.name());
	}

	public static JavaResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JavaResource(value);
	}

	public static List<JavaResource> fromValues(List<GenericValue> values) {
		List<JavaResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JavaResource(value));
		}
		return entities;
	}
}