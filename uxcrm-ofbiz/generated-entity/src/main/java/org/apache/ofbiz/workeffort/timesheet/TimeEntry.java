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
 * Time Entry
 */
@FieldNameConstants
public class TimeEntry implements Serializable {

	public static final long serialVersionUID = 6936844562844041216L;
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

	public TimeEntry(GenericValue value) {
		timeEntryId = (String) value.get(FIELD_TIME_ENTRY_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		timesheetId = (String) value.get(FIELD_TIMESHEET_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		hours = (Double) value.get(FIELD_HOURS);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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