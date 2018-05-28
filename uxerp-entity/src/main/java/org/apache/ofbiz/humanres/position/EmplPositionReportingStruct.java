package org.apache.ofbiz.humanres.position;

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
public class EmplPositionReportingStruct implements Serializable {

	public static final long serialVersionUID = 4642360843773081600L;
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

	public enum Fields {
		emplPositionIdReportingTo, emplPositionIdManagedBy, fromDate, thruDate, comments, primaryFlag, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EmplPositionReportingStruct(GenericValue value) {
		emplPositionIdReportingTo = (String) value
				.get(Fields.emplPositionIdReportingTo.name());
		emplPositionIdManagedBy = (String) value
				.get(Fields.emplPositionIdManagedBy.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		primaryFlag = (String) value.get(Fields.primaryFlag.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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