package org.apache.ofbiz.marketing.contact;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContactListParty implements Serializable {

	public static final long serialVersionUID = 3040091537969874944L;
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

	public ContactListParty(GenericValue value) {
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		preferredContactMechId = (String) value
				.get(FIELD_PREFERRED_CONTACT_MECH_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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