package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Action Type
 */
public class ProductPriceActionType implements Serializable {

	public static final long serialVersionUID = 2639246035902182400L;
	public static final String NAME = "ProductPriceActionType";
	/**
	 * Product Price Action Type Id
	 */
	@Getter
	@Setter
	private String productPriceActionTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productPriceActionTypeId, description
	}

	public ProductPriceActionType(GenericValue value) {
		productPriceActionTypeId = (String) value
				.get(Fields.productPriceActionTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductPriceActionType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceActionType(value);
	}

	public static List<ProductPriceActionType> fromValues(
			List<GenericValue> values) {
		List<ProductPriceActionType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceActionType(value));
		}
		return entities;
	}
}