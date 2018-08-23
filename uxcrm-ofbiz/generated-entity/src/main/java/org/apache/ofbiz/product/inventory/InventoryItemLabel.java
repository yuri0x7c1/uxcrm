package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Label
 */
@FieldNameConstants
public class InventoryItemLabel implements Serializable {

	public static final long serialVersionUID = 5530170083426199552L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public InventoryItemLabel(GenericValue value) {
		inventoryItemLabelId = (String) value
				.get(FIELD_INVENTORY_ITEM_LABEL_ID);
		inventoryItemLabelTypeId = (String) value
				.get(FIELD_INVENTORY_ITEM_LABEL_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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