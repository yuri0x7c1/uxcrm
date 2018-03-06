package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Type
 */
public class PaymentType implements Serializable {

	public static final long serialVersionUID = 1488194248312602624L;
	public static final String NAME = "PaymentType";
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		paymentTypeId, parentTypeId, hasTable, description
	}

	public PaymentType(GenericValue value) {
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PaymentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentType(value);
	}

	public static List<PaymentType> fromValues(List<GenericValue> values) {
		List<PaymentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentType(value));
		}
		return entities;
	}
}