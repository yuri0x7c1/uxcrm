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
 * Communication Event And Product
 */
@FieldNameConstants
public class CommunicationEventAndProduct implements Serializable {

	public static final long serialVersionUID = 7343162839276620800L;
	public static final String NAME = "CommunicationEventAndProduct";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Note
	 */
	@Getter
	@Setter
	private String note;
	/**
	 * Subject
	 */
	@Getter
	@Setter
	private String subject;
	/**
	 * Cc String
	 */
	@Getter
	@Setter
	private String ccString;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Communication Event Type Id
	 */
	@Getter
	@Setter
	private String communicationEventTypeId;
	/**
	 * Content
	 */
	@Getter
	@Setter
	private String content;
	/**
	 * Content Mime Type Id
	 */
	@Getter
	@Setter
	private String contentMimeTypeId;
	/**
	 * Datetime Started
	 */
	@Getter
	@Setter
	private Timestamp datetimeStarted;
	/**
	 * Contact List Id
	 */
	@Getter
	@Setter
	private String contactListId;
	/**
	 * Contact Mech Id From
	 */
	@Getter
	@Setter
	private String contactMechIdFrom;
	/**
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Parent Comm Event Id
	 */
	@Getter
	@Setter
	private String parentCommEventId;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Datetime Ended
	 */
	@Getter
	@Setter
	private Timestamp datetimeEnded;
	/**
	 * Orig Comm Event Id
	 */
	@Getter
	@Setter
	private String origCommEventId;
	/**
	 * Message Id
	 */
	@Getter
	@Setter
	private String messageId;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Contact Mech Id To
	 */
	@Getter
	@Setter
	private String contactMechIdTo;
	/**
	 * Header String
	 */
	@Getter
	@Setter
	private String headerString;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Bcc String
	 */
	@Getter
	@Setter
	private String bccString;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * To String
	 */
	@Getter
	@Setter
	private String toString;
	/**
	 * From String
	 */
	@Getter
	@Setter
	private String fromString;

	public CommunicationEventAndProduct(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		note = (String) value.get(FIELD_NOTE);
		subject = (String) value.get(FIELD_SUBJECT);
		ccString = (String) value.get(FIELD_CC_STRING);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		communicationEventTypeId = (String) value
				.get(FIELD_COMMUNICATION_EVENT_TYPE_ID);
		content = (String) value.get(FIELD_CONTENT);
		contentMimeTypeId = (String) value.get(FIELD_CONTENT_MIME_TYPE_ID);
		datetimeStarted = (Timestamp) value.get(FIELD_DATETIME_STARTED);
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		contactMechIdFrom = (String) value.get(FIELD_CONTACT_MECH_ID_FROM);
		reasonEnumId = (String) value.get(FIELD_REASON_ENUM_ID);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		parentCommEventId = (String) value.get(FIELD_PARENT_COMM_EVENT_ID);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		datetimeEnded = (Timestamp) value.get(FIELD_DATETIME_ENDED);
		origCommEventId = (String) value.get(FIELD_ORIG_COMM_EVENT_ID);
		messageId = (String) value.get(FIELD_MESSAGE_ID);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		contactMechIdTo = (String) value.get(FIELD_CONTACT_MECH_ID_TO);
		headerString = (String) value.get(FIELD_HEADER_STRING);
		statusId = (String) value.get(FIELD_STATUS_ID);
		bccString = (String) value.get(FIELD_BCC_STRING);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		toString = (String) value.get(FIELD_TO_STRING);
		fromString = (String) value.get(FIELD_FROM_STRING);
	}

	public static CommunicationEventAndProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventAndProduct(value);
	}

	public static List<CommunicationEventAndProduct> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventAndProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventAndProduct(value));
		}
		return entities;
	}
}