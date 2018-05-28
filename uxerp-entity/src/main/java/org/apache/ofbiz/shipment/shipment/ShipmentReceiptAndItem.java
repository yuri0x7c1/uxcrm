package org.apache.ofbiz.shipment.shipment;

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
public class ShipmentReceiptAndItem implements Serializable {

	public static final long serialVersionUID = 8676439127278051328L;
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

	public enum Fields {
		facilityId, locationSeqId, quantityOnHandTotal, availableToPromiseTotal, unitCost, lotId, orderItemSeqId, productId, orderId, quantityAccepted, shipmentPackageSeqId, shipmentItemSeqId, quantityRejected, inventoryItemId, rejectionId, shipmentId, receivedByUserLoginId, returnId, returnItemSeqId, datetimeReceived, itemDescription, receiptId
	}

	public ShipmentReceiptAndItem(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		lotId = (String) value.get(Fields.lotId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		orderId = (String) value.get(Fields.orderId.name());
		quantityAccepted = (BigDecimal) value.get(Fields.quantityAccepted
				.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		quantityRejected = (BigDecimal) value.get(Fields.quantityRejected
				.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		rejectionId = (String) value.get(Fields.rejectionId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		receivedByUserLoginId = (String) value.get(Fields.receivedByUserLoginId
				.name());
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		datetimeReceived = (Timestamp) value
				.get(Fields.datetimeReceived.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		receiptId = (String) value.get(Fields.receiptId.name());
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