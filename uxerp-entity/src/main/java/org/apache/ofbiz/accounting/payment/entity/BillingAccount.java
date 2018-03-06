package org.apache.ofbiz.accounting.payment.entity;

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
public class BillingAccount implements Serializable {

	public static final long serialVersionUID = 4508734919106228224L;
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

	public enum Fields {
		billingAccountId, accountLimit, accountCurrencyUomId, contactMechId, fromDate, thruDate, description, externalAccountId
	}

	public BillingAccount(GenericValue value) {
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		accountLimit = (BigDecimal) value.get(Fields.accountLimit.name());
		accountCurrencyUomId = (String) value.get(Fields.accountCurrencyUomId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		description = (String) value.get(Fields.description.name());
		externalAccountId = (String) value.get(Fields.externalAccountId.name());
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