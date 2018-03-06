package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Method Type
 */
public class PaymentMethodType implements Serializable {

	public static final long serialVersionUID = 89524393817198592L;
	public static final String NAME = "PaymentMethodType";
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Gl Account Id
	 */
	@Getter
	@Setter
	private String defaultGlAccountId;

	public enum Fields {
		paymentMethodTypeId, description, defaultGlAccountId
	}

	public PaymentMethodType(GenericValue value) {
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		defaultGlAccountId = (String) value.get(Fields.defaultGlAccountId
				.name());
	}

	public static PaymentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentMethodType(value);
	}

	public static List<PaymentMethodType> fromValues(List<GenericValue> values) {
		List<PaymentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentMethodType(value));
		}
		return entities;
	}
}