package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Billing Account Term
 */
public class BillingAccountTerm implements Serializable {

	public static final long serialVersionUID = 5848737917293667328L;
	public static final String NAME = "BillingAccountTerm";
	/**
	 * Billing Account Term Id
	 */
	@Getter
	@Setter
	private String billingAccountTermId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Term Value
	 */
	@Getter
	@Setter
	private BigDecimal termValue;
	/**
	 * Term Days
	 */
	@Getter
	@Setter
	private Long termDays;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;

	public enum Fields {
		billingAccountTermId, billingAccountId, termTypeId, termValue, termDays, uomId
	}

	public BillingAccountTerm(GenericValue value) {
		billingAccountTermId = (String) value.get(Fields.billingAccountTermId
				.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		termTypeId = (String) value.get(Fields.termTypeId.name());
		termValue = (BigDecimal) value.get(Fields.termValue.name());
		termDays = (Long) value.get(Fields.termDays.name());
		uomId = (String) value.get(Fields.uomId.name());
	}

	public static BillingAccountTerm fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BillingAccountTerm(value);
	}

	public static List<BillingAccountTerm> fromValues(List<GenericValue> values) {
		List<BillingAccountTerm> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BillingAccountTerm(value));
		}
		return entities;
	}
}