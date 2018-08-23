package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Application
 */
@FieldNameConstants
public class PaymentApplication implements Serializable {

	public static final long serialVersionUID = 75637292493031424L;
	public static final String NAME = "PaymentApplication";
	/**
	 * Payment Application Id
	 */
	@Getter
	@Setter
	private String paymentApplicationId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * To Payment Id
	 */
	@Getter
	@Setter
	private String toPaymentId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Amount Applied
	 */
	@Getter
	@Setter
	private BigDecimal amountApplied;
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

	public PaymentApplication(GenericValue value) {
		paymentApplicationId = (String) value.get(FIELD_PAYMENT_APPLICATION_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		toPaymentId = (String) value.get(FIELD_TO_PAYMENT_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		amountApplied = (BigDecimal) value.get(FIELD_AMOUNT_APPLIED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentApplication fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentApplication(value);
	}

	public static List<PaymentApplication> fromValues(List<GenericValue> values) {
		List<PaymentApplication> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentApplication(value));
		}
		return entities;
	}
}