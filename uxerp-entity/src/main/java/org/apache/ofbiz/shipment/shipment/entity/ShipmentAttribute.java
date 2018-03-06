package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Attribute
 */
public class ShipmentAttribute implements Serializable {

	public static final long serialVersionUID = 4727300849863012352L;
	public static final String NAME = "ShipmentAttribute";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		shipmentId, attrName, attrValue, attrDescription
	}

	public ShipmentAttribute(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static ShipmentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentAttribute(value);
	}

	public static List<ShipmentAttribute> fromValues(List<GenericValue> values) {
		List<ShipmentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentAttribute(value));
		}
		return entities;
	}
}