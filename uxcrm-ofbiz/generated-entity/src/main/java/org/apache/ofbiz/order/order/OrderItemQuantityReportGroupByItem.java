package org.apache.ofbiz.order.order;

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
 * Order Item Quantity Report Group By Item
 */
@FieldNameConstants
public class OrderItemQuantityReportGroupByItem implements Serializable {

	public static final long serialVersionUID = 688664345285432320L;
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

	public OrderItemQuantityReportGroupByItem(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		orderItemStatusId = (String) value.get(FIELD_ORDER_ITEM_STATUS_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		shipBeforeDate = (Timestamp) value.get(FIELD_SHIP_BEFORE_DATE);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		quantityOrdered = (BigDecimal) value.get(FIELD_QUANTITY_ORDERED);
		quantityIssued = (BigDecimal) value.get(FIELD_QUANTITY_ISSUED);
		quantityOpen = (BigDecimal) value.get(FIELD_QUANTITY_OPEN);
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