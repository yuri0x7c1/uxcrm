package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Secure Pay
 */
public class PaymentGatewaySecurePay implements Serializable {

	public static final long serialVersionUID = 6154783828234733568L;
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

	public enum Fields {
		paymentGatewayConfigId, merchantId, pwd, serverURL, processTimeout, enableAmountRound
	}

	public PaymentGatewaySecurePay(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		merchantId = (String) value.get(Fields.merchantId.name());
		pwd = (String) value.get(Fields.pwd.name());
		serverURL = (String) value.get(Fields.serverURL.name());
		processTimeout = (Long) value.get(Fields.processTimeout.name());
		enableAmountRound = (String) value.get(Fields.enableAmountRound.name());
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