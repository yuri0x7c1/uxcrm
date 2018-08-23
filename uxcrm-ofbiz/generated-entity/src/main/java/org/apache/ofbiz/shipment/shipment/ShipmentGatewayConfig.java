package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ShipmentGatewayConfig implements Serializable {

	public static final long serialVersionUID = 6070141864114835456L;
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

	public ShipmentGatewayConfig(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONFIG_ID);
		shipmentGatewayConfTypeId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONF_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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