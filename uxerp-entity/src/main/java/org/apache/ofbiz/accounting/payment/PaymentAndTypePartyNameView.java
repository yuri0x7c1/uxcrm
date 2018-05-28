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
 * Payment And Type Party Name View
 */
public class PaymentAndTypePartyNameView implements Serializable {

	public static final long serialVersionUID = 3134030718158954496L;
	public static final String NAME = "PaymentAndTypePartyNameView";
	/**
	 * Party From First Name
	 */
	@Getter
	@Setter
	private String partyFromFirstName;
	/**
	 * Party From Last Name
	 */
	@Getter
	@Setter
	private String partyFromLastName;
	/**
	 * Party From Group Name
	 */
	@Getter
	@Setter
	private String partyFromGroupName;
	/**
	 * Party To First Name
	 */
	@Getter
	@Setter
	private String partyToFirstName;
	/**
	 * Party To Last Name
	 */
	@Getter
	@Setter
	private String partyToLastName;
	/**
	 * Party To Group Name
	 */
	@Getter
	@Setter
	private String partyToGroupName;
	/**
	 * Payment Type Desc
	 */
	@Getter
	@Setter
	private String paymentTypeDesc;
	/**
	 * Parent Payment Type Id
	 */
	@Getter
	@Setter
	private String parentPaymentTypeId;
	/**
	 * Status Desc
	 */
	@Getter
	@Setter
	private String statusDesc;
	/**
	 * Payment Method Type Desc
	 */
	@Getter
	@Setter
	private String paymentMethodTypeDesc;
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
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
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

	public enum Fields {
		partyFromFirstName, partyFromLastName, partyFromGroupName, partyToFirstName, partyToLastName, partyToGroupName, paymentTypeDesc, parentPaymentTypeId, statusDesc, paymentMethodTypeDesc, roleTypeIdTo, finAccountTransId, partyIdFrom, amount, paymentPreferenceId, comments, actualCurrencyAmount, overrideGlAccountId, paymentMethodTypeId, actualCurrencyUomId, paymentTypeId, currencyUomId, statusId, paymentId, paymentMethodId, paymentGatewayResponseId, paymentRefNum, partyIdTo, effectiveDate
	}

	public PaymentAndTypePartyNameView(GenericValue value) {
		partyFromFirstName = (String) value.get(Fields.partyFromFirstName
				.name());
		partyFromLastName = (String) value.get(Fields.partyFromLastName.name());
		partyFromGroupName = (String) value.get(Fields.partyFromGroupName
				.name());
		partyToFirstName = (String) value.get(Fields.partyToFirstName.name());
		partyToLastName = (String) value.get(Fields.partyToLastName.name());
		partyToGroupName = (String) value.get(Fields.partyToGroupName.name());
		paymentTypeDesc = (String) value.get(Fields.paymentTypeDesc.name());
		parentPaymentTypeId = (String) value.get(Fields.parentPaymentTypeId
				.name());
		statusDesc = (String) value.get(Fields.statusDesc.name());
		paymentMethodTypeDesc = (String) value.get(Fields.paymentMethodTypeDesc
				.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		paymentPreferenceId = (String) value.get(Fields.paymentPreferenceId
				.name());
		comments = (String) value.get(Fields.comments.name());
		actualCurrencyAmount = (BigDecimal) value
				.get(Fields.actualCurrencyAmount.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
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
	}

	public static PaymentAndTypePartyNameView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentAndTypePartyNameView(value);
	}

	public static List<PaymentAndTypePartyNameView> fromValues(
			List<GenericValue> values) {
		List<PaymentAndTypePartyNameView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentAndTypePartyNameView(value));
		}
		return entities;
	}
}