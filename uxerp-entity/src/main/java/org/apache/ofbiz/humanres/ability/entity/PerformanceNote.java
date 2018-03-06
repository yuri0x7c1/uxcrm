package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Performance Note
 */
public class PerformanceNote implements Serializable {

	public static final long serialVersionUID = 4363124115720809472L;
	public static final String NAME = "PerformanceNote";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
	 * Communication Date
	 */
	@Getter
	@Setter
	private Timestamp communicationDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		partyId, roleTypeId, fromDate, thruDate, communicationDate, comments
	}

	public PerformanceNote(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		communicationDate = (Timestamp) value.get(Fields.communicationDate
				.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static PerformanceNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PerformanceNote(value);
	}

	public static List<PerformanceNote> fromValues(List<GenericValue> values) {
		List<PerformanceNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PerformanceNote(value));
		}
		return entities;
	}
}