package org.apache.ofbiz.workeffort.timesheet;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Time Entry
 */
public class TimeEntry implements Serializable {

	public static final long serialVersionUID = 3124609486760702976L;
	public static final String NAME = "TimeEntry";
	/**
	 * Time Entry Id
	 */
	@Getter
	@Setter
	private String timeEntryId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Timesheet Id
	 */
	@Getter
	@Setter
	private String timesheetId;
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
		timeEntryId, partyId, fromDate, thruDate, rateTypeId, workEffortId, timesheetId, invoiceId, invoiceItemSeqId, hours, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TimeEntry(GenericValue value) {
		timeEntryId = (String) value.get(Fields.timeEntryId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		timesheetId = (String) value.get(Fields.timesheetId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		hours = (Double) value.get(Fields.hours.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TimeEntry fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new TimeEntry(value);
	}

	public static List<TimeEntry> fromValues(List<GenericValue> values) {
		List<TimeEntry> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TimeEntry(value));
		}
		return entities;
	}
}