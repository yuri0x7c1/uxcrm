package org.apache.ofbiz.manufacturing.techdata;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tech Data Calendar Exc Day
 */
public class TechDataCalendarExcDay implements Serializable {

	public static final long serialVersionUID = 8465648657360612352L;
	public static final String NAME = "TechDataCalendarExcDay";
	/**
	 * Calendar Id
	 */
	@Getter
	@Setter
	private String calendarId;
	/**
	 * Exception Date Start Time
	 */
	@Getter
	@Setter
	private Timestamp exceptionDateStartTime;
	/**
	 * Exception Capacity
	 */
	@Getter
	@Setter
	private BigDecimal exceptionCapacity;
	/**
	 * Used Capacity
	 */
	@Getter
	@Setter
	private BigDecimal usedCapacity;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		calendarId, exceptionDateStartTime, exceptionCapacity, usedCapacity, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TechDataCalendarExcDay(GenericValue value) {
		calendarId = (String) value.get(Fields.calendarId.name());
		exceptionDateStartTime = (Timestamp) value
				.get(Fields.exceptionDateStartTime.name());
		exceptionCapacity = (BigDecimal) value.get(Fields.exceptionCapacity
				.name());
		usedCapacity = (BigDecimal) value.get(Fields.usedCapacity.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TechDataCalendarExcDay fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TechDataCalendarExcDay(value);
	}

	public static List<TechDataCalendarExcDay> fromValues(
			List<GenericValue> values) {
		List<TechDataCalendarExcDay> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TechDataCalendarExcDay(value));
		}
		return entities;
	}
}