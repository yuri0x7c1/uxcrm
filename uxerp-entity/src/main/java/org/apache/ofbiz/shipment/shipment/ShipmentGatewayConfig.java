package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Gateway Config
 */
public class ShipmentGatewayConfig implements Serializable {

	public static final long serialVersionUID = 6281138910513145856L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		shipmentGatewayConfigId, shipmentGatewayConfTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentGatewayConfig(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		shipmentGatewayConfTypeId = (String) value
				.get(Fields.shipmentGatewayConfTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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