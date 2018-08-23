package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductCategoryMemberAndPrice implements Serializable {

	public static final long serialVersionUID = 216188863186124800L;
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
	 * Product Manufacturer Party Id
	 */
	@Getter
	@Setter
	private String productManufacturerPartyId;
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

	public ProductCategoryMemberAndPrice(GenericValue value) {
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		productOriginGeoId = (String) value.get(FIELD_PRODUCT_ORIGIN_GEO_ID);
		productDetailScreen = (String) value.get(FIELD_PRODUCT_DETAIL_SCREEN);
		productRequireInventory = (String) value
				.get(FIELD_PRODUCT_REQUIRE_INVENTORY);
		productQuantityUomId = (String) value
				.get(FIELD_PRODUCT_QUANTITY_UOM_ID);
		productMediumImageUrl = (String) value
				.get(FIELD_PRODUCT_MEDIUM_IMAGE_URL);
		productProductName = (String) value.get(FIELD_PRODUCT_PRODUCT_NAME);
		productIntroductionDate = (Timestamp) value
				.get(FIELD_PRODUCT_INTRODUCTION_DATE);
		productShippingHeight = (BigDecimal) value
				.get(FIELD_PRODUCT_SHIPPING_HEIGHT);
		productOriginalImageUrl = (String) value
				.get(FIELD_PRODUCT_ORIGINAL_IMAGE_URL);
		productInShippingBox = (String) value
				.get(FIELD_PRODUCT_IN_SHIPPING_BOX);
		productDetailImageUrl = (String) value
				.get(FIELD_PRODUCT_DETAIL_IMAGE_URL);
		productSupportDiscontinuationDate = (Timestamp) value
				.get(FIELD_PRODUCT_SUPPORT_DISCONTINUATION_DATE);
		productProductWidth = (BigDecimal) value
				.get(FIELD_PRODUCT_PRODUCT_WIDTH);
		productIncludeInPromotions = (String) value
				.get(FIELD_PRODUCT_INCLUDE_IN_PROMOTIONS);
		productConfigId = (String) value.get(FIELD_PRODUCT_CONFIG_ID);
		productBillOfMaterialLevel = (Long) value
				.get(FIELD_PRODUCT_BILL_OF_MATERIAL_LEVEL);
		productLotIdFilledIn = (String) value
				.get(FIELD_PRODUCT_LOT_ID_FILLED_IN);
		productProductRating = (BigDecimal) value
				.get(FIELD_PRODUCT_PRODUCT_RATING);
		productCreatedByUserLogin = (String) value
				.get(FIELD_PRODUCT_CREATED_BY_USER_LOGIN);
		productManufacturerPartyId = (String) value
				.get(FIELD_PRODUCT_MANUFACTURER_PARTY_ID);
		productBrandName = (String) value.get(FIELD_PRODUCT_BRAND_NAME);
		productRequireAmount = (String) value.get(FIELD_PRODUCT_REQUIRE_AMOUNT);
		productSmallImageUrl = (String) value
				.get(FIELD_PRODUCT_SMALL_IMAGE_URL);
		productTaxable = (String) value.get(FIELD_PRODUCT_TAXABLE);
		productPrimaryProductCategoryId = (String) value
				.get(FIELD_PRODUCT_PRIMARY_PRODUCT_CATEGORY_ID);
		productSalesDiscontinuationDate = (Timestamp) value
				.get(FIELD_PRODUCT_SALES_DISCONTINUATION_DATE);
		productSalesDiscWhenNotAvail = (String) value
				.get(FIELD_PRODUCT_SALES_DISC_WHEN_NOT_AVAIL);
		productReturnable = (String) value.get(FIELD_PRODUCT_RETURNABLE);
		productWeightUomId = (String) value.get(FIELD_PRODUCT_WEIGHT_UOM_ID);
		productIsVirtual = (String) value.get(FIELD_PRODUCT_IS_VIRTUAL);
		productPriceDetailText = (String) value
				.get(FIELD_PRODUCT_PRICE_DETAIL_TEXT);
		productReserv2ndPPPerc = (BigDecimal) value
				.get(FIELD_PRODUCT_RESERV2ND_P_P_PERC);
		productWidthUomId = (String) value.get(FIELD_PRODUCT_WIDTH_UOM_ID);
		productLongDescription = (String) value
				.get(FIELD_PRODUCT_LONG_DESCRIPTION);
		productDiameterUomId = (String) value
				.get(FIELD_PRODUCT_DIAMETER_UOM_ID);
		productAutoCreateKeywords = (String) value
				.get(FIELD_PRODUCT_AUTO_CREATE_KEYWORDS);
		productAmountUomTypeId = (String) value
				.get(FIELD_PRODUCT_AMOUNT_UOM_TYPE_ID);
		productProductDiameter = (BigDecimal) value
				.get(FIELD_PRODUCT_PRODUCT_DIAMETER);
		productRatingTypeEnum = (String) value
				.get(FIELD_PRODUCT_RATING_TYPE_ENUM);
		productDescription = (String) value.get(FIELD_PRODUCT_DESCRIPTION);
		productChargeShipping = (String) value
				.get(FIELD_PRODUCT_CHARGE_SHIPPING);
		productReservNthPPPerc = (BigDecimal) value
				.get(FIELD_PRODUCT_RESERV_NTH_P_P_PERC);
		productQuantityIncluded = (BigDecimal) value
				.get(FIELD_PRODUCT_QUANTITY_INCLUDED);
		productHeightUomId = (String) value.get(FIELD_PRODUCT_HEIGHT_UOM_ID);
		productInternalName = (String) value.get(FIELD_PRODUCT_INTERNAL_NAME);
		productLastModifiedByUserLogin = (String) value
				.get(FIELD_PRODUCT_LAST_MODIFIED_BY_USER_LOGIN);
		productVirtualVariantMethodEnum = (String) value
				.get(FIELD_PRODUCT_VIRTUAL_VARIANT_METHOD_ENUM);
		productShippingWeight = (BigDecimal) value
				.get(FIELD_PRODUCT_SHIPPING_WEIGHT);
		productShippingWidth = (BigDecimal) value
				.get(FIELD_PRODUCT_SHIPPING_WIDTH);
		productShippingDepth = (BigDecimal) value
				.get(FIELD_PRODUCT_SHIPPING_DEPTH);
		productReservMaxPersons = (BigDecimal) value
				.get(FIELD_PRODUCT_RESERV_MAX_PERSONS);
		productFixedAmount = (BigDecimal) value.get(FIELD_PRODUCT_FIXED_AMOUNT);
		productInventoryItemTypeId = (String) value
				.get(FIELD_PRODUCT_INVENTORY_ITEM_TYPE_ID);
		productPiecesIncluded = (Long) value.get(FIELD_PRODUCT_PIECES_INCLUDED);
		productProductDepth = (BigDecimal) value
				.get(FIELD_PRODUCT_PRODUCT_DEPTH);
		productFacilityId = (String) value.get(FIELD_PRODUCT_FACILITY_ID);
		productComments = (String) value.get(FIELD_PRODUCT_COMMENTS);
		productReleaseDate = (Timestamp) value.get(FIELD_PRODUCT_RELEASE_DATE);
		productProductHeight = (BigDecimal) value
				.get(FIELD_PRODUCT_PRODUCT_HEIGHT);
		productLastModifiedDate = (Timestamp) value
				.get(FIELD_PRODUCT_LAST_MODIFIED_DATE);
		productDefaultShipmentBoxTypeId = (String) value
				.get(FIELD_PRODUCT_DEFAULT_SHIPMENT_BOX_TYPE_ID);
		productOrderDecimalQuantity = (String) value
				.get(FIELD_PRODUCT_ORDER_DECIMAL_QUANTITY);
		productInventoryMessage = (String) value
				.get(FIELD_PRODUCT_INVENTORY_MESSAGE);
		productProductWeight = (BigDecimal) value
				.get(FIELD_PRODUCT_PRODUCT_WEIGHT);
		productDepthUomId = (String) value.get(FIELD_PRODUCT_DEPTH_UOM_ID);
		productProductTypeId = (String) value
				.get(FIELD_PRODUCT_PRODUCT_TYPE_ID);
		productCreatedDate = (Timestamp) value.get(FIELD_PRODUCT_CREATED_DATE);
		productIsVariant = (String) value.get(FIELD_PRODUCT_IS_VARIANT);
		productLargeImageUrl = (String) value
				.get(FIELD_PRODUCT_LARGE_IMAGE_URL);
		productRequirementMethodEnumId = (String) value
				.get(FIELD_PRODUCT_REQUIREMENT_METHOD_ENUM_ID);
		priceTaxInPrice = (String) value.get(FIELD_PRICE_TAX_IN_PRICE);
		priceTermUomId = (String) value.get(FIELD_PRICE_TERM_UOM_ID);
		pricePriceWithTax = (BigDecimal) value.get(FIELD_PRICE_PRICE_WITH_TAX);
		priceProductStoreGroupId = (String) value
				.get(FIELD_PRICE_PRODUCT_STORE_GROUP_ID);
		priceTaxAuthPartyId = (String) value.get(FIELD_PRICE_TAX_AUTH_PARTY_ID);
		priceLastModifiedByUserLogin = (String) value
				.get(FIELD_PRICE_LAST_MODIFIED_BY_USER_LOGIN);
		priceCustomPriceCalcService = (String) value
				.get(FIELD_PRICE_CUSTOM_PRICE_CALC_SERVICE);
		pricePrice = (BigDecimal) value.get(FIELD_PRICE_PRICE);
		priceTaxAuthGeoId = (String) value.get(FIELD_PRICE_TAX_AUTH_GEO_ID);
		priceProductPricePurposeId = (String) value
				.get(FIELD_PRICE_PRODUCT_PRICE_PURPOSE_ID);
		priceCreatedByUserLogin = (String) value
				.get(FIELD_PRICE_CREATED_BY_USER_LOGIN);
		priceLastModifiedDate = (Timestamp) value
				.get(FIELD_PRICE_LAST_MODIFIED_DATE);
		priceTaxPercentage = (BigDecimal) value.get(FIELD_PRICE_TAX_PERCENTAGE);
		priceThruDate = (Timestamp) value.get(FIELD_PRICE_THRU_DATE);
		priceFromDate = (Timestamp) value.get(FIELD_PRICE_FROM_DATE);
		priceCurrencyUomId = (String) value.get(FIELD_PRICE_CURRENCY_UOM_ID);
		priceCreatedDate = (Timestamp) value.get(FIELD_PRICE_CREATED_DATE);
		pricePriceWithoutTax = (BigDecimal) value
				.get(FIELD_PRICE_PRICE_WITHOUT_TAX);
		priceTaxAmount = (BigDecimal) value.get(FIELD_PRICE_TAX_AMOUNT);
		priceProductPriceTypeId = (String) value
				.get(FIELD_PRICE_PRODUCT_PRICE_TYPE_ID);
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