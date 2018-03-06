package org.apache.ofbiz.product.category.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Attribute
 */
public class ProductCategoryAttribute implements Serializable {

	public static final long serialVersionUID = 7626387883594526720L;
	public static final String NAME = "ProductCategoryAttribute";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		productCategoryId, attrName, attrValue, attrDescription
	}

	public ProductCategoryAttribute(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static ProductCategoryAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryAttribute(value);
	}

	public static List<ProductCategoryAttribute> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryAttribute(value));
		}
		return entities;
	}
}