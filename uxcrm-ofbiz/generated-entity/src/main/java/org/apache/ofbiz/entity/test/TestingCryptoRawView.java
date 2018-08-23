package org.apache.ofbiz.entity.test;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Crypto Raw View
 */
@FieldNameConstants
public class TestingCryptoRawView implements Serializable {

	public static final long serialVersionUID = 1362392014067550208L;
	public static final String NAME = "TestingCryptoRawView";
	/**
	 * Raw Encrypted Value
	 */
	@Getter
	@Setter
	private String rawEncryptedValue;
	/**
	 * Raw Salted Encrypted Value
	 */
	@Getter
	@Setter
	private String rawSaltedEncryptedValue;
	/**
	 * Testing Crypto Id
	 */
	@Getter
	@Setter
	private String testingCryptoId;
	/**
	 * Encrypted Value
	 */
	@Getter
	@Setter
	private String encryptedValue;
	/**
	 * Salted Encrypted Value
	 */
	@Getter
	@Setter
	private String saltedEncryptedValue;
	/**
	 * Unencrypted Value
	 */
	@Getter
	@Setter
	private String unencryptedValue;
	/**
	 * Testing Crypto Type Id
	 */
	@Getter
	@Setter
	private String testingCryptoTypeId;

	public TestingCryptoRawView(GenericValue value) {
		rawEncryptedValue = (String) value.get(FIELD_RAW_ENCRYPTED_VALUE);
		rawSaltedEncryptedValue = (String) value
				.get(FIELD_RAW_SALTED_ENCRYPTED_VALUE);
		testingCryptoId = (String) value.get(FIELD_TESTING_CRYPTO_ID);
		encryptedValue = (String) value.get(FIELD_ENCRYPTED_VALUE);
		saltedEncryptedValue = (String) value.get(FIELD_SALTED_ENCRYPTED_VALUE);
		unencryptedValue = (String) value.get(FIELD_UNENCRYPTED_VALUE);
		testingCryptoTypeId = (String) value.get(FIELD_TESTING_CRYPTO_TYPE_ID);
	}

	public static TestingCryptoRawView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingCryptoRawView(value);
	}

	public static List<TestingCryptoRawView> fromValues(
			List<GenericValue> values) {
		List<TestingCryptoRawView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingCryptoRawView(value));
		}
		return entities;
	}
}