package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product
 */
@FieldNameConstants
public class Product implements Serializable {

	public static final long serialVersionUID = 4029623512526838784L;
	public static final String NAME = "Product";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public Product(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productTypeId = (String) value.get(FIELD_PRODUCT_TYPE_ID);
		primaryProductCategoryId = (String) value
				.get(FIELD_PRIMARY_PRODUCT_CATEGORY_ID);
		manufacturerPartyId = (String) value.get(FIELD_MANUFACTURER_PARTY_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		introductionDate = (Timestamp) value.get(FIELD_INTRODUCTION_DATE);
		releaseDate = (Timestamp) value.get(FIELD_RELEASE_DATE);
		supportDiscontinuationDate = (Timestamp) value
				.get(FIELD_SUPPORT_DISCONTINUATION_DATE);
		salesDiscontinuationDate = (Timestamp) value
				.get(FIELD_SALES_DISCONTINUATION_DATE);
		salesDiscWhenNotAvail = (String) value
				.get(FIELD_SALES_DISC_WHEN_NOT_AVAIL);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		brandName = (String) value.get(FIELD_BRAND_NAME);
		comments = (String) value.get(FIELD_COMMENTS);
		productName = (String) value.get(FIELD_PRODUCT_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		longDescription = (String) value.get(FIELD_LONG_DESCRIPTION);
		priceDetailText = (String) value.get(FIELD_PRICE_DETAIL_TEXT);
		smallImageUrl = (String) value.get(FIELD_SMALL_IMAGE_URL);
		mediumImageUrl = (String) value.get(FIELD_MEDIUM_IMAGE_URL);
		largeImageUrl = (String) value.get(FIELD_LARGE_IMAGE_URL);
		detailImageUrl = (String) value.get(FIELD_DETAIL_IMAGE_URL);
		originalImageUrl = (String) value.get(FIELD_ORIGINAL_IMAGE_URL);
		detailScreen = (String) value.get(FIELD_DETAIL_SCREEN);
		inventoryMessage = (String) value.get(FIELD_INVENTORY_MESSAGE);
		inventoryItemTypeId = (String) value.get(FIELD_INVENTORY_ITEM_TYPE_ID);
		requireInventory = (String) value.get(FIELD_REQUIRE_INVENTORY);
		quantityUomId = (String) value.get(FIELD_QUANTITY_UOM_ID);
		quantityIncluded = (BigDecimal) value.get(FIELD_QUANTITY_INCLUDED);
		piecesIncluded = (Long) value.get(FIELD_PIECES_INCLUDED);
		requireAmount = (String) value.get(FIELD_REQUIRE_AMOUNT);
		fixedAmount = (BigDecimal) value.get(FIELD_FIXED_AMOUNT);
		amountUomTypeId = (String) value.get(FIELD_AMOUNT_UOM_TYPE_ID);
		weightUomId = (String) value.get(FIELD_WEIGHT_UOM_ID);
		shippingWeight = (BigDecimal) value.get(FIELD_SHIPPING_WEIGHT);
		productWeight = (BigDecimal) value.get(FIELD_PRODUCT_WEIGHT);
		heightUomId = (String) value.get(FIELD_HEIGHT_UOM_ID);
		productHeight = (BigDecimal) value.get(FIELD_PRODUCT_HEIGHT);
		shippingHeight = (BigDecimal) value.get(FIELD_SHIPPING_HEIGHT);
		widthUomId = (String) value.get(FIELD_WIDTH_UOM_ID);
		productWidth = (BigDecimal) value.get(FIELD_PRODUCT_WIDTH);
		shippingWidth = (BigDecimal) value.get(FIELD_SHIPPING_WIDTH);
		depthUomId = (String) value.get(FIELD_DEPTH_UOM_ID);
		productDepth = (BigDecimal) value.get(FIELD_PRODUCT_DEPTH);
		shippingDepth = (BigDecimal) value.get(FIELD_SHIPPING_DEPTH);
		diameterUomId = (String) value.get(FIELD_DIAMETER_UOM_ID);
		productDiameter = (BigDecimal) value.get(FIELD_PRODUCT_DIAMETER);
		productRating = (BigDecimal) value.get(FIELD_PRODUCT_RATING);
		ratingTypeEnum = (String) value.get(FIELD_RATING_TYPE_ENUM);
		returnable = (String) value.get(FIELD_RETURNABLE);
		taxable = (String) value.get(FIELD_TAXABLE);
		chargeShipping = (String) value.get(FIELD_CHARGE_SHIPPING);
		autoCreateKeywords = (String) value.get(FIELD_AUTO_CREATE_KEYWORDS);
		includeInPromotions = (String) value.get(FIELD_INCLUDE_IN_PROMOTIONS);
		isVirtual = (String) value.get(FIELD_IS_VIRTUAL);
		isVariant = (String) value.get(FIELD_IS_VARIANT);
		virtualVariantMethodEnum = (String) value
				.get(FIELD_VIRTUAL_VARIANT_METHOD_ENUM);
		originGeoId = (String) value.get(FIELD_ORIGIN_GEO_ID);
		requirementMethodEnumId = (String) value
				.get(FIELD_REQUIREMENT_METHOD_ENUM_ID);
		billOfMaterialLevel = (Long) value.get(FIELD_BILL_OF_MATERIAL_LEVEL);
		reservMaxPersons = (BigDecimal) value.get(FIELD_RESERV_MAX_PERSONS);
		reserv2ndPPPerc = (BigDecimal) value.get(FIELD_RESERV2ND_P_P_PERC);
		reservNthPPPerc = (BigDecimal) value.get(FIELD_RESERV_NTH_P_P_PERC);
		configId = (String) value.get(FIELD_CONFIG_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		inShippingBox = (String) value.get(FIELD_IN_SHIPPING_BOX);
		defaultShipmentBoxTypeId = (String) value
				.get(FIELD_DEFAULT_SHIPMENT_BOX_TYPE_ID);
		lotIdFilledIn = (String) value.get(FIELD_LOT_ID_FILLED_IN);
		orderDecimalQuantity = (String) value.get(FIELD_ORDER_DECIMAL_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Product fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Product(value);
	}

	public static List<Product> fromValues(List<GenericValue> values) {
		List<Product> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Product(value));
		}
		return entities;
	}
}