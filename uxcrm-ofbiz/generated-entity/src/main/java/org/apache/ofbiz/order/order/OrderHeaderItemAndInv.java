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
 * Order Header Item And Inv
 */
@FieldNameConstants
public class OrderHeaderItemAndInv implements Serializable {

	public static final long serialVersionUID = 3578534228109754368L;
	public static final String NAME = "OrderHeaderItemAndInv";
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
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Created By
	 */
	@Getter
	@Setter
	private String createdBy;
	/**
	 * First Attempt Order Id
	 */
	@Getter
	@Setter
	private String firstAttemptOrderId;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
	/**
	 * Sync Status Id
	 */
	@Getter
	@Setter
	private String syncStatusId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
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
	 * Remaining Sub Total
	 */
	@Getter
	@Setter
	private BigDecimal remainingSubTotal;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	/**
	 * Unit List Price
	 */
	@Getter
	@Setter
	private BigDecimal unitListPrice;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Auto Cancel Date
	 */
	@Getter
	@Setter
	private Timestamp autoCancelDate;
	/**
	 * Corresponding Po Id
	 */
	@Getter
	@Setter
	private String correspondingPoId;
	/**
	 * Quantity Not Available
	 */
	@Getter
	@Setter
	private BigDecimal quantityNotAvailable;

	public OrderHeaderItemAndInv(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		visitId = (String) value.get(FIELD_VISIT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		createdBy = (String) value.get(FIELD_CREATED_BY);
		firstAttemptOrderId = (String) value.get(FIELD_FIRST_ATTEMPT_ORDER_ID);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		syncStatusId = (String) value.get(FIELD_SYNC_STATUS_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		remainingSubTotal = (BigDecimal) value.get(FIELD_REMAINING_SUB_TOTAL);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		unitListPrice = (BigDecimal) value.get(FIELD_UNIT_LIST_PRICE);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		autoCancelDate = (Timestamp) value.get(FIELD_AUTO_CANCEL_DATE);
		correspondingPoId = (String) value.get(FIELD_CORRESPONDING_PO_ID);
		quantityNotAvailable = (BigDecimal) value
				.get(FIELD_QUANTITY_NOT_AVAILABLE);
	}

	public static OrderHeaderItemAndInv fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderItemAndInv(value);
	}

	public static List<OrderHeaderItemAndInv> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderItemAndInv> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderItemAndInv(value));
		}
		return entities;
	}
}