package org.apache.ofbiz.party.communication.entity.view;

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
public class CommunicationEventAndProduct implements Serializable {

	public static final long serialVersionUID = 6062127656161545216L;
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

	public enum Fields {
		productId, communicationEventId, communicationEventTypeId, origCommEventId, parentCommEventId, statusId, contactMechTypeId, contactMechIdFrom, contactMechIdTo, roleTypeIdFrom, roleTypeIdTo, partyIdFrom, partyIdTo, entryDate, datetimeStarted, datetimeEnded, subject, contentMimeTypeId, content, note, reasonEnumId, contactListId, headerString, fromString, toString, ccString, bccString, messageId
	}

	public CommunicationEventAndProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		communicationEventTypeId = (String) value
				.get(Fields.communicationEventTypeId.name());
		origCommEventId = (String) value.get(Fields.origCommEventId.name());
		parentCommEventId = (String) value.get(Fields.parentCommEventId.name());
		statusId = (String) value.get(Fields.statusId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		contactMechIdFrom = (String) value.get(Fields.contactMechIdFrom.name());
		contactMechIdTo = (String) value.get(Fields.contactMechIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		datetimeStarted = (Timestamp) value.get(Fields.datetimeStarted.name());
		datetimeEnded = (Timestamp) value.get(Fields.datetimeEnded.name());
		subject = (String) value.get(Fields.subject.name());
		contentMimeTypeId = (String) value.get(Fields.contentMimeTypeId.name());
		content = (String) value.get(Fields.content.name());
		note = (String) value.get(Fields.note.name());
		reasonEnumId = (String) value.get(Fields.reasonEnumId.name());
		contactListId = (String) value.get(Fields.contactListId.name());
		headerString = (String) value.get(Fields.headerString.name());
		fromString = (String) value.get(Fields.fromString.name());
		toString = (String) value.get(Fields.toString.name());
		ccString = (String) value.get(Fields.ccString.name());
		bccString = (String) value.get(Fields.bccString.name());
		messageId = (String) value.get(Fields.messageId.name());
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