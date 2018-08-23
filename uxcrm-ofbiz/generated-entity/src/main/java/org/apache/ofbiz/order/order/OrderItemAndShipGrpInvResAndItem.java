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
 * Order Item And Ship Grp Inv Res And Item
 */
@FieldNameConstants
public class OrderItemAndShipGrpInvResAndItem implements Serializable {

	public static final long serialVersionUID = 3658024407696738304L;
	public static final String NAME = "OrderItemAndShipGrpInvResAndItem";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
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
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
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
	 * Estimated Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedDeliveryDate;
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Sync Status Id
	 */
	@Getter
	@Setter
	private String syncStatusId;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
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
	 * Ship Before Date
	 */
	@Getter
	@Setter
	private Timestamp shipBeforeDate;
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
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
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
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
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
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
	/**
	 * Ship After Date
	 */
	@Getter
	@Setter
	private Timestamp shipAfterDate;
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
	/**
	 * Promised Datetime
	 */
	@Getter
	@Setter
	private Timestamp promisedDatetime;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private String priority;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private Long sequenceId;
	/**
	 * Old Pick Start Date
	 */
	@Getter
	@Setter
	private Timestamp oldPickStartDate;
	/**
	 * Current Promised Date
	 */
	@Getter
	@Setter
	private Timestamp currentPromisedDate;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Quantity Not Available
	 */
	@Getter
	@Setter
	private BigDecimal quantityNotAvailable;
	/**
	 * Created Datetime
	 */
	@Getter
	@Setter
	private Timestamp createdDatetime;
	/**
	 * Reserve Order Enum Id
	 */
	@Getter
	@Setter
	private String reserveOrderEnumId;
	/**
	 * Reserved Datetime
	 */
	@Getter
	@Setter
	private Timestamp reservedDatetime;
	/**
	 * Soft Identifier
	 */
	@Getter
	@Setter
	private String softIdentifier;
	/**
	 * Bin Number
	 */
	@Getter
	@Setter
	private String binNumber;
	/**
	 * Old Available To Promise
	 */
	@Getter
	@Setter
	private BigDecimal oldAvailableToPromise;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
	/**
	 * Datetime Manufactured
	 */
	@Getter
	@Setter
	private Timestamp datetimeManufactured;
	/**
	 * Expire Date
	 */
	@Getter
	@Setter
	private Timestamp expireDate;
	/**
	 * Old Quantity On Hand
	 */
	@Getter
	@Setter
	private BigDecimal oldQuantityOnHand;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Serial Number
	 */
	@Getter
	@Setter
	private String serialNumber;
	/**
	 * Lot Id
	 */
	@Getter
	@Setter
	private String lotId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Accounting Quantity Total
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityTotal;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Activation Valid Thru
	 */
	@Getter
	@Setter
	private Timestamp activationValidThru;
	/**
	 * Activation Number
	 */
	@Getter
	@Setter
	private String activationNumber;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Datetime Received
	 */
	@Getter
	@Setter
	private Timestamp datetimeReceived;

	public OrderItemAndShipGrpInvResAndItem(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		deploymentId = (String) value.get(FIELD_DEPLOYMENT_ID);
		cancelBackOrderDate = (Timestamp) value
				.get(FIELD_CANCEL_BACK_ORDER_DATE);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		selectedAmount = (BigDecimal) value.get(FIELD_SELECTED_AMOUNT);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		unitRecurringPrice = (BigDecimal) value.get(FIELD_UNIT_RECURRING_PRICE);
		isItemGroupPrimary = (String) value.get(FIELD_IS_ITEM_GROUP_PRIMARY);
		autoCancelDate = (Timestamp) value.get(FIELD_AUTO_CANCEL_DATE);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		supplierProductId = (String) value.get(FIELD_SUPPLIER_PRODUCT_ID);
		estimatedDeliveryDate = (Timestamp) value
				.get(FIELD_ESTIMATED_DELIVERY_DATE);
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		syncStatusId = (String) value.get(FIELD_SYNC_STATUS_ID);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		shoppingListItemSeqId = (String) value
				.get(FIELD_SHOPPING_LIST_ITEM_SEQ_ID);
		subscriptionId = (String) value.get(FIELD_SUBSCRIPTION_ID);
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		dontCancelSetUserLogin = (String) value
				.get(FIELD_DONT_CANCEL_SET_USER_LOGIN);
		isPromo = (String) value.get(FIELD_IS_PROMO);
		isModifiedPrice = (String) value.get(FIELD_IS_MODIFIED_PRICE);
		shipBeforeDate = (Timestamp) value.get(FIELD_SHIP_BEFORE_DATE);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		unitListPrice = (BigDecimal) value.get(FIELD_UNIT_LIST_PRICE);
		unitAverageCost = (BigDecimal) value.get(FIELD_UNIT_AVERAGE_COST);
		orderItemTypeId = (String) value.get(FIELD_ORDER_ITEM_TYPE_ID);
		dontCancelSetDate = (Timestamp) value.get(FIELD_DONT_CANCEL_SET_DATE);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		comments = (String) value.get(FIELD_COMMENTS);
		recurringFreqUomId = (String) value.get(FIELD_RECURRING_FREQ_UOM_ID);
		orderItemGroupSeqId = (String) value.get(FIELD_ORDER_ITEM_GROUP_SEQ_ID);
		quoteItemSeqId = (String) value.get(FIELD_QUOTE_ITEM_SEQ_ID);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		fromInventoryItemId = (String) value.get(FIELD_FROM_INVENTORY_ITEM_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		correspondingPoId = (String) value.get(FIELD_CORRESPONDING_PO_ID);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		promisedDatetime = (Timestamp) value.get(FIELD_PROMISED_DATETIME);
		priority = (String) value.get(FIELD_PRIORITY);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		sequenceId = (Long) value.get(FIELD_SEQUENCE_ID);
		oldPickStartDate = (Timestamp) value.get(FIELD_OLD_PICK_START_DATE);
		currentPromisedDate = (Timestamp) value
				.get(FIELD_CURRENT_PROMISED_DATE);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		quantityNotAvailable = (BigDecimal) value
				.get(FIELD_QUANTITY_NOT_AVAILABLE);
		createdDatetime = (Timestamp) value.get(FIELD_CREATED_DATETIME);
		reserveOrderEnumId = (String) value.get(FIELD_RESERVE_ORDER_ENUM_ID);
		reservedDatetime = (Timestamp) value.get(FIELD_RESERVED_DATETIME);
		softIdentifier = (String) value.get(FIELD_SOFT_IDENTIFIER);
		binNumber = (String) value.get(FIELD_BIN_NUMBER);
		oldAvailableToPromise = (BigDecimal) value
				.get(FIELD_OLD_AVAILABLE_TO_PROMISE);
		quantityOnHandTotal = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_TOTAL);
		datetimeManufactured = (Timestamp) value
				.get(FIELD_DATETIME_MANUFACTURED);
		expireDate = (Timestamp) value.get(FIELD_EXPIRE_DATE);
		oldQuantityOnHand = (BigDecimal) value.get(FIELD_OLD_QUANTITY_ON_HAND);
		partyId = (String) value.get(FIELD_PARTY_ID);
		containerId = (String) value.get(FIELD_CONTAINER_ID);
		availableToPromiseTotal = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_TOTAL);
		inventoryItemTypeId = (String) value.get(FIELD_INVENTORY_ITEM_TYPE_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		serialNumber = (String) value.get(FIELD_SERIAL_NUMBER);
		lotId = (String) value.get(FIELD_LOT_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		accountingQuantityTotal = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_TOTAL);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		activationValidThru = (Timestamp) value
				.get(FIELD_ACTIVATION_VALID_THRU);
		activationNumber = (String) value.get(FIELD_ACTIVATION_NUMBER);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		datetimeReceived = (Timestamp) value.get(FIELD_DATETIME_RECEIVED);
	}

	public static OrderItemAndShipGrpInvResAndItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAndShipGrpInvResAndItem(value);
	}

	public static List<OrderItemAndShipGrpInvResAndItem> fromValues(
			List<GenericValue> values) {
		List<OrderItemAndShipGrpInvResAndItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAndShipGrpInvResAndItem(value));
		}
		return entities;
	}
}