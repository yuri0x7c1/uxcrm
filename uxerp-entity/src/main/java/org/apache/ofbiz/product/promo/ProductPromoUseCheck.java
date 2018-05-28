package org.apache.ofbiz.product.promo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Use Check
 */
public class ProductPromoUseCheck implements Serializable {

	public static final long serialVersionUID = 3413496330144629760L;
	public static final String NAME = "ProductPromoUseCheck";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Quantity Left In Actions
	 */
	@Getter
	@Setter
	private BigDecimal quantityLeftInActions;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Total Discount Amount
	 */
	@Getter
	@Setter
	private BigDecimal totalDiscountAmount;
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public enum Fields {
		statusId, quantityLeftInActions, orderId, totalDiscountAmount, productPromoCodeId, promoSequenceId, productPromoId, partyId
	}

	public ProductPromoUseCheck(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		quantityLeftInActions = (BigDecimal) value
				.get(Fields.quantityLeftInActions.name());
		orderId = (String) value.get(Fields.orderId.name());
		totalDiscountAmount = (BigDecimal) value.get(Fields.totalDiscountAmount
				.name());
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		promoSequenceId = (String) value.get(Fields.promoSequenceId.name());
		productPromoId = (String) value.get(Fields.productPromoId.name());
		partyId = (String) value.get(Fields.partyId.name());
	}

	public static ProductPromoUseCheck fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoUseCheck(value);
	}

	public static List<ProductPromoUseCheck> fromValues(
			List<GenericValue> values) {
		List<ProductPromoUseCheck> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoUseCheck(value));
		}
		return entities;
	}
}