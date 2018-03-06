package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Label Type
 */
public class InventoryItemLabelType implements Serializable {

	public static final long serialVersionUID = 2565887220331417600L;
	public static final String NAME = "InventoryItemLabelType";
	/**
	 * Inventory Item Label Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelTypeId;
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
		inventoryItemLabelTypeId, parentTypeId, hasTable, description
	}

	public InventoryItemLabelType(GenericValue value) {
		inventoryItemLabelTypeId = (String) value
				.get(Fields.inventoryItemLabelTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InventoryItemLabelType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemLabelType(value);
	}

	public static List<InventoryItemLabelType> fromValues(
			List<GenericValue> values) {
		List<InventoryItemLabelType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemLabelType(value));
		}
		return entities;
	}
}