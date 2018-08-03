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
 * Order Report Group By Product
 */
public class OrderReportGroupByProduct implements Serializable {

	public static final long serialVersionUID = 8190019824455536640L;
	public static final String NAME = "OrderReportGroupByProduct";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Order Status Id
	 */
	@Getter
	@Setter
	private String orderStatusId;
	/**
	 * Order Item Status Id
	 */
	@Getter
	@Setter
	private String orderItemStatusId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;

	public enum Fields {
		productId, orderDate, orderStatusId, orderItemStatusId, orderTypeId, quantity, unitPrice
	}

	public OrderReportGroupByProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		orderItemStatusId = (String) value.get(Fields.orderItemStatusId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
	}

	public static OrderReportGroupByProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderReportGroupByProduct(value);
	}

	public static List<OrderReportGroupByProduct> fromValues(
			List<GenericValue> values) {
		List<OrderReportGroupByProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderReportGroupByProduct(value));
		}
		return entities;
	}
}