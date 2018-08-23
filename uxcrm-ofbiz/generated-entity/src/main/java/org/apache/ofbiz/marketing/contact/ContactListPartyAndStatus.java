package org.apache.ofbiz.marketing.contact;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContactListPartyAndStatus implements Serializable {

	public static final long serialVersionUID = 824330358658642944L;
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

	public ContactListPartyAndStatus(GenericValue value) {
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		optInVerifyCode = (String) value.get(FIELD_OPT_IN_VERIFY_CODE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		setByUserLoginId = (String) value.get(FIELD_SET_BY_USER_LOGIN_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		statusTypeId = (String) value.get(FIELD_STATUS_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		statusCode = (String) value.get(FIELD_STATUS_CODE);
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