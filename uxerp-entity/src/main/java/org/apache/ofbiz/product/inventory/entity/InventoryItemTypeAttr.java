package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Type Attr
 */
public class InventoryItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 5697662595294761984L;
	public static final String NAME = "InventoryItemTypeAttr";
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
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
		inventoryItemTypeId, attrName, description
	}

	public InventoryItemTypeAttr(GenericValue value) {
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InventoryItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemTypeAttr(value);
	}

	public static List<InventoryItemTypeAttr> fromValues(
			List<GenericValue> values) {
		List<InventoryItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemTypeAttr(value));
		}
		return entities;
	}
}