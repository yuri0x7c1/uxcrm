package org.apache.ofbiz.manufacturing.techdata;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tech Data Calendar Week
 */
@FieldNameConstants
public class TechDataCalendarWeek implements Serializable {

	public static final long serialVersionUID = 326980747818507264L;
	public static final String NAME = "TechDataCalendarWeek";
	/**
	 * Calendar Week Id
	 */
	@Getter
	@Setter
	private String calendarWeekId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Monday Start Time
	 */
	@Getter
	@Setter
	private Time mondayStartTime;
	/**
	 * Monday Capacity
	 */
	@Getter
	@Setter
	private Double mondayCapacity;
	/**
	 * Tuesday Start Time
	 */
	@Getter
	@Setter
	private Time tuesdayStartTime;
	/**
	 * Tuesday Capacity
	 */
	@Getter
	@Setter
	private Double tuesdayCapacity;
	/**
	 * Wednesday Start Time
	 */
	@Getter
	@Setter
	private Time wednesdayStartTime;
	/**
	 * Wednesday Capacity
	 */
	@Getter
	@Setter
	private Double wednesdayCapacity;
	/**
	 * Thursday Start Time
	 */
	@Getter
	@Setter
	private Time thursdayStartTime;
	/**
	 * Thursday Capacity
	 */
	@Getter
	@Setter
	private Double thursdayCapacity;
	/**
	 * Friday Start Time
	 */
	@Getter
	@Setter
	private Time fridayStartTime;
	/**
	 * Friday Capacity
	 */
	@Getter
	@Setter
	private Double fridayCapacity;
	/**
	 * Saturday Start Time
	 */
	@Getter
	@Setter
	private Time saturdayStartTime;
	/**
	 * Saturday Capacity
	 */
	@Getter
	@Setter
	private Double saturdayCapacity;
	/**
	 * Sunday Start Time
	 */
	@Getter
	@Setter
	private Time sundayStartTime;
	/**
	 * Sunday Capacity
	 */
	@Getter
	@Setter
	private Double sundayCapacity;
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

	public TechDataCalendarWeek(GenericValue value) {
		calendarWeekId = (String) value.get(FIELD_CALENDAR_WEEK_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		mondayStartTime = (Time) value.get(FIELD_MONDAY_START_TIME);
		mondayCapacity = (Double) value.get(FIELD_MONDAY_CAPACITY);
		tuesdayStartTime = (Time) value.get(FIELD_TUESDAY_START_TIME);
		tuesdayCapacity = (Double) value.get(FIELD_TUESDAY_CAPACITY);
		wednesdayStartTime = (Time) value.get(FIELD_WEDNESDAY_START_TIME);
		wednesdayCapacity = (Double) value.get(FIELD_WEDNESDAY_CAPACITY);
		thursdayStartTime = (Time) value.get(FIELD_THURSDAY_START_TIME);
		thursdayCapacity = (Double) value.get(FIELD_THURSDAY_CAPACITY);
		fridayStartTime = (Time) value.get(FIELD_FRIDAY_START_TIME);
		fridayCapacity = (Double) value.get(FIELD_FRIDAY_CAPACITY);
		saturdayStartTime = (Time) value.get(FIELD_SATURDAY_START_TIME);
		saturdayCapacity = (Double) value.get(FIELD_SATURDAY_CAPACITY);
		sundayStartTime = (Time) value.get(FIELD_SUNDAY_START_TIME);
		sundayCapacity = (Double) value.get(FIELD_SUNDAY_CAPACITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TechDataCalendarWeek fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TechDataCalendarWeek(value);
	}

	public static List<TechDataCalendarWeek> fromValues(
			List<GenericValue> values) {
		List<TechDataCalendarWeek> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TechDataCalendarWeek(value));
		}
		return entities;
	}
}