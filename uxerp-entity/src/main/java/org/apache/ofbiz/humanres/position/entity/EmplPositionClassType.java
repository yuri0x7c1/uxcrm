package org.apache.ofbiz.humanres.position.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Class Type
 */
public class EmplPositionClassType implements Serializable {

	public static final long serialVersionUID = 3662313981987485696L;
	public static final String NAME = "EmplPositionClassType";
	/**
	 * Empl Position Class Type Id
	 */
	@Getter
	@Setter
	private String emplPositionClassTypeId;
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
		emplPositionClassTypeId, parentTypeId, hasTable, description
	}

	public EmplPositionClassType(GenericValue value) {
		emplPositionClassTypeId = (String) value
				.get(Fields.emplPositionClassTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static EmplPositionClassType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionClassType(value);
	}

	public static List<EmplPositionClassType> fromValues(
			List<GenericValue> values) {
		List<EmplPositionClassType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionClassType(value));
		}
		return entities;
	}
}