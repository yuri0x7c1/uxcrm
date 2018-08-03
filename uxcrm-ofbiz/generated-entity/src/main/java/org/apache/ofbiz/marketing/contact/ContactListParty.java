package org.apache.ofbiz.marketing.contact;

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

	public static final long serialVersionUID = 1818145802816347136L;
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

	public enum Fields {
		contactListId, partyId, fromDate, thruDate, statusId, preferredContactMechId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactListParty(GenericValue value) {
		contactListId = (String) value.get(Fields.contactListId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredContactMechId = (String) value
				.get(Fields.preferredContactMechId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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