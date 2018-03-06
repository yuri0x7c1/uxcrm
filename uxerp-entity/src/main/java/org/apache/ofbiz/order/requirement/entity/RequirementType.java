package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Type
 */
public class RequirementType implements Serializable {

	public static final long serialVersionUID = 7859698453564839936L;
	public static final String NAME = "RequirementType";
	/**
	 * Requirement Type Id
	 */
	@Getter
	@Setter
	private String requirementTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		requirementTypeId, parentTypeId, hasTable, description
	}

	public RequirementType(GenericValue value) {
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static RequirementType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementType(value);
	}

	public static List<RequirementType> fromValues(List<GenericValue> values) {
		List<RequirementType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementType(value));
		}
		return entities;
	}
}