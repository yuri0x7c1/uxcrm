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
 * Payment And Application
 */
@FieldNameConstants
public class PaymentAndApplication implements Serializable {

	public static final long serialVersionUID = 4146884000212069376L;
	public static final String NAME = "PaymentAndApplication";
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Payment Preference Id
	 */
	@Getter
	@Setter
	private String paymentPreferenceId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Actual Currency Amount
	 */
	@Getter
	@Setter
	private BigDecimal actualCurrencyAmount;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Actual Currency Uom Id
	 */
	@Getter
	@Setter
	private String actualCurrencyUomId;
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Payment Gateway Response Id
	 */
	@Getter
	@Setter
	private String paymentGatewayResponseId;
	/**
	 * Payment Ref Num
	 */
	@Getter
	@Setter
	private String paymentRefNum;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;
	/**
	 * To Payment Id
	 */
	@Getter
	@Setter
	private String toPaymentId;
	/**
	 * Amount Applied
	 */
	@Getter
	@Setter
	private BigDecimal amountApplied;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
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
	 * Payment Application Id
	 */
	@Getter
	@Setter
	private String paymentApplicationId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;

	public PaymentAndApplication(GenericValue value) {
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		paymentPreferenceId = (String) value.get(FIELD_PAYMENT_PREFERENCE_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		actualCurrencyAmount = (BigDecimal) value
				.get(FIELD_ACTUAL_CURRENCY_AMOUNT);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		actualCurrencyUomId = (String) value.get(FIELD_ACTUAL_CURRENCY_UOM_ID);
		paymentTypeId = (String) value.get(FIELD_PAYMENT_TYPE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		paymentGatewayResponseId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_RESPONSE_ID);
		paymentRefNum = (String) value.get(FIELD_PAYMENT_REF_NUM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		effectiveDate = (Timestamp) value.get(FIELD_EFFECTIVE_DATE);
		toPaymentId = (String) value.get(FIELD_TO_PAYMENT_ID);
		amountApplied = (BigDecimal) value.get(FIELD_AMOUNT_APPLIED);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		paymentApplicationId = (String) value.get(FIELD_PAYMENT_APPLICATION_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
	}

	public static PaymentAndApplication fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentAndApplication(value);
	}

	public static List<PaymentAndApplication> fromValues(
			List<GenericValue> values) {
		List<PaymentAndApplication> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentAndApplication(value));
		}
		return entities;
	}
}