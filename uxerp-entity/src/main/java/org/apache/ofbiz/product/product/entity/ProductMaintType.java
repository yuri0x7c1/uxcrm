package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Maint Type
 */
public class ProductMaintType implements Serializable {

	public static final long serialVersionUID = 2673547062378313728L;
	public static final String NAME = "ProductMaintType";
	/**
	 * Product Maint Type Id
	 */
	@Getter
	@Setter
	private String productMaintTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;

	public enum Fields {
		productMaintTypeId, description, parentTypeId
	}

	public ProductMaintType(GenericValue value) {
		productMaintTypeId = (String) value.get(Fields.productMaintTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
	}

	public static ProductMaintType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMaintType(value);
	}

	public static List<ProductMaintType> fromValues(List<GenericValue> values) {
		List<ProductMaintType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMaintType(value));
		}
		return entities;
	}
}