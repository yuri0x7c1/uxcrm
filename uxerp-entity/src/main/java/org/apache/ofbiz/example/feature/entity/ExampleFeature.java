package org.apache.ofbiz.example.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Example Feature
 */
public class ExampleFeature implements Serializable {

	public static final long serialVersionUID = 4128152935137922048L;
	public static final String NAME = "ExampleFeature";
	/**
	 * Example Feature Id
	 */
	@Getter
	@Setter
	private String exampleFeatureId;
	/**
	 * Feature Source Enum Id
	 */
	@Getter
	@Setter
	private String featureSourceEnumId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		exampleFeatureId, featureSourceEnumId, description
	}

	public ExampleFeature(GenericValue value) {
		exampleFeatureId = (String) value.get(Fields.exampleFeatureId.name());
		featureSourceEnumId = (String) value.get(Fields.featureSourceEnumId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ExampleFeature fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ExampleFeature(value);
	}

	public static List<ExampleFeature> fromValues(List<GenericValue> values) {
		List<ExampleFeature> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ExampleFeature(value));
		}
		return entities;
	}
}