package org.apache.ofbiz.shipment.receipt.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Receipt Role
 */
public class ShipmentReceiptRole implements Serializable {

	public static final long serialVersionUID = 3137769117091906560L;
	public static final String NAME = "ShipmentReceiptRole";
	/**
	 * Receipt Id
	 */
	@Getter
	@Setter
	private String receiptId;
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

	public enum Fields {
		receiptId, partyId, roleTypeId
	}

	public ShipmentReceiptRole(GenericValue value) {
		receiptId = (String) value.get(Fields.receiptId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static ShipmentReceiptRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentReceiptRole(value);
	}

	public static List<ShipmentReceiptRole> fromValues(List<GenericValue> values) {
		List<ShipmentReceiptRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentReceiptRole(value));
		}
		return entities;
	}
}