package org.apache.ofbiz.shipment.picklist;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PicklistItemAndBin implements Serializable {

	public static final long serialVersionUID = 6789406290537491456L;
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

	public PicklistItemAndBin(GenericValue value) {
		picklistId = (String) value.get(FIELD_PICKLIST_ID);
		primaryOrderId = (String) value.get(FIELD_PRIMARY_ORDER_ID);
		picklistBinId = (String) value.get(FIELD_PICKLIST_BIN_ID);
		primaryShipGroupSeqId = (String) value
				.get(FIELD_PRIMARY_SHIP_GROUP_SEQ_ID);
		binLocationNumber = (Long) value.get(FIELD_BIN_LOCATION_NUMBER);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		orderId = (String) value.get(FIELD_ORDER_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		itemStatusId = (String) value.get(FIELD_ITEM_STATUS_ID);
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