package org.apache.ofbiz.accounting.invoice;

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

	public static final long serialVersionUID = 7468779676504466432L;
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

	public enum Fields {
		partyIdFrom, roleTypeId, recurrenceInfoId, invoiceTypeId, dueDate, description, billingAccountId, invoiceDate, contactMechId, currencyUomId, statusId, paidDate, referenceNumber, invoiceId, invoiceMessage, partyId, toPaymentId, amountApplied, overrideGlAccountId, invoiceItemSeqId, paymentApplicationId, paymentId, taxAuthGeoId, pmRoleTypeIdTo, pmFinAccountTransId, pmPartyIdFrom, pmAmount, pmPaymentPreferenceId, pmComments, pmActualCurrencyAmount, pmOverrideGlAccountId, pmPaymentMethodTypeId, pmActualCurrencyUomId, pmPaymentTypeId, pmCurrencyUomId, pmStatusId, pmPaymentId, pmPaymentMethodId, pmPaymentGatewayResponseId, pmPaymentRefNum, pmPartyIdTo, pmEffectiveDate
	}

	public InvoiceAndApplAndPayment(GenericValue value) {
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		dueDate = (Timestamp) value.get(Fields.dueDate.name());
		description = (String) value.get(Fields.description.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		invoiceDate = (Timestamp) value.get(Fields.invoiceDate.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		paidDate = (Timestamp) value.get(Fields.paidDate.name());
		referenceNumber = (String) value.get(Fields.referenceNumber.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceMessage = (String) value.get(Fields.invoiceMessage.name());
		partyId = (String) value.get(Fields.partyId.name());
		toPaymentId = (String) value.get(Fields.toPaymentId.name());
		amountApplied = (BigDecimal) value.get(Fields.amountApplied.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		paymentApplicationId = (String) value.get(Fields.paymentApplicationId
				.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		pmRoleTypeIdTo = (String) value.get(Fields.pmRoleTypeIdTo.name());
		pmFinAccountTransId = (String) value.get(Fields.pmFinAccountTransId
				.name());
		pmPartyIdFrom = (String) value.get(Fields.pmPartyIdFrom.name());
		pmAmount = (BigDecimal) value.get(Fields.pmAmount.name());
		pmPaymentPreferenceId = (String) value.get(Fields.pmPaymentPreferenceId
				.name());
		pmComments = (String) value.get(Fields.pmComments.name());
		pmActualCurrencyAmount = (BigDecimal) value
				.get(Fields.pmActualCurrencyAmount.name());
		pmOverrideGlAccountId = (String) value.get(Fields.pmOverrideGlAccountId
				.name());
		pmPaymentMethodTypeId = (String) value.get(Fields.pmPaymentMethodTypeId
				.name());
		pmActualCurrencyUomId = (String) value.get(Fields.pmActualCurrencyUomId
				.name());
		pmPaymentTypeId = (String) value.get(Fields.pmPaymentTypeId.name());
		pmCurrencyUomId = (String) value.get(Fields.pmCurrencyUomId.name());
		pmStatusId = (String) value.get(Fields.pmStatusId.name());
		pmPaymentId = (String) value.get(Fields.pmPaymentId.name());
		pmPaymentMethodId = (String) value.get(Fields.pmPaymentMethodId.name());
		pmPaymentGatewayResponseId = (String) value
				.get(Fields.pmPaymentGatewayResponseId.name());
		pmPaymentRefNum = (String) value.get(Fields.pmPaymentRefNum.name());
		pmPartyIdTo = (String) value.get(Fields.pmPartyIdTo.name());
		pmEffectiveDate = (Timestamp) value.get(Fields.pmEffectiveDate.name());
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