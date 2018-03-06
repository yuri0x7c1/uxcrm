package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Desired Feature
 */
public class DesiredFeature implements Serializable {

	public static final long serialVersionUID = 6289741162189656064L;
	public static final String NAME = "DesiredFeature";
	/**
	 * Desired Feature Id
	 */
	@Getter
	@Setter
	private String desiredFeatureId;
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Optional Ind
	 */
	@Getter
	@Setter
	private String optionalInd;

	public enum Fields {
		desiredFeatureId, requirementId, productFeatureId, optionalInd
	}

	public DesiredFeature(GenericValue value) {
		desiredFeatureId = (String) value.get(Fields.desiredFeatureId.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		optionalInd = (String) value.get(Fields.optionalInd.name());
	}

	public static DesiredFeature fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DesiredFeature(value);
	}

	public static List<DesiredFeature> fromValues(List<GenericValue> values) {
		List<DesiredFeature> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DesiredFeature(value));
		}
		return entities;
	}
}