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
 * Inventory Item Status For Count
 */
@FieldNameConstants
public class InventoryItemStatusForCount implements Serializable {

	public static final long serialVersionUID = 3648973609697072128L;
	public static final String NAME = "InventoryItemStatusForCount";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Datetime
	 */
	@Getter
	@Setter
	private Timestamp statusDatetime;
	/**
	 * Status End Datetime
	 */
	@Getter
	@Setter
	private Timestamp statusEndDatetime;

	public InventoryItemStatusForCount(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		inventoryItemTypeId = (String) value.get(FIELD_INVENTORY_ITEM_TYPE_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDatetime = (Timestamp) value.get(FIELD_STATUS_DATETIME);
		statusEndDatetime = (Timestamp) value.get(FIELD_STATUS_END_DATETIME);
	}

	public static InventoryItemStatusForCount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemStatusForCount(value);
	}

	public static List<InventoryItemStatusForCount> fromValues(
			List<GenericValue> values) {
		List<InventoryItemStatusForCount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemStatusForCount(value));
		}
		return entities;
	}
}