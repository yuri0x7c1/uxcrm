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
 * Product Promo Rule
 */
@FieldNameConstants
public class ProductPromoRule implements Serializable {

	public static final long serialVersionUID = 8962286996461224960L;
	public static final String NAME = "ProductPromoRule";
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
	 * Rule Name
	 */
	@Getter
	@Setter
	private String ruleName;
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

	public ProductPromoRule(GenericValue value) {
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoRuleId = (String) value.get(FIELD_PRODUCT_PROMO_RULE_ID);
		ruleName = (String) value.get(FIELD_RULE_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoRule fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoRule(value);
	}

	public static List<ProductPromoRule> fromValues(List<GenericValue> values) {
		List<ProductPromoRule> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoRule(value));
		}
		return entities;
	}
}