package org.apache.ofbiz.workeffort.timesheet;

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
public class Timesheet implements Serializable {

	public static final long serialVersionUID = 6275816586510913536L;
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

	public enum Fields {
		timesheetId, partyId, clientPartyId, fromDate, thruDate, statusId, approvedByUserLoginId, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Timesheet(GenericValue value) {
		timesheetId = (String) value.get(Fields.timesheetId.name());
		partyId = (String) value.get(Fields.partyId.name());
		clientPartyId = (String) value.get(Fields.clientPartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		approvedByUserLoginId = (String) value.get(Fields.approvedByUserLoginId
				.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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