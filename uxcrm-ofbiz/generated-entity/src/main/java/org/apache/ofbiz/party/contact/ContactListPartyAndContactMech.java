package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContactListPartyAndContactMech implements Serializable {

	public static final long serialVersionUID = 7928097484110300160L;
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

	public ContactListPartyAndContactMech(GenericValue value) {
		contactFromDate = (Timestamp) value.get(FIELD_CONTACT_FROM_DATE);
		contactThruDate = (Timestamp) value.get(FIELD_CONTACT_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		preferredContactMechId = (String) value
				.get(FIELD_PREFERRED_CONTACT_MECH_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		infoString = (String) value.get(FIELD_INFO_STRING);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
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