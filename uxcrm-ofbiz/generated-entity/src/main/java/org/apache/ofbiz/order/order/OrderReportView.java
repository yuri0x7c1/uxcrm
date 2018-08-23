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
 * Order Report View
 */
@FieldNameConstants
public class OrderReportView implements Serializable {

	public static final long serialVersionUID = 1054928436027521024L;
	public static final String NAME = "OrderReportView";
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
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
	 * Order Status
	 */
	@Getter
	@Setter
	private String orderStatus;
	/**
	 * Payment Method
	 */
	@Getter
	@Setter
	private String paymentMethod;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
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
	 * Item Status
	 */
	@Getter
	@Setter
	private String itemStatus;
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

	public OrderReportView(GenericValue value) {
		groupName = (String) value.get(FIELD_GROUP_NAME);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		orderStatus = (String) value.get(FIELD_ORDER_STATUS);
		paymentMethod = (String) value.get(FIELD_PAYMENT_METHOD);
		visitId = (String) value.get(FIELD_VISIT_ID);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		itemStatus = (String) value.get(FIELD_ITEM_STATUS);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
	}

	public static OrderReportView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderReportView(value);
	}

	public static List<OrderReportView> fromValues(List<GenericValue> values) {
		List<OrderReportView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderReportView(value));
		}
		return entities;
	}
}