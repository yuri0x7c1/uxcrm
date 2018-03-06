package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Contact Mech
 */
public class ShipmentContactMech implements Serializable {

	public static final long serialVersionUID = 6034872116759020544L;
	public static final String NAME = "ShipmentContactMech";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String shipmentContactMechTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;

	public enum Fields {
		shipmentId, shipmentContactMechTypeId, contactMechId
	}

	public ShipmentContactMech(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentContactMechTypeId = (String) value
				.get(Fields.shipmentContactMechTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static ShipmentContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentContactMech(value);
	}

	public static List<ShipmentContactMech> fromValues(List<GenericValue> values) {
		List<ShipmentContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentContactMech(value));
		}
		return entities;
	}
}