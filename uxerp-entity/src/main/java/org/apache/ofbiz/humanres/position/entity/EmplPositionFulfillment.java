package org.apache.ofbiz.humanres.position.entity;

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

	public static final long serialVersionUID = 5938950281896163328L;
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

	public enum Fields {
		emplPositionId, partyId, fromDate, thruDate, comments
	}

	public EmplPositionFulfillment(GenericValue value) {
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
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