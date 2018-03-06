package org.apache.ofbiz.shipment.picklist.entity.view;

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

	public static final long serialVersionUID = 1018390777442026496L;
	public static final String NAME = "PicklistItemAndBin";
	/**
	 * Picklist Bin Id
	 */
	@Getter
	@Setter
	private String picklistBinId;
	/**
	 * Picklist Id
	 */
	@Getter
	@Setter
	private String picklistId;
	/**
	 * Bin Location Number
	 */
	@Getter
	@Setter
	private Long binLocationNumber;
	/**
	 * Primary Order Id
	 */
	@Getter
	@Setter
	private String primaryOrderId;
	/**
	 * Primary Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String primaryShipGroupSeqId;
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
		picklistBinId, picklistId, binLocationNumber, primaryOrderId, primaryShipGroupSeqId, orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId, itemStatusId, quantity
	}

	public PicklistItemAndBin(GenericValue value) {
		picklistBinId = (String) value.get(Fields.picklistBinId.name());
		picklistId = (String) value.get(Fields.picklistId.name());
		binLocationNumber = (Long) value.get(Fields.binLocationNumber.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		primaryShipGroupSeqId = (String) value.get(Fields.primaryShipGroupSeqId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		itemStatusId = (String) value.get(Fields.itemStatusId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
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