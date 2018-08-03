package org.apache.ofbiz.product.inventory;

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
public class InventoryItemStatusForCount implements Serializable {

	public static final long serialVersionUID = 202585815008031744L;
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

	public enum Fields {
		facilityId, inventoryItemTypeId, inventoryItemId, productId, statusId, statusDatetime, statusEndDatetime
	}

	public InventoryItemStatusForCount(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		productId = (String) value.get(Fields.productId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDatetime = (Timestamp) value.get(Fields.statusDatetime.name());
		statusEndDatetime = (Timestamp) value.get(Fields.statusEndDatetime
				.name());
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