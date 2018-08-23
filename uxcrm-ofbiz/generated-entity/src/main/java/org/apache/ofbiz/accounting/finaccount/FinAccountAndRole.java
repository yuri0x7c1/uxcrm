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
 * Fin Account And Role
 */
@FieldNameConstants
public class FinAccountAndRole implements Serializable {

	public static final long serialVersionUID = 2907911303254639616L;
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

	public FinAccountAndRole(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		roleFromDate = (Timestamp) value.get(FIELD_ROLE_FROM_DATE);
		roleThruDate = (Timestamp) value.get(FIELD_ROLE_THRU_DATE);
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