package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Contact Mech Type
 */
public class ShipmentContactMechType implements Serializable {

	public static final long serialVersionUID = 1981400463099388928L;
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
		shipmentContactMechTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentContactMechType(GenericValue value) {
		shipmentContactMechTypeId = (String) value
				.get(Fields.shipmentContactMechTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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