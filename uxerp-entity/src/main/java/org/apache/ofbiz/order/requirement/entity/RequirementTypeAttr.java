package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Type Attr
 */
public class RequirementTypeAttr implements Serializable {

	public static final long serialVersionUID = 754373573289135104L;
	public static final String NAME = "RequirementTypeAttr";
	/**
	 * Requirement Type Id
	 */
	@Getter
	@Setter
	private String requirementTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		requirementTypeId, attrName, description
	}

	public RequirementTypeAttr(GenericValue value) {
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static RequirementTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementTypeAttr(value);
	}

	public static List<RequirementTypeAttr> fromValues(List<GenericValue> values) {
		List<RequirementTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementTypeAttr(value));
		}
		return entities;
	}
}