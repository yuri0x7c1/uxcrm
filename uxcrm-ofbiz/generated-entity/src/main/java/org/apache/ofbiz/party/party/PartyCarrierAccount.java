package org.apache.ofbiz.party.party;

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
public class PartyCarrierAccount implements Serializable {

	public static final long serialVersionUID = 8703626669095815168L;
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

	public enum Fields {
		partyId, carrierPartyId, fromDate, thruDate, accountNumber, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyCarrierAccount(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		accountNumber = (String) value.get(Fields.accountNumber.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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