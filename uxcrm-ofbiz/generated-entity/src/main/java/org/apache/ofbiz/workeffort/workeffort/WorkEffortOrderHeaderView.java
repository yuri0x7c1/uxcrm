package org.apache.ofbiz.workeffort.workeffort;

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
 * Work Effort Order Header View
 */
@FieldNameConstants
public class WorkEffortOrderHeaderView implements Serializable {

	public static final long serialVersionUID = 565454850203308032L;
	public static final String NAME = "WorkEffortOrderHeaderView";
	/**
	 * Order Type Description
	 */
	@Getter
	@Setter
	private String orderTypeDescription;
	/**
	 * Status Item Description
	 */
	@Getter
	@Setter
	private String statusItemDescription;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Invoice Per Shipment
	 */
	@Getter
	@Setter
	private String invoicePerShipment;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Terminal Id
	 */
	@Getter
	@Setter
	private String terminalId;
	/**
	 * Is Viewed
	 */
	@Getter
	@Setter
	private String isViewed;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Remaining Sub Total
	 */
	@Getter
	@Setter
	private BigDecimal remainingSubTotal;
	/**
	 * Order Name
	 */
	@Getter
	@Setter
	private String orderName;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Is Rush Order
	 */
	@Getter
	@Setter
	private String isRushOrder;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Auto Order Shopping List Id
	 */
	@Getter
	@Setter
	private String autoOrderShoppingListId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private String priority;
	/**
	 * Transaction Id
	 */
	@Getter
	@Setter
	private String transactionId;
	/**
	 * First Attempt Order Id
	 */
	@Getter
	@Setter
	private String firstAttemptOrderId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
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
	 * Pick Sheet Printed Date
	 */
	@Getter
	@Setter
	private Timestamp pickSheetPrintedDate;
	/**
	 * Needs Inventory Issuance
	 */
	@Getter
	@Setter
	private String needsInventoryIssuance;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Internal Code
	 */
	@Getter
	@Setter
	private String internalCode;

	public WorkEffortOrderHeaderView(GenericValue value) {
		orderTypeDescription = (String) value.get(FIELD_ORDER_TYPE_DESCRIPTION);
		statusItemDescription = (String) value
				.get(FIELD_STATUS_ITEM_DESCRIPTION);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		invoicePerShipment = (String) value.get(FIELD_INVOICE_PER_SHIPMENT);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		terminalId = (String) value.get(FIELD_TERMINAL_ID);
		isViewed = (String) value.get(FIELD_IS_VIEWED);
		visitId = (String) value.get(FIELD_VISIT_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		remainingSubTotal = (BigDecimal) value.get(FIELD_REMAINING_SUB_TOTAL);
		orderName = (String) value.get(FIELD_ORDER_NAME);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		isRushOrder = (String) value.get(FIELD_IS_RUSH_ORDER);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		autoOrderShoppingListId = (String) value
				.get(FIELD_AUTO_ORDER_SHOPPING_LIST_ID);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		priority = (String) value.get(FIELD_PRIORITY);
		transactionId = (String) value.get(FIELD_TRANSACTION_ID);
		firstAttemptOrderId = (String) value.get(FIELD_FIRST_ATTEMPT_ORDER_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		createdBy = (String) value.get(FIELD_CREATED_BY);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		syncStatusId = (String) value.get(FIELD_SYNC_STATUS_ID);
		pickSheetPrintedDate = (Timestamp) value
				.get(FIELD_PICK_SHEET_PRINTED_DATE);
		needsInventoryIssuance = (String) value
				.get(FIELD_NEEDS_INVENTORY_ISSUANCE);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		internalCode = (String) value.get(FIELD_INTERNAL_CODE);
	}

	public static WorkEffortOrderHeaderView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortOrderHeaderView(value);
	}

	public static List<WorkEffortOrderHeaderView> fromValues(
			List<GenericValue> values) {
		List<WorkEffortOrderHeaderView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortOrderHeaderView(value));
		}
		return entities;
	}
}