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
 * Fin Account
 */
@FieldNameConstants
public class FinAccount implements Serializable {

	public static final long serialVersionUID = 2630498266127777792L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public FinAccount(GenericValue value) {
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		finAccountTypeId = (String) value.get(FIELD_FIN_ACCOUNT_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		finAccountName = (String) value.get(FIELD_FIN_ACCOUNT_NAME);
		finAccountCode = (String) value.get(FIELD_FIN_ACCOUNT_CODE);
		finAccountPin = (String) value.get(FIELD_FIN_ACCOUNT_PIN);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		postToGlAccountId = (String) value.get(FIELD_POST_TO_GL_ACCOUNT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		isRefundable = (String) value.get(FIELD_IS_REFUNDABLE);
		replenishPaymentId = (String) value.get(FIELD_REPLENISH_PAYMENT_ID);
		replenishLevel = (BigDecimal) value.get(FIELD_REPLENISH_LEVEL);
		actualBalance = (BigDecimal) value.get(FIELD_ACTUAL_BALANCE);
		availableBalance = (BigDecimal) value.get(FIELD_AVAILABLE_BALANCE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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