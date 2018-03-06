package org.apache.ofbiz.example.example.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Example Type
 */
public class ExampleType implements Serializable {

	public static final long serialVersionUID = 7477605718927299584L;
	public static final String NAME = "ExampleType";
	/**
	 * Example Type Id
	 */
	@Getter
	@Setter
	private String exampleTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		exampleTypeId, parentTypeId, description
	}

	public ExampleType(GenericValue value) {
		exampleTypeId = (String) value.get(Fields.exampleTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ExampleType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ExampleType(value);
	}

	public static List<ExampleType> fromValues(List<GenericValue> values) {
		List<ExampleType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ExampleType(value));
		}
		return entities;
	}
}