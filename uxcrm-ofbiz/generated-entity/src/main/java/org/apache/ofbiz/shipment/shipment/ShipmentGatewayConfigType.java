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
 * Shipment Gateway Config Type
 */
@FieldNameConstants
public class ShipmentGatewayConfigType implements Serializable {

	public static final long serialVersionUID = 5793078744967706624L;
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

	public ShipmentGatewayConfigType(GenericValue value) {
		shipmentGatewayConfTypeId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONF_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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