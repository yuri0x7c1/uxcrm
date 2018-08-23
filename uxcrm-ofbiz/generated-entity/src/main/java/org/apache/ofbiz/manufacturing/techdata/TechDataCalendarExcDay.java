package org.apache.ofbiz.manufacturing.techdata;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TechDataCalendarExcDay implements Serializable {

	public static final long serialVersionUID = 6909373244380050432L;
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

	public TechDataCalendarExcDay(GenericValue value) {
		calendarId = (String) value.get(FIELD_CALENDAR_ID);
		exceptionDateStartTime = (Timestamp) value
				.get(FIELD_EXCEPTION_DATE_START_TIME);
		exceptionCapacity = (BigDecimal) value.get(FIELD_EXCEPTION_CAPACITY);
		usedCapacity = (BigDecimal) value.get(FIELD_USED_CAPACITY);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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