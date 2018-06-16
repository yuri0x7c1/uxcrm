package org.apache.ofbiz.service.schedule;

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
public class RecurrenceInfo implements Serializable {

	public static final long serialVersionUID = 5446923058062280704L;
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

	public enum Fields {
		recurrenceInfoId, startDateTime, exceptionDateTimes, recurrenceDateTimes, exceptionRuleId, recurrenceRuleId, recurrenceCount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public RecurrenceInfo(GenericValue value) {
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		startDateTime = (Timestamp) value.get(Fields.startDateTime.name());
		exceptionDateTimes = (String) value.get(Fields.exceptionDateTimes
				.name());
		recurrenceDateTimes = (String) value.get(Fields.recurrenceDateTimes
				.name());
		exceptionRuleId = (String) value.get(Fields.exceptionRuleId.name());
		recurrenceRuleId = (String) value.get(Fields.recurrenceRuleId.name());
		recurrenceCount = (Long) value.get(Fields.recurrenceCount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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