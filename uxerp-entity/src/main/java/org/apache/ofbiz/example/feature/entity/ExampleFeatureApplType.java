package org.apache.ofbiz.example.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Example Feature Appl Type
 */
public class ExampleFeatureApplType implements Serializable {

	public static final long serialVersionUID = 6084385380766882816L;
	public static final String NAME = "ExampleFeatureApplType";
	/**
	 * Example Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String exampleFeatureApplTypeId;
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
		exampleFeatureApplTypeId, parentTypeId, description
	}

	public ExampleFeatureApplType(GenericValue value) {
		exampleFeatureApplTypeId = (String) value
				.get(Fields.exampleFeatureApplTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ExampleFeatureApplType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ExampleFeatureApplType(value);
	}

	public static List<ExampleFeatureApplType> fromValues(
			List<GenericValue> values) {
		List<ExampleFeatureApplType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ExampleFeatureApplType(value));
		}
		return entities;
	}
}