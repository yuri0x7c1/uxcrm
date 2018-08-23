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
 * Billing Account And Role
 */
@FieldNameConstants
public class BillingAccountAndRole implements Serializable {

	public static final long serialVersionUID = 4972259285787683840L;
	public static final String NAME = "BillingAccountAndRole";
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
	 * Account From Date
	 */
	@Getter
	@Setter
	private Timestamp accountFromDate;
	/**
	 * Account Thru Date
	 */
	@Getter
	@Setter
	private Timestamp accountThruDate;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public BillingAccountAndRole(GenericValue value) {
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		accountLimit = (BigDecimal) value.get(FIELD_ACCOUNT_LIMIT);
		accountCurrencyUomId = (String) value
				.get(FIELD_ACCOUNT_CURRENCY_UOM_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		accountFromDate = (Timestamp) value.get(FIELD_ACCOUNT_FROM_DATE);
		accountThruDate = (Timestamp) value.get(FIELD_ACCOUNT_THRU_DATE);
		description = (String) value.get(FIELD_DESCRIPTION);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static BillingAccountAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BillingAccountAndRole(value);
	}

	public static List<BillingAccountAndRole> fromValues(
			List<GenericValue> values) {
		List<BillingAccountAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BillingAccountAndRole(value));
		}
		return entities;
	}
}