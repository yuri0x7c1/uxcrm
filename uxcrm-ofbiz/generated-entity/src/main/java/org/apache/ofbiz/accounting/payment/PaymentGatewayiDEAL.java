package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gatewayi Deal
 */
@FieldNameConstants
public class PaymentGatewayiDEAL implements Serializable {

	public static final long serialVersionUID = 337841574975450112L;
	public static final String NAME = "PaymentGatewayiDEAL";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Merchant Id
	 */
	@Getter
	@Setter
	private String merchantId;
	/**
	 * Merchant Sub Id
	 */
	@Getter
	@Setter
	private String merchantSubId;
	/**
	 * Merchant Return Url
	 */
	@Getter
	@Setter
	private String merchantReturnURL;
	/**
	 * Acquirer Url
	 */
	@Getter
	@Setter
	private String acquirerURL;
	/**
	 * Acquirer Timeout
	 */
	@Getter
	@Setter
	private String acquirerTimeout;
	/**
	 * Private Cert
	 */
	@Getter
	@Setter
	private String privateCert;
	/**
	 * Acquirer Key Store Filename
	 */
	@Getter
	@Setter
	private String acquirerKeyStoreFilename;
	/**
	 * Acquirer Key Store Password
	 */
	@Getter
	@Setter
	private String acquirerKeyStorePassword;
	/**
	 * Merchant Key Store Filename
	 */
	@Getter
	@Setter
	private String merchantKeyStoreFilename;
	/**
	 * Merchant Key Store Password
	 */
	@Getter
	@Setter
	private String merchantKeyStorePassword;
	/**
	 * Expiration Period
	 */
	@Getter
	@Setter
	private String expirationPeriod;
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

	public PaymentGatewayiDEAL(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		merchantId = (String) value.get(FIELD_MERCHANT_ID);
		merchantSubId = (String) value.get(FIELD_MERCHANT_SUB_ID);
		merchantReturnURL = (String) value.get(FIELD_MERCHANT_RETURN_U_R_L);
		acquirerURL = (String) value.get(FIELD_ACQUIRER_U_R_L);
		acquirerTimeout = (String) value.get(FIELD_ACQUIRER_TIMEOUT);
		privateCert = (String) value.get(FIELD_PRIVATE_CERT);
		acquirerKeyStoreFilename = (String) value
				.get(FIELD_ACQUIRER_KEY_STORE_FILENAME);
		acquirerKeyStorePassword = (String) value
				.get(FIELD_ACQUIRER_KEY_STORE_PASSWORD);
		merchantKeyStoreFilename = (String) value
				.get(FIELD_MERCHANT_KEY_STORE_FILENAME);
		merchantKeyStorePassword = (String) value
				.get(FIELD_MERCHANT_KEY_STORE_PASSWORD);
		expirationPeriod = (String) value.get(FIELD_EXPIRATION_PERIOD);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayiDEAL fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayiDEAL(value);
	}

	public static List<PaymentGatewayiDEAL> fromValues(List<GenericValue> values) {
		List<PaymentGatewayiDEAL> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayiDEAL(value));
		}
		return entities;
	}
}