package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Carrier Shipment
 */
public class FacilityCarrierShipment implements Serializable {

	public static final long serialVersionUID = 2472911287107252224L;
	public static final String NAME = "FacilityCarrierShipment";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
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
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;

	public enum Fields {
		facilityId, partyId, roleTypeId, shipmentMethodTypeId
	}

	public FacilityCarrierShipment(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
	}

	public static FacilityCarrierShipment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityCarrierShipment(value);
	}

	public static List<FacilityCarrierShipment> fromValues(
			List<GenericValue> values) {
		List<FacilityCarrierShipment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityCarrierShipment(value));
		}
		return entities;
	}
}