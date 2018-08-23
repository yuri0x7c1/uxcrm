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
 * Shipment Contact Mech Type
 */
@FieldNameConstants
public class ShipmentContactMechType implements Serializable {

	public static final long serialVersionUID = 7672173585868154880L;
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

	public ShipmentContactMechType(GenericValue value) {
		shipmentContactMechTypeId = (String) value
				.get(FIELD_SHIPMENT_CONTACT_MECH_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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