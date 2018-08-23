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
 * Recurrence Rule
 */
@FieldNameConstants
public class RecurrenceRule implements Serializable {

	public static final long serialVersionUID = 3576115689832863744L;
	public static final String NAME = "RecurrenceRule";
	/**
	 * Recurrence Rule Id
	 */
	@Getter
	@Setter
	private String recurrenceRuleId;
	/**
	 * Frequency
	 */
	@Getter
	@Setter
	private String frequency;
	/**
	 * Until Date Time
	 */
	@Getter
	@Setter
	private Timestamp untilDateTime;
	/**
	 * Count Number
	 */
	@Getter
	@Setter
	private Long countNumber;
	/**
	 * Interval Number
	 */
	@Getter
	@Setter
	private Long intervalNumber;
	/**
	 * By Second List
	 */
	@Getter
	@Setter
	private String bySecondList;
	/**
	 * By Minute List
	 */
	@Getter
	@Setter
	private String byMinuteList;
	/**
	 * By Hour List
	 */
	@Getter
	@Setter
	private String byHourList;
	/**
	 * By Day List
	 */
	@Getter
	@Setter
	private String byDayList;
	/**
	 * By Month Day List
	 */
	@Getter
	@Setter
	private String byMonthDayList;
	/**
	 * By Year Day List
	 */
	@Getter
	@Setter
	private String byYearDayList;
	/**
	 * By Week No List
	 */
	@Getter
	@Setter
	private String byWeekNoList;
	/**
	 * By Month List
	 */
	@Getter
	@Setter
	private String byMonthList;
	/**
	 * By Set Pos List
	 */
	@Getter
	@Setter
	private String bySetPosList;
	/**
	 * Week Start
	 */
	@Getter
	@Setter
	private String weekStart;
	/**
	 * X Name
	 */
	@Getter
	@Setter
	private String xName;
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

	public RecurrenceRule(GenericValue value) {
		recurrenceRuleId = (String) value.get(FIELD_RECURRENCE_RULE_ID);
		frequency = (String) value.get(FIELD_FREQUENCY);
		untilDateTime = (Timestamp) value.get(FIELD_UNTIL_DATE_TIME);
		countNumber = (Long) value.get(FIELD_COUNT_NUMBER);
		intervalNumber = (Long) value.get(FIELD_INTERVAL_NUMBER);
		bySecondList = (String) value.get(FIELD_BY_SECOND_LIST);
		byMinuteList = (String) value.get(FIELD_BY_MINUTE_LIST);
		byHourList = (String) value.get(FIELD_BY_HOUR_LIST);
		byDayList = (String) value.get(FIELD_BY_DAY_LIST);
		byMonthDayList = (String) value.get(FIELD_BY_MONTH_DAY_LIST);
		byYearDayList = (String) value.get(FIELD_BY_YEAR_DAY_LIST);
		byWeekNoList = (String) value.get(FIELD_BY_WEEK_NO_LIST);
		byMonthList = (String) value.get(FIELD_BY_MONTH_LIST);
		bySetPosList = (String) value.get(FIELD_BY_SET_POS_LIST);
		weekStart = (String) value.get(FIELD_WEEK_START);
		xName = (String) value.get(FIELD_X_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static RecurrenceRule fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RecurrenceRule(value);
	}

	public static List<RecurrenceRule> fromValues(List<GenericValue> values) {
		List<RecurrenceRule> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RecurrenceRule(value));
		}
		return entities;
	}
}