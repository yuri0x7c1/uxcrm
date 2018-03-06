package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Data Resource
 */
public class ProductFeatureDataResource implements Serializable {

	public static final long serialVersionUID = 7296291695196664832L;
	public static final String NAME = "ProductFeatureDataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;

	public enum Fields {
		dataResourceId, productFeatureId
	}

	public ProductFeatureDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
	}

	public static ProductFeatureDataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureDataResource(value);
	}

	public static List<ProductFeatureDataResource> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureDataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureDataResource(value));
		}
		return entities;
	}
}