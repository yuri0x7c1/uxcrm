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
 * Contact List Party Status
 */
@FieldNameConstants
public class ContactListPartyStatus implements Serializable {

	public static final long serialVersionUID = 7101403491272532992L;
	public static final String NAME = "ContactListPartyStatus";
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

	public ContactListPartyStatus(GenericValue value) {
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		setByUserLoginId = (String) value.get(FIELD_SET_BY_USER_LOGIN_ID);
		optInVerifyCode = (String) value.get(FIELD_OPT_IN_VERIFY_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContactListPartyStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactListPartyStatus(value);
	}

	public static List<ContactListPartyStatus> fromValues(
			List<GenericValue> values) {
		List<ContactListPartyStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactListPartyStatus(value));
		}
		return entities;
	}
}