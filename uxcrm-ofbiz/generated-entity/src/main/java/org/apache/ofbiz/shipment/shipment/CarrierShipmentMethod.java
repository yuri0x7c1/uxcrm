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
 * Carrier Shipment Method
 */
@FieldNameConstants
public class CarrierShipmentMethod implements Serializable {

	public static final long serialVersionUID = 7166151386345147392L;
	public static final String NAME = "CarrierShipmentMethod";
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Sequence Number
	 */
	@Getter
	@Setter
	private Long sequenceNumber;
	/**
	 * Carrier Service Code
	 */
	@Getter
	@Setter
	private String carrierServiceCode;
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

	public CarrierShipmentMethod(GenericValue value) {
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		sequenceNumber = (Long) value.get(FIELD_SEQUENCE_NUMBER);
		carrierServiceCode = (String) value.get(FIELD_CARRIER_SERVICE_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CarrierShipmentMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CarrierShipmentMethod(value);
	}

	public static List<CarrierShipmentMethod> fromValues(
			List<GenericValue> values) {
		List<CarrierShipmentMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CarrierShipmentMethod(value));
		}
		return entities;
	}
}