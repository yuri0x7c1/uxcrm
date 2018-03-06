package org.apache.ofbiz.accounting.finaccount.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account And Role
 */
public class FinAccountAndRole implements Serializable {

	public static final long serialVersionUID = 7543302427857100800L;
	public static final String NAME = "FinAccountAndRole";
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

	public enum Fields {
		finAccountId, finAccountTypeId, statusId, finAccountName, finAccountCode, finAccountPin, currencyUomId, organizationPartyId, ownerPartyId, postToGlAccountId, fromDate, thruDate, isRefundable, replenishPaymentId, replenishLevel, actualBalance, availableBalance, partyId, roleTypeId
	}

	public FinAccountAndRole(GenericValue value) {
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
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static FinAccountAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountAndRole(value);
	}

	public static List<FinAccountAndRole> fromValues(List<GenericValue> values) {
		List<FinAccountAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountAndRole(value));
		}
		return entities;
	}
}