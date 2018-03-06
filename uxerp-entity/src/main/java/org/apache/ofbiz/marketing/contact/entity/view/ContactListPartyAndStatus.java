package org.apache.ofbiz.marketing.contact.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List Party And Status
 */
public class ContactListPartyAndStatus implements Serializable {

	public static final long serialVersionUID = 1269085873476772864L;
	public static final String NAME = "ContactListPartyAndStatus";
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
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Set By User Login Id
	 */
	@Getter
	@Setter
	private String setByUserLoginId;
	/**
	 * Opt In Verify Code
	 */
	@Getter
	@Setter
	private String optInVerifyCode;
	/**
	 * Status Type Id
	 */
	@Getter
	@Setter
	private String statusTypeId;
	/**
	 * Status Code
	 */
	@Getter
	@Setter
	private String statusCode;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contactListId, partyId, fromDate, statusDate, statusId, setByUserLoginId, optInVerifyCode, statusTypeId, statusCode, sequenceId, description
	}

	public ContactListPartyAndStatus(GenericValue value) {
		contactListId = (String) value.get(Fields.contactListId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		setByUserLoginId = (String) value.get(Fields.setByUserLoginId.name());
		optInVerifyCode = (String) value.get(Fields.optInVerifyCode.name());
		statusTypeId = (String) value.get(Fields.statusTypeId.name());
		statusCode = (String) value.get(Fields.statusCode.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContactListPartyAndStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactListPartyAndStatus(value);
	}

	public static List<ContactListPartyAndStatus> fromValues(
			List<GenericValue> values) {
		List<ContactListPartyAndStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactListPartyAndStatus(value));
		}
		return entities;
	}
}