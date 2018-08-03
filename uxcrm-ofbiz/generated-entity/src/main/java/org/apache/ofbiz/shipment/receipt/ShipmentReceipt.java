package org.apache.ofbiz.shipment.receipt;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Receipt
 */
public class ShipmentReceipt implements Serializable {

	public static final long serialVersionUID = 2659743430790832128L;
	public static final String NAME = "ShipmentReceipt";
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
		receiptId, inventoryItemId, productId, shipmentId, shipmentItemSeqId, shipmentPackageSeqId, orderId, orderItemSeqId, returnId, returnItemSeqId, rejectionId, receivedByUserLoginId, datetimeReceived, itemDescription, quantityAccepted, quantityRejected, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentReceipt(GenericValue value) {
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentReceipt fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentReceipt(value);
	}

	public static List<ShipmentReceipt> fromValues(List<GenericValue> values) {
		List<ShipmentReceipt> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentReceipt(value));
		}
		return entities;
	}
}