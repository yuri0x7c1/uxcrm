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
 * Order Report Sales Group By Product
 */
@FieldNameConstants
public class OrderReportSalesGroupByProduct implements Serializable {

	public static final long serialVersionUID = 266705605778281472L;
	public static final String NAME = "OrderReportSalesGroupByProduct";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Store Name
	 */
	@Getter
	@Setter
	private String storeName;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Quantity Ordered
	 */
	@Getter
	@Setter
	private BigDecimal quantityOrdered;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public OrderReportSalesGroupByProduct(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		storeName = (String) value.get(FIELD_STORE_NAME);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		orderItemStatusId = (String) value.get(FIELD_ORDER_ITEM_STATUS_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		quantityOrdered = (BigDecimal) value.get(FIELD_QUANTITY_ORDERED);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
	}

	public static OrderReportSalesGroupByProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderReportSalesGroupByProduct(value);
	}

	public static List<OrderReportSalesGroupByProduct> fromValues(
			List<GenericValue> values) {
		List<OrderReportSalesGroupByProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderReportSalesGroupByProduct(value));
		}
		return entities;
	}
}