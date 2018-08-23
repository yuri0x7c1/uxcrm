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
 * Contact List Comm Status
 */
@FieldNameConstants
public class ContactListCommStatus implements Serializable {

	public static final long serialVersionUID = 5943338683599539200L;
	public static final String NAME = "ContactListCommStatus";
	/**
	 * Contact List Id
	 */
	@Getter
	@Setter
	private String contactListId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Message Id
	 */
	@Getter
	@Setter
	private String messageId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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

	public ContactListCommStatus(GenericValue value) {
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		messageId = (String) value.get(FIELD_MESSAGE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContactListCommStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactListCommStatus(value);
	}

	public static List<ContactListCommStatus> fromValues(
			List<GenericValue> values) {
		List<ContactListCommStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactListCommStatus(value));
		}
		return entities;
	}
}