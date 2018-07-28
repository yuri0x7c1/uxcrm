package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Sage Pay
 */
public class PaymentGatewaySagePay implements Serializable {

	public static final long serialVersionUID = 3326298966492836864L;
	public static final String NAME = "PaymentGatewaySagePay";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Vendor
	 */
	@Getter
	@Setter
	private String vendor;
	/**
	 * Production Host
	 */
	@Getter
	@Setter
	private String productionHost;
	/**
	 * Testing Host
	 */
	@Getter
	@Setter
	private String testingHost;
	/**
	 * Sage Pay Mode
	 */
	@Getter
	@Setter
	private String sagePayMode;
	/**
	 * Protocol Version
	 */
	@Getter
	@Setter
	private String protocolVersion;
	/**
	 * Authentication Trans Type
	 */
	@Getter
	@Setter
	private String authenticationTransType;
	/**
	 * Authentication Url
	 */
	@Getter
	@Setter
	private String authenticationUrl;
	/**
	 * Authorise Trans Type
	 */
	@Getter
	@Setter
	private String authoriseTransType;
	/**
	 * Authorise Url
	 */
	@Getter
	@Setter
	private String authoriseUrl;
	/**
	 * Release Trans Type
	 */
	@Getter
	@Setter
	private String releaseTransType;
	/**
	 * Release Url
	 */
	@Getter
	@Setter
	private String releaseUrl;
	/**
	 * Void Url
	 */
	@Getter
	@Setter
	private String voidUrl;
	/**
	 * Refund Url
	 */
	@Getter
	@Setter
	private String refundUrl;
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
		paymentGatewayConfigId, vendor, productionHost, testingHost, sagePayMode, protocolVersion, authenticationTransType, authenticationUrl, authoriseTransType, authoriseUrl, releaseTransType, releaseUrl, voidUrl, refundUrl, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewaySagePay(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		vendor = (String) value.get(Fields.vendor.name());
		productionHost = (String) value.get(Fields.productionHost.name());
		testingHost = (String) value.get(Fields.testingHost.name());
		sagePayMode = (String) value.get(Fields.sagePayMode.name());
		protocolVersion = (String) value.get(Fields.protocolVersion.name());
		authenticationTransType = (String) value
				.get(Fields.authenticationTransType.name());
		authenticationUrl = (String) value.get(Fields.authenticationUrl.name());
		authoriseTransType = (String) value.get(Fields.authoriseTransType
				.name());
		authoriseUrl = (String) value.get(Fields.authoriseUrl.name());
		releaseTransType = (String) value.get(Fields.releaseTransType.name());
		releaseUrl = (String) value.get(Fields.releaseUrl.name());
		voidUrl = (String) value.get(Fields.voidUrl.name());
		refundUrl = (String) value.get(Fields.refundUrl.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PaymentGatewaySagePay fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewaySagePay(value);
	}

	public static List<PaymentGatewaySagePay> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewaySagePay> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewaySagePay(value));
		}
		return entities;
	}
}