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
 * Product Promo Category
 */
@FieldNameConstants
public class ProductPromoCategory implements Serializable {

	public static final long serialVersionUID = 3043258754181475328L;
	public static final String NAME = "ProductPromoCategory";
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
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * And Group Id
	 */
	@Getter
	@Setter
	private String andGroupId;
	/**
	 * Product Promo Appl Enum Id
	 */
	@Getter
	@Setter
	private String productPromoApplEnumId;
	/**
	 * Include Sub Categories
	 */
	@Getter
	@Setter
	private String includeSubCategories;
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

	public ProductPromoCategory(GenericValue value) {
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoRuleId = (String) value.get(FIELD_PRODUCT_PROMO_RULE_ID);
		productPromoActionSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_ACTION_SEQ_ID);
		productPromoCondSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_COND_SEQ_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		andGroupId = (String) value.get(FIELD_AND_GROUP_ID);
		productPromoApplEnumId = (String) value
				.get(FIELD_PRODUCT_PROMO_APPL_ENUM_ID);
		includeSubCategories = (String) value.get(FIELD_INCLUDE_SUB_CATEGORIES);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCategory(value);
	}

	public static List<ProductPromoCategory> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCategory(value));
		}
		return entities;
	}
}