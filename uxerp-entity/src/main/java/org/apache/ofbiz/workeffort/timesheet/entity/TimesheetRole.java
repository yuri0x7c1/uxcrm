package org.apache.ofbiz.workeffort.timesheet.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Timesheet Role
 */
public class TimesheetRole implements Serializable {

	public static final long serialVersionUID = 5099636207568857088L;
	public static final String NAME = "TimesheetRole";
	/**
	 * Timesheet Id
	 */
	@Getter
	@Setter
	private String timesheetId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;

	public enum Fields {
		timesheetId, partyId, roleTypeId
	}

	public TimesheetRole(GenericValue value) {
		timesheetId = (String) value.get(Fields.timesheetId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static TimesheetRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TimesheetRole(value);
	}

	public static List<TimesheetRole> fromValues(List<GenericValue> values) {
		List<TimesheetRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TimesheetRole(value));
		}
		return entities;
	}
}