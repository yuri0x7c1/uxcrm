package org.apache.ofbiz.entity.test;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TestingCrypto implements Serializable {

	public static final long serialVersionUID = 5616199274267744256L;
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

	public TestingCrypto(GenericValue value) {
		testingCryptoId = (String) value.get(FIELD_TESTING_CRYPTO_ID);
		testingCryptoTypeId = (String) value.get(FIELD_TESTING_CRYPTO_TYPE_ID);
		unencryptedValue = (String) value.get(FIELD_UNENCRYPTED_VALUE);
		encryptedValue = (String) value.get(FIELD_ENCRYPTED_VALUE);
		saltedEncryptedValue = (String) value.get(FIELD_SALTED_ENCRYPTED_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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