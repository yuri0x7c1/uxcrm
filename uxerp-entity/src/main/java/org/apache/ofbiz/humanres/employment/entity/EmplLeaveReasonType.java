package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Leave Reason Type
 */
public class EmplLeaveReasonType implements Serializable {

	public static final long serialVersionUID = 5936221176029228032L;
	public static final String NAME = "EmplLeaveReasonType";
	/**
	 * Empl Leave Reason Type Id
	 */
	@Getter
	@Setter
	private String emplLeaveReasonTypeId;
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
		emplLeaveReasonTypeId, parentTypeId, hasTable, description
	}

	public EmplLeaveReasonType(GenericValue value) {
		emplLeaveReasonTypeId = (String) value.get(Fields.emplLeaveReasonTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static EmplLeaveReasonType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplLeaveReasonType(value);
	}

	public static List<EmplLeaveReasonType> fromValues(List<GenericValue> values) {
		List<EmplLeaveReasonType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplLeaveReasonType(value));
		}
		return entities;
	}
}