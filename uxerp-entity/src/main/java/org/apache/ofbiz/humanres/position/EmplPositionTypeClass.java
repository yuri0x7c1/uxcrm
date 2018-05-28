package org.apache.ofbiz.humanres.position;

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

	public static final long serialVersionUID = 2171888632966323200L;
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
		emplPositionTypeId, emplPositionClassTypeId, fromDate, thruDate, standardHoursPerWeek, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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