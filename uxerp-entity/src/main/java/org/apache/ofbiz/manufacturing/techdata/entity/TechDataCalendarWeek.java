package org.apache.ofbiz.manufacturing.techdata.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tech Data Calendar Week
 */
public class TechDataCalendarWeek implements Serializable {

	public static final long serialVersionUID = 8981251996025279488L;
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

	public enum Fields {
		calendarWeekId, description, mondayStartTime, mondayCapacity, tuesdayStartTime, tuesdayCapacity, wednesdayStartTime, wednesdayCapacity, thursdayStartTime, thursdayCapacity, fridayStartTime, fridayCapacity, saturdayStartTime, saturdayCapacity, sundayStartTime, sundayCapacity
	}

	public TechDataCalendarWeek(GenericValue value) {
		calendarWeekId = (String) value.get(Fields.calendarWeekId.name());
		description = (String) value.get(Fields.description.name());
		mondayStartTime = (Time) value.get(Fields.mondayStartTime.name());
		mondayCapacity = (Double) value.get(Fields.mondayCapacity.name());
		tuesdayStartTime = (Time) value.get(Fields.tuesdayStartTime.name());
		tuesdayCapacity = (Double) value.get(Fields.tuesdayCapacity.name());
		wednesdayStartTime = (Time) value.get(Fields.wednesdayStartTime.name());
		wednesdayCapacity = (Double) value.get(Fields.wednesdayCapacity.name());
		thursdayStartTime = (Time) value.get(Fields.thursdayStartTime.name());
		thursdayCapacity = (Double) value.get(Fields.thursdayCapacity.name());
		fridayStartTime = (Time) value.get(Fields.fridayStartTime.name());
		fridayCapacity = (Double) value.get(Fields.fridayCapacity.name());
		saturdayStartTime = (Time) value.get(Fields.saturdayStartTime.name());
		saturdayCapacity = (Double) value.get(Fields.saturdayCapacity.name());
		sundayStartTime = (Time) value.get(Fields.sundayStartTime.name());
		sundayCapacity = (Double) value.get(Fields.sundayCapacity.name());
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