package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Quantity Report Group By Item
 */
public class OrderItemQuantityReportGroupByItem implements Serializable {

	public static final long serialVersionUID = 5276851053578416128L;
	public static final String NAME = "OrderItemQuantityReportGroupByItem";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Order Status Id
	 */
	@Getter
	@Setter
	private String orderStatusId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Order Item Status Id
	 */
	@Getter
	@Setter
	private String orderItemStatusId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Ship Before Date
	 */
	@Getter
	@Setter
	private Timestamp shipBeforeDate;
	/**
	 * Ship After Date
	 */
	@Getter
	@Setter
	private Timestamp shipAfterDate;
	/**
	 * Quantity Ordered
	 */
	@Getter
	@Setter
	private BigDecimal quantityOrdered;
	/**
	 * Quantity Issued
	 */
	@Getter
	@Setter
	private BigDecimal quantityIssued;
	/**
	 * Quantity Open
	 */
	@Getter
	@Setter
	private BigDecimal quantityOpen;

	public enum Fields {
		productStoreId, orderId, orderTypeId, orderStatusId, orderDate, orderItemSeqId, orderItemStatusId, productId, itemDescription, shipBeforeDate, shipAfterDate, quantityOrdered, quantityIssued, quantityOpen
	}

	public OrderItemQuantityReportGroupByItem(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		orderItemStatusId = (String) value.get(Fields.orderItemStatusId.name());
		productId = (String) value.get(Fields.productId.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		shipBeforeDate = (Timestamp) value.get(Fields.shipBeforeDate.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		quantityOrdered = (BigDecimal) value.get(Fields.quantityOrdered.name());
		quantityIssued = (BigDecimal) value.get(Fields.quantityIssued.name());
		quantityOpen = (BigDecimal) value.get(Fields.quantityOpen.name());
	}

	public static OrderItemQuantityReportGroupByItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemQuantityReportGroupByItem(value);
	}

	public static List<OrderItemQuantityReportGroupByItem> fromValues(
			List<GenericValue> values) {
		List<OrderItemQuantityReportGroupByItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemQuantityReportGroupByItem(value));
		}
		return entities;
	}
}