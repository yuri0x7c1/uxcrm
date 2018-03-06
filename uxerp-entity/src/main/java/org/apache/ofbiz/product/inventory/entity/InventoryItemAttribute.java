package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Attribute
 */
public class InventoryItemAttribute implements Serializable {

	public static final long serialVersionUID = 5354426054490374144L;
	public static final String NAME = "InventoryItemAttribute";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
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
		inventoryItemId, attrName, attrValue, attrDescription
	}

	public InventoryItemAttribute(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static InventoryItemAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemAttribute(value);
	}

	public static List<InventoryItemAttribute> fromValues(
			List<GenericValue> values) {
		List<InventoryItemAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemAttribute(value));
		}
		return entities;
	}
}