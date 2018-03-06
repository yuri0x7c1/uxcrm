package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account
 */
public class FinAccount implements Serializable {

	public static final long serialVersionUID = 6500416054952621056L;
	public static final String NAME = "FinAccount";
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Fin Account Type Id
	 */
	@Getter
	@Setter
	private String finAccountTypeId;
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
	 * Fin Account Code
	 */
	@Getter
	@Setter
	private String finAccountCode;
	/**
	 * Fin Account Pin
	 */
	@Getter
	@Setter
	private String finAccountPin;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Post To Gl Account Id
	 */
	@Getter
	@Setter
	private String postToGlAccountId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
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
	 * Replenish Payment Id
	 */
	@Getter
	@Setter
	private String replenishPaymentId;
	/**
	 * Replenish Level
	 */
	@Getter
	@Setter
	private BigDecimal replenishLevel;
	/**
	 * Actual Balance
	 */
	@Getter
	@Setter
	private BigDecimal actualBalance;
	/**
	 * Available Balance
	 */
	@Getter
	@Setter
	private BigDecimal availableBalance;

	public enum Fields {
		finAccountId, finAccountTypeId, statusId, finAccountName, finAccountCode, finAccountPin, currencyUomId, organizationPartyId, ownerPartyId, postToGlAccountId, fromDate, thruDate, isRefundable, replenishPaymentId, replenishLevel, actualBalance, availableBalance
	}

	public FinAccount(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		finAccountName = (String) value.get(Fields.finAccountName.name());
		finAccountCode = (String) value.get(Fields.finAccountCode.name());
		finAccountPin = (String) value.get(Fields.finAccountPin.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		postToGlAccountId = (String) value.get(Fields.postToGlAccountId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		isRefundable = (String) value.get(Fields.isRefundable.name());
		replenishPaymentId = (String) value.get(Fields.replenishPaymentId
				.name());
		replenishLevel = (BigDecimal) value.get(Fields.replenishLevel.name());
		actualBalance = (BigDecimal) value.get(Fields.actualBalance.name());
		availableBalance = (BigDecimal) value.get(Fields.availableBalance
				.name());
	}

	public static FinAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccount(value);
	}

	public static List<FinAccount> fromValues(List<GenericValue> values) {
		List<FinAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccount(value));
		}
		return entities;
	}
}