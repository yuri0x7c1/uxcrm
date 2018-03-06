package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Type Attr
 */
public class ProductTypeAttr implements Serializable {

	public static final long serialVersionUID = 3735672043132022784L;
	public static final String NAME = "ProductTypeAttr";
	/**
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productTypeId, attrName, description
	}

	public ProductTypeAttr(GenericValue value) {
		productTypeId = (String) value.get(Fields.productTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductTypeAttr(value);
	}

	public static List<ProductTypeAttr> fromValues(List<GenericValue> values) {
		List<ProductTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductTypeAttr(value));
		}
		return entities;
	}
}