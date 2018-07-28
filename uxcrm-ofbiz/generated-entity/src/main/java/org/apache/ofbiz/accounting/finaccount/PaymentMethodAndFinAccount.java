package org.apache.ofbiz.accounting.finaccount;

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
public class PaymentMethodAndFinAccount implements Serializable {

	public static final long serialVersionUID = 4113796640451529728L;
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

	public enum Fields {
		finAccountTypeId, thruDate, isRefundable, availableBalance, fromDate, ownerPartyId, finAccountId, postToGlAccountId, currencyUomId, statusId, finAccountName, finAccountPin, actualBalance, replenishLevel, replenishPaymentId, organizationPartyId, finAccountCode, paymentMethodId, glAccountId, description, paymentMethodTypeId, partyId
	}

	public PaymentMethodAndFinAccount(GenericValue value) {
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		isRefundable = (String) value.get(Fields.isRefundable.name());
		availableBalance = (BigDecimal) value.get(Fields.availableBalance
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		finAccountId = (String) value.get(Fields.finAccountId.name());
		postToGlAccountId = (String) value.get(Fields.postToGlAccountId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		finAccountName = (String) value.get(Fields.finAccountName.name());
		finAccountPin = (String) value.get(Fields.finAccountPin.name());
		actualBalance = (BigDecimal) value.get(Fields.actualBalance.name());
		replenishLevel = (BigDecimal) value.get(Fields.replenishLevel.name());
		replenishPaymentId = (String) value.get(Fields.replenishPaymentId
				.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		finAccountCode = (String) value.get(Fields.finAccountCode.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		description = (String) value.get(Fields.description.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
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