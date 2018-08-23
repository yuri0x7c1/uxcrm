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
 * Empl Position Reporting Struct
 */
@FieldNameConstants
public class EmplPositionReportingStruct implements Serializable {

	public static final long serialVersionUID = 3327754384864270336L;
	public static final String NAME = "EmplPositionReportingStruct";
	/**
	 * Empl Position Id Reporting To
	 */
	@Getter
	@Setter
	private String emplPositionIdReportingTo;
	/**
	 * Empl Position Id Managed By
	 */
	@Getter
	@Setter
	private String emplPositionIdManagedBy;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Primary Flag
	 */
	@Getter
	@Setter
	private String primaryFlag;
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

	public EmplPositionReportingStruct(GenericValue value) {
		emplPositionIdReportingTo = (String) value
				.get(FIELD_EMPL_POSITION_ID_REPORTING_TO);
		emplPositionIdManagedBy = (String) value
				.get(FIELD_EMPL_POSITION_ID_MANAGED_BY);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		primaryFlag = (String) value.get(FIELD_PRIMARY_FLAG);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EmplPositionReportingStruct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionReportingStruct(value);
	}

	public static List<EmplPositionReportingStruct> fromValues(
			List<GenericValue> values) {
		List<EmplPositionReportingStruct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionReportingStruct(value));
		}
		return entities;
	}
}