package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Type
 */
public class InventoryItemType implements Serializable {

	public static final long serialVersionUID = 6283863411227066368L;
	public static final String NAME = "InventoryItemType";
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		inventoryItemTypeId, parentTypeId, hasTable, description
	}

	public InventoryItemType(GenericValue value) {
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InventoryItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemType(value);
	}

	public static List<InventoryItemType> fromValues(List<GenericValue> values) {
		List<InventoryItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemType(value));
		}
		return entities;
	}
}