package org.apache.ofbiz.product.promo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Use
 */
@FieldNameConstants
public class ProductPromoUse implements Serializable {

	public static final long serialVersionUID = 320188801745165312L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public ProductPromoUse(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		promoSequenceId = (String) value.get(FIELD_PROMO_SEQUENCE_ID);
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		totalDiscountAmount = (BigDecimal) value
				.get(FIELD_TOTAL_DISCOUNT_AMOUNT);
		quantityLeftInActions = (BigDecimal) value
				.get(FIELD_QUANTITY_LEFT_IN_ACTIONS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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