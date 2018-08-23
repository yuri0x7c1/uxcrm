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
 * Shipment Contact Mech
 */
@FieldNameConstants
public class ShipmentContactMech implements Serializable {

	public static final long serialVersionUID = 820180968753251328L;
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

	public ShipmentContactMech(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentContactMechTypeId = (String) value
				.get(FIELD_SHIPMENT_CONTACT_MECH_TYPE_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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