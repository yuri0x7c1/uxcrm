package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Responsibility Type
 */
public class ResponsibilityType implements Serializable {

	public static final long serialVersionUID = 394993264336795648L;
	public static final String NAME = "ResponsibilityType";
	/**
	 * Responsibility Type Id
	 */
	@Getter
	@Setter
	private String responsibilityTypeId;
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
		responsibilityTypeId, parentTypeId, hasTable, description
	}

	public ResponsibilityType(GenericValue value) {
		responsibilityTypeId = (String) value.get(Fields.responsibilityTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ResponsibilityType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ResponsibilityType(value);
	}

	public static List<ResponsibilityType> fromValues(List<GenericValue> values) {
		List<ResponsibilityType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ResponsibilityType(value));
		}
		return entities;
	}
}