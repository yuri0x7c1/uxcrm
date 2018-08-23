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
 * Payment Gateway Sage Pay
 */
@FieldNameConstants
public class PaymentGatewaySagePay implements Serializable {

	public static final long serialVersionUID = 8056153945071000576L;
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

	public PaymentGatewaySagePay(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		vendor = (String) value.get(FIELD_VENDOR);
		productionHost = (String) value.get(FIELD_PRODUCTION_HOST);
		testingHost = (String) value.get(FIELD_TESTING_HOST);
		sagePayMode = (String) value.get(FIELD_SAGE_PAY_MODE);
		protocolVersion = (String) value.get(FIELD_PROTOCOL_VERSION);
		authenticationTransType = (String) value
				.get(FIELD_AUTHENTICATION_TRANS_TYPE);
		authenticationUrl = (String) value.get(FIELD_AUTHENTICATION_URL);
		authoriseTransType = (String) value.get(FIELD_AUTHORISE_TRANS_TYPE);
		authoriseUrl = (String) value.get(FIELD_AUTHORISE_URL);
		releaseTransType = (String) value.get(FIELD_RELEASE_TRANS_TYPE);
		releaseUrl = (String) value.get(FIELD_RELEASE_URL);
		voidUrl = (String) value.get(FIELD_VOID_URL);
		refundUrl = (String) value.get(FIELD_REFUND_URL);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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