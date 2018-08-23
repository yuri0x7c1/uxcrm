package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductFacilityLocationQuantityTest implements Serializable {

	public static final long serialVersionUID = 4684668133724352512L;
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

	public ProductFacilityLocationQuantityTest(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		minimumStock = (BigDecimal) value.get(FIELD_MINIMUM_STOCK);
		moveQuantity = (BigDecimal) value.get(FIELD_MOVE_QUANTITY);
		locationTypeEnumId = (String) value.get(FIELD_LOCATION_TYPE_ENUM_ID);
		availableToPromiseTotal = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_TOTAL);
		quantityOnHandTotal = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_TOTAL);
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