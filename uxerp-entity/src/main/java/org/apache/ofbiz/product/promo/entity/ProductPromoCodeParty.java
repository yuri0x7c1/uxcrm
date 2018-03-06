package org.apache.ofbiz.product.promo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Code Party
 */
public class ProductPromoCodeParty implements Serializable {

	public static final long serialVersionUID = 2384203184554186752L;
	public static final String NAME = "ProductPromoCodeParty";
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

	public enum Fields {
		productPromoCodeId, partyId
	}

	public ProductPromoCodeParty(GenericValue value) {
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
	}

	public static ProductPromoCodeParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCodeParty(value);
	}

	public static List<ProductPromoCodeParty> fromValues(
			List<GenericValue> values) {
		List<ProductPromoCodeParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCodeParty(value));
		}
		return entities;
	}
}