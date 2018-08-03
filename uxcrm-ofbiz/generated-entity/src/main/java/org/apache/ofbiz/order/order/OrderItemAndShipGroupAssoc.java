package org.apache.ofbiz.order.order;

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
public class OrderItemAndShipGroupAssoc implements Serializable {

	public static final long serialVersionUID = 2424667569690542080L;
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

	public enum Fields {
		orderItemQuantity, orderItemCancelQuantity, orderId, deploymentId, cancelBackOrderDate, itemDescription, selectedAmount, orderItemSeqId, unitPrice, productId, unitRecurringPrice, isItemGroupPrimary, autoCancelDate, productFeatureId, overrideGlAccountId, budgetId, supplierProductId, estimatedDeliveryDate, quoteId, statusId, syncStatusId, estimatedShipDate, shoppingListItemSeqId, subscriptionId, salesOpportunityId, dontCancelSetUserLogin, isPromo, isModifiedPrice, shipBeforeDate, productCategoryId, shoppingListId, unitListPrice, unitAverageCost, orderItemTypeId, dontCancelSetDate, comments, recurringFreqUomId, orderItemGroupSeqId, quoteItemSeqId, externalId, fromInventoryItemId, budgetItemSeqId, correspondingPoId, shipAfterDate, changeByUserLoginId, prodCatalogId, quantity, shipGroupSeqId, cancelQuantity
	}

	public OrderItemAndShipGroupAssoc(GenericValue value) {
		orderItemQuantity = (BigDecimal) value.get(Fields.orderItemQuantity
				.name());
		orderItemCancelQuantity = (BigDecimal) value
				.get(Fields.orderItemCancelQuantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		deploymentId = (String) value.get(Fields.deploymentId.name());
		cancelBackOrderDate = (Timestamp) value.get(Fields.cancelBackOrderDate
				.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		selectedAmount = (BigDecimal) value.get(Fields.selectedAmount.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
		productId = (String) value.get(Fields.productId.name());
		unitRecurringPrice = (BigDecimal) value.get(Fields.unitRecurringPrice
				.name());
		isItemGroupPrimary = (String) value.get(Fields.isItemGroupPrimary
				.name());
		autoCancelDate = (Timestamp) value.get(Fields.autoCancelDate.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		budgetId = (String) value.get(Fields.budgetId.name());
		supplierProductId = (String) value.get(Fields.supplierProductId.name());
		estimatedDeliveryDate = (Timestamp) value
				.get(Fields.estimatedDeliveryDate.name());
		quoteId = (String) value.get(Fields.quoteId.name());
		statusId = (String) value.get(Fields.statusId.name());
		syncStatusId = (String) value.get(Fields.syncStatusId.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		shoppingListItemSeqId = (String) value.get(Fields.shoppingListItemSeqId
				.name());
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		dontCancelSetUserLogin = (String) value
				.get(Fields.dontCancelSetUserLogin.name());
		isPromo = (String) value.get(Fields.isPromo.name());
		isModifiedPrice = (String) value.get(Fields.isModifiedPrice.name());
		shipBeforeDate = (Timestamp) value.get(Fields.shipBeforeDate.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		unitListPrice = (BigDecimal) value.get(Fields.unitListPrice.name());
		unitAverageCost = (BigDecimal) value.get(Fields.unitAverageCost.name());
		orderItemTypeId = (String) value.get(Fields.orderItemTypeId.name());
		dontCancelSetDate = (Timestamp) value.get(Fields.dontCancelSetDate
				.name());
		comments = (String) value.get(Fields.comments.name());
		recurringFreqUomId = (String) value.get(Fields.recurringFreqUomId
				.name());
		orderItemGroupSeqId = (String) value.get(Fields.orderItemGroupSeqId
				.name());
		quoteItemSeqId = (String) value.get(Fields.quoteItemSeqId.name());
		externalId = (String) value.get(Fields.externalId.name());
		fromInventoryItemId = (String) value.get(Fields.fromInventoryItemId
				.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		correspondingPoId = (String) value.get(Fields.correspondingPoId.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
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