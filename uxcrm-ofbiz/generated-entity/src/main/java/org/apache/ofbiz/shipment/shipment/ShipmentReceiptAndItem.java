package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Receipt And Item
 */
@FieldNameConstants
public class ShipmentReceiptAndItem implements Serializable {

	public static final long serialVersionUID = 3989297161752187904L;
	public static final String NAME = "ShipmentReceiptAndItem";
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
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Lot Id
	 */
	@Getter
	@Setter
	private String lotId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Quantity Accepted
	 */
	@Getter
	@Setter
	private BigDecimal quantityAccepted;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Quantity Rejected
	 */
	@Getter
	@Setter
	private BigDecimal quantityRejected;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Rejection Id
	 */
	@Getter
	@Setter
	private String rejectionId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Received By User Login Id
	 */
	@Getter
	@Setter
	private String receivedByUserLoginId;
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Return Item Seq Id
	 */
	@Getter
	@Setter
	private String returnItemSeqId;
	/**
	 * Datetime Received
	 */
	@Getter
	@Setter
	private Timestamp datetimeReceived;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Receipt Id
	 */
	@Getter
	@Setter
	private String receiptId;

	public ShipmentReceiptAndItem(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		quantityOnHandTotal = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_TOTAL);
		availableToPromiseTotal = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_TOTAL);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		lotId = (String) value.get(FIELD_LOT_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		quantityAccepted = (BigDecimal) value.get(FIELD_QUANTITY_ACCEPTED);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		quantityRejected = (BigDecimal) value.get(FIELD_QUANTITY_REJECTED);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		rejectionId = (String) value.get(FIELD_REJECTION_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		receivedByUserLoginId = (String) value
				.get(FIELD_RECEIVED_BY_USER_LOGIN_ID);
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		datetimeReceived = (Timestamp) value.get(FIELD_DATETIME_RECEIVED);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		receiptId = (String) value.get(FIELD_RECEIPT_ID);
	}

	public static ShipmentReceiptAndItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentReceiptAndItem(value);
	}

	public static List<ShipmentReceiptAndItem> fromValues(
			List<GenericValue> values) {
		List<ShipmentReceiptAndItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentReceiptAndItem(value));
		}
		return entities;
	}
}