package org.apache.ofbiz.manufacturing.techdata;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tech Data Calendar
 */
public class TechDataCalendar implements Serializable {

	public static final long serialVersionUID = 3258908223861529600L;
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
		calendarId, description, calendarWeekId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TechDataCalendar(GenericValue value) {
		calendarId = (String) value.get(Fields.calendarId.name());
		description = (String) value.get(Fields.description.name());
		calendarWeekId = (String) value.get(Fields.calendarWeekId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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