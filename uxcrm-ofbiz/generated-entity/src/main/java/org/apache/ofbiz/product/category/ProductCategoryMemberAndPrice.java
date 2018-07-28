package org.apache.ofbiz.product.category;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Member And Price
 */
public class ProductCategoryMemberAndPrice implements Serializable {

	public static final long serialVersionUID = 7421340693077705728L;
	public static final String NAME = "ProductCategoryMemberAndPrice";
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Product Origin Geo Id
	 */
	@Getter
	@Setter
	private String productOriginGeoId;
	/**
	 * Product Detail Screen
	 */
	@Getter
	@Setter
	private String productDetailScreen;
	/**
	 * Product Require Inventory
	 */
	@Getter
	@Setter
	private String productRequireInventory;
	/**
	 * Product Quantity Uom Id
	 */
	@Getter
	@Setter
	private String productQuantityUomId;
	/**
	 * Product Medium Image Url
	 */
	@Getter
	@Setter
	private String productMediumImageUrl;
	/**
	 * Product Product Name
	 */
	@Getter
	@Setter
	private String productProductName;
	/**
	 * Product Introduction Date
	 */
	@Getter
	@Setter
	private Timestamp productIntroductionDate;
	/**
	 * Product Shipping Height
	 */
	@Getter
	@Setter
	private BigDecimal productShippingHeight;
	/**
	 * Product Original Image Url
	 */
	@Getter
	@Setter
	private String productOriginalImageUrl;
	/**
	 * Product In Shipping Box
	 */
	@Getter
	@Setter
	private String productInShippingBox;
	/**
	 * Product Detail Image Url
	 */
	@Getter
	@Setter
	private String productDetailImageUrl;
	/**
	 * Product Support Discontinuation Date
	 */
	@Getter
	@Setter
	private Timestamp productSupportDiscontinuationDate;
	/**
	 * Product Product Width
	 */
	@Getter
	@Setter
	private BigDecimal productProductWidth;
	/**
	 * Product Include In Promotions
	 */
	@Getter
	@Setter
	private String productIncludeInPromotions;
	/**
	 * Product Config Id
	 */
	@Getter
	@Setter
	private String productConfigId;
	/**
	 * Product Bill Of Material Level
	 */
	@Getter
	@Setter
	private Long productBillOfMaterialLevel;
	/**
	 * Product Lot Id Filled In
	 */
	@Getter
	@Setter
	private String productLotIdFilledIn;
	/**
	 * Product Product Rating
	 */
	@Getter
	@Setter
	private BigDecimal productProductRating;
	/**
	 * Product Created By User Login
	 */
	@Getter
	@Setter
	private String productCreatedByUserLogin;
	/**
	 * Product Brand Name
	 */
	@Getter
	@Setter
	private String productBrandName;
	/**
	 * Product Require Amount
	 */
	@Getter
	@Setter
	private String productRequireAmount;
	/**
	 * Product Small Image Url
	 */
	@Getter
	@Setter
	private String productSmallImageUrl;
	/**
	 * Product Taxable
	 */
	@Getter
	@Setter
	private String productTaxable;
	/**
	 * Product Primary Product Category Id
	 */
	@Getter
	@Setter
	private String productPrimaryProductCategoryId;
	/**
	 * Product Sales Discontinuation Date
	 */
	@Getter
	@Setter
	private Timestamp productSalesDiscontinuationDate;
	/**
	 * Product Sales Disc When Not Avail
	 */
	@Getter
	@Setter
	private String productSalesDiscWhenNotAvail;
	/**
	 * Product Returnable
	 */
	@Getter
	@Setter
	private String productReturnable;
	/**
	 * Product Weight Uom Id
	 */
	@Getter
	@Setter
	private String productWeightUomId;
	/**
	 * Product Is Virtual
	 */
	@Getter
	@Setter
	private String productIsVirtual;
	/**
	 * Product Price Detail Text
	 */
	@Getter
	@Setter
	private String productPriceDetailText;
	/**
	 * Product Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal productReserv2ndPPPerc;
	/**
	 * Product Width Uom Id
	 */
	@Getter
	@Setter
	private String productWidthUomId;
	/**
	 * Product Long Description
	 */
	@Getter
	@Setter
	private String productLongDescription;
	/**
	 * Product Diameter Uom Id
	 */
	@Getter
	@Setter
	private String productDiameterUomId;
	/**
	 * Product Auto Create Keywords
	 */
	@Getter
	@Setter
	private String productAutoCreateKeywords;
	/**
	 * Product Amount Uom Type Id
	 */
	@Getter
	@Setter
	private String productAmountUomTypeId;
	/**
	 * Product Product Diameter
	 */
	@Getter
	@Setter
	private BigDecimal productProductDiameter;
	/**
	 * Product Rating Type Enum
	 */
	@Getter
	@Setter
	private String productRatingTypeEnum;
	/**
	 * Product Description
	 */
	@Getter
	@Setter
	private String productDescription;
	/**
	 * Product Charge Shipping
	 */
	@Getter
	@Setter
	private String productChargeShipping;
	/**
	 * Product Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal productReservNthPPPerc;
	/**
	 * Product Quantity Included
	 */
	@Getter
	@Setter
	private BigDecimal productQuantityIncluded;
	/**
	 * Product Height Uom Id
	 */
	@Getter
	@Setter
	private String productHeightUomId;
	/**
	 * Product Internal Name
	 */
	@Getter
	@Setter
	private String productInternalName;
	/**
	 * Product Last Modified By User Login
	 */
	@Getter
	@Setter
	private String productLastModifiedByUserLogin;
	/**
	 * Product Virtual Variant Method Enum
	 */
	@Getter
	@Setter
	private String productVirtualVariantMethodEnum;
	/**
	 * Product Shipping Weight
	 */
	@Getter
	@Setter
	private BigDecimal productShippingWeight;
	/**
	 * Product Shipping Width
	 */
	@Getter
	@Setter
	private BigDecimal productShippingWidth;
	/**
	 * Product Shipping Depth
	 */
	@Getter
	@Setter
	private BigDecimal productShippingDepth;
	/**
	 * Product Reserv Max Persons
	 */
	@Getter
	@Setter
	private BigDecimal productReservMaxPersons;
	/**
	 * Product Fixed Amount
	 */
	@Getter
	@Setter
	private BigDecimal productFixedAmount;
	/**
	 * Product Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String productInventoryItemTypeId;
	/**
	 * Product Pieces Included
	 */
	@Getter
	@Setter
	private Long productPiecesIncluded;
	/**
	 * Product Product Depth
	 */
	@Getter
	@Setter
	private BigDecimal productProductDepth;
	/**
	 * Product Facility Id
	 */
	@Getter
	@Setter
	private String productFacilityId;
	/**
	 * Product Comments
	 */
	@Getter
	@Setter
	private String productComments;
	/**
	 * Product Release Date
	 */
	@Getter
	@Setter
	private Timestamp productReleaseDate;
	/**
	 * Product Product Height
	 */
	@Getter
	@Setter
	private BigDecimal productProductHeight;
	/**
	 * Product Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp productLastModifiedDate;
	/**
	 * Product Default Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String productDefaultShipmentBoxTypeId;
	/**
	 * Product Order Decimal Quantity
	 */
	@Getter
	@Setter
	private String productOrderDecimalQuantity;
	/**
	 * Product Inventory Message
	 */
	@Getter
	@Setter
	private String productInventoryMessage;
	/**
	 * Product Product Weight
	 */
	@Getter
	@Setter
	private BigDecimal productProductWeight;
	/**
	 * Product Depth Uom Id
	 */
	@Getter
	@Setter
	private String productDepthUomId;
	/**
	 * Product Product Type Id
	 */
	@Getter
	@Setter
	private String productProductTypeId;
	/**
	 * Product Created Date
	 */
	@Getter
	@Setter
	private Timestamp productCreatedDate;
	/**
	 * Product Is Variant
	 */
	@Getter
	@Setter
	private String productIsVariant;
	/**
	 * Product Large Image Url
	 */
	@Getter
	@Setter
	private String productLargeImageUrl;
	/**
	 * Product Requirement Method Enum Id
	 */
	@Getter
	@Setter
	private String productRequirementMethodEnumId;
	/**
	 * Price Tax In Price
	 */
	@Getter
	@Setter
	private String priceTaxInPrice;
	/**
	 * Price Term Uom Id
	 */
	@Getter
	@Setter
	private String priceTermUomId;
	/**
	 * Price Price With Tax
	 */
	@Getter
	@Setter
	private BigDecimal pricePriceWithTax;
	/**
	 * Price Product Store Group Id
	 */
	@Getter
	@Setter
	private String priceProductStoreGroupId;
	/**
	 * Price Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String priceTaxAuthPartyId;
	/**
	 * Price Last Modified By User Login
	 */
	@Getter
	@Setter
	private String priceLastModifiedByUserLogin;
	/**
	 * Price Custom Price Calc Service
	 */
	@Getter
	@Setter
	private String priceCustomPriceCalcService;
	/**
	 * Price Price
	 */
	@Getter
	@Setter
	private BigDecimal pricePrice;
	/**
	 * Price Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String priceTaxAuthGeoId;
	/**
	 * Price Product Price Purpose Id
	 */
	@Getter
	@Setter
	private String priceProductPricePurposeId;
	/**
	 * Price Created By User Login
	 */
	@Getter
	@Setter
	private String priceCreatedByUserLogin;
	/**
	 * Price Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp priceLastModifiedDate;
	/**
	 * Price Tax Percentage
	 */
	@Getter
	@Setter
	private BigDecimal priceTaxPercentage;
	/**
	 * Price Thru Date
	 */
	@Getter
	@Setter
	private Timestamp priceThruDate;
	/**
	 * Price From Date
	 */
	@Getter
	@Setter
	private Timestamp priceFromDate;
	/**
	 * Price Currency Uom Id
	 */
	@Getter
	@Setter
	private String priceCurrencyUomId;
	/**
	 * Price Created Date
	 */
	@Getter
	@Setter
	private Timestamp priceCreatedDate;
	/**
	 * Price Price Without Tax
	 */
	@Getter
	@Setter
	private BigDecimal pricePriceWithoutTax;
	/**
	 * Price Tax Amount
	 */
	@Getter
	@Setter
	private BigDecimal priceTaxAmount;
	/**
	 * Price Product Price Type Id
	 */
	@Getter
	@Setter
	private String priceProductPriceTypeId;

	public enum Fields {
		fromDate, productCategoryId, comments, quantity, productId, sequenceNum, thruDate, productOriginGeoId, productDetailScreen, productRequireInventory, productQuantityUomId, productMediumImageUrl, productProductName, productIntroductionDate, productShippingHeight, productOriginalImageUrl, productInShippingBox, productDetailImageUrl, productSupportDiscontinuationDate, productProductWidth, productIncludeInPromotions, productConfigId, productBillOfMaterialLevel, productLotIdFilledIn, productProductRating, productCreatedByUserLogin, productBrandName, productRequireAmount, productSmallImageUrl, productTaxable, productPrimaryProductCategoryId, productSalesDiscontinuationDate, productSalesDiscWhenNotAvail, productReturnable, productWeightUomId, productIsVirtual, productPriceDetailText, productReserv2ndPPPerc, productWidthUomId, productLongDescription, productDiameterUomId, productAutoCreateKeywords, productAmountUomTypeId, productProductDiameter, productRatingTypeEnum, productDescription, productChargeShipping, productReservNthPPPerc, productQuantityIncluded, productHeightUomId, productInternalName, productLastModifiedByUserLogin, productVirtualVariantMethodEnum, productShippingWeight, productShippingWidth, productShippingDepth, productReservMaxPersons, productFixedAmount, productInventoryItemTypeId, productPiecesIncluded, productProductDepth, productFacilityId, productComments, productReleaseDate, productProductHeight, productLastModifiedDate, productDefaultShipmentBoxTypeId, productOrderDecimalQuantity, productInventoryMessage, productProductWeight, productDepthUomId, productProductTypeId, productCreatedDate, productIsVariant, productLargeImageUrl, productRequirementMethodEnumId, priceTaxInPrice, priceTermUomId, pricePriceWithTax, priceProductStoreGroupId, priceTaxAuthPartyId, priceLastModifiedByUserLogin, priceCustomPriceCalcService, pricePrice, priceTaxAuthGeoId, priceProductPricePurposeId, priceCreatedByUserLogin, priceLastModifiedDate, priceTaxPercentage, priceThruDate, priceFromDate, priceCurrencyUomId, priceCreatedDate, pricePriceWithoutTax, priceTaxAmount, priceProductPriceTypeId
	}

	public ProductCategoryMemberAndPrice(GenericValue value) {
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		comments = (String) value.get(Fields.comments.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		productId = (String) value.get(Fields.productId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		productOriginGeoId = (String) value.get(Fields.productOriginGeoId
				.name());
		productDetailScreen = (String) value.get(Fields.productDetailScreen
				.name());
		productRequireInventory = (String) value
				.get(Fields.productRequireInventory.name());
		productQuantityUomId = (String) value.get(Fields.productQuantityUomId
				.name());
		productMediumImageUrl = (String) value.get(Fields.productMediumImageUrl
				.name());
		productProductName = (String) value.get(Fields.productProductName
				.name());
		productIntroductionDate = (Timestamp) value
				.get(Fields.productIntroductionDate.name());
		productShippingHeight = (BigDecimal) value
				.get(Fields.productShippingHeight.name());
		productOriginalImageUrl = (String) value
				.get(Fields.productOriginalImageUrl.name());
		productInShippingBox = (String) value.get(Fields.productInShippingBox
				.name());
		productDetailImageUrl = (String) value.get(Fields.productDetailImageUrl
				.name());
		productSupportDiscontinuationDate = (Timestamp) value
				.get(Fields.productSupportDiscontinuationDate.name());
		productProductWidth = (BigDecimal) value.get(Fields.productProductWidth
				.name());
		productIncludeInPromotions = (String) value
				.get(Fields.productIncludeInPromotions.name());
		productConfigId = (String) value.get(Fields.productConfigId.name());
		productBillOfMaterialLevel = (Long) value
				.get(Fields.productBillOfMaterialLevel.name());
		productLotIdFilledIn = (String) value.get(Fields.productLotIdFilledIn
				.name());
		productProductRating = (BigDecimal) value
				.get(Fields.productProductRating.name());
		productCreatedByUserLogin = (String) value
				.get(Fields.productCreatedByUserLogin.name());
		productBrandName = (String) value.get(Fields.productBrandName.name());
		productRequireAmount = (String) value.get(Fields.productRequireAmount
				.name());
		productSmallImageUrl = (String) value.get(Fields.productSmallImageUrl
				.name());
		productTaxable = (String) value.get(Fields.productTaxable.name());
		productPrimaryProductCategoryId = (String) value
				.get(Fields.productPrimaryProductCategoryId.name());
		productSalesDiscontinuationDate = (Timestamp) value
				.get(Fields.productSalesDiscontinuationDate.name());
		productSalesDiscWhenNotAvail = (String) value
				.get(Fields.productSalesDiscWhenNotAvail.name());
		productReturnable = (String) value.get(Fields.productReturnable.name());
		productWeightUomId = (String) value.get(Fields.productWeightUomId
				.name());
		productIsVirtual = (String) value.get(Fields.productIsVirtual.name());
		productPriceDetailText = (String) value
				.get(Fields.productPriceDetailText.name());
		productReserv2ndPPPerc = (BigDecimal) value
				.get(Fields.productReserv2ndPPPerc.name());
		productWidthUomId = (String) value.get(Fields.productWidthUomId.name());
		productLongDescription = (String) value
				.get(Fields.productLongDescription.name());
		productDiameterUomId = (String) value.get(Fields.productDiameterUomId
				.name());
		productAutoCreateKeywords = (String) value
				.get(Fields.productAutoCreateKeywords.name());
		productAmountUomTypeId = (String) value
				.get(Fields.productAmountUomTypeId.name());
		productProductDiameter = (BigDecimal) value
				.get(Fields.productProductDiameter.name());
		productRatingTypeEnum = (String) value.get(Fields.productRatingTypeEnum
				.name());
		productDescription = (String) value.get(Fields.productDescription
				.name());
		productChargeShipping = (String) value.get(Fields.productChargeShipping
				.name());
		productReservNthPPPerc = (BigDecimal) value
				.get(Fields.productReservNthPPPerc.name());
		productQuantityIncluded = (BigDecimal) value
				.get(Fields.productQuantityIncluded.name());
		productHeightUomId = (String) value.get(Fields.productHeightUomId
				.name());
		productInternalName = (String) value.get(Fields.productInternalName
				.name());
		productLastModifiedByUserLogin = (String) value
				.get(Fields.productLastModifiedByUserLogin.name());
		productVirtualVariantMethodEnum = (String) value
				.get(Fields.productVirtualVariantMethodEnum.name());
		productShippingWeight = (BigDecimal) value
				.get(Fields.productShippingWeight.name());
		productShippingWidth = (BigDecimal) value
				.get(Fields.productShippingWidth.name());
		productShippingDepth = (BigDecimal) value
				.get(Fields.productShippingDepth.name());
		productReservMaxPersons = (BigDecimal) value
				.get(Fields.productReservMaxPersons.name());
		productFixedAmount = (BigDecimal) value.get(Fields.productFixedAmount
				.name());
		productInventoryItemTypeId = (String) value
				.get(Fields.productInventoryItemTypeId.name());
		productPiecesIncluded = (Long) value.get(Fields.productPiecesIncluded
				.name());
		productProductDepth = (BigDecimal) value.get(Fields.productProductDepth
				.name());
		productFacilityId = (String) value.get(Fields.productFacilityId.name());
		productComments = (String) value.get(Fields.productComments.name());
		productReleaseDate = (Timestamp) value.get(Fields.productReleaseDate
				.name());
		productProductHeight = (BigDecimal) value
				.get(Fields.productProductHeight.name());
		productLastModifiedDate = (Timestamp) value
				.get(Fields.productLastModifiedDate.name());
		productDefaultShipmentBoxTypeId = (String) value
				.get(Fields.productDefaultShipmentBoxTypeId.name());
		productOrderDecimalQuantity = (String) value
				.get(Fields.productOrderDecimalQuantity.name());
		productInventoryMessage = (String) value
				.get(Fields.productInventoryMessage.name());
		productProductWeight = (BigDecimal) value
				.get(Fields.productProductWeight.name());
		productDepthUomId = (String) value.get(Fields.productDepthUomId.name());
		productProductTypeId = (String) value.get(Fields.productProductTypeId
				.name());
		productCreatedDate = (Timestamp) value.get(Fields.productCreatedDate
				.name());
		productIsVariant = (String) value.get(Fields.productIsVariant.name());
		productLargeImageUrl = (String) value.get(Fields.productLargeImageUrl
				.name());
		productRequirementMethodEnumId = (String) value
				.get(Fields.productRequirementMethodEnumId.name());
		priceTaxInPrice = (String) value.get(Fields.priceTaxInPrice.name());
		priceTermUomId = (String) value.get(Fields.priceTermUomId.name());
		pricePriceWithTax = (BigDecimal) value.get(Fields.pricePriceWithTax
				.name());
		priceProductStoreGroupId = (String) value
				.get(Fields.priceProductStoreGroupId.name());
		priceTaxAuthPartyId = (String) value.get(Fields.priceTaxAuthPartyId
				.name());
		priceLastModifiedByUserLogin = (String) value
				.get(Fields.priceLastModifiedByUserLogin.name());
		priceCustomPriceCalcService = (String) value
				.get(Fields.priceCustomPriceCalcService.name());
		pricePrice = (BigDecimal) value.get(Fields.pricePrice.name());
		priceTaxAuthGeoId = (String) value.get(Fields.priceTaxAuthGeoId.name());
		priceProductPricePurposeId = (String) value
				.get(Fields.priceProductPricePurposeId.name());
		priceCreatedByUserLogin = (String) value
				.get(Fields.priceCreatedByUserLogin.name());
		priceLastModifiedDate = (Timestamp) value
				.get(Fields.priceLastModifiedDate.name());
		priceTaxPercentage = (BigDecimal) value.get(Fields.priceTaxPercentage
				.name());
		priceThruDate = (Timestamp) value.get(Fields.priceThruDate.name());
		priceFromDate = (Timestamp) value.get(Fields.priceFromDate.name());
		priceCurrencyUomId = (String) value.get(Fields.priceCurrencyUomId
				.name());
		priceCreatedDate = (Timestamp) value
				.get(Fields.priceCreatedDate.name());
		pricePriceWithoutTax = (BigDecimal) value
				.get(Fields.pricePriceWithoutTax.name());
		priceTaxAmount = (BigDecimal) value.get(Fields.priceTaxAmount.name());
		priceProductPriceTypeId = (String) value
				.get(Fields.priceProductPriceTypeId.name());
	}

	public static ProductCategoryMemberAndPrice fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryMemberAndPrice(value);
	}

	public static List<ProductCategoryMemberAndPrice> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryMemberAndPrice> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryMemberAndPrice(value));
		}
		return entities;
	}
}