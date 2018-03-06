package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Classification
 */
public class PartyClassification implements Serializable {

	public static final long serialVersionUID = 7847108307220576256L;
	public static final String NAME = "PartyClassification";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Classification Group Id
	 */
	@Getter
	@Setter
	private String partyClassificationGroupId;
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

	public enum Fields {
		partyId, partyClassificationGroupId, fromDate, thruDate
	}

	public PartyClassification(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyClassificationGroupId = (String) value
				.get(Fields.partyClassificationGroupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static PartyClassification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyClassification(value);
	}

	public static List<PartyClassification> fromValues(List<GenericValue> values) {
		List<PartyClassification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyClassification(value));
		}
		return entities;
	}
}