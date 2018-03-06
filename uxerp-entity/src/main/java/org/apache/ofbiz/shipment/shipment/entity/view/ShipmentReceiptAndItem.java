package org.apache.ofbiz.shipment.shipment.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Receipt And Item
 */
public class ShipmentReceiptAndItem implements Serializable {

	public static final long serialVersionUID = 5400608888632747008L;
	public static final String NAME = "ShipmentReceiptAndItem";
	/**
	 * Receipt Id
	 */
	@Getter
	@Setter
	private String receiptId;
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
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
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
	 * Rejection Id
	 */
	@Getter
	@Setter
	private String rejectionId;
	/**
	 * Received By User Login Id
	 */
	@Getter
	@Setter
	private String receivedByUserLoginId;
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
	 * Quantity Accepted
	 */
	@Getter
	@Setter
	private BigDecimal quantityAccepted;
	/**
	 * Quantity Rejected
	 */
	@Getter
	@Setter
	private BigDecimal quantityRejected;
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

	public enum Fields {
		receiptId, inventoryItemId, productId, shipmentId, shipmentItemSeqId, shipmentPackageSeqId, orderId, orderItemSeqId, returnId, returnItemSeqId, rejectionId, receivedByUserLoginId, datetimeReceived, itemDescription, quantityAccepted, quantityRejected, facilityId, locationSeqId, quantityOnHandTotal, availableToPromiseTotal, unitCost, lotId
	}

	public ShipmentReceiptAndItem(GenericValue value) {
		receiptId = (String) value.get(Fields.receiptId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		productId = (String) value.get(Fields.productId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		rejectionId = (String) value.get(Fields.rejectionId.name());
		receivedByUserLoginId = (String) value.get(Fields.receivedByUserLoginId
				.name());
		datetimeReceived = (Timestamp) value
				.get(Fields.datetimeReceived.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		quantityAccepted = (BigDecimal) value.get(Fields.quantityAccepted
				.name());
		quantityRejected = (BigDecimal) value.get(Fields.quantityRejected
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		lotId = (String) value.get(Fields.lotId.name());
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