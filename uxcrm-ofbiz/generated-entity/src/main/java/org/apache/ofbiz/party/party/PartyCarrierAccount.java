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
 * Party Carrier Account
 */
@FieldNameConstants
public class PartyCarrierAccount implements Serializable {

	public static final long serialVersionUID = 2839025142783740928L;
	public static final String NAME = "PartyCarrierAccount";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
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
	 * Account Number
	 */
	@Getter
	@Setter
	private String accountNumber;
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

	public PartyCarrierAccount(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		accountNumber = (String) value.get(FIELD_ACCOUNT_NUMBER);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyCarrierAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyCarrierAccount(value);
	}

	public static List<PartyCarrierAccount> fromValues(List<GenericValue> values) {
		List<PartyCarrierAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyCarrierAccount(value));
		}
		return entities;
	}
}