package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Meter Type
 */
public class ProductMeterType implements Serializable {

	public static final long serialVersionUID = 2525399081371615232L;
	public static final String NAME = "ProductMeterType";
	/**
	 * Product Meter Type Id
	 */
	@Getter
	@Setter
	private String productMeterTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Uom Id
	 */
	@Getter
	@Setter
	private String defaultUomId;

	public enum Fields {
		productMeterTypeId, description, defaultUomId
	}

	public ProductMeterType(GenericValue value) {
		productMeterTypeId = (String) value.get(Fields.productMeterTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		defaultUomId = (String) value.get(Fields.defaultUomId.name());
	}

	public static ProductMeterType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMeterType(value);
	}

	public static List<ProductMeterType> fromValues(List<GenericValue> values) {
		List<ProductMeterType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMeterType(value));
		}
		return entities;
	}
}