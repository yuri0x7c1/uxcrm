package org.apache.ofbiz.product.promo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Product
 */
public class ProductPromoProduct implements Serializable {

	public static final long serialVersionUID = 3449066312631786496L;
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

	public enum Fields {
		productPromoId, productPromoRuleId, productPromoActionSeqId, productPromoCondSeqId, productId, productPromoApplEnumId
	}

	public ProductPromoProduct(GenericValue value) {
		productPromoId = (String) value.get(Fields.productPromoId.name());
		productPromoRuleId = (String) value.get(Fields.productPromoRuleId
				.name());
		productPromoActionSeqId = (String) value
				.get(Fields.productPromoActionSeqId.name());
		productPromoCondSeqId = (String) value.get(Fields.productPromoCondSeqId
				.name());
		productId = (String) value.get(Fields.productId.name());
		productPromoApplEnumId = (String) value
				.get(Fields.productPromoApplEnumId.name());
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