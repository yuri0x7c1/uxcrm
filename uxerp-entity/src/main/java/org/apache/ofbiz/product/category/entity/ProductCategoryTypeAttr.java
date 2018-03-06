package org.apache.ofbiz.product.category.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Type Attr
 */
public class ProductCategoryTypeAttr implements Serializable {

	public static final long serialVersionUID = 4720761742706284544L;
	public static final String NAME = "ProductCategoryTypeAttr";
	/**
	 * Product Category Type Id
	 */
	@Getter
	@Setter
	private String productCategoryTypeId;
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
		productCategoryTypeId, attrName, description
	}

	public ProductCategoryTypeAttr(GenericValue value) {
		productCategoryTypeId = (String) value.get(Fields.productCategoryTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductCategoryTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryTypeAttr(value);
	}

	public static List<ProductCategoryTypeAttr> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryTypeAttr(value));
		}
		return entities;
	}
}