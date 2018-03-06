package org.apache.ofbiz.manufacturing.techdata.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tech Data Calendar
 */
public class TechDataCalendar implements Serializable {

	public static final long serialVersionUID = 8675584965276808192L;
	public static final String NAME = "TechDataCalendar";
	/**
	 * Calendar Id
	 */
	@Getter
	@Setter
	private String calendarId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Calendar Week Id
	 */
	@Getter
	@Setter
	private String calendarWeekId;

	public enum Fields {
		calendarId, description, calendarWeekId
	}

	public TechDataCalendar(GenericValue value) {
		calendarId = (String) value.get(Fields.calendarId.name());
		description = (String) value.get(Fields.description.name());
		calendarWeekId = (String) value.get(Fields.calendarWeekId.name());
	}

	public static TechDataCalendar fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TechDataCalendar(value);
	}

	public static List<TechDataCalendar> fromValues(List<GenericValue> values) {
		List<TechDataCalendar> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TechDataCalendar(value));
		}
		return entities;
	}
}