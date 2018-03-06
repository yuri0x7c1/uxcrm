package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Meter
 */
public class ProductMeter implements Serializable {

	public static final long serialVersionUID = 8400730225775108096L;
	public static final String NAME = "ProductMeter";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Meter Type Id
	 */
	@Getter
	@Setter
	private String productMeterTypeId;
	/**
	 * Meter Uom Id
	 */
	@Getter
	@Setter
	private String meterUomId;
	/**
	 * Meter Name
	 */
	@Getter
	@Setter
	private String meterName;

	public enum Fields {
		productId, productMeterTypeId, meterUomId, meterName
	}

	public ProductMeter(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		productMeterTypeId = (String) value.get(Fields.productMeterTypeId
				.name());
		meterUomId = (String) value.get(Fields.meterUomId.name());
		meterName = (String) value.get(Fields.meterName.name());
	}

	public static ProductMeter fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductMeter(value);
	}

	public static List<ProductMeter> fromValues(List<GenericValue> values) {
		List<ProductMeter> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductMeter(value));
		}
		return entities;
	}
}