package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Gateway Config Type
 */
public class ShipmentGatewayConfigType implements Serializable {

	public static final long serialVersionUID = 8680676053640617984L;
	public static final String NAME = "ShipmentGatewayConfigType";
	/**
	 * Shipment Gateway Conf Type Id
	 */
	@Getter
	@Setter
	private String shipmentGatewayConfTypeId;
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
		shipmentGatewayConfTypeId, parentTypeId, hasTable, description
	}

	public ShipmentGatewayConfigType(GenericValue value) {
		shipmentGatewayConfTypeId = (String) value
				.get(Fields.shipmentGatewayConfTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ShipmentGatewayConfigType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentGatewayConfigType(value);
	}

	public static List<ShipmentGatewayConfigType> fromValues(
			List<GenericValue> values) {
		List<ShipmentGatewayConfigType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentGatewayConfigType(value));
		}
		return entities;
	}
}