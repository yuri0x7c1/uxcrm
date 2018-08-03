package org.apache.ofbiz.service.schedule;

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
public class RecurrenceRule implements Serializable {

	public static final long serialVersionUID = 271843258802840576L;
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

	public enum Fields {
		recurrenceRuleId, frequency, untilDateTime, countNumber, intervalNumber, bySecondList, byMinuteList, byHourList, byDayList, byMonthDayList, byYearDayList, byWeekNoList, byMonthList, bySetPosList, weekStart, xName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public RecurrenceRule(GenericValue value) {
		recurrenceRuleId = (String) value.get(Fields.recurrenceRuleId.name());
		frequency = (String) value.get(Fields.frequency.name());
		untilDateTime = (Timestamp) value.get(Fields.untilDateTime.name());
		countNumber = (Long) value.get(Fields.countNumber.name());
		intervalNumber = (Long) value.get(Fields.intervalNumber.name());
		bySecondList = (String) value.get(Fields.bySecondList.name());
		byMinuteList = (String) value.get(Fields.byMinuteList.name());
		byHourList = (String) value.get(Fields.byHourList.name());
		byDayList = (String) value.get(Fields.byDayList.name());
		byMonthDayList = (String) value.get(Fields.byMonthDayList.name());
		byYearDayList = (String) value.get(Fields.byYearDayList.name());
		byWeekNoList = (String) value.get(Fields.byWeekNoList.name());
		byMonthList = (String) value.get(Fields.byMonthList.name());
		bySetPosList = (String) value.get(Fields.bySetPosList.name());
		weekStart = (String) value.get(Fields.weekStart.name());
		xName = (String) value.get(Fields.xName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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