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
 * Pay Pal Payment Method
 */
@FieldNameConstants
public class PayPalPaymentMethod implements Serializable {

	public static final long serialVersionUID = 692593690414240768L;
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

	public PayPalPaymentMethod(GenericValue value) {
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		payerId = (String) value.get(FIELD_PAYER_ID);
		expressCheckoutToken = (String) value.get(FIELD_EXPRESS_CHECKOUT_TOKEN);
		payerStatus = (String) value.get(FIELD_PAYER_STATUS);
		avsAddr = (String) value.get(FIELD_AVS_ADDR);
		avsZip = (String) value.get(FIELD_AVS_ZIP);
		correlationId = (String) value.get(FIELD_CORRELATION_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		transactionId = (String) value.get(FIELD_TRANSACTION_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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