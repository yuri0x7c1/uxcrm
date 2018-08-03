package org.apache.ofbiz.product.inventory;

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
public class InventoryItemStatus implements Serializable {

	public static final long serialVersionUID = 5772499217563671552L;
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

	public enum Fields {
		inventoryItemId, statusId, statusDatetime, statusEndDatetime, changeByUserLoginId, ownerPartyId, productId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InventoryItemStatus(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDatetime = (Timestamp) value.get(Fields.statusDatetime.name());
		statusEndDatetime = (Timestamp) value.get(Fields.statusEndDatetime
				.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		productId = (String) value.get(Fields.productId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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