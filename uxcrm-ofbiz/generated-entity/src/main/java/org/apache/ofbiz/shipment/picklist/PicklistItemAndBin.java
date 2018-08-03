package org.apache.ofbiz.shipment.picklist;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Picklist Item And Bin
 */
public class PicklistItemAndBin implements Serializable {

	public static final long serialVersionUID = 4760341332461559808L;
	public static final String NAME = "PicklistItemAndBin";
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
	/**
	 * Primary Order Id
	 */
	@Getter
	@Setter
	private String primaryOrderId;
	/**
	 * Picklist Bin Id
	 */
	@Getter
	@Setter
	private String picklistBinId;
	/**
	 * Primary Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String primaryShipGroupSeqId;
	/**
	 * Bin Location Number
	 */
	@Getter
	@Setter
	private Long binLocationNumber;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Item Status Id
	 */
	@Getter
	@Setter
	private String itemStatusId;

	public enum Fields {
		picklistId, primaryOrderId, picklistBinId, primaryShipGroupSeqId, binLocationNumber, orderItemSeqId, inventoryItemId, quantity, orderId, shipGroupSeqId, itemStatusId
	}

	public PicklistItemAndBin(GenericValue value) {
		picklistId = (String) value.get(Fields.picklistId.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		primaryShipGroupSeqId = (String) value.get(Fields.primaryShipGroupSeqId
				.name());
		binLocationNumber = (Long) value.get(Fields.binLocationNumber.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		itemStatusId = (String) value.get(Fields.itemStatusId.name());
	}

	public static PicklistItemAndBin fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PicklistItemAndBin(value);
	}

	public static List<PicklistItemAndBin> fromValues(List<GenericValue> values) {
		List<PicklistItemAndBin> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PicklistItemAndBin(value));
		}
		return entities;
	}
}