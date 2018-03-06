package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Label Appl
 */
public class InventoryItemLabelAppl implements Serializable {

	public static final long serialVersionUID = 3625562466557764608L;
	public static final String NAME = "InventoryItemLabelAppl";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Inventory Item Label Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelTypeId;
	/**
	 * Inventory Item Label Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		inventoryItemId, inventoryItemLabelTypeId, inventoryItemLabelId, sequenceNum
	}

	public InventoryItemLabelAppl(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		inventoryItemLabelTypeId = (String) value
				.get(Fields.inventoryItemLabelTypeId.name());
		inventoryItemLabelId = (String) value.get(Fields.inventoryItemLabelId
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static InventoryItemLabelAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemLabelAppl(value);
	}

	public static List<InventoryItemLabelAppl> fromValues(
			List<GenericValue> values) {
		List<InventoryItemLabelAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemLabelAppl(value));
		}
		return entities;
	}
}