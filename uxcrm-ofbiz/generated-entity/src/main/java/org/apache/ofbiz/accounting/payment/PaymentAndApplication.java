package org.apache.ofbiz.accounting.payment;

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
public class PaymentAndApplication implements Serializable {

	public static final long serialVersionUID = 6393677668045737984L;
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

	public enum Fields {
		roleTypeIdTo, finAccountTransId, partyIdFrom, amount, paymentPreferenceId, comments, actualCurrencyAmount, paymentMethodTypeId, actualCurrencyUomId, paymentTypeId, currencyUomId, statusId, paymentId, paymentMethodId, paymentGatewayResponseId, paymentRefNum, partyIdTo, effectiveDate, toPaymentId, amountApplied, overrideGlAccountId, invoiceItemSeqId, billingAccountId, paymentApplicationId, taxAuthGeoId, invoiceId
	}

	public PaymentAndApplication(GenericValue value) {
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		paymentPreferenceId = (String) value.get(Fields.paymentPreferenceId
				.name());
		comments = (String) value.get(Fields.comments.name());
		actualCurrencyAmount = (BigDecimal) value
				.get(Fields.actualCurrencyAmount.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		actualCurrencyUomId = (String) value.get(Fields.actualCurrencyUomId
				.name());
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		paymentRefNum = (String) value.get(Fields.paymentRefNum.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		toPaymentId = (String) value.get(Fields.toPaymentId.name());
		amountApplied = (BigDecimal) value.get(Fields.amountApplied.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		paymentApplicationId = (String) value.get(Fields.paymentApplicationId
				.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
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