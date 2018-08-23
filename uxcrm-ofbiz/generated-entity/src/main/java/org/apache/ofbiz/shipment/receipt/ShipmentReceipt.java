package org.apache.ofbiz.shipment.receipt;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ShipmentReceipt implements Serializable {

	public static final long serialVersionUID = 6954476232143128576L;
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

	public ShipmentReceipt(GenericValue value) {
		receiptId = (String) value.get(FIELD_RECEIPT_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		rejectionId = (String) value.get(FIELD_REJECTION_ID);
		receivedByUserLoginId = (String) value
				.get(FIELD_RECEIVED_BY_USER_LOGIN_ID);
		datetimeReceived = (Timestamp) value.get(FIELD_DATETIME_RECEIVED);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		quantityAccepted = (BigDecimal) value.get(FIELD_QUANTITY_ACCEPTED);
		quantityRejected = (BigDecimal) value.get(FIELD_QUANTITY_REJECTED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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