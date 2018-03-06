package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Attribute
 */
public class PaymentAttribute implements Serializable {

	public static final long serialVersionUID = 8250323201486390272L;
	public static final String NAME = "PaymentAttribute";
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
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
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		paymentId, attrName, attrValue, attrDescription
	}

	public PaymentAttribute(GenericValue value) {
		paymentId = (String) value.get(Fields.paymentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static PaymentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentAttribute(value);
	}

	public static List<PaymentAttribute> fromValues(List<GenericValue> values) {
		List<PaymentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentAttribute(value));
		}
		return entities;
	}
}