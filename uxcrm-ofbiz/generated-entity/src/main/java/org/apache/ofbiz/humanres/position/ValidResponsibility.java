package org.apache.ofbiz.humanres.position;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Valid Responsibility
 */
public class ValidResponsibility implements Serializable {

	public static final long serialVersionUID = 2432517584461872128L;
	public static final String NAME = "ValidResponsibility";
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
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
		emplPositionTypeId, responsibilityTypeId, fromDate, thruDate, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ValidResponsibility(GenericValue value) {
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
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

	public static ValidResponsibility fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ValidResponsibility(value);
	}

	public static List<ValidResponsibility> fromValues(List<GenericValue> values) {
		List<ValidResponsibility> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ValidResponsibility(value));
		}
		return entities;
	}
}