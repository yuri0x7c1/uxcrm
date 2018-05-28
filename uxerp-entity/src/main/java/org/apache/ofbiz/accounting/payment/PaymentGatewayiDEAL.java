package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayiDEAL implements Serializable {

	public static final long serialVersionUID = 8331407117252132864L;
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

	public enum Fields {
		paymentGatewayConfigId, merchantId, merchantSubId, merchantReturnURL, acquirerURL, acquirerTimeout, privateCert, acquirerKeyStoreFilename, acquirerKeyStorePassword, merchantKeyStoreFilename, merchantKeyStorePassword, expirationPeriod, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayiDEAL(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		merchantId = (String) value.get(Fields.merchantId.name());
		merchantSubId = (String) value.get(Fields.merchantSubId.name());
		merchantReturnURL = (String) value.get(Fields.merchantReturnURL.name());
		acquirerURL = (String) value.get(Fields.acquirerURL.name());
		acquirerTimeout = (String) value.get(Fields.acquirerTimeout.name());
		privateCert = (String) value.get(Fields.privateCert.name());
		acquirerKeyStoreFilename = (String) value
				.get(Fields.acquirerKeyStoreFilename.name());
		acquirerKeyStorePassword = (String) value
				.get(Fields.acquirerKeyStorePassword.name());
		merchantKeyStoreFilename = (String) value
				.get(Fields.merchantKeyStoreFilename.name());
		merchantKeyStorePassword = (String) value
				.get(Fields.merchantKeyStorePassword.name());
		expirationPeriod = (String) value.get(Fields.expirationPeriod.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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