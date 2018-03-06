package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Timesheet And Time Entry
 */
public class TimesheetAndTimeEntry implements Serializable {

	public static final long serialVersionUID = 5812499760206758912L;
	public static final String NAME = "TimesheetAndTimeEntry";
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
	 * Time Entry Id
	 */
	@Getter
	@Setter
	private String timeEntryId;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Hours
	 */
	@Getter
	@Setter
	private Double hours;

	public enum Fields {
		timesheetId, partyId, clientPartyId, fromDate, thruDate, statusId, approvedByUserLoginId, comments, timeEntryId, rateTypeId, workEffortId, invoiceId, invoiceItemSeqId, hours
	}

	public TimesheetAndTimeEntry(GenericValue value) {
		timesheetId = (String) value.get(Fields.timesheetId.name());
		partyId = (String) value.get(Fields.partyId.name());
		clientPartyId = (String) value.get(Fields.clientPartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		approvedByUserLoginId = (String) value.get(Fields.approvedByUserLoginId
				.name());
		comments = (String) value.get(Fields.comments.name());
		timeEntryId = (String) value.get(Fields.timeEntryId.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		hours = (Double) value.get(Fields.hours.name());
	}

	public static TimesheetAndTimeEntry fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TimesheetAndTimeEntry(value);
	}

	public static List<TimesheetAndTimeEntry> fromValues(
			List<GenericValue> values) {
		List<TimesheetAndTimeEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TimesheetAndTimeEntry(value));
		}
		return entities;
	}
}