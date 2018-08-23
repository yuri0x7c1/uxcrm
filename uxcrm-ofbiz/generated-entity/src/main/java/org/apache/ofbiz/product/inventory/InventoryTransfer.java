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
 * Inventory Transfer
 */
@FieldNameConstants
public class InventoryTransfer implements Serializable {

	public static final long serialVersionUID = 7797490763891968000L;
	public static final String NAME = "InventoryTransfer";
	/**
	 * Inventory Transfer Id
	 */
	@Getter
	@Setter
	private String inventoryTransferId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
	/**
	 * Facility Id To
	 */
	@Getter
	@Setter
	private String facilityIdTo;
	/**
	 * Location Seq Id To
	 */
	@Getter
	@Setter
	private String locationSeqIdTo;
	/**
	 * Container Id To
	 */
	@Getter
	@Setter
	private String containerIdTo;
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
	/**
	 * Send Date
	 */
	@Getter
	@Setter
	private Timestamp sendDate;
	/**
	 * Receive Date
	 */
	@Getter
	@Setter
	private Timestamp receiveDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public InventoryTransfer(GenericValue value) {
		inventoryTransferId = (String) value.get(FIELD_INVENTORY_TRANSFER_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		containerId = (String) value.get(FIELD_CONTAINER_ID);
		facilityIdTo = (String) value.get(FIELD_FACILITY_ID_TO);
		locationSeqIdTo = (String) value.get(FIELD_LOCATION_SEQ_ID_TO);
		containerIdTo = (String) value.get(FIELD_CONTAINER_ID_TO);
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		sendDate = (Timestamp) value.get(FIELD_SEND_DATE);
		receiveDate = (Timestamp) value.get(FIELD_RECEIVE_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InventoryTransfer fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryTransfer(value);
	}

	public static List<InventoryTransfer> fromValues(List<GenericValue> values) {
		List<InventoryTransfer> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryTransfer(value));
		}
		return entities;
	}
}