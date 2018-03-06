package org.apache.ofbiz.humanres.position.entity;

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

	public static final long serialVersionUID = 4689429001941694464L;
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

	public enum Fields {
		emplPositionId, responsibilityTypeId, fromDate, thruDate, comments
	}

	public EmplPositionResponsibility(GenericValue value) {
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		responsibilityTypeId = (String) value.get(Fields.responsibilityTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
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