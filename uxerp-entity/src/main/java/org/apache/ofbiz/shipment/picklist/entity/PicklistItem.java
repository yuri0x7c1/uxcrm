package org.apache.ofbiz.shipment.picklist.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Picklist Item
 */
public class PicklistItem implements Serializable {

	public static final long serialVersionUID = 1062765189580984320L;
	public static final String NAME = "PicklistItem";
	/**
	 * Picklist Bin Id
	 */
	@Getter
	@Setter
	private String picklistBinId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Item Status Id
	 */
	@Getter
	@Setter
	private String itemStatusId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;

	public enum Fields {
		picklistBinId, orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId, itemStatusId, quantity
	}

	public PicklistItem(GenericValue value) {
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		itemStatusId = (String) value.get(Fields.itemStatusId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
	}

	public static PicklistItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PicklistItem(value);
	}

	public static List<PicklistItem> fromValues(List<GenericValue> values) {
		List<PicklistItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PicklistItem(value));
		}
		return entities;
	}
}