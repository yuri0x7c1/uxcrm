package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event
 */
@FieldNameConstants
public class CommunicationEvent implements Serializable {

	public static final long serialVersionUID = 7468361358457446400L;
	public static final String NAME = "CommunicationEvent";
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Communication Event Type Id
	 */
	@Getter
	@Setter
	private String communicationEventTypeId;
	/**
	 * Orig Comm Event Id
	 */
	@Getter
	@Setter
	private String origCommEventId;
	/**
	 * Parent Comm Event Id
	 */
	@Getter
	@Setter
	private String parentCommEventId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Contact Mech Id From
	 */
	@Getter
	@Setter
	private String contactMechIdFrom;
	/**
	 * Contact Mech Id To
	 */
	@Getter
	@Setter
	private String contactMechIdTo;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Datetime Started
	 */
	@Getter
	@Setter
	private Timestamp datetimeStarted;
	/**
	 * Datetime Ended
	 */
	@Getter
	@Setter
	private Timestamp datetimeEnded;
	/**
	 * Subject
	 */
	@Getter
	@Setter
	private String subject;
	/**
	 * Content Mime Type Id
	 */
	@Getter
	@Setter
	private String contentMimeTypeId;
	/**
	 * Content
	 */
	@Getter
	@Setter
	private String content;
	/**
	 * Note
	 */
	@Getter
	@Setter
	private String note;
	/**
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;
	/**
	 * Contact List Id
	 */
	@Getter
	@Setter
	private String contactListId;
	/**
	 * Header String
	 */
	@Getter
	@Setter
	private String headerString;
	/**
	 * From String
	 */
	@Getter
	@Setter
	private String fromString;
	/**
	 * To String
	 */
	@Getter
	@Setter
	private String toString;
	/**
	 * Cc String
	 */
	@Getter
	@Setter
	private String ccString;
	/**
	 * Bcc String
	 */
	@Getter
	@Setter
	private String bccString;
	/**
	 * Message Id
	 */
	@Getter
	@Setter
	private String messageId;
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

	public CommunicationEvent(GenericValue value) {
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		communicationEventTypeId = (String) value
				.get(FIELD_COMMUNICATION_EVENT_TYPE_ID);
		origCommEventId = (String) value.get(FIELD_ORIG_COMM_EVENT_ID);
		parentCommEventId = (String) value.get(FIELD_PARENT_COMM_EVENT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		contactMechIdFrom = (String) value.get(FIELD_CONTACT_MECH_ID_FROM);
		contactMechIdTo = (String) value.get(FIELD_CONTACT_MECH_ID_TO);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		datetimeStarted = (Timestamp) value.get(FIELD_DATETIME_STARTED);
		datetimeEnded = (Timestamp) value.get(FIELD_DATETIME_ENDED);
		subject = (String) value.get(FIELD_SUBJECT);
		contentMimeTypeId = (String) value.get(FIELD_CONTENT_MIME_TYPE_ID);
		content = (String) value.get(FIELD_CONTENT);
		note = (String) value.get(FIELD_NOTE);
		reasonEnumId = (String) value.get(FIELD_REASON_ENUM_ID);
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		headerString = (String) value.get(FIELD_HEADER_STRING);
		fromString = (String) value.get(FIELD_FROM_STRING);
		toString = (String) value.get(FIELD_TO_STRING);
		ccString = (String) value.get(FIELD_CC_STRING);
		bccString = (String) value.get(FIELD_BCC_STRING);
		messageId = (String) value.get(FIELD_MESSAGE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CommunicationEvent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEvent(value);
	}

	public static List<CommunicationEvent> fromValues(List<GenericValue> values) {
		List<CommunicationEvent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEvent(value));
		}
		return entities;
	}
}