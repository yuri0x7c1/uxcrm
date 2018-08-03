package org.apache.ofbiz.marketing.contact;

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
public class ContactListCommStatus implements Serializable {

	public static final long serialVersionUID = 1473707572817053696L;
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

	public enum Fields {
		contactListId, communicationEventId, contactMechId, partyId, messageId, statusId, changeByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactListCommStatus(GenericValue value) {
		contactListId = (String) value.get(Fields.contactListId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		partyId = (String) value.get(Fields.partyId.name());
		messageId = (String) value.get(Fields.messageId.name());
		statusId = (String) value.get(Fields.statusId.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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