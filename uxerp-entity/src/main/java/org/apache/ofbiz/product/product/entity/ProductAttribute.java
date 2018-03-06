package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Attribute
 */
public class ProductAttribute implements Serializable {

	public static final long serialVersionUID = 4871745603926641664L;
	public static final String NAME = "ProductAttribute";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Attr Type
	 */
	@Getter
	@Setter
	private String attrType;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		productId, attrName, attrValue, attrType, attrDescription
	}

	public ProductAttribute(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrType = (String) value.get(Fields.attrType.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static ProductAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAttribute(value);
	}

	public static List<ProductAttribute> fromValues(List<GenericValue> values) {
		List<ProductAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAttribute(value));
		}
		return entities;
	}
}