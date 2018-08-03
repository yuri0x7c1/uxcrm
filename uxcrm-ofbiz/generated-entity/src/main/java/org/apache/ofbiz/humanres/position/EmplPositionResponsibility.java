package org.apache.ofbiz.humanres.position;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Responsibility
 */
public class EmplPositionResponsibility implements Serializable {

	public static final long serialVersionUID = 5192263194190141440L;
	public static final String NAME = "EmplPositionResponsibility";
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * Responsibility Type Id
	 */
	@Getter
	@Setter
	private String responsibilityTypeId;
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
		emplPositionId, responsibilityTypeId, fromDate, thruDate, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EmplPositionResponsibility(GenericValue value) {
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		responsibilityTypeId = (String) value.get(Fields.responsibilityTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static EmplPositionResponsibility fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionResponsibility(value);
	}

	public static List<EmplPositionResponsibility> fromValues(
			List<GenericValue> values) {
		List<EmplPositionResponsibility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionResponsibility(value));
		}
		return entities;
	}
}