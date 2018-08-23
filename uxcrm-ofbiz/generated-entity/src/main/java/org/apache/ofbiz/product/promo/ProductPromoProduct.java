package org.apache.ofbiz.product.promo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Product
 */
@FieldNameConstants
public class ProductPromoProduct implements Serializable {

	public static final long serialVersionUID = 4068510186869760000L;
	public static final String NAME = "ProductPromoProduct";
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
	 * Product Promo Cond Seq Id
	 */
	@Getter
	@Setter
	private String productPromoCondSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Promo Appl Enum Id
	 */
	@Getter
	@Setter
	private String productPromoApplEnumId;
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

	public ProductPromoProduct(GenericValue value) {
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoRuleId = (String) value.get(FIELD_PRODUCT_PROMO_RULE_ID);
		productPromoActionSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_ACTION_SEQ_ID);
		productPromoCondSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_COND_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productPromoApplEnumId = (String) value
				.get(FIELD_PRODUCT_PROMO_APPL_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoProduct(value);
	}

	public static List<ProductPromoProduct> fromValues(List<GenericValue> values) {
		List<ProductPromoProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoProduct(value));
		}
		return entities;
	}
}