package org.apache.ofbiz.manufacturing.techdata;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tech Data Calendar Exc Week
 */
@FieldNameConstants
public class TechDataCalendarExcWeek implements Serializable {

	public static final long serialVersionUID = 743706591259223040L;
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

	public TechDataCalendarExcWeek(GenericValue value) {
		calendarId = (String) value.get(FIELD_CALENDAR_ID);
		exceptionDateStart = (Date) value.get(FIELD_EXCEPTION_DATE_START);
		calendarWeekId = (String) value.get(FIELD_CALENDAR_WEEK_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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