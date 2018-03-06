package org.apache.ofbiz.product.supplier.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Supplier Product And Product
 */
public class SupplierProductAndProduct implements Serializable {

	public static final long serialVersionUID = 5704304375600195584L;
	public static final String NAME = "SupplierProductAndProduct";
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
	 * Available From Date
	 */
	@Getter
	@Setter
	private Timestamp availableFromDate;
	/**
	 * Available Thru Date
	 */
	@Getter
	@Setter
	private Timestamp availableThruDate;
	/**
	 * Supplier Pref Order Id
	 */
	@Getter
	@Setter
	private String supplierPrefOrderId;
	/**
	 * Supplier Rating Type Id
	 */
	@Getter
	@Setter
	private String supplierRatingTypeId;
	/**
	 * Standard Lead Time Days
	 */
	@Getter
	@Setter
	private BigDecimal standardLeadTimeDays;
	/**
	 * Minimum Order Quantity
	 */
	@Getter
	@Setter
	private BigDecimal minimumOrderQuantity;
	/**
	 * Order Qty Increments
	 */
	@Getter
	@Setter
	private BigDecimal orderQtyIncrements;
	/**
	 * Units Included
	 */
	@Getter
	@Setter
	private BigDecimal unitsIncluded;
	/**
	 * Quantity Uom Id
	 */
	@Getter
	@Setter
	private String quantityUomId;
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Last Price
	 */
	@Getter
	@Setter
	private BigDecimal lastPrice;
	/**
	 * Shipping Price
	 */
	@Getter
	@Setter
	private BigDecimal shippingPrice;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Supplier Product Name
	 */
	@Getter
	@Setter
	private String supplierProductName;
	/**
	 * Supplier Product Id
	 */
	@Getter
	@Setter
	private String supplierProductId;
	/**
	 * Can Drop Ship
	 */
	@Getter
	@Setter
	private String canDropShip;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
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
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Require Inventory
	 */
	@Getter
	@Setter
	private String requireInventory;
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

	public enum Fields {
		productId, partyId, availableFromDate, availableThruDate, supplierPrefOrderId, supplierRatingTypeId, standardLeadTimeDays, minimumOrderQuantity, orderQtyIncrements, unitsIncluded, quantityUomId, agreementId, agreementItemSeqId, lastPrice, shippingPrice, currencyUomId, supplierProductName, supplierProductId, canDropShip, comments, productTypeId, primaryProductCategoryId, manufacturerPartyId, facilityId, introductionDate, releaseDate, supportDiscontinuationDate, salesDiscontinuationDate, salesDiscWhenNotAvail, internalName, brandName, productName, description, longDescription, priceDetailText, smallImageUrl, mediumImageUrl, largeImageUrl, detailImageUrl, originalImageUrl, detailScreen, inventoryMessage, inventoryItemTypeId, requireInventory, quantityIncluded, piecesIncluded, requireAmount, fixedAmount, amountUomTypeId, weightUomId, shippingWeight, productWeight, heightUomId, productHeight, shippingHeight, widthUomId, productWidth, shippingWidth, depthUomId, productDepth, shippingDepth, diameterUomId, productDiameter, productRating, ratingTypeEnum, returnable, taxable, chargeShipping, autoCreateKeywords, includeInPromotions, isVirtual, isVariant, virtualVariantMethodEnum, originGeoId, requirementMethodEnumId, billOfMaterialLevel, reservMaxPersons, reserv2ndPPPerc, reservNthPPPerc, configId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, inShippingBox, defaultShipmentBoxTypeId, lotIdFilledIn, orderDecimalQuantity
	}

	public SupplierProductAndProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		partyId = (String) value.get(Fields.partyId.name());
		availableFromDate = (Timestamp) value.get(Fields.availableFromDate
				.name());
		availableThruDate = (Timestamp) value.get(Fields.availableThruDate
				.name());
		supplierPrefOrderId = (String) value.get(Fields.supplierPrefOrderId
				.name());
		supplierRatingTypeId = (String) value.get(Fields.supplierRatingTypeId
				.name());
		standardLeadTimeDays = (BigDecimal) value
				.get(Fields.standardLeadTimeDays.name());
		minimumOrderQuantity = (BigDecimal) value
				.get(Fields.minimumOrderQuantity.name());
		orderQtyIncrements = (BigDecimal) value.get(Fields.orderQtyIncrements
				.name());
		unitsIncluded = (BigDecimal) value.get(Fields.unitsIncluded.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		lastPrice = (BigDecimal) value.get(Fields.lastPrice.name());
		shippingPrice = (BigDecimal) value.get(Fields.shippingPrice.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		supplierProductName = (String) value.get(Fields.supplierProductName
				.name());
		supplierProductId = (String) value.get(Fields.supplierProductId.name());
		canDropShip = (String) value.get(Fields.canDropShip.name());
		comments = (String) value.get(Fields.comments.name());
		productTypeId = (String) value.get(Fields.productTypeId.name());
		primaryProductCategoryId = (String) value
				.get(Fields.primaryProductCategoryId.name());
		manufacturerPartyId = (String) value.get(Fields.manufacturerPartyId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
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
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		requireInventory = (String) value.get(Fields.requireInventory.name());
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
	}

	public static SupplierProductAndProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierProductAndProduct(value);
	}

	public static List<SupplierProductAndProduct> fromValues(
			List<GenericValue> values) {
		List<SupplierProductAndProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierProductAndProduct(value));
		}
		return entities;
	}
}