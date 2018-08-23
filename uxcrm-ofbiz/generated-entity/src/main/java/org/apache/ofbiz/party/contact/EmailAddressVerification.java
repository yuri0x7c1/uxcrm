package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Email Address Verification
 */
@FieldNameConstants
public class EmailAddressVerification implements Serializable {

	public static final long serialVersionUID = 2222940667664373760L;
	public static final String NAME = "EmailAddressVerification";
	/**
	 * Email Address
	 */
	@Getter
	@Setter
	private String emailAddress;
	/**
	 * Verify Hash
	 */
	@Getter
	@Setter
	private String verifyHash;
	/**
	 * Expire Date
	 */
	@Getter
	@Setter
	private Timestamp expireDate;
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

	public EmailAddressVerification(GenericValue value) {
		emailAddress = (String) value.get(FIELD_EMAIL_ADDRESS);
		verifyHash = (String) value.get(FIELD_VERIFY_HASH);
		expireDate = (Timestamp) value.get(FIELD_EXPIRE_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static EmailAddressVerification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmailAddressVerification(value);
	}

	public static List<EmailAddressVerification> fromValues(
			List<GenericValue> values) {
		List<EmailAddressVerification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmailAddressVerification(value));
		}
		return entities;
	}
}