package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Contact With Purpose
 */
public class PartyContactWithPurpose implements Serializable {

	public static final long serialVersionUID = 2466174434744869888L;
	public static final String NAME = "PartyContactWithPurpose";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Contact From Date
	 */
	@Getter
	@Setter
	private Timestamp contactFromDate;
	/**
	 * Contact Thru Date
	 */
	@Getter
	@Setter
	private Timestamp contactThruDate;
	/**
	 * Purpose From Date
	 */
	@Getter
	@Setter
	private Timestamp purposeFromDate;
	/**
	 * Purpose Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purposeThruDate;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Allow Solicitation
	 */
	@Getter
	@Setter
	private String allowSolicitation;
	/**
	 * Purpose Description
	 */
	@Getter
	@Setter
	private String purposeDescription;

	public enum Fields {
		contactMechId, partyId, contactMechPurposeTypeId, contactFromDate, contactThruDate, purposeFromDate, purposeThruDate, contactMechTypeId, infoString, comments, extension, allowSolicitation, purposeDescription
	}

	public PartyContactWithPurpose(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		partyId = (String) value.get(Fields.partyId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		contactFromDate = (Timestamp) value.get(Fields.contactFromDate.name());
		contactThruDate = (Timestamp) value.get(Fields.contactThruDate.name());
		purposeFromDate = (Timestamp) value.get(Fields.purposeFromDate.name());
		purposeThruDate = (Timestamp) value.get(Fields.purposeThruDate.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
		comments = (String) value.get(Fields.comments.name());
		extension = (String) value.get(Fields.extension.name());
		allowSolicitation = (String) value.get(Fields.allowSolicitation.name());
		purposeDescription = (String) value.get(Fields.purposeDescription
				.name());
	}

	public static PartyContactWithPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContactWithPurpose(value);
	}

	public static List<PartyContactWithPurpose> fromValues(
			List<GenericValue> values) {
		List<PartyContactWithPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContactWithPurpose(value));
		}
		return entities;
	}
}