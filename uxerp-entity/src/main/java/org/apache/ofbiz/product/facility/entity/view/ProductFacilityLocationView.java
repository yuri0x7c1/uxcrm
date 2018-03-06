package org.apache.ofbiz.product.facility.entity.view;

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
public class ProductFacilityLocationView implements Serializable {

	public static final long serialVersionUID = 1354074478776151040L;
	public static final String NAME = "ProductFacilityLocationView";
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
	 * Area Id
	 */
	@Getter
	@Setter
	private String areaId;
	/**
	 * Aisle Id
	 */
	@Getter
	@Setter
	private String aisleId;
	/**
	 * Section Id
	 */
	@Getter
	@Setter
	private String sectionId;
	/**
	 * Level Id
	 */
	@Getter
	@Setter
	private String levelId;
	/**
	 * Position Id
	 */
	@Getter
	@Setter
	private String positionId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;

	public enum Fields {
		productId, facilityId, locationSeqId, minimumStock, moveQuantity, locationTypeEnumId, areaId, aisleId, sectionId, levelId, positionId, geoPointId
	}

	public ProductFacilityLocationView(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		moveQuantity = (BigDecimal) value.get(Fields.moveQuantity.name());
		locationTypeEnumId = (String) value.get(Fields.locationTypeEnumId
				.name());
		areaId = (String) value.get(Fields.areaId.name());
		aisleId = (String) value.get(Fields.aisleId.name());
		sectionId = (String) value.get(Fields.sectionId.name());
		levelId = (String) value.get(Fields.levelId.name());
		positionId = (String) value.get(Fields.positionId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
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