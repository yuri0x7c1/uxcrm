package org.apache.ofbiz.humanres.position.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Type
 */
public class EmplPositionType implements Serializable {

	public static final long serialVersionUID = 1396366624474225664L;
	public static final String NAME = "EmplPositionType";
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
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
		emplPositionTypeId, parentTypeId, hasTable, description
	}

	public EmplPositionType(GenericValue value) {
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static EmplPositionType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionType(value);
	}

	public static List<EmplPositionType> fromValues(List<GenericValue> values) {
		List<EmplPositionType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionType(value));
		}
		return entities;
	}
}