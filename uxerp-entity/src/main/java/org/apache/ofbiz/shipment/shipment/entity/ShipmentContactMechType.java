package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Contact Mech Type
 */
public class ShipmentContactMechType implements Serializable {

	public static final long serialVersionUID = 4913305969576942592L;
	public static final String NAME = "ShipmentContactMechType";
	/**
	 * Shipment Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String shipmentContactMechTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		shipmentContactMechTypeId, description
	}

	public ShipmentContactMechType(GenericValue value) {
		shipmentContactMechTypeId = (String) value
				.get(Fields.shipmentContactMechTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ShipmentContactMechType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentContactMechType(value);
	}

	public static List<ShipmentContactMechType> fromValues(
			List<GenericValue> values) {
		List<ShipmentContactMechType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentContactMechType(value));
		}
		return entities;
	}
}