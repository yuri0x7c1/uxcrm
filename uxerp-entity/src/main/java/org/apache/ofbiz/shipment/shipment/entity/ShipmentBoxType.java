package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Box Type
 */
public class ShipmentBoxType implements Serializable {

	public static final long serialVersionUID = 2161608375663019008L;
	public static final String NAME = "ShipmentBoxType";
	/**
	 * Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String shipmentBoxTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Dimension Uom Id
	 */
	@Getter
	@Setter
	private String dimensionUomId;
	/**
	 * Box Length
	 */
	@Getter
	@Setter
	private BigDecimal boxLength;
	/**
	 * Box Width
	 */
	@Getter
	@Setter
	private BigDecimal boxWidth;
	/**
	 * Box Height
	 */
	@Getter
	@Setter
	private BigDecimal boxHeight;
	/**
	 * Weight Uom Id
	 */
	@Getter
	@Setter
	private String weightUomId;
	/**
	 * Box Weight
	 */
	@Getter
	@Setter
	private BigDecimal boxWeight;

	public enum Fields {
		shipmentBoxTypeId, description, dimensionUomId, boxLength, boxWidth, boxHeight, weightUomId, boxWeight
	}

	public ShipmentBoxType(GenericValue value) {
		shipmentBoxTypeId = (String) value.get(Fields.shipmentBoxTypeId.name());
		description = (String) value.get(Fields.description.name());
		dimensionUomId = (String) value.get(Fields.dimensionUomId.name());
		boxLength = (BigDecimal) value.get(Fields.boxLength.name());
		boxWidth = (BigDecimal) value.get(Fields.boxWidth.name());
		boxHeight = (BigDecimal) value.get(Fields.boxHeight.name());
		weightUomId = (String) value.get(Fields.weightUomId.name());
		boxWeight = (BigDecimal) value.get(Fields.boxWeight.name());
	}

	public static ShipmentBoxType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentBoxType(value);
	}

	public static List<ShipmentBoxType> fromValues(List<GenericValue> values) {
		List<ShipmentBoxType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentBoxType(value));
		}
		return entities;
	}
}