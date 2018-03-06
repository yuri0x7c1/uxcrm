package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Billing Account Term Attr
 */
public class BillingAccountTermAttr implements Serializable {

	public static final long serialVersionUID = 4621896254058084352L;
	public static final String NAME = "BillingAccountTermAttr";
	/**
	 * Billing Account Term Id
	 */
	@Getter
	@Setter
	private String billingAccountTermId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;

	public enum Fields {
		billingAccountTermId, attrName, attrValue
	}

	public BillingAccountTermAttr(GenericValue value) {
		billingAccountTermId = (String) value.get(Fields.billingAccountTermId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
	}

	public static BillingAccountTermAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BillingAccountTermAttr(value);
	}

	public static List<BillingAccountTermAttr> fromValues(
			List<GenericValue> values) {
		List<BillingAccountTermAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BillingAccountTermAttr(value));
		}
		return entities;
	}
}