package org.apache.ofbiz.order.order;

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
public class OrderItemAndShipGrpInvResAndItem implements Serializable {

	public static final long serialVersionUID = 303073677849120768L;
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

	public enum Fields {
		orderId, deploymentId, cancelBackOrderDate, itemDescription, selectedAmount, orderItemSeqId, unitPrice, productId, unitRecurringPrice, isItemGroupPrimary, autoCancelDate, productFeatureId, overrideGlAccountId, budgetId, supplierProductId, estimatedDeliveryDate, quoteId, statusId, syncStatusId, estimatedShipDate, shoppingListItemSeqId, subscriptionId, salesOpportunityId, dontCancelSetUserLogin, isPromo, isModifiedPrice, shipBeforeDate, productCategoryId, shoppingListId, unitListPrice, unitAverageCost, orderItemTypeId, dontCancelSetDate, quantity, comments, recurringFreqUomId, orderItemGroupSeqId, quoteItemSeqId, externalId, fromInventoryItemId, budgetItemSeqId, correspondingPoId, cancelQuantity, shipAfterDate, changeByUserLoginId, prodCatalogId, promisedDatetime, priority, shipGroupSeqId, sequenceId, oldPickStartDate, currentPromisedDate, inventoryItemId, quantityNotAvailable, createdDatetime, reserveOrderEnumId, reservedDatetime, softIdentifier, binNumber, oldAvailableToPromise, quantityOnHandTotal, datetimeManufactured, expireDate, oldQuantityOnHand, partyId, containerId, availableToPromiseTotal, inventoryItemTypeId, locationSeqId, facilityId, serialNumber, lotId, uomId, accountingQuantityTotal, ownerPartyId, activationValidThru, activationNumber, currencyUomId, unitCost, fixedAssetId, datetimeReceived
	}

	public OrderItemAndShipGrpInvResAndItem(GenericValue value) {
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
		quantity = (BigDecimal) value.get(Fields.quantity.name());
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
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		prodCatalogId = (String) value.get(Fields.prodCatalogId.name());
		promisedDatetime = (Timestamp) value
				.get(Fields.promisedDatetime.name());
		priority = (String) value.get(Fields.priority.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		sequenceId = (Long) value.get(Fields.sequenceId.name());
		oldPickStartDate = (Timestamp) value
				.get(Fields.oldPickStartDate.name());
		currentPromisedDate = (Timestamp) value.get(Fields.currentPromisedDate
				.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		quantityNotAvailable = (BigDecimal) value
				.get(Fields.quantityNotAvailable.name());
		createdDatetime = (Timestamp) value.get(Fields.createdDatetime.name());
		reserveOrderEnumId = (String) value.get(Fields.reserveOrderEnumId
				.name());
		reservedDatetime = (Timestamp) value
				.get(Fields.reservedDatetime.name());
		softIdentifier = (String) value.get(Fields.softIdentifier.name());
		binNumber = (String) value.get(Fields.binNumber.name());
		oldAvailableToPromise = (BigDecimal) value
				.get(Fields.oldAvailableToPromise.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		datetimeManufactured = (Timestamp) value
				.get(Fields.datetimeManufactured.name());
		expireDate = (Timestamp) value.get(Fields.expireDate.name());
		oldQuantityOnHand = (BigDecimal) value.get(Fields.oldQuantityOnHand
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		containerId = (String) value.get(Fields.containerId.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		serialNumber = (String) value.get(Fields.serialNumber.name());
		lotId = (String) value.get(Fields.lotId.name());
		uomId = (String) value.get(Fields.uomId.name());
		accountingQuantityTotal = (BigDecimal) value
				.get(Fields.accountingQuantityTotal.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		activationValidThru = (Timestamp) value.get(Fields.activationValidThru
				.name());
		activationNumber = (String) value.get(Fields.activationNumber.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		datetimeReceived = (Timestamp) value
				.get(Fields.datetimeReceived.name());
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