package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Type
 */
public class ProductPriceType implements Serializable {

	public static final long serialVersionUID = 4577967885986555904L;
	public static final String NAME = "ProductPriceType";
	/**
	 * Product Price Type Id
	 */
	@Getter
	@Setter
	private String productPriceTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productPriceTypeId, description
	}

	public ProductPriceType(GenericValue value) {
		productPriceTypeId = (String) value.get(Fields.productPriceTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductPriceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceType(value);
	}

	public static List<ProductPriceType> fromValues(List<GenericValue> values) {
		List<ProductPriceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceType(value));
		}
		return entities;
	}
}