package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Category
 */
public class ProductFeatureCategory implements Serializable {

	public static final long serialVersionUID = 5088686020904492032L;
	public static final String NAME = "ProductFeatureCategory";
	/**
	 * Product Feature Category Id
	 */
	@Getter
	@Setter
	private String productFeatureCategoryId;
	/**
	 * Parent Category Id
	 */
	@Getter
	@Setter
	private String parentCategoryId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productFeatureCategoryId, parentCategoryId, description
	}

	public ProductFeatureCategory(GenericValue value) {
		productFeatureCategoryId = (String) value
				.get(Fields.productFeatureCategoryId.name());
		parentCategoryId = (String) value.get(Fields.parentCategoryId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductFeatureCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureCategory(value);
	}

	public static List<ProductFeatureCategory> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureCategory(value));
		}
		return entities;
	}
}