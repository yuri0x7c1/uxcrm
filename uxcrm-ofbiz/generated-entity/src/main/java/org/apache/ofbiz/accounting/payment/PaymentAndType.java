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
 * Payment And Type
 */
@FieldNameConstants
public class PaymentAndType implements Serializable {

	public static final long serialVersionUID = 5765583967529289728L;
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

	public PaymentAndType(GenericValue value) {
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		finAccountTransId = (String) value.get(FIELD_FIN_ACCOUNT_TRANS_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		paymentPreferenceId = (String) value.get(FIELD_PAYMENT_PREFERENCE_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		actualCurrencyAmount = (BigDecimal) value
				.get(FIELD_ACTUAL_CURRENCY_AMOUNT);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
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
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
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