package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Appl Type
 */
public class ProductFeatureApplType implements Serializable {

	public static final long serialVersionUID = 8030095296183705600L;
	public static final String NAME = "ProductFeatureApplType";
	/**
	 * Product Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String productFeatureApplTypeId;
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
		productFeatureApplTypeId, parentTypeId, hasTable, description
	}

	public ProductFeatureApplType(GenericValue value) {
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductFeatureApplType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureApplType(value);
	}

	public static List<ProductFeatureApplType> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureApplType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureApplType(value));
		}
		return entities;
	}
}