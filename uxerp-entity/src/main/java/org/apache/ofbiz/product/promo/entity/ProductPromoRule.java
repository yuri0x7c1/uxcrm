package org.apache.ofbiz.product.promo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Rule
 */
public class ProductPromoRule implements Serializable {

	public static final long serialVersionUID = 2622208432898019328L;
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

	public enum Fields {
		productPromoId, productPromoRuleId, ruleName
	}

	public ProductPromoRule(GenericValue value) {
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoRuleId = (String) value.get(Fields.productPromoRuleId
				.name());
		ruleName = (String) value.get(Fields.ruleName.name());
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