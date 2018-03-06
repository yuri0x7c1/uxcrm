package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Carrier Shipment Box Type
 */
public class CarrierShipmentBoxType implements Serializable {

	public static final long serialVersionUID = 3536373614465072128L;
	public static final String NAME = "CarrierShipmentBoxType";
	/**
	 * Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String shipmentBoxTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Packaging Type Code
	 */
	@Getter
	@Setter
	private String packagingTypeCode;
	/**
	 * Oversize Code
	 */
	@Getter
	@Setter
	private String oversizeCode;

	public enum Fields {
		shipmentBoxTypeId, partyId, packagingTypeCode, oversizeCode
	}

	public CarrierShipmentBoxType(GenericValue value) {
		shipmentBoxTypeId = (String) value.get(Fields.shipmentBoxTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		packagingTypeCode = (String) value.get(Fields.packagingTypeCode.name());
		oversizeCode = (String) value.get(Fields.oversizeCode.name());
	}

	public static CarrierShipmentBoxType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CarrierShipmentBoxType(value);
	}

	public static List<CarrierShipmentBoxType> fromValues(
			List<GenericValue> values) {
		List<CarrierShipmentBoxType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CarrierShipmentBoxType(value));
		}
		return entities;
	}
}