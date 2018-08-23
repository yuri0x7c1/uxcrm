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
 * Inventory Item Label Type
 */
@FieldNameConstants
public class InventoryItemLabelType implements Serializable {

	public static final long serialVersionUID = 2581917039293860864L;
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

	public InventoryItemLabelType(GenericValue value) {
		inventoryItemLabelTypeId = (String) value
				.get(FIELD_INVENTORY_ITEM_LABEL_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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