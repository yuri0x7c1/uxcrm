package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Config Type
 */
public class PaymentGatewayConfigType implements Serializable {

	public static final long serialVersionUID = 4930733159379950592L;
	public static final String NAME = "PaymentGatewayConfigType";
	/**
	 * Payment Gateway Config Type Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigTypeId;
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
		paymentGatewayConfigTypeId, parentTypeId, hasTable, description
	}

	public PaymentGatewayConfigType(GenericValue value) {
		paymentGatewayConfigTypeId = (String) value
				.get(Fields.paymentGatewayConfigTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PaymentGatewayConfigType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayConfigType(value);
	}

	public static List<PaymentGatewayConfigType> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayConfigType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayConfigType(value));
		}
		return entities;
	}
}