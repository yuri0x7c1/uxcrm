package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Iactn
 */
public class ProductFeatureIactn implements Serializable {

	public static final long serialVersionUID = 5293569598704822272L;
	public static final String NAME = "ProductFeatureIactn";
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Product Feature Id To
	 */
	@Getter
	@Setter
	private String productFeatureIdTo;
	/**
	 * Product Feature Iactn Type Id
	 */
	@Getter
	@Setter
	private String productFeatureIactnTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;

	public enum Fields {
		productFeatureId, productFeatureIdTo, productFeatureIactnTypeId, productId
	}

	public ProductFeatureIactn(GenericValue value) {
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		productFeatureIdTo = (String) value.get(Fields.productFeatureIdTo
				.name());
		productFeatureIactnTypeId = (String) value
				.get(Fields.productFeatureIactnTypeId.name());
		productId = (String) value.get(Fields.productId.name());
	}

	public static ProductFeatureIactn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureIactn(value);
	}

	public static List<ProductFeatureIactn> fromValues(List<GenericValue> values) {
		List<ProductFeatureIactn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureIactn(value));
		}
		return entities;
	}
}