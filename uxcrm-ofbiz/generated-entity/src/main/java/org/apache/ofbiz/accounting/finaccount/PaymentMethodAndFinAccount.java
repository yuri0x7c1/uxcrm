package org.apache.ofbiz.accounting.finaccount;

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
 * Payment Method And Fin Account
 */
@FieldNameConstants
public class PaymentMethodAndFinAccount implements Serializable {

	public static final long serialVersionUID = 6132776101145929728L;
	public static final String NAME = "PaymentMethodAndFinAccount";
	/**
	 * Fin Account Type Id
	 */
	@Getter
	@Setter
	private String finAccountTypeId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Is Refundable
	 */
	@Getter
	@Setter
	private String isRefundable;
	/**
	 * Available Balance
	 */
	@Getter
	@Setter
	private BigDecimal availableBalance;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Post To Gl Account Id
	 */
	@Getter
	@Setter
	private String postToGlAccountId;
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
	 * Fin Account Name
	 */
	@Getter
	@Setter
	private String finAccountName;
	/**
	 * Fin Account Pin
	 */
	@Getter
	@Setter
	private String finAccountPin;
	/**
	 * Actual Balance
	 */
	@Getter
	@Setter
	private BigDecimal actualBalance;
	/**
	 * Replenish Level
	 */
	@Getter
	@Setter
	private BigDecimal replenishLevel;
	/**
	 * Replenish Payment Id
	 */
	@Getter
	@Setter
	private String replenishPaymentId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Fin Account Code
	 */
	@Getter
	@Setter
	private String finAccountCode;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public PaymentMethodAndFinAccount(GenericValue value) {
		finAccountTypeId = (String) value.get(FIELD_FIN_ACCOUNT_TYPE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		isRefundable = (String) value.get(FIELD_IS_REFUNDABLE);
		availableBalance = (BigDecimal) value.get(FIELD_AVAILABLE_BALANCE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		postToGlAccountId = (String) value.get(FIELD_POST_TO_GL_ACCOUNT_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		finAccountName = (String) value.get(FIELD_FIN_ACCOUNT_NAME);
		finAccountPin = (String) value.get(FIELD_FIN_ACCOUNT_PIN);
		actualBalance = (BigDecimal) value.get(FIELD_ACTUAL_BALANCE);
		replenishLevel = (BigDecimal) value.get(FIELD_REPLENISH_LEVEL);
		replenishPaymentId = (String) value.get(FIELD_REPLENISH_PAYMENT_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		finAccountCode = (String) value.get(FIELD_FIN_ACCOUNT_CODE);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
	}

	public static PaymentMethodAndFinAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodAndFinAccount(value);
	}

	public static List<PaymentMethodAndFinAccount> fromValues(
			List<GenericValue> values) {
		List<PaymentMethodAndFinAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodAndFinAccount(value));
		}
		return entities;
	}
}