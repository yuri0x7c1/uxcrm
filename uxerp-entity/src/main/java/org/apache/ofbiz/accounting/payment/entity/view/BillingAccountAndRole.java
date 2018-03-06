package org.apache.ofbiz.accounting.payment.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Billing Account And Role
 */
public class BillingAccountAndRole implements Serializable {

	public static final long serialVersionUID = 1254991781635257344L;
	public static final String NAME = "BillingAccountAndRole";
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		billingAccountId, partyId, roleTypeId, fromDate, thruDate, accountLimit, accountCurrencyUomId, contactMechId, description
	}

	public BillingAccountAndRole(GenericValue value) {
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		accountLimit = (BigDecimal) value.get(Fields.accountLimit.name());
		accountCurrencyUomId = (String) value.get(Fields.accountCurrencyUomId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		description = (String) value.get(Fields.description.name());
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