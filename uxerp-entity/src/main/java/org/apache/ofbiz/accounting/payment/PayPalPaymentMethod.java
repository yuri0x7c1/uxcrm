package org.apache.ofbiz.accounting.payment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Pay Pal Payment Method
 */
public class PayPalPaymentMethod implements Serializable {

	public static final long serialVersionUID = 8324971867710267392L;
	public static final String NAME = "PayPalPaymentMethod";
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Payer Id
	 */
	@Getter
	@Setter
	private String payerId;
	/**
	 * Express Checkout Token
	 */
	@Getter
	@Setter
	private String expressCheckoutToken;
	/**
	 * Payer Status
	 */
	@Getter
	@Setter
	private String payerStatus;
	/**
	 * Avs Addr
	 */
	@Getter
	@Setter
	private String avsAddr;
	/**
	 * Avs Zip
	 */
	@Getter
	@Setter
	private String avsZip;
	/**
	 * Correlation Id
	 */
	@Getter
	@Setter
	private String correlationId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Transaction Id
	 */
	@Getter
	@Setter
	private String transactionId;
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
		paymentMethodId, payerId, expressCheckoutToken, payerStatus, avsAddr, avsZip, correlationId, contactMechId, transactionId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PayPalPaymentMethod(GenericValue value) {
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		payerId = (String) value.get(Fields.payerId.name());
		expressCheckoutToken = (String) value.get(Fields.expressCheckoutToken
				.name());
		payerStatus = (String) value.get(Fields.payerStatus.name());
		avsAddr = (String) value.get(Fields.avsAddr.name());
		avsZip = (String) value.get(Fields.avsZip.name());
		correlationId = (String) value.get(Fields.correlationId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		transactionId = (String) value.get(Fields.transactionId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PayPalPaymentMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PayPalPaymentMethod(value);
	}

	public static List<PayPalPaymentMethod> fromValues(List<GenericValue> values) {
		List<PayPalPaymentMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PayPalPaymentMethod(value));
		}
		return entities;
	}
}