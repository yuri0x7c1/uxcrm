package org.apache.ofbiz.entity.test;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Testing Crypto
 */
public class TestingCrypto implements Serializable {

	public static final long serialVersionUID = 8787380644689227776L;
	public static final String NAME = "TestingCrypto";
	/**
	 * Testing Crypto Id
	 */
	@Getter
	@Setter
	private String testingCryptoId;
	/**
	 * Testing Crypto Type Id
	 */
	@Getter
	@Setter
	private String testingCryptoTypeId;
	/**
	 * Unencrypted Value
	 */
	@Getter
	@Setter
	private String unencryptedValue;
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
		testingCryptoId, testingCryptoTypeId, unencryptedValue, encryptedValue, saltedEncryptedValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TestingCrypto(GenericValue value) {
		testingCryptoId = (String) value.get(Fields.testingCryptoId.name());
		testingCryptoTypeId = (String) value.get(Fields.testingCryptoTypeId
				.name());
		unencryptedValue = (String) value.get(Fields.unencryptedValue.name());
		encryptedValue = (String) value.get(Fields.encryptedValue.name());
		saltedEncryptedValue = (String) value.get(Fields.saltedEncryptedValue
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TestingCrypto fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TestingCrypto(value);
	}

	public static List<TestingCrypto> fromValues(List<GenericValue> values) {
		List<TestingCrypto> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TestingCrypto(value));
		}
		return entities;
	}
}