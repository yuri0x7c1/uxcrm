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
 * Payment Gateway Secure Pay
 */
@FieldNameConstants
public class PaymentGatewaySecurePay implements Serializable {

	public static final long serialVersionUID = 8422672469533719552L;
	public static final String NAME = "PaymentGatewaySecurePay";
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
	 * Pwd
	 */
	@Getter
	@Setter
	private String pwd;
	/**
	 * Server Url
	 */
	@Getter
	@Setter
	private String serverURL;
	/**
	 * Process Timeout
	 */
	@Getter
	@Setter
	private Long processTimeout;
	/**
	 * Enable Amount Round
	 */
	@Getter
	@Setter
	private String enableAmountRound;
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

	public PaymentGatewaySecurePay(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		merchantId = (String) value.get(FIELD_MERCHANT_ID);
		pwd = (String) value.get(FIELD_PWD);
		serverURL = (String) value.get(FIELD_SERVER_U_R_L);
		processTimeout = (Long) value.get(FIELD_PROCESS_TIMEOUT);
		enableAmountRound = (String) value.get(FIELD_ENABLE_AMOUNT_ROUND);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewaySecurePay fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewaySecurePay(value);
	}

	public static List<PaymentGatewaySecurePay> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewaySecurePay> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewaySecurePay(value));
		}
		return entities;
	}
}