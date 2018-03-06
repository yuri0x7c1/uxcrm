package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Type
 */
public class ShipmentType implements Serializable {

	public static final long serialVersionUID = 6728259479549193216L;
	public static final String NAME = "ShipmentType";
	/**
	 * Shipment Type Id
	 */
	@Getter
	@Setter
	private String shipmentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		shipmentTypeId, parentTypeId, hasTable, description
	}

	public ShipmentType(GenericValue value) {
		shipmentTypeId = (String) value.get(Fields.shipmentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ShipmentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentType(value);
	}

	public static List<ShipmentType> fromValues(List<GenericValue> values) {
		List<ShipmentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentType(value));
		}
		return entities;
	}
}