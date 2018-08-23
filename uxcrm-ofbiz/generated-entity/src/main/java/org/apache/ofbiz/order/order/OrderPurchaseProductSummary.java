package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OrderPurchaseProductSummary implements Serializable {

	public static final long serialVersionUID = 8011692730540169216L;
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

	public OrderPurchaseProductSummary(GenericValue value) {
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		terminalId = (String) value.get(FIELD_TERMINAL_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		unitListPrice = (BigDecimal) value.get(FIELD_UNIT_LIST_PRICE);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		itemStatusId = (String) value.get(FIELD_ITEM_STATUS_ID);
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