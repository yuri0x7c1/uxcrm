package org.apache.ofbiz.party.contact.entity;

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

	public static final long serialVersionUID = 4961401552253137920L;
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

	public enum Fields {
		emailAddress, verifyHash, expireDate
	}

	public EmailAddressVerification(GenericValue value) {
		emailAddress = (String) value.get(Fields.emailAddress.name());
		verifyHash = (String) value.get(Fields.verifyHash.name());
		expireDate = (Timestamp) value.get(Fields.expireDate.name());
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