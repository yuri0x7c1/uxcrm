package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Facility Location
 */
public class ProductFacilityLocation implements Serializable {

	public static final long serialVersionUID = 3716925313511043072L;
	public static final String NAME = "ProductFacilityLocation";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Minimum Stock
	 */
	@Getter
	@Setter
	private BigDecimal minimumStock;
	/**
	 * Move Quantity
	 */
	@Getter
	@Setter
	private BigDecimal moveQuantity;

	public enum Fields {
		productId, facilityId, locationSeqId, minimumStock, moveQuantity
	}

	public ProductFacilityLocation(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		moveQuantity = (BigDecimal) value.get(Fields.moveQuantity.name());
	}

	public static ProductFacilityLocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFacilityLocation(value);
	}

	public static List<ProductFacilityLocation> fromValues(
			List<GenericValue> values) {
		List<ProductFacilityLocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFacilityLocation(value));
		}
		return entities;
	}
}