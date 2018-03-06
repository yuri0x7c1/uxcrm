package org.apache.ofbiz.product.inventory.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item And Location
 */
public class InventoryItemAndLocation implements Serializable {

	public static final long serialVersionUID = 4226325731746909184L;
	public static final String NAME = "InventoryItemAndLocation";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Datetime Received
	 */
	@Getter
	@Setter
	private Timestamp datetimeReceived;
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
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
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
	 * Bin Number
	 */
	@Getter
	@Setter
	private String binNumber;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Accounting Quantity Total
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityTotal;
	/**
	 * Old Quantity On Hand
	 */
	@Getter
	@Setter
	private BigDecimal oldQuantityOnHand;
	/**
	 * Old Available To Promise
	 */
	@Getter
	@Setter
	private BigDecimal oldAvailableToPromise;
	/**
	 * Serial Number
	 */
	@Getter
	@Setter
	private String serialNumber;
	/**
	 * Soft Identifier
	 */
	@Getter
	@Setter
	private String softIdentifier;
	/**
	 * Activation Number
	 */
	@Getter
	@Setter
	private String activationNumber;
	/**
	 * Activation Valid Thru
	 */
	@Getter
	@Setter
	private Timestamp activationValidThru;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
	/**
	 * Primary Product Category Id
	 */
	@Getter
	@Setter
	private String primaryProductCategoryId;
	/**
	 * Manufacturer Party Id
	 */
	@Getter
	@Setter
	private String manufacturerPartyId;
	/**
	 * Introduction Date
	 */
	@Getter
	@Setter
	private Timestamp introductionDate;
	/**
	 * Release Date
	 */
	@Getter
	@Setter
	private Timestamp releaseDate;
	/**
	 * Support Discontinuation Date
	 */
	@Getter
	@Setter
	private Timestamp supportDiscontinuationDate;
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
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Brand Name
	 */
	@Getter
	@Setter
	private String brandName;
	/**
	 * Product Name
	 */
	@Getter
	@Setter
	private String productName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Price Detail Text
	 */
	@Getter
	@Setter
	private String priceDetailText;
	/**
	 * Small Image Url
	 */
	@Getter
	@Setter
	private String smallImageUrl;
	/**
	 * Medium Image Url
	 */
	@Getter
	@Setter
	private String mediumImageUrl;
	/**
	 * Large Image Url
	 */
	@Getter
	@Setter
	private String largeImageUrl;
	/**
	 * Detail Image Url
	 */
	@Getter
	@Setter
	private String detailImageUrl;
	/**
	 * Original Image Url
	 */
	@Getter
	@Setter
	private String originalImageUrl;
	/**
	 * Detail Screen
	 */
	@Getter
	@Setter
	private String detailScreen;
	/**
	 * Inventory Message
	 */
	@Getter
	@Setter
	private String inventoryMessage;
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
	 * Quantity Included
	 */
	@Getter
	@Setter
	private BigDecimal quantityIncluded;
	/**
	 * Pieces Included
	 */
	@Getter
	@Setter
	private Long piecesIncluded;
	/**
	 * Require Amount
	 */
	@Getter
	@Setter
	private String requireAmount;
	/**
	 * Fixed Amount
	 */
	@Getter
	@Setter
	private BigDecimal fixedAmount;
	/**
	 * Amount Uom Type Id
	 */
	@Getter
	@Setter
	private String amountUomTypeId;
	/**
	 * Weight Uom Id
	 */
	@Getter
	@Setter
	private String weightUomId;
	/**
	 * Shipping Weight
	 */
	@Getter
	@Setter
	private BigDecimal shippingWeight;
	/**
	 * Product Weight
	 */
	@Getter
	@Setter
	private BigDecimal productWeight;
	/**
	 * Height Uom Id
	 */
	@Getter
	@Setter
	private String heightUomId;
	/**
	 * Product Height
	 */
	@Getter
	@Setter
	private BigDecimal productHeight;
	/**
	 * Shipping Height
	 */
	@Getter
	@Setter
	private BigDecimal shippingHeight;
	/**
	 * Width Uom Id
	 */
	@Getter
	@Setter
	private String widthUomId;
	/**
	 * Product Width
	 */
	@Getter
	@Setter
	private BigDecimal productWidth;
	/**
	 * Shipping Width
	 */
	@Getter
	@Setter
	private BigDecimal shippingWidth;
	/**
	 * Depth Uom Id
	 */
	@Getter
	@Setter
	private String depthUomId;
	/**
	 * Product Depth
	 */
	@Getter
	@Setter
	private BigDecimal productDepth;
	/**
	 * Shipping Depth
	 */
	@Getter
	@Setter
	private BigDecimal shippingDepth;
	/**
	 * Diameter Uom Id
	 */
	@Getter
	@Setter
	private String diameterUomId;
	/**
	 * Product Diameter
	 */
	@Getter
	@Setter
	private BigDecimal productDiameter;
	/**
	 * Product Rating
	 */
	@Getter
	@Setter
	private BigDecimal productRating;
	/**
	 * Rating Type Enum
	 */
	@Getter
	@Setter
	private String ratingTypeEnum;
	/**
	 * Returnable
	 */
	@Getter
	@Setter
	private String returnable;
	/**
	 * Taxable
	 */
	@Getter
	@Setter
	private String taxable;
	/**
	 * Charge Shipping
	 */
	@Getter
	@Setter
	private String chargeShipping;
	/**
	 * Auto Create Keywords
	 */
	@Getter
	@Setter
	private String autoCreateKeywords;
	/**
	 * Include In Promotions
	 */
	@Getter
	@Setter
	private String includeInPromotions;
	/**
	 * Is Virtual
	 */
	@Getter
	@Setter
	private String isVirtual;
	/**
	 * Is Variant
	 */
	@Getter
	@Setter
	private String isVariant;
	/**
	 * Virtual Variant Method Enum
	 */
	@Getter
	@Setter
	private String virtualVariantMethodEnum;
	/**
	 * Origin Geo Id
	 */
	@Getter
	@Setter
	private String originGeoId;
	/**
	 * Requirement Method Enum Id
	 */
	@Getter
	@Setter
	private String requirementMethodEnumId;
	/**
	 * Bill Of Material Level
	 */
	@Getter
	@Setter
	private Long billOfMaterialLevel;
	/**
	 * Reserv Max Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservMaxPersons;
	/**
	 * Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reserv2ndPPPerc;
	/**
	 * Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reservNthPPPerc;
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * In Shipping Box
	 */
	@Getter
	@Setter
	private String inShippingBox;
	/**
	 * Default Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String defaultShipmentBoxTypeId;
	/**
	 * Lot Id Filled In
	 */
	@Getter
	@Setter
	private String lotIdFilledIn;
	/**
	 * Order Decimal Quantity
	 */
	@Getter
	@Setter
	private String orderDecimalQuantity;
	/**
	 * Location Type Enum Id
	 */
	@Getter
	@Setter
	private String locationTypeEnumId;
	/**
	 * Area Id
	 */
	@Getter
	@Setter
	private String areaId;
	/**
	 * Aisle Id
	 */
	@Getter
	@Setter
	private String aisleId;
	/**
	 * Section Id
	 */
	@Getter
	@Setter
	private String sectionId;
	/**
	 * Level Id
	 */
	@Getter
	@Setter
	private String levelId;
	/**
	 * Position Id
	 */
	@Getter
	@Setter
	private String positionId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;

	public enum Fields {
		inventoryItemId, inventoryItemTypeId, productId, partyId, ownerPartyId, statusId, datetimeReceived, datetimeManufactured, expireDate, facilityId, containerId, lotId, uomId, binNumber, locationSeqId, comments, quantityOnHandTotal, availableToPromiseTotal, accountingQuantityTotal, oldQuantityOnHand, oldAvailableToPromise, serialNumber, softIdentifier, activationNumber, activationValidThru, unitCost, currencyUomId, productTypeId, primaryProductCategoryId, manufacturerPartyId, introductionDate, releaseDate, supportDiscontinuationDate, salesDiscontinuationDate, salesDiscWhenNotAvail, internalName, brandName, productName, description, longDescription, priceDetailText, smallImageUrl, mediumImageUrl, largeImageUrl, detailImageUrl, originalImageUrl, detailScreen, inventoryMessage, requireInventory, quantityUomId, quantityIncluded, piecesIncluded, requireAmount, fixedAmount, amountUomTypeId, weightUomId, shippingWeight, productWeight, heightUomId, productHeight, shippingHeight, widthUomId, productWidth, shippingWidth, depthUomId, productDepth, shippingDepth, diameterUomId, productDiameter, productRating, ratingTypeEnum, returnable, taxable, chargeShipping, autoCreateKeywords, includeInPromotions, isVirtual, isVariant, virtualVariantMethodEnum, originGeoId, requirementMethodEnumId, billOfMaterialLevel, reservMaxPersons, reserv2ndPPPerc, reservNthPPPerc, configId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, inShippingBox, defaultShipmentBoxTypeId, lotIdFilledIn, orderDecimalQuantity, locationTypeEnumId, areaId, aisleId, sectionId, levelId, positionId, geoPointId
	}

	public InventoryItemAndLocation(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		productId = (String) value.get(Fields.productId.name());
		partyId = (String) value.get(Fields.partyId.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		statusId = (String) value.get(Fields.statusId.name());
		datetimeReceived = (Timestamp) value
				.get(Fields.datetimeReceived.name());
		datetimeManufactured = (Timestamp) value
				.get(Fields.datetimeManufactured.name());
		expireDate = (Timestamp) value.get(Fields.expireDate.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		containerId = (String) value.get(Fields.containerId.name());
		lotId = (String) value.get(Fields.lotId.name());
		uomId = (String) value.get(Fields.uomId.name());
		binNumber = (String) value.get(Fields.binNumber.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		comments = (String) value.get(Fields.comments.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		accountingQuantityTotal = (BigDecimal) value
				.get(Fields.accountingQuantityTotal.name());
		oldQuantityOnHand = (BigDecimal) value.get(Fields.oldQuantityOnHand
				.name());
		oldAvailableToPromise = (BigDecimal) value
				.get(Fields.oldAvailableToPromise.name());
		serialNumber = (String) value.get(Fields.serialNumber.name());
		softIdentifier = (String) value.get(Fields.softIdentifier.name());
		activationNumber = (String) value.get(Fields.activationNumber.name());
		activationValidThru = (Timestamp) value.get(Fields.activationValidThru
				.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		productTypeId = (String) value.get(Fields.productTypeId.name());
		primaryProductCategoryId = (String) value
				.get(Fields.primaryProductCategoryId.name());
		manufacturerPartyId = (String) value.get(Fields.manufacturerPartyId
				.name());
		introductionDate = (Timestamp) value
				.get(Fields.introductionDate.name());
		releaseDate = (Timestamp) value.get(Fields.releaseDate.name());
		supportDiscontinuationDate = (Timestamp) value
				.get(Fields.supportDiscontinuationDate.name());
		salesDiscontinuationDate = (Timestamp) value
				.get(Fields.salesDiscontinuationDate.name());
		salesDiscWhenNotAvail = (String) value.get(Fields.salesDiscWhenNotAvail
				.name());
		internalName = (String) value.get(Fields.internalName.name());
		brandName = (String) value.get(Fields.brandName.name());
		productName = (String) value.get(Fields.productName.name());
		description = (String) value.get(Fields.description.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		priceDetailText = (String) value.get(Fields.priceDetailText.name());
		smallImageUrl = (String) value.get(Fields.smallImageUrl.name());
		mediumImageUrl = (String) value.get(Fields.mediumImageUrl.name());
		largeImageUrl = (String) value.get(Fields.largeImageUrl.name());
		detailImageUrl = (String) value.get(Fields.detailImageUrl.name());
		originalImageUrl = (String) value.get(Fields.originalImageUrl.name());
		detailScreen = (String) value.get(Fields.detailScreen.name());
		inventoryMessage = (String) value.get(Fields.inventoryMessage.name());
		requireInventory = (String) value.get(Fields.requireInventory.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
		quantityIncluded = (BigDecimal) value.get(Fields.quantityIncluded
				.name());
		piecesIncluded = (Long) value.get(Fields.piecesIncluded.name());
		requireAmount = (String) value.get(Fields.requireAmount.name());
		fixedAmount = (BigDecimal) value.get(Fields.fixedAmount.name());
		amountUomTypeId = (String) value.get(Fields.amountUomTypeId.name());
		weightUomId = (String) value.get(Fields.weightUomId.name());
		shippingWeight = (BigDecimal) value.get(Fields.shippingWeight.name());
		productWeight = (BigDecimal) value.get(Fields.productWeight.name());
		heightUomId = (String) value.get(Fields.heightUomId.name());
		productHeight = (BigDecimal) value.get(Fields.productHeight.name());
		shippingHeight = (BigDecimal) value.get(Fields.shippingHeight.name());
		widthUomId = (String) value.get(Fields.widthUomId.name());
		productWidth = (BigDecimal) value.get(Fields.productWidth.name());
		shippingWidth = (BigDecimal) value.get(Fields.shippingWidth.name());
		depthUomId = (String) value.get(Fields.depthUomId.name());
		productDepth = (BigDecimal) value.get(Fields.productDepth.name());
		shippingDepth = (BigDecimal) value.get(Fields.shippingDepth.name());
		diameterUomId = (String) value.get(Fields.diameterUomId.name());
		productDiameter = (BigDecimal) value.get(Fields.productDiameter.name());
		productRating = (BigDecimal) value.get(Fields.productRating.name());
		ratingTypeEnum = (String) value.get(Fields.ratingTypeEnum.name());
		returnable = (String) value.get(Fields.returnable.name());
		taxable = (String) value.get(Fields.taxable.name());
		chargeShipping = (String) value.get(Fields.chargeShipping.name());
		autoCreateKeywords = (String) value.get(Fields.autoCreateKeywords
				.name());
		includeInPromotions = (String) value.get(Fields.includeInPromotions
				.name());
		isVirtual = (String) value.get(Fields.isVirtual.name());
		isVariant = (String) value.get(Fields.isVariant.name());
		virtualVariantMethodEnum = (String) value
				.get(Fields.virtualVariantMethodEnum.name());
		originGeoId = (String) value.get(Fields.originGeoId.name());
		requirementMethodEnumId = (String) value
				.get(Fields.requirementMethodEnumId.name());
		billOfMaterialLevel = (Long) value.get(Fields.billOfMaterialLevel
				.name());
		reservMaxPersons = (BigDecimal) value.get(Fields.reservMaxPersons
				.name());
		reserv2ndPPPerc = (BigDecimal) value.get(Fields.reserv2ndPPPerc.name());
		reservNthPPPerc = (BigDecimal) value.get(Fields.reservNthPPPerc.name());
		configId = (String) value.get(Fields.configId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		inShippingBox = (String) value.get(Fields.inShippingBox.name());
		defaultShipmentBoxTypeId = (String) value
				.get(Fields.defaultShipmentBoxTypeId.name());
		lotIdFilledIn = (String) value.get(Fields.lotIdFilledIn.name());
		orderDecimalQuantity = (String) value.get(Fields.orderDecimalQuantity
				.name());
		locationTypeEnumId = (String) value.get(Fields.locationTypeEnumId
				.name());
		areaId = (String) value.get(Fields.areaId.name());
		aisleId = (String) value.get(Fields.aisleId.name());
		sectionId = (String) value.get(Fields.sectionId.name());
		levelId = (String) value.get(Fields.levelId.name());
		positionId = (String) value.get(Fields.positionId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
	}

	public static InventoryItemAndLocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemAndLocation(value);
	}

	public static List<InventoryItemAndLocation> fromValues(
			List<GenericValue> values) {
		List<InventoryItemAndLocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemAndLocation(value));
		}
		return entities;
	}
}