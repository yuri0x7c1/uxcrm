package org.apache.ofbiz.bi.dimension.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Dimension
 */
public class ProductDimension implements Serializable {

	public static final long serialVersionUID = 7622063618418757632L;
	public static final String NAME = "ProductDimension";
	/**
	 * Dimension Id
	 */
	@Getter
	@Setter
	private String dimensionId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Type
	 */
	@Getter
	@Setter
	private String productType;
	/**
	 * Brand Name
	 */
	@Getter
	@Setter
	private String brandName;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;

	public enum Fields {
		dimensionId, productId, productType, brandName, internalName
	}

	public ProductDimension(GenericValue value) {
		dimensionId = (String) value.get(Fields.dimensionId.name());
		productId = (String) value.get(Fields.productId.name());
		productType = (String) value.get(Fields.productType.name());
		brandName = (String) value.get(Fields.brandName.name());
		internalName = (String) value.get(Fields.internalName.name());
	}

	public static ProductDimension fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductDimension(value);
	}

	public static List<ProductDimension> fromValues(List<GenericValue> values) {
		List<ProductDimension> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductDimension(value));
		}
		return entities;
	}
}