package org.apache.ofbiz.product.store.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group Type
 */
public class ProductStoreGroupType implements Serializable {

	public static final long serialVersionUID = 5146625564845922304L;
	public static final String NAME = "ProductStoreGroupType";
	/**
	 * Product Store Group Type Id
	 */
	@Getter
	@Setter
	private String productStoreGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		productStoreGroupTypeId, description
	}

	public ProductStoreGroupType(GenericValue value) {
		productStoreGroupTypeId = (String) value
				.get(Fields.productStoreGroupTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductStoreGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreGroupType(value);
	}

	public static List<ProductStoreGroupType> fromValues(
			List<GenericValue> values) {
		List<ProductStoreGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreGroupType(value));
		}
		return entities;
	}
}