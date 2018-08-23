package org.apache.ofbiz.order._return;

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
 * Return Item
 */
@FieldNameConstants
public class ReturnItem implements Serializable {

	public static final long serialVersionUID = 7899916811948569600L;
	public static final String NAME = "ReturnItem";
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
	 * Return Reason Id
	 */
	@Getter
	@Setter
	private String returnReasonId;
	/**
	 * Return Type Id
	 */
	@Getter
	@Setter
	private String returnTypeId;
	/**
	 * Return Item Type Id
	 */
	@Getter
	@Setter
	private String returnItemTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Expected Item Status
	 */
	@Getter
	@Setter
	private String expectedItemStatus;
	/**
	 * Return Quantity
	 */
	@Getter
	@Setter
	private BigDecimal returnQuantity;
	/**
	 * Received Quantity
	 */
	@Getter
	@Setter
	private BigDecimal receivedQuantity;
	/**
	 * Return Price
	 */
	@Getter
	@Setter
	private BigDecimal returnPrice;
	/**
	 * Return Item Response Id
	 */
	@Getter
	@Setter
	private String returnItemResponseId;
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

	public ReturnItem(GenericValue value) {
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		returnReasonId = (String) value.get(FIELD_RETURN_REASON_ID);
		returnTypeId = (String) value.get(FIELD_RETURN_TYPE_ID);
		returnItemTypeId = (String) value.get(FIELD_RETURN_ITEM_TYPE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		expectedItemStatus = (String) value.get(FIELD_EXPECTED_ITEM_STATUS);
		returnQuantity = (BigDecimal) value.get(FIELD_RETURN_QUANTITY);
		receivedQuantity = (BigDecimal) value.get(FIELD_RECEIVED_QUANTITY);
		returnPrice = (BigDecimal) value.get(FIELD_RETURN_PRICE);
		returnItemResponseId = (String) value
				.get(FIELD_RETURN_ITEM_RESPONSE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItem(value);
	}

	public static List<ReturnItem> fromValues(List<GenericValue> values) {
		List<ReturnItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItem(value));
		}
		return entities;
	}
}