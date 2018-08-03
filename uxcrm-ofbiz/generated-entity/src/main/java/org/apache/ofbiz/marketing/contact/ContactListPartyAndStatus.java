package org.apache.ofbiz.marketing.contact;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List Party And Status
 */
public class ContactListPartyAndStatus implements Serializable {

	public static final long serialVersionUID = 8646610101889196032L;
	public static final String NAME = "ContactListPartyAndStatus";
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
	 * Opt In Verify Code
	 */
	@Getter
	@Setter
	private String optInVerifyCode;
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
	 * Set By User Login Id
	 */
	@Getter
	@Setter
	private String setByUserLoginId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Status Type Id
	 */
	@Getter
	@Setter
	private String statusTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Status Code
	 */
	@Getter
	@Setter
	private String statusCode;

	public enum Fields {
		fromDate, statusDate, optInVerifyCode, statusId, contactListId, setByUserLoginId, partyId, statusTypeId, description, sequenceId, statusCode
	}

	public ContactListPartyAndStatus(GenericValue value) {
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		optInVerifyCode = (String) value.get(Fields.optInVerifyCode.name());
		statusId = (String) value.get(Fields.statusId.name());
		contactListId = (String) value.get(Fields.contactListId.name());
		setByUserLoginId = (String) value.get(Fields.setByUserLoginId.name());
		partyId = (String) value.get(Fields.partyId.name());
		statusTypeId = (String) value.get(Fields.statusTypeId.name());
		description = (String) value.get(Fields.description.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		statusCode = (String) value.get(Fields.statusCode.name());
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