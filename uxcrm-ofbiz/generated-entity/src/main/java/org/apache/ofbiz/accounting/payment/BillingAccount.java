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
 * Billing Account
 */
@FieldNameConstants
public class BillingAccount implements Serializable {

	public static final long serialVersionUID = 8577887059393471488L;
	public static final String NAME = "BillingAccount";
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Account Limit
	 */
	@Getter
	@Setter
	private BigDecimal accountLimit;
	/**
	 * Account Currency Uom Id
	 */
	@Getter
	@Setter
	private String accountCurrencyUomId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * External Account Id
	 */
	@Getter
	@Setter
	private String externalAccountId;
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

	public BillingAccount(GenericValue value) {
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		accountLimit = (BigDecimal) value.get(FIELD_ACCOUNT_LIMIT);
		accountCurrencyUomId = (String) value
				.get(FIELD_ACCOUNT_CURRENCY_UOM_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		externalAccountId = (String) value.get(FIELD_EXTERNAL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BillingAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BillingAccount(value);
	}

	public static List<BillingAccount> fromValues(List<GenericValue> values) {
		List<BillingAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BillingAccount(value));
		}
		return entities;
	}
}