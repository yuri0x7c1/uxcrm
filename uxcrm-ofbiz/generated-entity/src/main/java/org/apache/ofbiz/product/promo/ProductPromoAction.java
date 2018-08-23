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
 * Product Promo Action
 */
@FieldNameConstants
public class ProductPromoAction implements Serializable {

	public static final long serialVersionUID = 7811669751128105984L;
	public static final String NAME = "ProductPromoAction";
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Product Promo Rule Id
	 */
	@Getter
	@Setter
	private String productPromoRuleId;
	/**
	 * Product Promo Action Seq Id
	 */
	@Getter
	@Setter
	private String productPromoActionSeqId;
	/**
	 * Product Promo Action Enum Id
	 */
	@Getter
	@Setter
	private String productPromoActionEnumId;
	/**
	 * Order Adjustment Type Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentTypeId;
	/**
	 * Service Name
	 */
	@Getter
	@Setter
	private String serviceName;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Use Cart Quantity
	 */
	@Getter
	@Setter
	private String useCartQuantity;
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

	public ProductPromoAction(GenericValue value) {
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoRuleId = (String) value.get(FIELD_PRODUCT_PROMO_RULE_ID);
		productPromoActionSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_ACTION_SEQ_ID);
		productPromoActionEnumId = (String) value
				.get(FIELD_PRODUCT_PROMO_ACTION_ENUM_ID);
		orderAdjustmentTypeId = (String) value
				.get(FIELD_ORDER_ADJUSTMENT_TYPE_ID);
		serviceName = (String) value.get(FIELD_SERVICE_NAME);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		useCartQuantity = (String) value.get(FIELD_USE_CART_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoAction fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoAction(value);
	}

	public static List<ProductPromoAction> fromValues(List<GenericValue> values) {
		List<ProductPromoAction> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoAction(value));
		}
		return entities;
	}
}