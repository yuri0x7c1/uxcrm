package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyContactMechPurpose implements Serializable {

	public static final long serialVersionUID = 5475692420624605184L;
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

	public PartyContactMechPurpose(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		contactMechPurposeTypeId = (String) value
				.get(FIELD_CONTACT_MECH_PURPOSE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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