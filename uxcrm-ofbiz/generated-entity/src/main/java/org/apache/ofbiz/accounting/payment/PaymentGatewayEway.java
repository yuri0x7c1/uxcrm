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
 * Payment Gateway Eway
 */
@FieldNameConstants
public class PaymentGatewayEway implements Serializable {

	public static final long serialVersionUID = 5318412243976214528L;
	public static final String NAME = "PaymentGatewayEway";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Customer Id
	 */
	@Getter
	@Setter
	private String customerId;
	/**
	 * Refund Pwd
	 */
	@Getter
	@Setter
	private String refundPwd;
	/**
	 * Test Mode
	 */
	@Getter
	@Setter
	private String testMode;
	/**
	 * Enable Cvn
	 */
	@Getter
	@Setter
	private String enableCvn;
	/**
	 * Enable Beagle
	 */
	@Getter
	@Setter
	private String enableBeagle;
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

	public PaymentGatewayEway(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		customerId = (String) value.get(FIELD_CUSTOMER_ID);
		refundPwd = (String) value.get(FIELD_REFUND_PWD);
		testMode = (String) value.get(FIELD_TEST_MODE);
		enableCvn = (String) value.get(FIELD_ENABLE_CVN);
		enableBeagle = (String) value.get(FIELD_ENABLE_BEAGLE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayEway fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayEway(value);
	}

	public static List<PaymentGatewayEway> fromValues(List<GenericValue> values) {
		List<PaymentGatewayEway> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayEway(value));
		}
		return entities;
	}
}