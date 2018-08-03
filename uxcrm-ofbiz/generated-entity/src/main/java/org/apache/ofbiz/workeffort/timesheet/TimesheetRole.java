package org.apache.ofbiz.workeffort.timesheet;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Timesheet Role
 */
public class TimesheetRole implements Serializable {

	public static final long serialVersionUID = 740833035986660352L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		timesheetId, partyId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TimesheetRole(GenericValue value) {
		timesheetId = (String) value.get(Fields.timesheetId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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