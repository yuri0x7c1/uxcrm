package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayCyberSource implements Serializable {

	public static final long serialVersionUID = 4152306954060555264L;
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

	public enum Fields {
		paymentGatewayConfigId, merchantId, apiVersion, production, keysDir, keysFile, logEnabled, logDir, logFile, logSize, merchantDescr, merchantContact, autoBill, enableDav, fraudScore, ignoreAvs, disableBillAvs, avsDeclineCodes, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayCyberSource(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		merchantId = (String) value.get(Fields.merchantId.name());
		apiVersion = (String) value.get(Fields.apiVersion.name());
		production = (String) value.get(Fields.production.name());
		keysDir = (String) value.get(Fields.keysDir.name());
		keysFile = (String) value.get(Fields.keysFile.name());
		logEnabled = (String) value.get(Fields.logEnabled.name());
		logDir = (String) value.get(Fields.logDir.name());
		logFile = (String) value.get(Fields.logFile.name());
		logSize = (Long) value.get(Fields.logSize.name());
		merchantDescr = (String) value.get(Fields.merchantDescr.name());
		merchantContact = (String) value.get(Fields.merchantContact.name());
		autoBill = (String) value.get(Fields.autoBill.name());
		enableDav = (String) value.get(Fields.enableDav.name());
		fraudScore = (String) value.get(Fields.fraudScore.name());
		ignoreAvs = (String) value.get(Fields.ignoreAvs.name());
		disableBillAvs = (String) value.get(Fields.disableBillAvs.name());
		avsDeclineCodes = (String) value.get(Fields.avsDeclineCodes.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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