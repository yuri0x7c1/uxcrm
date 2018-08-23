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
 * Order Report Group By Product
 */
@FieldNameConstants
public class OrderReportGroupByProduct implements Serializable {

	public static final long serialVersionUID = 4129278026845599744L;
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

	public OrderReportGroupByProduct(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		orderItemStatusId = (String) value.get(FIELD_ORDER_ITEM_STATUS_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
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