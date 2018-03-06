package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Gateway Config
 */
public class ShipmentGatewayConfig implements Serializable {

	public static final long serialVersionUID = 7590756653853510656L;
	public static final String NAME = "ShipmentGatewayConfig";
	/**
	 * Shipment Gateway Config Id
	 */
	@Getter
	@Setter
	private String shipmentGatewayConfigId;
	/**
	 * Shipment Gateway Conf Type Id
	 */
	@Getter
	@Setter
	private String shipmentGatewayConfTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		shipmentGatewayConfigId, shipmentGatewayConfTypeId, description
	}

	public ShipmentGatewayConfig(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		shipmentGatewayConfTypeId = (String) value
				.get(Fields.shipmentGatewayConfTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ShipmentGatewayConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentGatewayConfig(value);
	}

	public static List<ShipmentGatewayConfig> fromValues(
			List<GenericValue> values) {
		List<ShipmentGatewayConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentGatewayConfig(value));
		}
		return entities;
	}
}