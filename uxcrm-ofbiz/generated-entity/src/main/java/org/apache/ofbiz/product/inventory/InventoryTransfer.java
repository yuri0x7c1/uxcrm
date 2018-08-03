package org.apache.ofbiz.product.inventory;

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
public class InventoryTransfer implements Serializable {

	public static final long serialVersionUID = 8352189650224771072L;
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

	public enum Fields {
		inventoryTransferId, statusId, inventoryItemId, facilityId, locationSeqId, containerId, facilityIdTo, locationSeqIdTo, containerIdTo, itemIssuanceId, sendDate, receiveDate, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InventoryTransfer(GenericValue value) {
		inventoryTransferId = (String) value.get(Fields.inventoryTransferId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		containerId = (String) value.get(Fields.containerId.name());
		facilityIdTo = (String) value.get(Fields.facilityIdTo.name());
		locationSeqIdTo = (String) value.get(Fields.locationSeqIdTo.name());
		containerIdTo = (String) value.get(Fields.containerIdTo.name());
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		sendDate = (Timestamp) value.get(Fields.sendDate.name());
		receiveDate = (Timestamp) value.get(Fields.receiveDate.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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