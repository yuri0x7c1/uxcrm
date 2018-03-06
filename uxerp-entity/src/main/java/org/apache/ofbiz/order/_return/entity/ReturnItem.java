package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item
 */
public class ReturnItem implements Serializable {

	public static final long serialVersionUID = 2656841893852466176L;
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

	public enum Fields {
		returnId, returnItemSeqId, returnReasonId, returnTypeId, returnItemTypeId, productId, description, orderId, orderItemSeqId, statusId, expectedItemStatus, returnQuantity, receivedQuantity, returnPrice, returnItemResponseId
	}

	public ReturnItem(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		returnReasonId = (String) value.get(Fields.returnReasonId.name());
		returnTypeId = (String) value.get(Fields.returnTypeId.name());
		returnItemTypeId = (String) value.get(Fields.returnItemTypeId.name());
		productId = (String) value.get(Fields.productId.name());
		description = (String) value.get(Fields.description.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		statusId = (String) value.get(Fields.statusId.name());
		expectedItemStatus = (String) value.get(Fields.expectedItemStatus
				.name());
		returnQuantity = (BigDecimal) value.get(Fields.returnQuantity.name());
		receivedQuantity = (BigDecimal) value.get(Fields.receivedQuantity
				.name());
		returnPrice = (BigDecimal) value.get(Fields.returnPrice.name());
		returnItemResponseId = (String) value.get(Fields.returnItemResponseId
				.name());
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