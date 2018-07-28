package org.apache.ofbiz.product.facility;

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

	public static final long serialVersionUID = 4711087113076576256L;
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

	public enum Fields {
		facilityId, productId, moveQuantity, minimumStock, locationSeqId, sectionId, aisleId, areaId, positionId, levelId, geoPointId, locationTypeEnumId
	}

	public ProductFacilityLocationView(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		productId = (String) value.get(Fields.productId.name());
		moveQuantity = (BigDecimal) value.get(Fields.moveQuantity.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		sectionId = (String) value.get(Fields.sectionId.name());
		aisleId = (String) value.get(Fields.aisleId.name());
		areaId = (String) value.get(Fields.areaId.name());
		positionId = (String) value.get(Fields.positionId.name());
		levelId = (String) value.get(Fields.levelId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		locationTypeEnumId = (String) value.get(Fields.locationTypeEnumId
				.name());
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