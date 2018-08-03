package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Purchase Product Summary
 */
public class OrderPurchaseProductSummary implements Serializable {

	public static final long serialVersionUID = 355326051507832832L;
	public static final String NAME = "OrderPurchaseProductSummary";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Terminal Id
	 */
	@Getter
	@Setter
	private String terminalId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
	/**
	 * Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;
	/**
	 * Unit List Price
	 */
	@Getter
	@Setter
	private BigDecimal unitListPrice;
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
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Item Status Id
	 */
	@Getter
	@Setter
	private String itemStatusId;

	public enum Fields {
		webSiteId, productStoreId, originFacilityId, terminalId, statusId, productId, internalName, quantity, cancelQuantity, unitPrice, unitListPrice, orderId, orderTypeId, orderDate, itemStatusId
	}

	public OrderPurchaseProductSummary(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		terminalId = (String) value.get(Fields.terminalId.name());
		statusId = (String) value.get(Fields.statusId.name());
		productId = (String) value.get(Fields.productId.name());
		internalName = (String) value.get(Fields.internalName.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
		unitListPrice = (BigDecimal) value.get(Fields.unitListPrice.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		itemStatusId = (String) value.get(Fields.itemStatusId.name());
	}

	public static OrderPurchaseProductSummary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderPurchaseProductSummary(value);
	}

	public static List<OrderPurchaseProductSummary> fromValues(
			List<GenericValue> values) {
		List<OrderPurchaseProductSummary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderPurchaseProductSummary(value));
		}
		return entities;
	}
}