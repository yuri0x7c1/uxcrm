package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Group
 */
public class ProductFeatureGroup implements Serializable {

	public static final long serialVersionUID = 1898563181270182912L;
	public static final String NAME = "ProductFeatureGroup";
	/**
	 * Product Feature Group Id
	 */
	@Getter
	@Setter
	private String productFeatureGroupId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productFeatureGroupId, description
	}

	public ProductFeatureGroup(GenericValue value) {
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductFeatureGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureGroup(value);
	}

	public static List<ProductFeatureGroup> fromValues(List<GenericValue> values) {
		List<ProductFeatureGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureGroup(value));
		}
		return entities;
	}
}