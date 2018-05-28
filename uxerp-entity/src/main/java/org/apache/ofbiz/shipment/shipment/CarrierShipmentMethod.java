package org.apache.ofbiz.shipment.shipment;

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
public class CarrierShipmentMethod implements Serializable {

	public static final long serialVersionUID = 1296240465420112896L;
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

	public enum Fields {
		shipmentMethodTypeId, partyId, roleTypeId, sequenceNumber, carrierServiceCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CarrierShipmentMethod(GenericValue value) {
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		sequenceNumber = (Long) value.get(Fields.sequenceNumber.name());
		carrierServiceCode = (String) value.get(Fields.carrierServiceCode
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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