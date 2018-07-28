package org.apache.ofbiz.product.product;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Inventory Item
 */
public class ProductInventoryItem implements Serializable {

	public static final long serialVersionUID = 2053969061268185088L;
	public static final String NAME = "ProductInventoryItem";
	/**
	 * Product Facility Id
	 */
	@Getter
	@Setter
	private String productFacilityId;
	/**
	 * Inventory Comments
	 */
	@Getter
	@Setter
	private String inventoryComments;
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
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
		productFacilityId, inventoryComments, originGeoId, detailScreen, requireInventory, quantityUomId, mediumImageUrl, productName, introductionDate, shippingHeight, originalImageUrl, inShippingBox, detailImageUrl, supportDiscontinuationDate, productWidth, includeInPromotions, configId, billOfMaterialLevel, lotIdFilledIn, productRating, createdByUserLogin, brandName, requireAmount, productId, smallImageUrl, taxable, primaryProductCategoryId, salesDiscontinuationDate, salesDiscWhenNotAvail, returnable, weightUomId, isVirtual, priceDetailText, reserv2ndPPPerc, widthUomId, longDescription, diameterUomId, autoCreateKeywords, amountUomTypeId, productDiameter, ratingTypeEnum, description, chargeShipping, reservNthPPPerc, quantityIncluded, heightUomId, internalName, lastModifiedByUserLogin, virtualVariantMethodEnum, shippingWeight, shippingWidth, shippingDepth, reservMaxPersons, fixedAmount, piecesIncluded, productDepth, comments, releaseDate, productHeight, lastModifiedDate, defaultShipmentBoxTypeId, orderDecimalQuantity, inventoryMessage, productWeight, depthUomId, productTypeId, createdDate, isVariant, largeImageUrl, requirementMethodEnumId, softIdentifier, binNumber, oldAvailableToPromise, quantityOnHandTotal, datetimeManufactured, expireDate, oldQuantityOnHand, partyId, containerId, availableToPromiseTotal, inventoryItemTypeId, locationSeqId, facilityId, serialNumber, lotId, uomId, accountingQuantityTotal, inventoryItemId, ownerPartyId, activationValidThru, activationNumber, currencyUomId, statusId, unitCost, fixedAssetId, datetimeReceived
	}

	public ProductInventoryItem(GenericValue value) {
		productFacilityId = (String) value.get(Fields.productFacilityId.name());
		inventoryComments = (String) value.get(Fields.inventoryComments.name());
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
		productId = (String) value.get(Fields.productId.name());
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
		piecesIncluded = (Long) value.get(Fields.piecesIncluded.name());
		productDepth = (BigDecimal) value.get(Fields.productDepth.name());
		comments = (String) value.get(Fields.comments.name());
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
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		activationValidThru = (Timestamp) value.get(Fields.activationValidThru
				.name());
		activationNumber = (String) value.get(Fields.activationNumber.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		datetimeReceived = (Timestamp) value
				.get(Fields.datetimeReceived.name());
	}

	public static ProductInventoryItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductInventoryItem(value);
	}

	public static List<ProductInventoryItem> fromValues(
			List<GenericValue> values) {
		List<ProductInventoryItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductInventoryItem(value));
		}
		return entities;
	}
}