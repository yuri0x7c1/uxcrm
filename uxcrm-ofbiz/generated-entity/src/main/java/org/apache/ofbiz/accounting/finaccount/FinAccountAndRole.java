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
 * Fin Account And Role
 */
public class FinAccountAndRole implements Serializable {

	public static final long serialVersionUID = 5744091180508105728L;
	public static final String NAME = "FinAccountAndRole";
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
	/**
	 * Role From Date
	 */
	@Getter
	@Setter
	private Timestamp roleFromDate;
	/**
	 * Role Thru Date
	 */
	@Getter
	@Setter
	private Timestamp roleThruDate;
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

	public enum Fields {
		partyId, roleTypeId, roleFromDate, roleThruDate, finAccountTypeId, thruDate, isRefundable, availableBalance, fromDate, ownerPartyId, finAccountId, postToGlAccountId, currencyUomId, statusId, finAccountName, finAccountPin, actualBalance, replenishLevel, replenishPaymentId, organizationPartyId, finAccountCode
	}

	public FinAccountAndRole(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		roleFromDate = (Timestamp) value.get(Fields.roleFromDate.name());
		roleThruDate = (Timestamp) value.get(Fields.roleThruDate.name());
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