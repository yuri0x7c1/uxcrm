package org.apache.ofbiz.order.order;

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
 * Order Item And Product
 */
@FieldNameConstants
public class OrderItemAndProduct implements Serializable {

	public static final long serialVersionUID = 2541871674331822080L;
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
	 * Manufacturer Party Id
	 */
	@Getter
	@Setter
	private String manufacturerPartyId;
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

	public OrderItemAndProduct(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		deploymentId = (String) value.get(FIELD_DEPLOYMENT_ID);
		cancelBackOrderDate = (Timestamp) value
				.get(FIELD_CANCEL_BACK_ORDER_DATE);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		selectedAmount = (BigDecimal) value.get(FIELD_SELECTED_AMOUNT);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		unitRecurringPrice = (BigDecimal) value.get(FIELD_UNIT_RECURRING_PRICE);
		isItemGroupPrimary = (String) value.get(FIELD_IS_ITEM_GROUP_PRIMARY);
		autoCancelDate = (Timestamp) value.get(FIELD_AUTO_CANCEL_DATE);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		supplierProductId = (String) value.get(FIELD_SUPPLIER_PRODUCT_ID);
		estimatedDeliveryDate = (Timestamp) value
				.get(FIELD_ESTIMATED_DELIVERY_DATE);
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		syncStatusId = (String) value.get(FIELD_SYNC_STATUS_ID);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		shoppingListItemSeqId = (String) value
				.get(FIELD_SHOPPING_LIST_ITEM_SEQ_ID);
		subscriptionId = (String) value.get(FIELD_SUBSCRIPTION_ID);
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		dontCancelSetUserLogin = (String) value
				.get(FIELD_DONT_CANCEL_SET_USER_LOGIN);
		isPromo = (String) value.get(FIELD_IS_PROMO);
		isModifiedPrice = (String) value.get(FIELD_IS_MODIFIED_PRICE);
		shipBeforeDate = (Timestamp) value.get(FIELD_SHIP_BEFORE_DATE);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		unitListPrice = (BigDecimal) value.get(FIELD_UNIT_LIST_PRICE);
		unitAverageCost = (BigDecimal) value.get(FIELD_UNIT_AVERAGE_COST);
		orderItemTypeId = (String) value.get(FIELD_ORDER_ITEM_TYPE_ID);
		dontCancelSetDate = (Timestamp) value.get(FIELD_DONT_CANCEL_SET_DATE);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		comments = (String) value.get(FIELD_COMMENTS);
		recurringFreqUomId = (String) value.get(FIELD_RECURRING_FREQ_UOM_ID);
		orderItemGroupSeqId = (String) value.get(FIELD_ORDER_ITEM_GROUP_SEQ_ID);
		quoteItemSeqId = (String) value.get(FIELD_QUOTE_ITEM_SEQ_ID);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		fromInventoryItemId = (String) value.get(FIELD_FROM_INVENTORY_ITEM_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		correspondingPoId = (String) value.get(FIELD_CORRESPONDING_PO_ID);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		prodCatalogId = (String) value.get(FIELD_PROD_CATALOG_ID);
		originGeoId = (String) value.get(FIELD_ORIGIN_GEO_ID);
		detailScreen = (String) value.get(FIELD_DETAIL_SCREEN);
		requireInventory = (String) value.get(FIELD_REQUIRE_INVENTORY);
		quantityUomId = (String) value.get(FIELD_QUANTITY_UOM_ID);
		mediumImageUrl = (String) value.get(FIELD_MEDIUM_IMAGE_URL);
		productName = (String) value.get(FIELD_PRODUCT_NAME);
		introductionDate = (Timestamp) value.get(FIELD_INTRODUCTION_DATE);
		shippingHeight = (BigDecimal) value.get(FIELD_SHIPPING_HEIGHT);
		originalImageUrl = (String) value.get(FIELD_ORIGINAL_IMAGE_URL);
		inShippingBox = (String) value.get(FIELD_IN_SHIPPING_BOX);
		detailImageUrl = (String) value.get(FIELD_DETAIL_IMAGE_URL);
		supportDiscontinuationDate = (Timestamp) value
				.get(FIELD_SUPPORT_DISCONTINUATION_DATE);
		productWidth = (BigDecimal) value.get(FIELD_PRODUCT_WIDTH);
		includeInPromotions = (String) value.get(FIELD_INCLUDE_IN_PROMOTIONS);
		configId = (String) value.get(FIELD_CONFIG_ID);
		billOfMaterialLevel = (Long) value.get(FIELD_BILL_OF_MATERIAL_LEVEL);
		lotIdFilledIn = (String) value.get(FIELD_LOT_ID_FILLED_IN);
		productRating = (BigDecimal) value.get(FIELD_PRODUCT_RATING);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		manufacturerPartyId = (String) value.get(FIELD_MANUFACTURER_PARTY_ID);
		brandName = (String) value.get(FIELD_BRAND_NAME);
		requireAmount = (String) value.get(FIELD_REQUIRE_AMOUNT);
		smallImageUrl = (String) value.get(FIELD_SMALL_IMAGE_URL);
		taxable = (String) value.get(FIELD_TAXABLE);
		primaryProductCategoryId = (String) value
				.get(FIELD_PRIMARY_PRODUCT_CATEGORY_ID);
		salesDiscontinuationDate = (Timestamp) value
				.get(FIELD_SALES_DISCONTINUATION_DATE);
		salesDiscWhenNotAvail = (String) value
				.get(FIELD_SALES_DISC_WHEN_NOT_AVAIL);
		returnable = (String) value.get(FIELD_RETURNABLE);
		weightUomId = (String) value.get(FIELD_WEIGHT_UOM_ID);
		isVirtual = (String) value.get(FIELD_IS_VIRTUAL);
		priceDetailText = (String) value.get(FIELD_PRICE_DETAIL_TEXT);
		reserv2ndPPPerc = (BigDecimal) value.get(FIELD_RESERV2ND_P_P_PERC);
		widthUomId = (String) value.get(FIELD_WIDTH_UOM_ID);
		longDescription = (String) value.get(FIELD_LONG_DESCRIPTION);
		diameterUomId = (String) value.get(FIELD_DIAMETER_UOM_ID);
		autoCreateKeywords = (String) value.get(FIELD_AUTO_CREATE_KEYWORDS);
		amountUomTypeId = (String) value.get(FIELD_AMOUNT_UOM_TYPE_ID);
		productDiameter = (BigDecimal) value.get(FIELD_PRODUCT_DIAMETER);
		ratingTypeEnum = (String) value.get(FIELD_RATING_TYPE_ENUM);
		description = (String) value.get(FIELD_DESCRIPTION);
		chargeShipping = (String) value.get(FIELD_CHARGE_SHIPPING);
		reservNthPPPerc = (BigDecimal) value.get(FIELD_RESERV_NTH_P_P_PERC);
		quantityIncluded = (BigDecimal) value.get(FIELD_QUANTITY_INCLUDED);
		heightUomId = (String) value.get(FIELD_HEIGHT_UOM_ID);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		virtualVariantMethodEnum = (String) value
				.get(FIELD_VIRTUAL_VARIANT_METHOD_ENUM);
		shippingWeight = (BigDecimal) value.get(FIELD_SHIPPING_WEIGHT);
		shippingWidth = (BigDecimal) value.get(FIELD_SHIPPING_WIDTH);
		shippingDepth = (BigDecimal) value.get(FIELD_SHIPPING_DEPTH);
		reservMaxPersons = (BigDecimal) value.get(FIELD_RESERV_MAX_PERSONS);
		fixedAmount = (BigDecimal) value.get(FIELD_FIXED_AMOUNT);
		inventoryItemTypeId = (String) value.get(FIELD_INVENTORY_ITEM_TYPE_ID);
		piecesIncluded = (Long) value.get(FIELD_PIECES_INCLUDED);
		productDepth = (BigDecimal) value.get(FIELD_PRODUCT_DEPTH);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		releaseDate = (Timestamp) value.get(FIELD_RELEASE_DATE);
		productHeight = (BigDecimal) value.get(FIELD_PRODUCT_HEIGHT);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		defaultShipmentBoxTypeId = (String) value
				.get(FIELD_DEFAULT_SHIPMENT_BOX_TYPE_ID);
		orderDecimalQuantity = (String) value.get(FIELD_ORDER_DECIMAL_QUANTITY);
		inventoryMessage = (String) value.get(FIELD_INVENTORY_MESSAGE);
		productWeight = (BigDecimal) value.get(FIELD_PRODUCT_WEIGHT);
		depthUomId = (String) value.get(FIELD_DEPTH_UOM_ID);
		productTypeId = (String) value.get(FIELD_PRODUCT_TYPE_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		isVariant = (String) value.get(FIELD_IS_VARIANT);
		largeImageUrl = (String) value.get(FIELD_LARGE_IMAGE_URL);
		requirementMethodEnumId = (String) value
				.get(FIELD_REQUIREMENT_METHOD_ENUM_ID);
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