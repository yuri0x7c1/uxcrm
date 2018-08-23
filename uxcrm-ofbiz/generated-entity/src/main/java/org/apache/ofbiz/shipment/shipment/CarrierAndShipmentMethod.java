package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Carrier And Shipment Method
 */
@FieldNameConstants
public class CarrierAndShipmentMethod implements Serializable {

	public static final long serialVersionUID = 768383696922244096L;
	public static final String NAME = "CarrierAndShipmentMethod";
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public CarrierAndShipmentMethod(GenericValue value) {
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		sequenceNumber = (Long) value.get(FIELD_SEQUENCE_NUMBER);
		description = (String) value.get(FIELD_DESCRIPTION);
	}

	public static CarrierAndShipmentMethod fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CarrierAndShipmentMethod(value);
	}

	public static List<CarrierAndShipmentMethod> fromValues(
			List<GenericValue> values) {
		List<CarrierAndShipmentMethod> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CarrierAndShipmentMethod(value));
		}
		return entities;
	}
}