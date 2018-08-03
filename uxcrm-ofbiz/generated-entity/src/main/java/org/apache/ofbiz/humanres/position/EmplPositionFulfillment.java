package org.apache.ofbiz.humanres.position;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Fulfillment
 */
public class EmplPositionFulfillment implements Serializable {

	public static final long serialVersionUID = 4118265230109601792L;
	public static final String NAME = "EmplPositionFulfillment";
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
		emplPositionId, partyId, fromDate, thruDate, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EmplPositionFulfillment(GenericValue value) {
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		partyId = (String) value.get(Fields.partyId.name());
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

	public static EmplPositionFulfillment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionFulfillment(value);
	}

	public static List<EmplPositionFulfillment> fromValues(
			List<GenericValue> values) {
		List<EmplPositionFulfillment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionFulfillment(value));
		}
		return entities;
	}
}