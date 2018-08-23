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
 * Payment Gateway Cyber Source
 */
@FieldNameConstants
public class PaymentGatewayCyberSource implements Serializable {

	public static final long serialVersionUID = 1940090203023568896L;
	public static final String NAME = "PaymentGatewayCyberSource";
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
	 * Api Version
	 */
	@Getter
	@Setter
	private String apiVersion;
	/**
	 * Production
	 */
	@Getter
	@Setter
	private String production;
	/**
	 * Keys Dir
	 */
	@Getter
	@Setter
	private String keysDir;
	/**
	 * Keys File
	 */
	@Getter
	@Setter
	private String keysFile;
	/**
	 * Log Enabled
	 */
	@Getter
	@Setter
	private String logEnabled;
	/**
	 * Log Dir
	 */
	@Getter
	@Setter
	private String logDir;
	/**
	 * Log File
	 */
	@Getter
	@Setter
	private String logFile;
	/**
	 * Log Size
	 */
	@Getter
	@Setter
	private Long logSize;
	/**
	 * Merchant Descr
	 */
	@Getter
	@Setter
	private String merchantDescr;
	/**
	 * Merchant Contact
	 */
	@Getter
	@Setter
	private String merchantContact;
	/**
	 * Auto Bill
	 */
	@Getter
	@Setter
	private String autoBill;
	/**
	 * Enable Dav
	 */
	@Getter
	@Setter
	private String enableDav;
	/**
	 * Fraud Score
	 */
	@Getter
	@Setter
	private String fraudScore;
	/**
	 * Ignore Avs
	 */
	@Getter
	@Setter
	private String ignoreAvs;
	/**
	 * Disable Bill Avs
	 */
	@Getter
	@Setter
	private String disableBillAvs;
	/**
	 * Avs Decline Codes
	 */
	@Getter
	@Setter
	private String avsDeclineCodes;
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

	public PaymentGatewayCyberSource(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		merchantId = (String) value.get(FIELD_MERCHANT_ID);
		apiVersion = (String) value.get(FIELD_API_VERSION);
		production = (String) value.get(FIELD_PRODUCTION);
		keysDir = (String) value.get(FIELD_KEYS_DIR);
		keysFile = (String) value.get(FIELD_KEYS_FILE);
		logEnabled = (String) value.get(FIELD_LOG_ENABLED);
		logDir = (String) value.get(FIELD_LOG_DIR);
		logFile = (String) value.get(FIELD_LOG_FILE);
		logSize = (Long) value.get(FIELD_LOG_SIZE);
		merchantDescr = (String) value.get(FIELD_MERCHANT_DESCR);
		merchantContact = (String) value.get(FIELD_MERCHANT_CONTACT);
		autoBill = (String) value.get(FIELD_AUTO_BILL);
		enableDav = (String) value.get(FIELD_ENABLE_DAV);
		fraudScore = (String) value.get(FIELD_FRAUD_SCORE);
		ignoreAvs = (String) value.get(FIELD_IGNORE_AVS);
		disableBillAvs = (String) value.get(FIELD_DISABLE_BILL_AVS);
		avsDeclineCodes = (String) value.get(FIELD_AVS_DECLINE_CODES);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayCyberSource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayCyberSource(value);
	}

	public static List<PaymentGatewayCyberSource> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayCyberSource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayCyberSource(value));
		}
		return entities;
	}
}