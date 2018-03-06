package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Type Attr
 */
public class PaymentTypeAttr implements Serializable {

	public static final long serialVersionUID = 2085941428876795904L;
	public static final String NAME = "PaymentTypeAttr";
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		paymentTypeId, attrName, description
	}

	public PaymentTypeAttr(GenericValue value) {
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PaymentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentTypeAttr(value);
	}

	public static List<PaymentTypeAttr> fromValues(List<GenericValue> values) {
		List<PaymentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentTypeAttr(value));
		}
		return entities;
	}
}