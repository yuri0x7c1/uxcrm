package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway Config
 */
public class PaymentGatewayConfig implements Serializable {

	public static final long serialVersionUID = 6683519525782406144L;
	public static final String NAME = "PaymentGatewayConfig";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Payment Gateway Config Type Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		paymentGatewayConfigId, paymentGatewayConfigTypeId, description
	}

	public PaymentGatewayConfig(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		paymentGatewayConfigTypeId = (String) value
				.get(Fields.paymentGatewayConfigTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PaymentGatewayConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayConfig(value);
	}

	public static List<PaymentGatewayConfig> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayConfig(value));
		}
		return entities;
	}
}