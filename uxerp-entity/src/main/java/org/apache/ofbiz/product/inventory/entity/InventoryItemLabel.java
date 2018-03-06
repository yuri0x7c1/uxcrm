package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Label
 */
public class InventoryItemLabel implements Serializable {

	public static final long serialVersionUID = 8726349087634483200L;
	public static final String NAME = "InventoryItemLabel";
	/**
	 * Inventory Item Label Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelId;
	/**
	 * Inventory Item Label Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		inventoryItemLabelId, inventoryItemLabelTypeId, description
	}

	public InventoryItemLabel(GenericValue value) {
		inventoryItemLabelId = (String) value.get(Fields.inventoryItemLabelId
				.name());
		inventoryItemLabelTypeId = (String) value
				.get(Fields.inventoryItemLabelTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InventoryItemLabel fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemLabel(value);
	}

	public static List<InventoryItemLabel> fromValues(List<GenericValue> values) {
		List<InventoryItemLabel> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemLabel(value));
		}
		return entities;
	}
}