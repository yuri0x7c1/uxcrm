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
 * Order Item Quantity Report Group By Product
 */
@FieldNameConstants
public class OrderItemQuantityReportGroupByProduct implements Serializable {

	public static final long serialVersionUID = 2289289339396855808L;
	public static final String NAME = "OrderItemQuantityReportGroupByProduct";
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

	public OrderItemQuantityReportGroupByProduct(GenericValue value) {
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		orderItemStatusId = (String) value.get(FIELD_ORDER_ITEM_STATUS_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantityOrdered = (BigDecimal) value.get(FIELD_QUANTITY_ORDERED);
		quantityIssued = (BigDecimal) value.get(FIELD_QUANTITY_ISSUED);
		quantityOpen = (BigDecimal) value.get(FIELD_QUANTITY_OPEN);
	}

	public static OrderItemQuantityReportGroupByProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemQuantityReportGroupByProduct(value);
	}

	public static List<OrderItemQuantityReportGroupByProduct> fromValues(
			List<GenericValue> values) {
		List<OrderItemQuantityReportGroupByProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemQuantityReportGroupByProduct(value));
		}
		return entities;
	}
}