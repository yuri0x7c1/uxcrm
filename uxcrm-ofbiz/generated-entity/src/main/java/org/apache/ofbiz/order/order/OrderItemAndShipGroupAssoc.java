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
 * Order Item And Ship Group Assoc
 */
@FieldNameConstants
public class OrderItemAndShipGroupAssoc implements Serializable {

	public static final long serialVersionUID = 926098504410789888L;
	public static final String NAME = "OrderItemAndShipGroupAssoc";
	/**
	 * Order Item Quantity
	 */
	@Getter
	@Setter
	private BigDecimal orderItemQuantity;
	/**
	 * Order Item Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal orderItemCancelQuantity;
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

	public OrderItemAndShipGroupAssoc(GenericValue value) {
		orderItemQuantity = (BigDecimal) value.get(FIELD_ORDER_ITEM_QUANTITY);
		orderItemCancelQuantity = (BigDecimal) value
				.get(FIELD_ORDER_ITEM_CANCEL_QUANTITY);
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
		comments = (String) value.get(FIELD_COMMENTS);
		recurringFreqUomId = (String) value.get(FIELD_RECURRING_FREQ_UOM_ID);
		orderItemGroupSeqId = (String) value.get(FIELD_ORDER_ITEM_GROUP_SEQ_ID);
		quoteItemSeqId = (String) value.get(FIELD_QUOTE_ITEM_SEQ_ID);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		fromInventoryItemId = (String) value.get(FIELD_FROM_INVENTORY_ITEM_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		correspondingPoId = (String) value.get(FIELD_CORRESPONDING_PO_ID);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
	}

	public static OrderItemAndShipGroupAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAndShipGroupAssoc(value);
	}

	public static List<OrderItemAndShipGroupAssoc> fromValues(
			List<GenericValue> values) {
		List<OrderItemAndShipGroupAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAndShipGroupAssoc(value));
		}
		return entities;
	}
}