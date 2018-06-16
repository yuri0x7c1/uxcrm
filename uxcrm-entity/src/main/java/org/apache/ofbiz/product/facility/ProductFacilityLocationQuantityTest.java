package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Facility Location Quantity Test
 */
public class ProductFacilityLocationQuantityTest implements Serializable {

	public static final long serialVersionUID = 6462713550989320192L;
	public static final String NAME = "ProductFacilityLocationQuantityTest";
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
	/**
	 * Location Type Enum Id
	 */
	@Getter
	@Setter
	private String locationTypeEnumId;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;

	public enum Fields {
		productId, facilityId, locationSeqId, minimumStock, moveQuantity, locationTypeEnumId, availableToPromiseTotal, quantityOnHandTotal
	}

	public ProductFacilityLocationQuantityTest(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		moveQuantity = (BigDecimal) value.get(Fields.moveQuantity.name());
		locationTypeEnumId = (String) value.get(Fields.locationTypeEnumId
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
	}

	public static ProductFacilityLocationQuantityTest fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFacilityLocationQuantityTest(value);
	}

	public static List<ProductFacilityLocationQuantityTest> fromValues(
			List<GenericValue> values) {
		List<ProductFacilityLocationQuantityTest> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFacilityLocationQuantityTest(value));
		}
		return entities;
	}
}