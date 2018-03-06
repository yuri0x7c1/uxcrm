package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Purpose
 */
public class ProductPricePurpose implements Serializable {

	public static final long serialVersionUID = 8921249599435993088L;
	public static final String NAME = "ProductPricePurpose";
	/**
	 * Product Price Purpose Id
	 */
	@Getter
	@Setter
	private String productPricePurposeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productPricePurposeId, description
	}

	public ProductPricePurpose(GenericValue value) {
		productPricePurposeId = (String) value.get(Fields.productPricePurposeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductPricePurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPricePurpose(value);
	}

	public static List<ProductPricePurpose> fromValues(List<GenericValue> values) {
		List<ProductPricePurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPricePurpose(value));
		}
		return entities;
	}
}