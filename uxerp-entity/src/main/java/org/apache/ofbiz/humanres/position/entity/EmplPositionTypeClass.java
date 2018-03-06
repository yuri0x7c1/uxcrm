package org.apache.ofbiz.humanres.position.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Type Class
 */
public class EmplPositionTypeClass implements Serializable {

	public static final long serialVersionUID = 2118900476206219264L;
	public static final String NAME = "EmplPositionTypeClass";
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Empl Position Class Type Id
	 */
	@Getter
	@Setter
	private String emplPositionClassTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Standard Hours Per Week
	 */
	@Getter
	@Setter
	private Double standardHoursPerWeek;

	public enum Fields {
		emplPositionTypeId, emplPositionClassTypeId, fromDate, thruDate, standardHoursPerWeek
	}

	public EmplPositionTypeClass(GenericValue value) {
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		emplPositionClassTypeId = (String) value
				.get(Fields.emplPositionClassTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		standardHoursPerWeek = (Double) value.get(Fields.standardHoursPerWeek
				.name());
	}

	public static EmplPositionTypeClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionTypeClass(value);
	}

	public static List<EmplPositionTypeClass> fromValues(
			List<GenericValue> values) {
		List<EmplPositionTypeClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionTypeClass(value));
		}
		return entities;
	}
}