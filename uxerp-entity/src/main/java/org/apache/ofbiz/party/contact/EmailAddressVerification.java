package org.apache.ofbiz.party.contact;

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
public class EmailAddressVerification implements Serializable {

	public static final long serialVersionUID = 5996784339718849536L;
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

	public enum Fields {
		emailAddress, verifyHash, expireDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public EmailAddressVerification(GenericValue value) {
		emailAddress = (String) value.get(Fields.emailAddress.name());
		verifyHash = (String) value.get(Fields.verifyHash.name());
		expireDate = (Timestamp) value.get(Fields.expireDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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