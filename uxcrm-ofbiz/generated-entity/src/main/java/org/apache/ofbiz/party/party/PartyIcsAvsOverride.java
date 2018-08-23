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
 * Party Ics Avs Override
 */
@FieldNameConstants
public class PartyIcsAvsOverride implements Serializable {

	public static final long serialVersionUID = 1233288659383099392L;
	public static final String NAME = "PartyIcsAvsOverride";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Avs Decline String
	 */
	@Getter
	@Setter
	private String avsDeclineString;
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

	public PartyIcsAvsOverride(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		avsDeclineString = (String) value.get(FIELD_AVS_DECLINE_STRING);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyIcsAvsOverride fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIcsAvsOverride(value);
	}

	public static List<PartyIcsAvsOverride> fromValues(List<GenericValue> values) {
		List<PartyIcsAvsOverride> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIcsAvsOverride(value));
		}
		return entities;
	}
}