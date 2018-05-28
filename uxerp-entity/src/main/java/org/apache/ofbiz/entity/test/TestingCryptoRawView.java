package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Crypto Raw View
 */
public class TestingCryptoRawView implements Serializable {

	public static final long serialVersionUID = 4735323175481379840L;
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

	public enum Fields {
		rawEncryptedValue, rawSaltedEncryptedValue, testingCryptoId, encryptedValue, saltedEncryptedValue, unencryptedValue, testingCryptoTypeId
	}

	public TestingCryptoRawView(GenericValue value) {
		rawEncryptedValue = (String) value.get(Fields.rawEncryptedValue.name());
		rawSaltedEncryptedValue = (String) value
				.get(Fields.rawSaltedEncryptedValue.name());
		testingCryptoId = (String) value.get(Fields.testingCryptoId.name());
		encryptedValue = (String) value.get(Fields.encryptedValue.name());
		saltedEncryptedValue = (String) value.get(Fields.saltedEncryptedValue
				.name());
		unencryptedValue = (String) value.get(Fields.unencryptedValue.name());
		testingCryptoTypeId = (String) value.get(Fields.testingCryptoTypeId
				.name());
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