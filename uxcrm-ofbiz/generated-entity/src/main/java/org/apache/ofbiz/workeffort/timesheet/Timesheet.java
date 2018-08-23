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
 * Timesheet
 */
@FieldNameConstants
public class Timesheet implements Serializable {

	public static final long serialVersionUID = 5413913049453238272L;
	public static final String NAME = "Timesheet";
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
	 * Client Party Id
	 */
	@Getter
	@Setter
	private String clientPartyId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Approved By User Login Id
	 */
	@Getter
	@Setter
	private String approvedByUserLoginId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public Timesheet(GenericValue value) {
		timesheetId = (String) value.get(FIELD_TIMESHEET_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		clientPartyId = (String) value.get(FIELD_CLIENT_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		approvedByUserLoginId = (String) value
				.get(FIELD_APPROVED_BY_USER_LOGIN_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Timesheet fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Timesheet(value);
	}

	public static List<Timesheet> fromValues(List<GenericValue> values) {
		List<Timesheet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Timesheet(value));
		}
		return entities;
	}
}