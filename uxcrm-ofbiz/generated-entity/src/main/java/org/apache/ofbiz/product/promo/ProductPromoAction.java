package org.apache.ofbiz.product.promo;

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
public class ProductPromoAction implements Serializable {

	public static final long serialVersionUID = 6135936430245726208L;
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

	public enum Fields {
		productPromoId, productPromoRuleId, productPromoActionSeqId, productPromoActionEnumId, orderAdjustmentTypeId, serviceName, quantity, amount, productId, partyId, useCartQuantity, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductPromoAction(GenericValue value) {
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoRuleId = (String) value.get(Fields.productPromoRuleId
				.name());
		productPromoActionSeqId = (String) value
				.get(Fields.productPromoActionSeqId.name());
		productPromoActionEnumId = (String) value
				.get(Fields.productPromoActionEnumId.name());
		orderAdjustmentTypeId = (String) value.get(Fields.orderAdjustmentTypeId
				.name());
		serviceName = (String) value.get(Fields.serviceName.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		productId = (String) value.get(Fields.productId.name());
		partyId = (String) value.get(Fields.partyId.name());
		useCartQuantity = (String) value.get(Fields.useCartQuantity.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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