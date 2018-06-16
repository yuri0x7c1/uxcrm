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
 * Payment And Type
 */
public class PaymentAndType implements Serializable {

	public static final long serialVersionUID = 2794800438263091200L;
	public static final String NAME = "PaymentAndType";
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
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		roleTypeIdTo, finAccountTransId, partyIdFrom, amount, paymentPreferenceId, comments, actualCurrencyAmount, overrideGlAccountId, paymentMethodTypeId, actualCurrencyUomId, paymentTypeId, currencyUomId, statusId, paymentId, paymentMethodId, paymentGatewayResponseId, paymentRefNum, partyIdTo, effectiveDate, parentTypeId, hasTable, description
	}

	public PaymentAndType(GenericValue value) {
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
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PaymentAndType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentAndType(value);
	}

	public static List<PaymentAndType> fromValues(List<GenericValue> values) {
		List<PaymentAndType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentAndType(value));
		}
		return entities;
	}
}