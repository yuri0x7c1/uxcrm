package org.apache.ofbiz.shipment.shipment.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Carrier And Shipment Method
 */
public class CarrierAndShipmentMethod implements Serializable {

	public static final long serialVersionUID = 5086169131457208320L;
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

	public enum Fields {
		shipmentMethodTypeId, partyId, roleTypeId, sequenceNumber, description
	}

	public CarrierAndShipmentMethod(GenericValue value) {
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		sequenceNumber = (Long) value.get(Fields.sequenceNumber.name());
		description = (String) value.get(Fields.description.name());
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