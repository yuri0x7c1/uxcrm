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
 * Order Header Item And Ship Group
 */
public class OrderHeaderItemAndShipGroup implements Serializable {

	public static final long serialVersionUID = 1432735748194053120L;
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
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
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
	 * Supplier Agreement Id
	 */
	@Getter
	@Setter
	private String supplierAgreementId;
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

	public enum Fields {
		oiQuantity, oiCancelQuantity, oiShipAfterDate, oiShipBeforeDate, oiEstimatedShipDate, oiEstimatedDeliveryDate, oiStatusId, oiExternalId, oiSyncStatusId, reservedQuantity, facilityId, invoicePerShipment, salesChannelEnumId, orderId, orderTypeId, billingAccountId, terminalId, isViewed, visitId, agreementId, productStoreId, remainingSubTotal, orderName, webSiteId, isRushOrder, entryDate, grandTotal, autoOrderShoppingListId, externalId, priority, transactionId, firstAttemptOrderId, originFacilityId, statusId, createdBy, currencyUom, syncStatusId, pickSheetPrintedDate, needsInventoryIssuance, orderDate, internalCode, orderItemSeqId, quantity, shipGroupSeqId, cancelQuantity, giftMessage, shippingInstructions, maySplit, shipByDate, supplierAgreementId, estimatedDeliveryDate, vendorPartyId, contactMechId, telecomContactMechId, shipAfterDate, carrierPartyId, carrierRoleTypeId, isGift, estimatedShipDate, supplierPartyId, shipmentMethodTypeId, trackingNumber, deploymentId, cancelBackOrderDate, itemDescription, selectedAmount, unitPrice, productId, unitRecurringPrice, isItemGroupPrimary, autoCancelDate, productFeatureId, overrideGlAccountId, budgetId, supplierProductId, quoteId, shoppingListItemSeqId, subscriptionId, salesOpportunityId, dontCancelSetUserLogin, isPromo, isModifiedPrice, productCategoryId, shoppingListId, unitListPrice, unitAverageCost, orderItemTypeId, dontCancelSetDate, comments, recurringFreqUomId, orderItemGroupSeqId, quoteItemSeqId, fromInventoryItemId, budgetItemSeqId, correspondingPoId, changeByUserLoginId, prodCatalogId
	}

	public OrderHeaderItemAndShipGroup(GenericValue value) {
		oiQuantity = (BigDecimal) value.get(Fields.oiQuantity.name());
		oiCancelQuantity = (BigDecimal) value.get(Fields.oiCancelQuantity
				.name());
		oiShipAfterDate = (Timestamp) value.get(Fields.oiShipAfterDate.name());
		oiShipBeforeDate = (Timestamp) value
				.get(Fields.oiShipBeforeDate.name());
		oiEstimatedShipDate = (Timestamp) value.get(Fields.oiEstimatedShipDate
				.name());
		oiEstimatedDeliveryDate = (Timestamp) value
				.get(Fields.oiEstimatedDeliveryDate.name());
		oiStatusId = (String) value.get(Fields.oiStatusId.name());
		oiExternalId = (String) value.get(Fields.oiExternalId.name());
		oiSyncStatusId = (String) value.get(Fields.oiSyncStatusId.name());
		reservedQuantity = (BigDecimal) value.get(Fields.reservedQuantity
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		invoicePerShipment = (String) value.get(Fields.invoicePerShipment
				.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		terminalId = (String) value.get(Fields.terminalId.name());
		isViewed = (String) value.get(Fields.isViewed.name());
		visitId = (String) value.get(Fields.visitId.name());
		agreementId = (String) value.get(Fields.agreementId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		remainingSubTotal = (BigDecimal) value.get(Fields.remainingSubTotal
				.name());
		orderName = (String) value.get(Fields.orderName.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		isRushOrder = (String) value.get(Fields.isRushOrder.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		autoOrderShoppingListId = (String) value
				.get(Fields.autoOrderShoppingListId.name());
		externalId = (String) value.get(Fields.externalId.name());
		priority = (String) value.get(Fields.priority.name());
		transactionId = (String) value.get(Fields.transactionId.name());
		firstAttemptOrderId = (String) value.get(Fields.firstAttemptOrderId
				.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdBy = (String) value.get(Fields.createdBy.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		syncStatusId = (String) value.get(Fields.syncStatusId.name());
		pickSheetPrintedDate = (Timestamp) value
				.get(Fields.pickSheetPrintedDate.name());
		needsInventoryIssuance = (String) value
				.get(Fields.needsInventoryIssuance.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		internalCode = (String) value.get(Fields.internalCode.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
		giftMessage = (String) value.get(Fields.giftMessage.name());
		shippingInstructions = (String) value.get(Fields.shippingInstructions
				.name());
		maySplit = (String) value.get(Fields.maySplit.name());
		shipByDate = (Timestamp) value.get(Fields.shipByDate.name());
		supplierAgreementId = (String) value.get(Fields.supplierAgreementId
				.name());
		estimatedDeliveryDate = (Timestamp) value
				.get(Fields.estimatedDeliveryDate.name());
		vendorPartyId = (String) value.get(Fields.vendorPartyId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		telecomContactMechId = (String) value.get(Fields.telecomContactMechId
				.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierRoleTypeId = (String) value.get(Fields.carrierRoleTypeId.name());
		isGift = (String) value.get(Fields.isGift.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		supplierPartyId = (String) value.get(Fields.supplierPartyId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		trackingNumber = (String) value.get(Fields.trackingNumber.name());
		deploymentId = (String) value.get(Fields.deploymentId.name());
		cancelBackOrderDate = (Timestamp) value.get(Fields.cancelBackOrderDate
				.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		selectedAmount = (BigDecimal) value.get(Fields.selectedAmount.name());
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
		quoteId = (String) value.get(Fields.quoteId.name());
		shoppingListItemSeqId = (String) value.get(Fields.shoppingListItemSeqId
				.name());
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		dontCancelSetUserLogin = (String) value
				.get(Fields.dontCancelSetUserLogin.name());
		isPromo = (String) value.get(Fields.isPromo.name());
		isModifiedPrice = (String) value.get(Fields.isModifiedPrice.name());
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
		fromInventoryItemId = (String) value.get(Fields.fromInventoryItemId
				.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		correspondingPoId = (String) value.get(Fields.correspondingPoId.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
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