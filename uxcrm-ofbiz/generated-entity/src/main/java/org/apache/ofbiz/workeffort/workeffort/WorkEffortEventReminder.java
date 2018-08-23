package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Event Reminder
 */
@FieldNameConstants
public class WorkEffortEventReminder implements Serializable {

	public static final long serialVersionUID = 153084130655158272L;
	public static final String NAME = "WorkEffortEventReminder";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Reminder Date Time
	 */
	@Getter
	@Setter
	private Timestamp reminderDateTime;
	/**
	 * Repeat Count
	 */
	@Getter
	@Setter
	private Long repeatCount;
	/**
	 * Repeat Interval
	 */
	@Getter
	@Setter
	private Long repeatInterval;
	/**
	 * Current Count
	 */
	@Getter
	@Setter
	private Long currentCount;
	/**
	 * Reminder Offset
	 */
	@Getter
	@Setter
	private Long reminderOffset;
	/**
	 * Locale Id
	 */
	@Getter
	@Setter
	private String localeId;
	/**
	 * Time Zone Id
	 */
	@Getter
	@Setter
	private String timeZoneId;
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

	public WorkEffortEventReminder(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		reminderDateTime = (Timestamp) value.get(FIELD_REMINDER_DATE_TIME);
		repeatCount = (Long) value.get(FIELD_REPEAT_COUNT);
		repeatInterval = (Long) value.get(FIELD_REPEAT_INTERVAL);
		currentCount = (Long) value.get(FIELD_CURRENT_COUNT);
		reminderOffset = (Long) value.get(FIELD_REMINDER_OFFSET);
		localeId = (String) value.get(FIELD_LOCALE_ID);
		timeZoneId = (String) value.get(FIELD_TIME_ZONE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortEventReminder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortEventReminder(value);
	}

	public static List<WorkEffortEventReminder> fromValues(
			List<GenericValue> values) {
		List<WorkEffortEventReminder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortEventReminder(value));
		}
		return entities;
	}
}