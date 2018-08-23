package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice And Appl And Payment
 */
@FieldNameConstants
public class InvoiceAndApplAndPayment implements Serializable {

	public static final long serialVersionUID = 1300389555422747648L;
	public static final String NAME = "InvoiceAndApplAndPayment";
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Due Date
	 */
	@Getter
	@Setter
	private Timestamp dueDate;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Invoice Date
	 */
	@Getter
	@Setter
	private Timestamp invoiceDate;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Paid Date
	 */
	@Getter
	@Setter
	private Timestamp paidDate;
	/**
	 * Reference Number
	 */
	@Getter
	@Setter
	private String referenceNumber;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Message
	 */
	@Getter
	@Setter
	private String invoiceMessage;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Pm Role Type Id To
	 */
	@Getter
	@Setter
	private String pmRoleTypeIdTo;
	/**
	 * Pm Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String pmFinAccountTransId;
	/**
	 * Pm Party Id From
	 */
	@Getter
	@Setter
	private String pmPartyIdFrom;
	/**
	 * Pm Amount
	 */
	@Getter
	@Setter
	private BigDecimal pmAmount;
	/**
	 * Pm Payment Preference Id
	 */
	@Getter
	@Setter
	private String pmPaymentPreferenceId;
	/**
	 * Pm Comments
	 */
	@Getter
	@Setter
	private String pmComments;
	/**
	 * Pm Actual Currency Amount
	 */
	@Getter
	@Setter
	private BigDecimal pmActualCurrencyAmount;
	/**
	 * Pm Override Gl Account Id
	 */
	@Getter
	@Setter
	private String pmOverrideGlAccountId;
	/**
	 * Pm Payment Method Type Id
	 */
	@Getter
	@Setter
	private String pmPaymentMethodTypeId;
	/**
	 * Pm Actual Currency Uom Id
	 */
	@Getter
	@Setter
	private String pmActualCurrencyUomId;
	/**
	 * Pm Payment Type Id
	 */
	@Getter
	@Setter
	private String pmPaymentTypeId;
	/**
	 * Pm Currency Uom Id
	 */
	@Getter
	@Setter
	private String pmCurrencyUomId;
	/**
	 * Pm Status Id
	 */
	@Getter
	@Setter
	private String pmStatusId;
	/**
	 * Pm Payment Id
	 */
	@Getter
	@Setter
	private String pmPaymentId;
	/**
	 * Pm Payment Method Id
	 */
	@Getter
	@Setter
	private String pmPaymentMethodId;
	/**
	 * Pm Payment Gateway Response Id
	 */
	@Getter
	@Setter
	private String pmPaymentGatewayResponseId;
	/**
	 * Pm Payment Ref Num
	 */
	@Getter
	@Setter
	private String pmPaymentRefNum;
	/**
	 * Pm Party Id To
	 */
	@Getter
	@Setter
	private String pmPartyIdTo;
	/**
	 * Pm Effective Date
	 */
	@Getter
	@Setter
	private Timestamp pmEffectiveDate;

	public InvoiceAndApplAndPayment(GenericValue value) {
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		invoiceTypeId = (String) value.get(FIELD_INVOICE_TYPE_ID);
		dueDate = (Timestamp) value.get(FIELD_DUE_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		invoiceDate = (Timestamp) value.get(FIELD_INVOICE_DATE);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		paidDate = (Timestamp) value.get(FIELD_PAID_DATE);
		referenceNumber = (String) value.get(FIELD_REFERENCE_NUMBER);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceMessage = (String) value.get(FIELD_INVOICE_MESSAGE);
		partyId = (String) value.get(FIELD_PARTY_ID);
		toPaymentId = (String) value.get(FIELD_TO_PAYMENT_ID);
		amountApplied = (BigDecimal) value.get(FIELD_AMOUNT_APPLIED);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		paymentApplicationId = (String) value.get(FIELD_PAYMENT_APPLICATION_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		pmRoleTypeIdTo = (String) value.get(FIELD_PM_ROLE_TYPE_ID_TO);
		pmFinAccountTransId = (String) value.get(FIELD_PM_FIN_ACCOUNT_TRANS_ID);
		pmPartyIdFrom = (String) value.get(FIELD_PM_PARTY_ID_FROM);
		pmAmount = (BigDecimal) value.get(FIELD_PM_AMOUNT);
		pmPaymentPreferenceId = (String) value
				.get(FIELD_PM_PAYMENT_PREFERENCE_ID);
		pmComments = (String) value.get(FIELD_PM_COMMENTS);
		pmActualCurrencyAmount = (BigDecimal) value
				.get(FIELD_PM_ACTUAL_CURRENCY_AMOUNT);
		pmOverrideGlAccountId = (String) value
				.get(FIELD_PM_OVERRIDE_GL_ACCOUNT_ID);
		pmPaymentMethodTypeId = (String) value
				.get(FIELD_PM_PAYMENT_METHOD_TYPE_ID);
		pmActualCurrencyUomId = (String) value
				.get(FIELD_PM_ACTUAL_CURRENCY_UOM_ID);
		pmPaymentTypeId = (String) value.get(FIELD_PM_PAYMENT_TYPE_ID);
		pmCurrencyUomId = (String) value.get(FIELD_PM_CURRENCY_UOM_ID);
		pmStatusId = (String) value.get(FIELD_PM_STATUS_ID);
		pmPaymentId = (String) value.get(FIELD_PM_PAYMENT_ID);
		pmPaymentMethodId = (String) value.get(FIELD_PM_PAYMENT_METHOD_ID);
		pmPaymentGatewayResponseId = (String) value
				.get(FIELD_PM_PAYMENT_GATEWAY_RESPONSE_ID);
		pmPaymentRefNum = (String) value.get(FIELD_PM_PAYMENT_REF_NUM);
		pmPartyIdTo = (String) value.get(FIELD_PM_PARTY_ID_TO);
		pmEffectiveDate = (Timestamp) value.get(FIELD_PM_EFFECTIVE_DATE);
	}

	public static InvoiceAndApplAndPayment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceAndApplAndPayment(value);
	}

	public static List<InvoiceAndApplAndPayment> fromValues(
			List<GenericValue> values) {
		List<InvoiceAndApplAndPayment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceAndApplAndPayment(value));
		}
		return entities;
	}
}