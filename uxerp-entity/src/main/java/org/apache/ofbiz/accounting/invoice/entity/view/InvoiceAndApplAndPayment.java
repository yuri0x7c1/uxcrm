package org.apache.ofbiz.accounting.invoice.entity.view;

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
public class InvoiceAndApplAndPayment implements Serializable {

	public static final long serialVersionUID = 2888471412725592064L;
	public static final String NAME = "InvoiceAndApplAndPayment";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Invoice Date
	 */
	@Getter
	@Setter
	private Timestamp invoiceDate;
	/**
	 * Due Date
	 */
	@Getter
	@Setter
	private Timestamp dueDate;
	/**
	 * Paid Date
	 */
	@Getter
	@Setter
	private Timestamp paidDate;
	/**
	 * Invoice Message
	 */
	@Getter
	@Setter
	private String invoiceMessage;
	/**
	 * Reference Number
	 */
	@Getter
	@Setter
	private String referenceNumber;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
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
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
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
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
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
	 * Payment Preference Id
	 */
	@Getter
	@Setter
	private String paymentPreferenceId;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;
	/**
	 * Payment Ref Num
	 */
	@Getter
	@Setter
	private String paymentRefNum;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
	/**
	 * Actual Currency Amount
	 */
	@Getter
	@Setter
	private BigDecimal actualCurrencyAmount;
	/**
	 * Actual Currency Uom Id
	 */
	@Getter
	@Setter
	private String actualCurrencyUomId;

	public enum Fields {
		invoiceId, invoiceTypeId, partyIdFrom, partyId, roleTypeId, statusId, billingAccountId, contactMechId, invoiceDate, dueDate, paidDate, invoiceMessage, referenceNumber, description, currencyUomId, recurrenceInfoId, paymentApplicationId, paymentId, invoiceItemSeqId, overrideGlAccountId, toPaymentId, taxAuthGeoId, amountApplied, paymentTypeId, paymentMethodTypeId, paymentMethodId, paymentGatewayResponseId, paymentPreferenceId, partyIdTo, roleTypeIdTo, effectiveDate, paymentRefNum, amount, comments, finAccountTransId, actualCurrencyAmount, actualCurrencyUomId
	}

	public InvoiceAndApplAndPayment(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		invoiceDate = (Timestamp) value.get(Fields.invoiceDate.name());
		dueDate = (Timestamp) value.get(Fields.dueDate.name());
		paidDate = (Timestamp) value.get(Fields.paidDate.name());
		invoiceMessage = (String) value.get(Fields.invoiceMessage.name());
		referenceNumber = (String) value.get(Fields.referenceNumber.name());
		description = (String) value.get(Fields.description.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		paymentApplicationId = (String) value.get(Fields.paymentApplicationId
				.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		toPaymentId = (String) value.get(Fields.toPaymentId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		amountApplied = (BigDecimal) value.get(Fields.amountApplied.name());
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		paymentPreferenceId = (String) value.get(Fields.paymentPreferenceId
				.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		paymentRefNum = (String) value.get(Fields.paymentRefNum.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		comments = (String) value.get(Fields.comments.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		actualCurrencyAmount = (BigDecimal) value
				.get(Fields.actualCurrencyAmount.name());
		actualCurrencyUomId = (String) value.get(Fields.actualCurrencyUomId
				.name());
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