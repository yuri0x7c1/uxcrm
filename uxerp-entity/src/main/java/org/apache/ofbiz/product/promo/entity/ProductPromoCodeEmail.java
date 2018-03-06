package org.apache.ofbiz.product.promo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Code Email
 */
public class ProductPromoCodeEmail implements Serializable {

	public static final long serialVersionUID = 1237245809554360320L;
	public static final String NAME = "ProductPromoCodeEmail";
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Email Address
	 */
	@Getter
	@Setter
	private String emailAddress;

	public enum Fields {
		productPromoCodeId, emailAddress
	}

	public ProductPromoCodeEmail(GenericValue value) {
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		emailAddress = (String) value.get(Fields.emailAddress.name());
	}

	public static ProductPromoCodeEmail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCodeEmail(value);
	}

	public static List<ProductPromoCodeEmail> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCodeEmail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCodeEmail(value));
		}
		return entities;
	}
}