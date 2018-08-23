package org.apache.ofbiz.humanres.position;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class EmplPositionTypeClass implements Serializable {

	public static final long serialVersionUID = 4687987158819642368L;
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

	public EmplPositionTypeClass(GenericValue value) {
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		emplPositionClassTypeId = (String) value
				.get(FIELD_EMPL_POSITION_CLASS_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		standardHoursPerWeek = (Double) value
				.get(FIELD_STANDARD_HOURS_PER_WEEK);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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