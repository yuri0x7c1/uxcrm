package org.apache.ofbiz.marketing.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List Party
 */
public class ContactListParty implements Serializable {

	public static final long serialVersionUID = 7479356184001630208L;
	public static final String NAME = "ContactListParty";
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

	public enum Fields {
		contactListId, partyId, fromDate, thruDate, statusId, preferredContactMechId
	}

	public ContactListParty(GenericValue value) {
		contactListId = (String) value.get(Fields.contactListId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredContactMechId = (String) value
				.get(Fields.preferredContactMechId.name());
	}

	public static ContactListParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactListParty(value);
	}

	public static List<ContactListParty> fromValues(List<GenericValue> values) {
		List<ContactListParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactListParty(value));
		}
		return entities;
	}
}