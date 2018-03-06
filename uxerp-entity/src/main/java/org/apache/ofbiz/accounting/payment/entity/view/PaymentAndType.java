package org.apache.ofbiz.accounting.payment.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment And Type
 */
public class PaymentAndType implements Serializable {

	public static final long serialVersionUID = 4663030120295267328L;
	public static final String NAME = "PaymentAndType";
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
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
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
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
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
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
		paymentId, paymentTypeId, paymentMethodTypeId, paymentMethodId, paymentGatewayResponseId, paymentPreferenceId, partyIdFrom, partyIdTo, roleTypeIdTo, statusId, effectiveDate, paymentRefNum, amount, currencyUomId, comments, finAccountTransId, overrideGlAccountId, actualCurrencyAmount, actualCurrencyUomId, parentTypeId, hasTable, description
	}

	public PaymentAndType(GenericValue value) {
		paymentId = (String) value.get(Fields.paymentId.name());
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		paymentGatewayResponseId = (String) value
				.get(Fields.paymentGatewayResponseId.name());
		paymentPreferenceId = (String) value.get(Fields.paymentPreferenceId
				.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		statusId = (String) value.get(Fields.statusId.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		paymentRefNum = (String) value.get(Fields.paymentRefNum.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		comments = (String) value.get(Fields.comments.name());
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		actualCurrencyAmount = (BigDecimal) value
				.get(Fields.actualCurrencyAmount.name());
		actualCurrencyUomId = (String) value.get(Fields.actualCurrencyUomId
				.name());
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