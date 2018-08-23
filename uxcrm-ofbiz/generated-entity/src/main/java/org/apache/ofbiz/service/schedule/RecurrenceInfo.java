package org.apache.ofbiz.service.schedule;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Recurrence Info
 */
@FieldNameConstants
public class RecurrenceInfo implements Serializable {

	public static final long serialVersionUID = 4479512839744910336L;
	public static final String NAME = "RecurrenceInfo";
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Start Date Time
	 */
	@Getter
	@Setter
	private Timestamp startDateTime;
	/**
	 * Exception Date Times
	 */
	@Getter
	@Setter
	private String exceptionDateTimes;
	/**
	 * Recurrence Date Times
	 */
	@Getter
	@Setter
	private String recurrenceDateTimes;
	/**
	 * Exception Rule Id
	 */
	@Getter
	@Setter
	private String exceptionRuleId;
	/**
	 * Recurrence Rule Id
	 */
	@Getter
	@Setter
	private String recurrenceRuleId;
	/**
	 * Recurrence Count
	 */
	@Getter
	@Setter
	private Long recurrenceCount;
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

	public RecurrenceInfo(GenericValue value) {
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		startDateTime = (Timestamp) value.get(FIELD_START_DATE_TIME);
		exceptionDateTimes = (String) value.get(FIELD_EXCEPTION_DATE_TIMES);
		recurrenceDateTimes = (String) value.get(FIELD_RECURRENCE_DATE_TIMES);
		exceptionRuleId = (String) value.get(FIELD_EXCEPTION_RULE_ID);
		recurrenceRuleId = (String) value.get(FIELD_RECURRENCE_RULE_ID);
		recurrenceCount = (Long) value.get(FIELD_RECURRENCE_COUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static RecurrenceInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RecurrenceInfo(value);
	}

	public static List<RecurrenceInfo> fromValues(List<GenericValue> values) {
		List<RecurrenceInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RecurrenceInfo(value));
		}
		return entities;
	}
}