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
 * Inventory Item Status
 */
@FieldNameConstants
public class InventoryItemStatus implements Serializable {

	public static final long serialVersionUID = 7467540604964314112L;
	public static final String NAME = "InventoryItemStatus";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
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
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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

	public InventoryItemStatus(GenericValue value) {
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDatetime = (Timestamp) value.get(FIELD_STATUS_DATETIME);
		statusEndDatetime = (Timestamp) value.get(FIELD_STATUS_END_DATETIME);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InventoryItemStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemStatus(value);
	}

	public static List<InventoryItemStatus> fromValues(List<GenericValue> values) {
		List<InventoryItemStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemStatus(value));
		}
		return entities;
	}
}