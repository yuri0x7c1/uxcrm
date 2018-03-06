package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Product Promo Code
 */
public class OrderProductPromoCode implements Serializable {

	public static final long serialVersionUID = 4056601872999420928L;
	public static final String NAME = "OrderProductPromoCode";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;

	public enum Fields {
		orderId, productPromoCodeId
	}

	public OrderProductPromoCode(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
	}

	public static OrderProductPromoCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderProductPromoCode(value);
	}

	public static List<OrderProductPromoCode> fromValues(
			List<GenericValue> values) {
		List<OrderProductPromoCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderProductPromoCode(value));
		}
		return entities;
	}
}