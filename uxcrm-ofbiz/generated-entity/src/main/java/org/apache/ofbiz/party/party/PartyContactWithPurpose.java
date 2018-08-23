package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyContactWithPurpose implements Serializable {

	public static final long serialVersionUID = 2682848228302849024L;
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

	public PartyContactWithPurpose(GenericValue value) {
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		contactMechPurposeTypeId = (String) value
				.get(FIELD_CONTACT_MECH_PURPOSE_TYPE_ID);
		contactFromDate = (Timestamp) value.get(FIELD_CONTACT_FROM_DATE);
		contactThruDate = (Timestamp) value.get(FIELD_CONTACT_THRU_DATE);
		purposeFromDate = (Timestamp) value.get(FIELD_PURPOSE_FROM_DATE);
		purposeThruDate = (Timestamp) value.get(FIELD_PURPOSE_THRU_DATE);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		infoString = (String) value.get(FIELD_INFO_STRING);
		comments = (String) value.get(FIELD_COMMENTS);
		extension = (String) value.get(FIELD_EXTENSION);
		allowSolicitation = (String) value.get(FIELD_ALLOW_SOLICITATION);
		purposeDescription = (String) value.get(FIELD_PURPOSE_DESCRIPTION);
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