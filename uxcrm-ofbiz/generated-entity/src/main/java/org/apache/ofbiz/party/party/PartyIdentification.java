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
 * Party Identification
 */
@FieldNameConstants
public class PartyIdentification implements Serializable {

	public static final long serialVersionUID = 1681019783550280704L;
	public static final String NAME = "PartyIdentification";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Identification Type Id
	 */
	@Getter
	@Setter
	private String partyIdentificationTypeId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;
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

	public PartyIdentification(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyIdentificationTypeId = (String) value
				.get(FIELD_PARTY_IDENTIFICATION_TYPE_ID);
		idValue = (String) value.get(FIELD_ID_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyIdentification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIdentification(value);
	}

	public static List<PartyIdentification> fromValues(List<GenericValue> values) {
		List<PartyIdentification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIdentification(value));
		}
		return entities;
	}
}