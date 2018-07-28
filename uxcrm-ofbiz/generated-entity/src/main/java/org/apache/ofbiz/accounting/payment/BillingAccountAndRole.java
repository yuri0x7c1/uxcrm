package org.apache.ofbiz.accounting.payment;

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
public class BillingAccountAndRole implements Serializable {

	public static final long serialVersionUID = 9159054317795189760L;
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

	public enum Fields {
		billingAccountId, accountLimit, accountCurrencyUomId, contactMechId, accountFromDate, accountThruDate, description, fromDate, roleTypeId, partyId, thruDate
	}

	public BillingAccountAndRole(GenericValue value) {
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		accountLimit = (BigDecimal) value.get(Fields.accountLimit.name());
		accountCurrencyUomId = (String) value.get(Fields.accountCurrencyUomId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		accountFromDate = (Timestamp) value.get(Fields.accountFromDate.name());
		accountThruDate = (Timestamp) value.get(Fields.accountThruDate.name());
		description = (String) value.get(Fields.description.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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