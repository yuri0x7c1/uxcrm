package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List Party And Contact Mech
 */
public class ContactListPartyAndContactMech implements Serializable {

	public static final long serialVersionUID = 6482275325769991168L;
	public static final String NAME = "ContactListPartyAndContactMech";
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
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Contact List Id
	 */
	@Getter
	@Setter
	private String contactListId;
	/**
	 * Preferred Contact Mech Id
	 */
	@Getter
	@Setter
	private String preferredContactMechId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;

	public enum Fields {
		contactFromDate, contactThruDate, fromDate, statusId, contactListId, preferredContactMechId, partyId, thruDate, infoString, contactMechTypeId, contactMechId
	}

	public ContactListPartyAndContactMech(GenericValue value) {
		contactFromDate = (Timestamp) value.get(Fields.contactFromDate.name());
		contactThruDate = (Timestamp) value.get(Fields.contactThruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		contactListId = (String) value.get(Fields.contactListId.name());
		preferredContactMechId = (String) value
				.get(Fields.preferredContactMechId.name());
		partyId = (String) value.get(Fields.partyId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		infoString = (String) value.get(Fields.infoString.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static ContactListPartyAndContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactListPartyAndContactMech(value);
	}

	public static List<ContactListPartyAndContactMech> fromValues(
			List<GenericValue> values) {
		List<ContactListPartyAndContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactListPartyAndContactMech(value));
		}
		return entities;
	}
}