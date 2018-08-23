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
 * Order Header
 */
@FieldNameConstants
public class OrderHeader implements Serializable {

	public static final long serialVersionUID = 5240588515585888256L;
	public static final String NAME = "OrderHeader";
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
	 * Order Name
	 */
	@Getter
	@Setter
	private String orderName;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private String priority;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Pick Sheet Printed Date
	 */
	@Getter
	@Setter
	private Timestamp pickSheetPrintedDate;
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
	 * Terminal Id
	 */
	@Getter
	@Setter
	private String terminalId;
	/**
	 * Transaction Id
	 */
	@Getter
	@Setter
	private String transactionId;
	/**
	 * Auto Order Shopping List Id
	 */
	@Getter
	@Setter
	private String autoOrderShoppingListId;
	/**
	 * Needs Inventory Issuance
	 */
	@Getter
	@Setter
	private String needsInventoryIssuance;
	/**
	 * Is Rush Order
	 */
	@Getter
	@Setter
	private String isRushOrder;
	/**
	 * Internal Code
	 */
	@Getter
	@Setter
	private String internalCode;
	/**
	 * Remaining Sub Total
	 */
	@Getter
	@Setter
	private BigDecimal remainingSubTotal;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Is Viewed
	 */
	@Getter
	@Setter
	private String isViewed;
	/**
	 * Invoice Per Shipment
	 */
	@Getter
	@Setter
	private String invoicePerShipment;
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public OrderHeader(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderName = (String) value.get(FIELD_ORDER_NAME);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		priority = (String) value.get(FIELD_PRIORITY);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		pickSheetPrintedDate = (Timestamp) value
				.get(FIELD_PICK_SHEET_PRINTED_DATE);
		visitId = (String) value.get(FIELD_VISIT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		createdBy = (String) value.get(FIELD_CREATED_BY);
		firstAttemptOrderId = (String) value.get(FIELD_FIRST_ATTEMPT_ORDER_ID);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		syncStatusId = (String) value.get(FIELD_SYNC_STATUS_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		terminalId = (String) value.get(FIELD_TERMINAL_ID);
		transactionId = (String) value.get(FIELD_TRANSACTION_ID);
		autoOrderShoppingListId = (String) value
				.get(FIELD_AUTO_ORDER_SHOPPING_LIST_ID);
		needsInventoryIssuance = (String) value
				.get(FIELD_NEEDS_INVENTORY_ISSUANCE);
		isRushOrder = (String) value.get(FIELD_IS_RUSH_ORDER);
		internalCode = (String) value.get(FIELD_INTERNAL_CODE);
		remainingSubTotal = (BigDecimal) value.get(FIELD_REMAINING_SUB_TOTAL);
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		isViewed = (String) value.get(FIELD_IS_VIEWED);
		invoicePerShipment = (String) value.get(FIELD_INVOICE_PER_SHIPMENT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderHeader fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeader(value);
	}

	public static List<OrderHeader> fromValues(List<GenericValue> values) {
		List<OrderHeader> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeader(value));
		}
		return entities;
	}
}