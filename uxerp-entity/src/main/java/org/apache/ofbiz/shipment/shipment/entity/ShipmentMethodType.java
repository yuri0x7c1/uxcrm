package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Method Type
 */
public class ShipmentMethodType implements Serializable {

	public static final long serialVersionUID = 7637675806593404928L;
	public static final String NAME = "ShipmentMethodType";
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		shipmentMethodTypeId, description, sequenceNum
	}

	public ShipmentMethodType(GenericValue value) {
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ShipmentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentMethodType(value);
	}

	public static List<ShipmentMethodType> fromValues(List<GenericValue> values) {
		List<ShipmentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentMethodType(value));
		}
		return entities;
	}
}