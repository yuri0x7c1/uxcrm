package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header Item And Ship Group
 */
@FieldNameConstants
public class OrderHeaderItemAndShipGroup implements Serializable {

	public static final long serialVersionUID = 7679056408818854912L;
	public static final String NAME = "OrderHeaderItemAndShipGroup";
	/**
	 * Oi Quantity
	 */
	@Getter
	@Setter
	private BigDecimal oiQuantity;
	/**
	 * Oi Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal oiCancelQuantity;
	/**
	 * Oi Ship After Date
	 */
	@Getter
	@Setter
	private Timestamp oiShipAfterDate;
	/**
	 * Oi Ship Before Date
	 */
	@Getter
	@Setter
	private Timestamp oiShipBeforeDate;
	/**
	 * Oi Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp oiEstimatedShipDate;
	/**
	 * Oi Estimated Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp oiEstimatedDeliveryDate;
	/**
	 * Oi Status Id
	 */
	@Getter
	@Setter
	private String oiStatusId;
	/**
	 * Oi External Id
	 */
	@Getter
	@Setter
	private String oiExternalId;
	/**
	 * Oi Sync Status Id
	 */
	@Getter
	@Setter
	private String oiSyncStatusId;
	/**
	 * Reserved Quantity
	 */
	@Getter
	@Setter
	private BigDecimal reservedQuantity;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
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
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
	/**
	 * Gift Message
	 */
	@Getter
	@Setter
	private String giftMessage;
	/**
	 * Shipping Instructions
	 */
	@Getter
	@Setter
	private String shippingInstructions;
	/**
	 * May Split
	 */
	@Getter
	@Setter
	private String maySplit;
	/**
	 * Ship By Date
	 */
	@Getter
	@Setter
	private Timestamp shipByDate;
	/**
	 * Estimated Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedDeliveryDate;
	/**
	 * Vendor Party Id
	 */
	@Getter
	@Setter
	private String vendorPartyId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Telecom Contact Mech Id
	 */
	@Getter
	@Setter
	private String telecomContactMechId;
	/**
	 * Ship After Date
	 */
	@Getter
	@Setter
	private Timestamp shipAfterDate;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Carrier Role Type Id
	 */
	@Getter
	@Setter
	private String carrierRoleTypeId;
	/**
	 * Is Gift
	 */
	@Getter
	@Setter
	private String isGift;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Supplier Party Id
	 */
	@Getter
	@Setter
	private String supplierPartyId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Tracking Number
	 */
	@Getter
	@Setter
	private String trackingNumber;
	/**
	 * Deployment Id
	 */
	@Getter
	@Setter
	private String deploymentId;
	/**
	 * Cancel Back Order Date
	 */
	@Getter
	@Setter
	private Timestamp cancelBackOrderDate;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Selected Amount
	 */
	@Getter
	@Setter
	private BigDecimal selectedAmount;
	/**
	 * Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Unit Recurring Price
	 */
	@Getter
	@Setter
	private BigDecimal unitRecurringPrice;
	/**
	 * Is Item Group Primary
	 */
	@Getter
	@Setter
	private String isItemGroupPrimary;
	/**
	 * Auto Cancel Date
	 */
	@Getter
	@Setter
	private Timestamp autoCancelDate;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Supplier Product Id
	 */
	@Getter
	@Setter
	private String supplierProductId;
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Shopping List Item Seq Id
	 */
	@Getter
	@Setter
	private String shoppingListItemSeqId;
	/**
	 * Subscription Id
	 */
	@Getter
	@Setter
	private String subscriptionId;
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
	/**
	 * Dont Cancel Set User Login
	 */
	@Getter
	@Setter
	private String dontCancelSetUserLogin;
	/**
	 * Is Promo
	 */
	@Getter
	@Setter
	private String isPromo;
	/**
	 * Is Modified Price
	 */
	@Getter
	@Setter
	private String isModifiedPrice;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Shopping List Id
	 */
	@Getter
	@Setter
	private String shoppingListId;
	/**
	 * Unit List Price
	 */
	@Getter
	@Setter
	private BigDecimal unitListPrice;
	/**
	 * Unit Average Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitAverageCost;
	/**
	 * Order Item Type Id
	 */
	@Getter
	@Setter
	private String orderItemTypeId;
	/**
	 * Dont Cancel Set Date
	 */
	@Getter
	@Setter
	private Timestamp dontCancelSetDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Recurring Freq Uom Id
	 */
	@Getter
	@Setter
	private String recurringFreqUomId;
	/**
	 * Order Item Group Seq Id
	 */
	@Getter
	@Setter
	private String orderItemGroupSeqId;
	/**
	 * Quote Item Seq Id
	 */
	@Getter
	@Setter
	private String quoteItemSeqId;
	/**
	 * From Inventory Item Id
	 */
	@Getter
	@Setter
	private String fromInventoryItemId;
	/**
	 * Budget Item Seq Id
	 */
	@Getter
	@Setter
	private String budgetItemSeqId;
	/**
	 * Corresponding Po Id
	 */
	@Getter
	@Setter
	private String correspondingPoId;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
	/**
	 * Prod Catalog Id
	 */
	@Getter
	@Setter
	private String prodCatalogId;

	public OrderHeaderItemAndShipGroup(GenericValue value) {
		oiQuantity = (BigDecimal) value.get(FIELD_OI_QUANTITY);
		oiCancelQuantity = (BigDecimal) value.get(FIELD_OI_CANCEL_QUANTITY);
		oiShipAfterDate = (Timestamp) value.get(FIELD_OI_SHIP_AFTER_DATE);
		oiShipBeforeDate = (Timestamp) value.get(FIELD_OI_SHIP_BEFORE_DATE);
		oiEstimatedShipDate = (Timestamp) value
				.get(FIELD_OI_ESTIMATED_SHIP_DATE);
		oiEstimatedDeliveryDate = (Timestamp) value
				.get(FIELD_OI_ESTIMATED_DELIVERY_DATE);
		oiStatusId = (String) value.get(FIELD_OI_STATUS_ID);
		oiExternalId = (String) value.get(FIELD_OI_EXTERNAL_ID);
		oiSyncStatusId = (String) value.get(FIELD_OI_SYNC_STATUS_ID);
		reservedQuantity = (BigDecimal) value.get(FIELD_RESERVED_QUANTITY);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
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
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		giftMessage = (String) value.get(FIELD_GIFT_MESSAGE);
		shippingInstructions = (String) value.get(FIELD_SHIPPING_INSTRUCTIONS);
		maySplit = (String) value.get(FIELD_MAY_SPLIT);
		shipByDate = (Timestamp) value.get(FIELD_SHIP_BY_DATE);
		estimatedDeliveryDate = (Timestamp) value
				.get(FIELD_ESTIMATED_DELIVERY_DATE);
		vendorPartyId = (String) value.get(FIELD_VENDOR_PARTY_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		telecomContactMechId = (String) value
				.get(FIELD_TELECOM_CONTACT_MECH_ID);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierRoleTypeId = (String) value.get(FIELD_CARRIER_ROLE_TYPE_ID);
		isGift = (String) value.get(FIELD_IS_GIFT);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		supplierPartyId = (String) value.get(FIELD_SUPPLIER_PARTY_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		trackingNumber = (String) value.get(FIELD_TRACKING_NUMBER);
		deploymentId = (String) value.get(FIELD_DEPLOYMENT_ID);
		cancelBackOrderDate = (Timestamp) value
				.get(FIELD_CANCEL_BACK_ORDER_DATE);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		selectedAmount = (BigDecimal) value.get(FIELD_SELECTED_AMOUNT);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		unitRecurringPrice = (BigDecimal) value.get(FIELD_UNIT_RECURRING_PRICE);
		isItemGroupPrimary = (String) value.get(FIELD_IS_ITEM_GROUP_PRIMARY);
		autoCancelDate = (Timestamp) value.get(FIELD_AUTO_CANCEL_DATE);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		supplierProductId = (String) value.get(FIELD_SUPPLIER_PRODUCT_ID);
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		shoppingListItemSeqId = (String) value
				.get(FIELD_SHOPPING_LIST_ITEM_SEQ_ID);
		subscriptionId = (String) value.get(FIELD_SUBSCRIPTION_ID);
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		dontCancelSetUserLogin = (String) value
				.get(FIELD_DONT_CANCEL_SET_USER_LOGIN);
		isPromo = (String) value.get(FIELD_IS_PROMO);
		isModifiedPrice = (String) value.get(FIELD_IS_MODIFIED_PRICE);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		unitListPrice = (BigDecimal) value.get(FIELD_UNIT_LIST_PRICE);
		unitAverageCost = (BigDecimal) value.get(FIELD_UNIT_AVERAGE_COST);
		orderItemTypeId = (String) value.get(FIELD_ORDER_ITEM_TYPE_ID);
		dontCancelSetDate = (Timestamp) value.get(FIELD_DONT_CANCEL_SET_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		recurringFreqUomId = (String) value.get(FIELD_RECURRING_FREQ_UOM_ID);
		orderItemGroupSeqId = (String) value.get(FIELD_ORDER_ITEM_GROUP_SEQ_ID);
		quoteItemSeqId = (String) value.get(FIELD_QUOTE_ITEM_SEQ_ID);
		fromInventoryItemId = (String) value.get(FIELD_FROM_INVENTORY_ITEM_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		correspondingPoId = (String) value.get(FIELD_CORRESPONDING_PO_ID);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
	}

	public static OrderHeaderItemAndShipGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderItemAndShipGroup(value);
	}

	public static List<OrderHeaderItemAndShipGroup> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderItemAndShipGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderItemAndShipGroup(value));
		}
		return entities;
	}
}