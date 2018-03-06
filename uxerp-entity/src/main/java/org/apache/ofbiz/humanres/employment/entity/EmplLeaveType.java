package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Leave Type
 */
public class EmplLeaveType implements Serializable {

	public static final long serialVersionUID = 4987179518405350400L;
	public static final String NAME = "EmplLeaveType";
	/**
	 * Leave Type Id
	 */
	@Getter
	@Setter
	private String leaveTypeId;
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
		leaveTypeId, parentTypeId, hasTable, description
	}

	public EmplLeaveType(GenericValue value) {
		leaveTypeId = (String) value.get(Fields.leaveTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static EmplLeaveType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplLeaveType(value);
	}

	public static List<EmplLeaveType> fromValues(List<GenericValue> values) {
		List<EmplLeaveType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplLeaveType(value));
		}
		return entities;
	}
}