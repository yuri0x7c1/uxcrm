package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Type Attr
 */
public class ShipmentTypeAttr implements Serializable {

	public static final long serialVersionUID = 7521216541405639680L;
	public static final String NAME = "ShipmentTypeAttr";
	/**
	 * Shipment Type Id
	 */
	@Getter
	@Setter
	private String shipmentTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		shipmentTypeId, attrName, description
	}

	public ShipmentTypeAttr(GenericValue value) {
		shipmentTypeId = (String) value.get(Fields.shipmentTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ShipmentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentTypeAttr(value);
	}

	public static List<ShipmentTypeAttr> fromValues(List<GenericValue> values) {
		List<ShipmentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentTypeAttr(value));
		}
		return entities;
	}
}