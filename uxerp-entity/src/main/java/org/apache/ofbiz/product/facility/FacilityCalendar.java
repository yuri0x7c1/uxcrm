package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Calendar
 */
public class FacilityCalendar implements Serializable {

	public static final long serialVersionUID = 1819864977391746048L;
	public static final String NAME = "FacilityCalendar";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Calendar Id
	 */
	@Getter
	@Setter
	private String calendarId;
	/**
	 * Facility Calendar Type Id
	 */
	@Getter
	@Setter
	private String facilityCalendarTypeId;
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
		facilityId, calendarId, facilityCalendarTypeId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FacilityCalendar(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		calendarId = (String) value.get(Fields.calendarId.name());
		facilityCalendarTypeId = (String) value
				.get(Fields.facilityCalendarTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FacilityCalendar fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityCalendar(value);
	}

	public static List<FacilityCalendar> fromValues(List<GenericValue> values) {
		List<FacilityCalendar> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityCalendar(value));
		}
		return entities;
	}
}