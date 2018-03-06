package org.apache.ofbiz.manufacturing.techdata.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tech Data Calendar Exc Week
 */
public class TechDataCalendarExcWeek implements Serializable {

	public static final long serialVersionUID = 1301116872927679488L;
	public static final String NAME = "TechDataCalendarExcWeek";
	/**
	 * Calendar Id
	 */
	@Getter
	@Setter
	private String calendarId;
	/**
	 * Exception Date Start
	 */
	@Getter
	@Setter
	private Date exceptionDateStart;
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

	public enum Fields {
		calendarId, exceptionDateStart, calendarWeekId, description
	}

	public TechDataCalendarExcWeek(GenericValue value) {
		calendarId = (String) value.get(Fields.calendarId.name());
		exceptionDateStart = (Date) value.get(Fields.exceptionDateStart.name());
		calendarWeekId = (String) value.get(Fields.calendarWeekId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TechDataCalendarExcWeek fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TechDataCalendarExcWeek(value);
	}

	public static List<TechDataCalendarExcWeek> fromValues(
			List<GenericValue> values) {
		List<TechDataCalendarExcWeek> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TechDataCalendarExcWeek(value));
		}
		return entities;
	}
}