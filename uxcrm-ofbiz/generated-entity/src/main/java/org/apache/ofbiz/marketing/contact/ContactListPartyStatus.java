package org.apache.ofbiz.marketing.contact;

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
public class ContactListPartyStatus implements Serializable {

	public static final long serialVersionUID = 4819419369003783168L;
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

	public enum Fields {
		contactListId, partyId, fromDate, statusDate, statusId, setByUserLoginId, optInVerifyCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactListPartyStatus(GenericValue value) {
		contactListId = (String) value.get(Fields.contactListId.name());
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		setByUserLoginId = (String) value.get(Fields.setByUserLoginId.name());
		optInVerifyCode = (String) value.get(Fields.optInVerifyCode.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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