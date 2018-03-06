package org.apache.ofbiz.party.contact.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List Party And Contact Mech
 */
public class ContactListPartyAndContactMech implements Serializable {

	public static final long serialVersionUID = 7273458798253280256L;
	public static final String NAME = "ContactListPartyAndContactMech";
	/**
	 * Contact List Id
	 */
	@Getter
	@Setter
	private String contactListId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Preferred Contact Mech Id
	 */
	@Getter
	@Setter
	private String preferredContactMechId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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

	public enum Fields {
		contactListId, partyId, fromDate, thruDate, statusId, preferredContactMechId, contactMechId, contactMechTypeId, infoString
	}

	public ContactListPartyAndContactMech(GenericValue value) {
		contactListId = (String) value.get(Fields.contactListId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredContactMechId = (String) value
				.get(Fields.preferredContactMechId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
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