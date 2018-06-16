package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Contact Mech
 */
public class ShipmentContactMech implements Serializable {

	public static final long serialVersionUID = 6455950565244655616L;
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
		shipmentId, shipmentContactMechTypeId, contactMechId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentContactMech(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentContactMechTypeId = (String) value
				.get(Fields.shipmentContactMechTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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