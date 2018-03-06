package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Contact Mech Purpose
 */
public class PartyContactMechPurpose implements Serializable {

	public static final long serialVersionUID = 1660335951755992064L;
	public static final String NAME = "PartyContactMechPurpose";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
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
		partyId, contactMechId, contactMechPurposeTypeId, fromDate, thruDate
	}

	public PartyContactMechPurpose(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static PartyContactMechPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContactMechPurpose(value);
	}

	public static List<PartyContactMechPurpose> fromValues(
			List<GenericValue> values) {
		List<PartyContactMechPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContactMechPurpose(value));
		}
		return entities;
	}
}