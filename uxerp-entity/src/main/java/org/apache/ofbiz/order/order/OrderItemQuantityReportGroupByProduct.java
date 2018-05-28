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
 * Order Item Quantity Report Group By Product
 */
public class OrderItemQuantityReportGroupByProduct implements Serializable {

	public static final long serialVersionUID = 6124929463479709696L;
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

	public enum Fields {
		orderTypeId, orderStatusId, orderDate, orderItemStatusId, productId, quantityOrdered, quantityIssued, quantityOpen
	}

	public OrderItemQuantityReportGroupByProduct(GenericValue value) {
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		orderItemStatusId = (String) value.get(Fields.orderItemStatusId.name());
		productId = (String) value.get(Fields.productId.name());
		quantityOrdered = (BigDecimal) value.get(Fields.quantityOrdered.name());
		quantityIssued = (BigDecimal) value.get(Fields.quantityIssued.name());
		quantityOpen = (BigDecimal) value.get(Fields.quantityOpen.name());
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