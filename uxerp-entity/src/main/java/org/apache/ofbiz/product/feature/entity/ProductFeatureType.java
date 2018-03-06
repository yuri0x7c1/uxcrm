package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Type
 */
public class ProductFeatureType implements Serializable {

	public static final long serialVersionUID = 3398300111358921728L;
	public static final String NAME = "ProductFeatureType";
	/**
	 * Product Feature Type Id
	 */
	@Getter
	@Setter
	private String productFeatureTypeId;
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
		productFeatureTypeId, parentTypeId, hasTable, description
	}

	public ProductFeatureType(GenericValue value) {
		productFeatureTypeId = (String) value.get(Fields.productFeatureTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductFeatureType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureType(value);
	}

	public static List<ProductFeatureType> fromValues(List<GenericValue> values) {
		List<ProductFeatureType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureType(value));
		}
		return entities;
	}
}