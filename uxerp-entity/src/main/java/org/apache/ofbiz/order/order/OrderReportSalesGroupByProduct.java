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
 * Order Report Sales Group By Product
 */
public class OrderReportSalesGroupByProduct implements Serializable {

	public static final long serialVersionUID = 6106543719638532096L;
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

	public enum Fields {
		productStoreId, storeName, productId, internalName, orderDate, orderStatusId, orderItemStatusId, orderTypeId, partyId, roleTypeId, quantityOrdered, amount
	}

	public OrderReportSalesGroupByProduct(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		storeName = (String) value.get(Fields.storeName.name());
		productId = (String) value.get(Fields.productId.name());
		internalName = (String) value.get(Fields.internalName.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		orderItemStatusId = (String) value.get(Fields.orderItemStatusId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		quantityOrdered = (BigDecimal) value.get(Fields.quantityOrdered.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
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