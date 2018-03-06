package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Iactn Type
 */
public class ProductFeatureIactnType implements Serializable {

	public static final long serialVersionUID = 1434328022975360000L;
	public static final String NAME = "ProductFeatureIactnType";
	/**
	 * Product Feature Iactn Type Id
	 */
	@Getter
	@Setter
	private String productFeatureIactnTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productFeatureIactnTypeId, parentTypeId, hasTable, description
	}

	public ProductFeatureIactnType(GenericValue value) {
		productFeatureIactnTypeId = (String) value
				.get(Fields.productFeatureIactnTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductFeatureIactnType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureIactnType(value);
	}

	public static List<ProductFeatureIactnType> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureIactnType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureIactnType(value));
		}
		return entities;
	}
}