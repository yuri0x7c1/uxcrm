package org.apache.ofbiz.product.promo;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductPromoUseCheck implements Serializable {

	public static final long serialVersionUID = 3096782199649476608L;
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

	public ProductPromoUseCheck(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		quantityLeftInActions = (BigDecimal) value
				.get(FIELD_QUANTITY_LEFT_IN_ACTIONS);
		orderId = (String) value.get(FIELD_ORDER_ID);
		totalDiscountAmount = (BigDecimal) value
				.get(FIELD_TOTAL_DISCOUNT_AMOUNT);
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		promoSequenceId = (String) value.get(FIELD_PROMO_SEQUENCE_ID);
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
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