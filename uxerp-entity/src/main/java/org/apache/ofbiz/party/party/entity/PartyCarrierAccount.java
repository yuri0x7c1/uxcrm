package org.apache.ofbiz.party.party.entity;

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

	public static final long serialVersionUID = 3915216810063824896L;
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

	public enum Fields {
		partyId, carrierPartyId, fromDate, thruDate, accountNumber
	}

	public PartyCarrierAccount(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		accountNumber = (String) value.get(Fields.accountNumber.name());
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