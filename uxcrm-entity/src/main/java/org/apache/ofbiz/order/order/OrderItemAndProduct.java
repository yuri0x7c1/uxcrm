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
 * Order Item And Product
 */
public class OrderItemAndProduct implements Serializable {

	public static final long serialVersionUID = 8812735381417497600L;
	public static final String NAME = "OrderItemAndProduct";
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
	 * Origin Geo Id
	 */
	@Getter
	@Setter
	private String originGeoId;
	/**
	 * Detail Screen
	 */
	@Getter
	@Setter
	private String detailScreen;
	/**
	 * Require Inventory
	 */
	@Getter
	@Setter
	private String requireInventory;
	/**
	 * Quantity Uom Id
	 */
	@Getter
	@Setter
	private String quantityUomId;
	/**
	 * Medium Image Url
	 */
	@Getter
	@Setter
	private String mediumImageUrl;
	/**
	 * Product Name
	 */
	@Getter
	@Setter
	private String productName;
	/**
	 * Introduction Date
	 */
	@Getter
	@Setter
	private Timestamp introductionDate;
	/**
	 * Shipping Height
	 */
	@Getter
	@Setter
	private BigDecimal shippingHeight;
	/**
	 * Original Image Url
	 */
	@Getter
	@Setter
	private String originalImageUrl;
	/**
	 * In Shipping Box
	 */
	@Getter
	@Setter
	private String inShippingBox;
	/**
	 * Detail Image Url
	 */
	@Getter
	@Setter
	private String detailImageUrl;
	/**
	 * Support Discontinuation Date
	 */
	@Getter
	@Setter
	private Timestamp supportDiscontinuationDate;
	/**
	 * Product Width
	 */
	@Getter
	@Setter
	private BigDecimal productWidth;
	/**
	 * Include In Promotions
	 */
	@Getter
	@Setter
	private String includeInPromotions;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Bill Of Material Level
	 */
	@Getter
	@Setter
	private Long billOfMaterialLevel;
	/**
	 * Lot Id Filled In
	 */
	@Getter
	@Setter
	private String lotIdFilledIn;
	/**
	 * Product Rating
	 */
	@Getter
	@Setter
	private BigDecimal productRating;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Brand Name
	 */
	@Getter
	@Setter
	private String brandName;
	/**
	 * Require Amount
	 */
	@Getter
	@Setter
	private String requireAmount;
	/**
	 * Small Image Url
	 */
	@Getter
	@Setter
	private String smallImageUrl;
	/**
	 * Taxable
	 */
	@Getter
	@Setter
	private String taxable;
	/**
	 * Primary Product Category Id
	 */
	@Getter
	@Setter
	private String primaryProductCategoryId;
	/**
	 * Sales Discontinuation Date
	 */
	@Getter
	@Setter
	private Timestamp salesDiscontinuationDate;
	/**
	 * Sales Disc When Not Avail
	 */
	@Getter
	@Setter
	private String salesDiscWhenNotAvail;
	/**
	 * Returnable
	 */
	@Getter
	@Setter
	private String returnable;
	/**
	 * Weight Uom Id
	 */
	@Getter
	@Setter
	private String weightUomId;
	/**
	 * Is Virtual
	 */
	@Getter
	@Setter
	private String isVirtual;
	/**
	 * Price Detail Text
	 */
	@Getter
	@Setter
	private String priceDetailText;
	/**
	 * Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reserv2ndPPPerc;
	/**
	 * Width Uom Id
	 */
	@Getter
	@Setter
	private String widthUomId;
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Diameter Uom Id
	 */
	@Getter
	@Setter
	private String diameterUomId;
	/**
	 * Auto Create Keywords
	 */
	@Getter
	@Setter
	private String autoCreateKeywords;
	/**
	 * Amount Uom Type Id
	 */
	@Getter
	@Setter
	private String amountUomTypeId;
	/**
	 * Product Diameter
	 */
	@Getter
	@Setter
	private BigDecimal productDiameter;
	/**
	 * Rating Type Enum
	 */
	@Getter
	@Setter
	private String ratingTypeEnum;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Charge Shipping
	 */
	@Getter
	@Setter
	private String chargeShipping;
	/**
	 * Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reservNthPPPerc;
	/**
	 * Quantity Included
	 */
	@Getter
	@Setter
	private BigDecimal quantityIncluded;
	/**
	 * Height Uom Id
	 */
	@Getter
	@Setter
	private String heightUomId;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Virtual Variant Method Enum
	 */
	@Getter
	@Setter
	private String virtualVariantMethodEnum;
	/**
	 * Shipping Weight
	 */
	@Getter
	@Setter
	private BigDecimal shippingWeight;
	/**
	 * Shipping Width
	 */
	@Getter
	@Setter
	private BigDecimal shippingWidth;
	/**
	 * Shipping Depth
	 */
	@Getter
	@Setter
	private BigDecimal shippingDepth;
	/**
	 * Reserv Max Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservMaxPersons;
	/**
	 * Fixed Amount
	 */
	@Getter
	@Setter
	private BigDecimal fixedAmount;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Pieces Included
	 */
	@Getter
	@Setter
	private Long piecesIncluded;
	/**
	 * Product Depth
	 */
	@Getter
	@Setter
	private BigDecimal productDepth;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Release Date
	 */
	@Getter
	@Setter
	private Timestamp releaseDate;
	/**
	 * Product Height
	 */
	@Getter
	@Setter
	private BigDecimal productHeight;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Default Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String defaultShipmentBoxTypeId;
	/**
	 * Order Decimal Quantity
	 */
	@Getter
	@Setter
	private String orderDecimalQuantity;
	/**
	 * Inventory Message
	 */
	@Getter
	@Setter
	private String inventoryMessage;
	/**
	 * Product Weight
	 */
	@Getter
	@Setter
	private BigDecimal productWeight;
	/**
	 * Depth Uom Id
	 */
	@Getter
	@Setter
	private String depthUomId;
	/**
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Is Variant
	 */
	@Getter
	@Setter
	private String isVariant;
	/**
	 * Large Image Url
	 */
	@Getter
	@Setter
	private String largeImageUrl;
	/**
	 * Requirement Method Enum Id
	 */
	@Getter
	@Setter
	private String requirementMethodEnumId;

	public enum Fields {
		orderId, deploymentId, cancelBackOrderDate, itemDescription, selectedAmount, orderItemSeqId, unitPrice, productId, unitRecurringPrice, isItemGroupPrimary, autoCancelDate, productFeatureId, overrideGlAccountId, budgetId, supplierProductId, estimatedDeliveryDate, quoteId, statusId, syncStatusId, estimatedShipDate, shoppingListItemSeqId, subscriptionId, salesOpportunityId, dontCancelSetUserLogin, isPromo, isModifiedPrice, shipBeforeDate, productCategoryId, shoppingListId, unitListPrice, unitAverageCost, orderItemTypeId, dontCancelSetDate, quantity, comments, recurringFreqUomId, orderItemGroupSeqId, quoteItemSeqId, externalId, fromInventoryItemId, budgetItemSeqId, correspondingPoId, cancelQuantity, shipAfterDate, changeByUserLoginId, prodCatalogId, originGeoId, detailScreen, requireInventory, quantityUomId, mediumImageUrl, productName, introductionDate, shippingHeight, originalImageUrl, inShippingBox, detailImageUrl, supportDiscontinuationDate, productWidth, includeInPromotions, configId, billOfMaterialLevel, lotIdFilledIn, productRating, createdByUserLogin, brandName, requireAmount, smallImageUrl, taxable, primaryProductCategoryId, salesDiscontinuationDate, salesDiscWhenNotAvail, returnable, weightUomId, isVirtual, priceDetailText, reserv2ndPPPerc, widthUomId, longDescription, diameterUomId, autoCreateKeywords, amountUomTypeId, productDiameter, ratingTypeEnum, description, chargeShipping, reservNthPPPerc, quantityIncluded, heightUomId, internalName, lastModifiedByUserLogin, virtualVariantMethodEnum, shippingWeight, shippingWidth, shippingDepth, reservMaxPersons, fixedAmount, inventoryItemTypeId, piecesIncluded, productDepth, facilityId, releaseDate, productHeight, lastModifiedDate, defaultShipmentBoxTypeId, orderDecimalQuantity, inventoryMessage, productWeight, depthUomId, productTypeId, createdDate, isVariant, largeImageUrl, requirementMethodEnumId
	}

	public OrderItemAndProduct(GenericValue value) {
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
		originGeoId = (String) value.get(Fields.originGeoId.name());
		detailScreen = (String) value.get(Fields.detailScreen.name());
		requireInventory = (String) value.get(Fields.requireInventory.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
		mediumImageUrl = (String) value.get(Fields.mediumImageUrl.name());
		productName = (String) value.get(Fields.productName.name());
		introductionDate = (Timestamp) value
				.get(Fields.introductionDate.name());
		shippingHeight = (BigDecimal) value.get(Fields.shippingHeight.name());
		originalImageUrl = (String) value.get(Fields.originalImageUrl.name());
		inShippingBox = (String) value.get(Fields.inShippingBox.name());
		detailImageUrl = (String) value.get(Fields.detailImageUrl.name());
		supportDiscontinuationDate = (Timestamp) value
				.get(Fields.supportDiscontinuationDate.name());
		productWidth = (BigDecimal) value.get(Fields.productWidth.name());
		includeInPromotions = (String) value.get(Fields.includeInPromotions
				.name());
		configId = (String) value.get(Fields.configId.name());
		billOfMaterialLevel = (Long) value.get(Fields.billOfMaterialLevel
				.name());
		lotIdFilledIn = (String) value.get(Fields.lotIdFilledIn.name());
		productRating = (BigDecimal) value.get(Fields.productRating.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		brandName = (String) value.get(Fields.brandName.name());
		requireAmount = (String) value.get(Fields.requireAmount.name());
		smallImageUrl = (String) value.get(Fields.smallImageUrl.name());
		taxable = (String) value.get(Fields.taxable.name());
		primaryProductCategoryId = (String) value
				.get(Fields.primaryProductCategoryId.name());
		salesDiscontinuationDate = (Timestamp) value
				.get(Fields.salesDiscontinuationDate.name());
		salesDiscWhenNotAvail = (String) value.get(Fields.salesDiscWhenNotAvail
				.name());
		returnable = (String) value.get(Fields.returnable.name());
		weightUomId = (String) value.get(Fields.weightUomId.name());
		isVirtual = (String) value.get(Fields.isVirtual.name());
		priceDetailText = (String) value.get(Fields.priceDetailText.name());
		reserv2ndPPPerc = (BigDecimal) value.get(Fields.reserv2ndPPPerc.name());
		widthUomId = (String) value.get(Fields.widthUomId.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		diameterUomId = (String) value.get(Fields.diameterUomId.name());
		autoCreateKeywords = (String) value.get(Fields.autoCreateKeywords
				.name());
		amountUomTypeId = (String) value.get(Fields.amountUomTypeId.name());
		productDiameter = (BigDecimal) value.get(Fields.productDiameter.name());
		ratingTypeEnum = (String) value.get(Fields.ratingTypeEnum.name());
		description = (String) value.get(Fields.description.name());
		chargeShipping = (String) value.get(Fields.chargeShipping.name());
		reservNthPPPerc = (BigDecimal) value.get(Fields.reservNthPPPerc.name());
		quantityIncluded = (BigDecimal) value.get(Fields.quantityIncluded
				.name());
		heightUomId = (String) value.get(Fields.heightUomId.name());
		internalName = (String) value.get(Fields.internalName.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		virtualVariantMethodEnum = (String) value
				.get(Fields.virtualVariantMethodEnum.name());
		shippingWeight = (BigDecimal) value.get(Fields.shippingWeight.name());
		shippingWidth = (BigDecimal) value.get(Fields.shippingWidth.name());
		shippingDepth = (BigDecimal) value.get(Fields.shippingDepth.name());
		reservMaxPersons = (BigDecimal) value.get(Fields.reservMaxPersons
				.name());
		fixedAmount = (BigDecimal) value.get(Fields.fixedAmount.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		piecesIncluded = (Long) value.get(Fields.piecesIncluded.name());
		productDepth = (BigDecimal) value.get(Fields.productDepth.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		releaseDate = (Timestamp) value.get(Fields.releaseDate.name());
		productHeight = (BigDecimal) value.get(Fields.productHeight.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		defaultShipmentBoxTypeId = (String) value
				.get(Fields.defaultShipmentBoxTypeId.name());
		orderDecimalQuantity = (String) value.get(Fields.orderDecimalQuantity
				.name());
		inventoryMessage = (String) value.get(Fields.inventoryMessage.name());
		productWeight = (BigDecimal) value.get(Fields.productWeight.name());
		depthUomId = (String) value.get(Fields.depthUomId.name());
		productTypeId = (String) value.get(Fields.productTypeId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		isVariant = (String) value.get(Fields.isVariant.name());
		largeImageUrl = (String) value.get(Fields.largeImageUrl.name());
		requirementMethodEnumId = (String) value
				.get(Fields.requirementMethodEnumId.name());
	}

	public static OrderItemAndProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAndProduct(value);
	}

	public static List<OrderItemAndProduct> fromValues(List<GenericValue> values) {
		List<OrderItemAndProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAndProduct(value));
		}
		return entities;
	}
}