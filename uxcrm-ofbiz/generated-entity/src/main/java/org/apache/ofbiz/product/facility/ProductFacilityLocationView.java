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
 * Product Facility Location View
 */
@FieldNameConstants
public class ProductFacilityLocationView implements Serializable {

	public static final long serialVersionUID = 4379583961111231488L;
	public static final String NAME = "ProductFacilityLocationView";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Move Quantity
	 */
	@Getter
	@Setter
	private BigDecimal moveQuantity;
	/**
	 * Minimum Stock
	 */
	@Getter
	@Setter
	private BigDecimal minimumStock;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Section Id
	 */
	@Getter
	@Setter
	private String sectionId;
	/**
	 * Aisle Id
	 */
	@Getter
	@Setter
	private String aisleId;
	/**
	 * Area Id
	 */
	@Getter
	@Setter
	private String areaId;
	/**
	 * Position Id
	 */
	@Getter
	@Setter
	private String positionId;
	/**
	 * Level Id
	 */
	@Getter
	@Setter
	private String levelId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
	/**
	 * Location Type Enum Id
	 */
	@Getter
	@Setter
	private String locationTypeEnumId;

	public ProductFacilityLocationView(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		moveQuantity = (BigDecimal) value.get(FIELD_MOVE_QUANTITY);
		minimumStock = (BigDecimal) value.get(FIELD_MINIMUM_STOCK);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		sectionId = (String) value.get(FIELD_SECTION_ID);
		aisleId = (String) value.get(FIELD_AISLE_ID);
		areaId = (String) value.get(FIELD_AREA_ID);
		positionId = (String) value.get(FIELD_POSITION_ID);
		levelId = (String) value.get(FIELD_LEVEL_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		locationTypeEnumId = (String) value.get(FIELD_LOCATION_TYPE_ENUM_ID);
	}

	public static ProductFacilityLocationView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFacilityLocationView(value);
	}

	public static List<ProductFacilityLocationView> fromValues(
			List<GenericValue> values) {
		List<ProductFacilityLocationView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFacilityLocationView(value));
		}
		return entities;
	}
}