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
 * Order Report Purchases Group By Product
 */
public class OrderReportPurchasesGroupByProduct implements Serializable {

	public static final long serialVersionUID = 873232050868332544L;
	public static final String NAME = "OrderReportPurchasesGroupByProduct";
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
	 * To Party Id
	 */
	@Getter
	@Setter
	private String toPartyId;
	/**
	 * To Role Type Id
	 */
	@Getter
	@Setter
	private String toRoleTypeId;
	/**
	 * From Party Id
	 */
	@Getter
	@Setter
	private String fromPartyId;
	/**
	 * From Role Type Id
	 */
	@Getter
	@Setter
	private String fromRoleTypeId;
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
		productId, internalName, orderDate, orderStatusId, orderItemStatusId, orderTypeId, toPartyId, toRoleTypeId, fromPartyId, fromRoleTypeId, quantity, unitPrice
	}

	public OrderReportPurchasesGroupByProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		internalName = (String) value.get(Fields.internalName.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		orderItemStatusId = (String) value.get(Fields.orderItemStatusId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		toPartyId = (String) value.get(Fields.toPartyId.name());
		toRoleTypeId = (String) value.get(Fields.toRoleTypeId.name());
		fromPartyId = (String) value.get(Fields.fromPartyId.name());
		fromRoleTypeId = (String) value.get(Fields.fromRoleTypeId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
	}

	public static OrderReportPurchasesGroupByProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderReportPurchasesGroupByProduct(value);
	}

	public static List<OrderReportPurchasesGroupByProduct> fromValues(
			List<GenericValue> values) {
		List<OrderReportPurchasesGroupByProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderReportPurchasesGroupByProduct(value));
		}
		return entities;
	}
}