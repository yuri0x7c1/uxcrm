package org.apache.ofbiz.product.promo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Use
 */
public class ProductPromoUse implements Serializable {

	public static final long serialVersionUID = 9215263653754244096L;
	public static final String NAME = "ProductPromoUse";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Promo Sequence Id
	 */
	@Getter
	@Setter
	private String promoSequenceId;
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Total Discount Amount
	 */
	@Getter
	@Setter
	private BigDecimal totalDiscountAmount;
	/**
	 * Quantity Left In Actions
	 */
	@Getter
	@Setter
	private BigDecimal quantityLeftInActions;

	public enum Fields {
		orderId, promoSequenceId, productPromoId, productPromoCodeId, partyId, totalDiscountAmount, quantityLeftInActions
	}

	public ProductPromoUse(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		promoSequenceId = (String) value.get(Fields.promoSequenceId.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		totalDiscountAmount = (BigDecimal) value.get(Fields.totalDiscountAmount
				.name());
		quantityLeftInActions = (BigDecimal) value
				.get(Fields.quantityLeftInActions.name());
	}

	public static ProductPromoUse fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoUse(value);
	}

	public static List<ProductPromoUse> fromValues(List<GenericValue> values) {
		List<ProductPromoUse> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoUse(value));
		}
		return entities;
	}
}