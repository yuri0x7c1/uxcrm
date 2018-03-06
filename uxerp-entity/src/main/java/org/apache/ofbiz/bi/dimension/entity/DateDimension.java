package org.apache.ofbiz.bi.dimension.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Date Dimension
 */
public class DateDimension implements Serializable {

	public static final long serialVersionUID = 6520309456440543232L;
	public static final String NAME = "DateDimension";
	/**
	 * Dimension Id
	 */
	@Getter
	@Setter
	private String dimensionId;
	/**
	 * Date Value
	 */
	@Getter
	@Setter
	private Date dateValue;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Day Name
	 */
	@Getter
	@Setter
	private String dayName;
	/**
	 * Day Of Month
	 */
	@Getter
	@Setter
	private Long dayOfMonth;
	/**
	 * Day Of Year
	 */
	@Getter
	@Setter
	private Long dayOfYear;
	/**
	 * Month Name
	 */
	@Getter
	@Setter
	private String monthName;
	/**
	 * Month Of Year
	 */
	@Getter
	@Setter
	private Long monthOfYear;
	/**
	 * Year Name
	 */
	@Getter
	@Setter
	private Long yearName;
	/**
	 * Week Of Month
	 */
	@Getter
	@Setter
	private Long weekOfMonth;
	/**
	 * Week Of Year
	 */
	@Getter
	@Setter
	private Long weekOfYear;
	/**
	 * Year Month Day
	 */
	@Getter
	@Setter
	private String yearMonthDay;
	/**
	 * Year And Month
	 */
	@Getter
	@Setter
	private String yearAndMonth;
	/**
	 * Weekday Type
	 */
	@Getter
	@Setter
	private String weekdayType;

	public enum Fields {
		dimensionId, dateValue, description, dayName, dayOfMonth, dayOfYear, monthName, monthOfYear, yearName, weekOfMonth, weekOfYear, yearMonthDay, yearAndMonth, weekdayType
	}

	public DateDimension(GenericValue value) {
		dimensionId = (String) value.get(Fields.dimensionId.name());
		dateValue = (Date) value.get(Fields.dateValue.name());
		description = (String) value.get(Fields.description.name());
		dayName = (String) value.get(Fields.dayName.name());
		dayOfMonth = (Long) value.get(Fields.dayOfMonth.name());
		dayOfYear = (Long) value.get(Fields.dayOfYear.name());
		monthName = (String) value.get(Fields.monthName.name());
		monthOfYear = (Long) value.get(Fields.monthOfYear.name());
		yearName = (Long) value.get(Fields.yearName.name());
		weekOfMonth = (Long) value.get(Fields.weekOfMonth.name());
		weekOfYear = (Long) value.get(Fields.weekOfYear.name());
		yearMonthDay = (String) value.get(Fields.yearMonthDay.name());
		yearAndMonth = (String) value.get(Fields.yearAndMonth.name());
		weekdayType = (String) value.get(Fields.weekdayType.name());
	}

	public static DateDimension fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DateDimension(value);
	}

	public static List<DateDimension> fromValues(List<GenericValue> values) {
		List<DateDimension> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DateDimension(value));
		}
		return entities;
	}
}