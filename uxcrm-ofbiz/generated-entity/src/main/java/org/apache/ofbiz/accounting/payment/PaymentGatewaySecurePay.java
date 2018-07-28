package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewaySecurePay implements Serializable {

	public static final long serialVersionUID = 8769419796776043520L;
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

	public enum Fields {
		paymentGatewayConfigId, merchantId, pwd, serverURL, processTimeout, enableAmountRound, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewaySecurePay(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		merchantId = (String) value.get(Fields.merchantId.name());
		pwd = (String) value.get(Fields.pwd.name());
		serverURL = (String) value.get(Fields.serverURL.name());
		processTimeout = (Long) value.get(Fields.processTimeout.name());
		enableAmountRound = (String) value.get(Fields.enableAmountRound.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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