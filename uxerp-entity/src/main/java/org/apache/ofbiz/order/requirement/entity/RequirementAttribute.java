package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Attribute
 */
public class RequirementAttribute implements Serializable {

	public static final long serialVersionUID = 172904402438408192L;
	public static final String NAME = "RequirementAttribute";
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		requirementId, attrName, attrValue, attrDescription
	}

	public RequirementAttribute(GenericValue value) {
		requirementId = (String) value.get(Fields.requirementId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static RequirementAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementAttribute(value);
	}

	public static List<RequirementAttribute> fromValues(
			List<GenericValue> values) {
		List<RequirementAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementAttribute(value));
		}
		return entities;
	}
}