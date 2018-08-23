package org.apache.ofbiz.workeffort.timesheet;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TimesheetRole implements Serializable {

	public static final long serialVersionUID = 8388756187482188800L;
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

	public TimesheetRole(GenericValue value) {
		timesheetId = (String) value.get(FIELD_TIMESHEET_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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