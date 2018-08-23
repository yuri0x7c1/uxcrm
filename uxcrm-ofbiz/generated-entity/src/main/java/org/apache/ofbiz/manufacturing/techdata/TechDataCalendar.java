package org.apache.ofbiz.manufacturing.techdata;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TechDataCalendar implements Serializable {

	public static final long serialVersionUID = 4764258000397441024L;
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

	public TechDataCalendar(GenericValue value) {
		calendarId = (String) value.get(FIELD_CALENDAR_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		calendarWeekId = (String) value.get(FIELD_CALENDAR_WEEK_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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