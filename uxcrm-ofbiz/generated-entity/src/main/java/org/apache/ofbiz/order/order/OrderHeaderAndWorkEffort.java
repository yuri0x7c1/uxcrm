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
 * Order Header And Work Effort
 */
@FieldNameConstants
public class OrderHeaderAndWorkEffort implements Serializable {

	public static final long serialVersionUID = 5654388438695934976L;
	public static final String NAME = "OrderHeaderAndWorkEffort";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Revision Number
	 */
	@Getter
	@Setter
	private Long revisionNumber;
	/**
	 * Temp Expr Id
	 */
	@Getter
	@Setter
	private String tempExprId;
	/**
	 * Show As Enum Id
	 */
	@Getter
	@Setter
	private String showAsEnumId;
	/**
	 * Info Url
	 */
	@Getter
	@Setter
	private String infoUrl;
	/**
	 * Universal Id
	 */
	@Getter
	@Setter
	private String universalId;
	/**
	 * Location Desc
	 */
	@Getter
	@Setter
	private String locationDesc;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Actual Milli Seconds
	 */
	@Getter
	@Setter
	private Double actualMilliSeconds;
	/**
	 * Quantity To Produce
	 */
	@Getter
	@Setter
	private BigDecimal quantityToProduce;
	/**
	 * Work Effort Purpose Type Id
	 */
	@Getter
	@Setter
	private String workEffortPurposeTypeId;
	/**
	 * Service Loader Name
	 */
	@Getter
	@Setter
	private String serviceLoaderName;
	/**
	 * Accommodation Spot Id
	 */
	@Getter
	@Setter
	private String accommodationSpotId;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Send Notification Email
	 */
	@Getter
	@Setter
	private String sendNotificationEmail;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * Quantity Rejected
	 */
	@Getter
	@Setter
	private BigDecimal quantityRejected;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Current Status Id
	 */
	@Getter
	@Setter
	private String currentStatusId;
	/**
	 * Runtime Data Id
	 */
	@Getter
	@Setter
	private String runtimeDataId;
	/**
	 * Estimated Milli Seconds
	 */
	@Getter
	@Setter
	private Double estimatedMilliSeconds;
	/**
	 * Special Terms
	 */
	@Getter
	@Setter
	private String specialTerms;
	/**
	 * Time Transparency
	 */
	@Getter
	@Setter
	private Long timeTransparency;
	/**
	 * Actual Completion Date
	 */
	@Getter
	@Setter
	private Timestamp actualCompletionDate;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reserv2ndPPPerc;
	/**
	 * Total Money Allowed
	 */
	@Getter
	@Setter
	private BigDecimal totalMoneyAllowed;
	/**
	 * Estimate Calc Method
	 */
	@Getter
	@Setter
	private String estimateCalcMethod;
	/**
	 * Work Effort Parent Id
	 */
	@Getter
	@Setter
	private String workEffortParentId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Money Uom Id
	 */
	@Getter
	@Setter
	private String moneyUomId;
	/**
	 * Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reservNthPPPerc;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Accommodation Map Id
	 */
	@Getter
	@Setter
	private String accommodationMapId;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Scope Enum Id
	 */
	@Getter
	@Setter
	private String scopeEnumId;
	/**
	 * Quantity Produced
	 */
	@Getter
	@Setter
	private BigDecimal quantityProduced;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Estimated Setup Millis
	 */
	@Getter
	@Setter
	private Double estimatedSetupMillis;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Source Reference Id
	 */
	@Getter
	@Setter
	private String sourceReferenceId;
	/**
	 * Last Status Update
	 */
	@Getter
	@Setter
	private Timestamp lastStatusUpdate;
	/**
	 * Percent Complete
	 */
	@Getter
	@Setter
	private Long percentComplete;
	/**
	 * Total Milli Seconds Allowed
	 */
	@Getter
	@Setter
	private Double totalMilliSecondsAllowed;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Actual Setup Millis
	 */
	@Getter
	@Setter
	private Double actualSetupMillis;
	/**
	 * Estimated Completion Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCompletionDate;
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

	public OrderHeaderAndWorkEffort(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		workEffortTypeId = (String) value.get(FIELD_WORK_EFFORT_TYPE_ID);
		reservPersons = (BigDecimal) value.get(FIELD_RESERV_PERSONS);
		revisionNumber = (Long) value.get(FIELD_REVISION_NUMBER);
		tempExprId = (String) value.get(FIELD_TEMP_EXPR_ID);
		showAsEnumId = (String) value.get(FIELD_SHOW_AS_ENUM_ID);
		infoUrl = (String) value.get(FIELD_INFO_URL);
		universalId = (String) value.get(FIELD_UNIVERSAL_ID);
		locationDesc = (String) value.get(FIELD_LOCATION_DESC);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		actualMilliSeconds = (Double) value.get(FIELD_ACTUAL_MILLI_SECONDS);
		quantityToProduce = (BigDecimal) value.get(FIELD_QUANTITY_TO_PRODUCE);
		workEffortPurposeTypeId = (String) value
				.get(FIELD_WORK_EFFORT_PURPOSE_TYPE_ID);
		serviceLoaderName = (String) value.get(FIELD_SERVICE_LOADER_NAME);
		accommodationSpotId = (String) value.get(FIELD_ACCOMMODATION_SPOT_ID);
		estimatedStartDate = (Timestamp) value.get(FIELD_ESTIMATED_START_DATE);
		sendNotificationEmail = (String) value
				.get(FIELD_SEND_NOTIFICATION_EMAIL);
		noteId = (String) value.get(FIELD_NOTE_ID);
		quantityRejected = (BigDecimal) value.get(FIELD_QUANTITY_REJECTED);
		priority = (Long) value.get(FIELD_PRIORITY);
		currentStatusId = (String) value.get(FIELD_CURRENT_STATUS_ID);
		runtimeDataId = (String) value.get(FIELD_RUNTIME_DATA_ID);
		estimatedMilliSeconds = (Double) value
				.get(FIELD_ESTIMATED_MILLI_SECONDS);
		specialTerms = (String) value.get(FIELD_SPECIAL_TERMS);
		timeTransparency = (Long) value.get(FIELD_TIME_TRANSPARENCY);
		actualCompletionDate = (Timestamp) value
				.get(FIELD_ACTUAL_COMPLETION_DATE);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		reserv2ndPPPerc = (BigDecimal) value.get(FIELD_RESERV2ND_P_P_PERC);
		totalMoneyAllowed = (BigDecimal) value.get(FIELD_TOTAL_MONEY_ALLOWED);
		estimateCalcMethod = (String) value.get(FIELD_ESTIMATE_CALC_METHOD);
		workEffortParentId = (String) value.get(FIELD_WORK_EFFORT_PARENT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		moneyUomId = (String) value.get(FIELD_MONEY_UOM_ID);
		reservNthPPPerc = (BigDecimal) value.get(FIELD_RESERV_NTH_P_P_PERC);
		workEffortName = (String) value.get(FIELD_WORK_EFFORT_NAME);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		accommodationMapId = (String) value.get(FIELD_ACCOMMODATION_MAP_ID);
		actualStartDate = (Timestamp) value.get(FIELD_ACTUAL_START_DATE);
		scopeEnumId = (String) value.get(FIELD_SCOPE_ENUM_ID);
		quantityProduced = (BigDecimal) value.get(FIELD_QUANTITY_PRODUCED);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		estimatedSetupMillis = (Double) value.get(FIELD_ESTIMATED_SETUP_MILLIS);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		sourceReferenceId = (String) value.get(FIELD_SOURCE_REFERENCE_ID);
		lastStatusUpdate = (Timestamp) value.get(FIELD_LAST_STATUS_UPDATE);
		percentComplete = (Long) value.get(FIELD_PERCENT_COMPLETE);
		totalMilliSecondsAllowed = (Double) value
				.get(FIELD_TOTAL_MILLI_SECONDS_ALLOWED);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		actualSetupMillis = (Double) value.get(FIELD_ACTUAL_SETUP_MILLIS);
		estimatedCompletionDate = (Timestamp) value
				.get(FIELD_ESTIMATED_COMPLETION_DATE);
		invoicePerShipment = (String) value.get(FIELD_INVOICE_PER_SHIPMENT);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
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

	public static OrderHeaderAndWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderAndWorkEffort(value);
	}

	public static List<OrderHeaderAndWorkEffort> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderAndWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderAndWorkEffort(value));
		}
		return entities;
	}
}