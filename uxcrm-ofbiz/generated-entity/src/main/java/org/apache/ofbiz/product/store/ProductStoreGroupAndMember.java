package org.apache.ofbiz.product.store;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Group And Member
 */
@FieldNameConstants
public class ProductStoreGroupAndMember implements Serializable {

	public static final long serialVersionUID = 8641385298921337856L;
	public static final String NAME = "ProductStoreGroupAndMember";
	/**
	 * Product Store Group Type Id
	 */
	@Getter
	@Setter
	private String productStoreGroupTypeId;
	/**
	 * Primary Parent Group Id
	 */
	@Getter
	@Setter
	private String primaryParentGroupId;
	/**
	 * Product Store Group Name
	 */
	@Getter
	@Setter
	private String productStoreGroupName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Product Store Group Id
	 */
	@Getter
	@Setter
	private String productStoreGroupId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * View Cart On Add
	 */
	@Getter
	@Setter
	private String viewCartOnAdd;
	/**
	 * Require Customer Role
	 */
	@Getter
	@Setter
	private String requireCustomerRole;
	/**
	 * Company Name
	 */
	@Getter
	@Setter
	private String companyName;
	/**
	 * Header Declined Status
	 */
	@Getter
	@Setter
	private String headerDeclinedStatus;
	/**
	 * Require Inventory
	 */
	@Getter
	@Setter
	private String requireInventory;
	/**
	 * Check Inventory
	 */
	@Getter
	@Setter
	private String checkInventory;
	/**
	 * Auto Approve Invoice
	 */
	@Getter
	@Setter
	private String autoApproveInvoice;
	/**
	 * Add To Cart Remove Incompat
	 */
	@Getter
	@Setter
	private String addToCartRemoveIncompat;
	/**
	 * Enable Auto Suggestion List
	 */
	@Getter
	@Setter
	private String enableAutoSuggestionList;
	/**
	 * Default Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String defaultSalesChannelEnumId;
	/**
	 * Auto Approve Order
	 */
	@Getter
	@Setter
	private String autoApproveOrder;
	/**
	 * Allow Password
	 */
	@Getter
	@Setter
	private String allowPassword;
	/**
	 * Show Tax Is Exempt
	 */
	@Getter
	@Setter
	private String showTaxIsExempt;
	/**
	 * Old Header Logo
	 */
	@Getter
	@Setter
	private String oldHeaderLogo;
	/**
	 * Auto Save Cart
	 */
	@Getter
	@Setter
	private String autoSaveCart;
	/**
	 * Inventory Facility Id
	 */
	@Getter
	@Setter
	private String inventoryFacilityId;
	/**
	 * Header Approved Status
	 */
	@Getter
	@Setter
	private String headerApprovedStatus;
	/**
	 * Old Header Middle Background
	 */
	@Getter
	@Setter
	private String oldHeaderMiddleBackground;
	/**
	 * Default Time Zone String
	 */
	@Getter
	@Setter
	private String defaultTimeZoneString;
	/**
	 * Prorate Taxes
	 */
	@Getter
	@Setter
	private String prorateTaxes;
	/**
	 * Show Checkout Gift Options
	 */
	@Getter
	@Setter
	private String showCheckoutGiftOptions;
	/**
	 * Old Style Sheet
	 */
	@Getter
	@Setter
	private String oldStyleSheet;
	/**
	 * Manual Auth Is Capture
	 */
	@Getter
	@Setter
	private String manualAuthIsCapture;
	/**
	 * Item Declined Status
	 */
	@Getter
	@Setter
	private String itemDeclinedStatus;
	/**
	 * Visual Theme Id
	 */
	@Getter
	@Setter
	private String visualThemeId;
	/**
	 * Store Credit Account Enum Id
	 */
	@Getter
	@Setter
	private String storeCreditAccountEnumId;
	/**
	 * Show Out Of Stock Products
	 */
	@Getter
	@Setter
	private String showOutOfStockProducts;
	/**
	 * Item Approved Status
	 */
	@Getter
	@Setter
	private String itemApprovedStatus;
	/**
	 * Allow Comment
	 */
	@Getter
	@Setter
	private String allowComment;
	/**
	 * Store Credit Valid Days
	 */
	@Getter
	@Setter
	private Long storeCreditValidDays;
	/**
	 * Split Pay Pref Per Shp Grp
	 */
	@Getter
	@Setter
	private String splitPayPrefPerShpGrp;
	/**
	 * Auth Fraud Message
	 */
	@Getter
	@Setter
	private String authFraudMessage;
	/**
	 * Managed By Lot
	 */
	@Getter
	@Setter
	private String managedByLot;
	/**
	 * Req Ship Addr For Dig Items
	 */
	@Getter
	@Setter
	private String reqShipAddrForDigItems;
	/**
	 * One Inventory Facility
	 */
	@Getter
	@Setter
	private String oneInventoryFacility;
	/**
	 * Order Number Prefix
	 */
	@Getter
	@Setter
	private String orderNumberPrefix;
	/**
	 * Auto Invoice Digital Items
	 */
	@Getter
	@Setter
	private String autoInvoiceDigitalItems;
	/**
	 * Subtitle
	 */
	@Getter
	@Setter
	private String subtitle;
	/**
	 * Reserve Order Enum Id
	 */
	@Getter
	@Setter
	private String reserveOrderEnumId;
	/**
	 * Is Demo Store
	 */
	@Getter
	@Setter
	private String isDemoStore;
	/**
	 * Retry Failed Auths
	 */
	@Getter
	@Setter
	private String retryFailedAuths;
	/**
	 * Select Payment Type Per Item
	 */
	@Getter
	@Setter
	private String selectPaymentTypePerItem;
	/**
	 * Balance Res On Order Creation
	 */
	@Getter
	@Setter
	private String balanceResOnOrderCreation;
	/**
	 * Auto Approve Reviews
	 */
	@Getter
	@Setter
	private String autoApproveReviews;
	/**
	 * Explode Order Items
	 */
	@Getter
	@Setter
	private String explodeOrderItems;
	/**
	 * Use Primary Email Username
	 */
	@Getter
	@Setter
	private String usePrimaryEmailUsername;
	/**
	 * Header Cancel Status
	 */
	@Getter
	@Setter
	private String headerCancelStatus;
	/**
	 * Title
	 */
	@Getter
	@Setter
	private String title;
	/**
	 * Primary Store Group Id
	 */
	@Getter
	@Setter
	private String primaryStoreGroupId;
	/**
	 * Old Header Right Background
	 */
	@Getter
	@Setter
	private String oldHeaderRightBackground;
	/**
	 * Enable Dig Prod Upload
	 */
	@Getter
	@Setter
	private String enableDigProdUpload;
	/**
	 * Auto Order Cc Try Other Cards
	 */
	@Getter
	@Setter
	private String autoOrderCcTryOtherCards;
	/**
	 * Auto Order Cc Try Later Max
	 */
	@Getter
	@Setter
	private Long autoOrderCcTryLaterMax;
	/**
	 * Digital Item Approved Status
	 */
	@Getter
	@Setter
	private String digitalItemApprovedStatus;
	/**
	 * Store Name
	 */
	@Getter
	@Setter
	private String storeName;
	/**
	 * Reserve Inventory
	 */
	@Getter
	@Setter
	private String reserveInventory;
	/**
	 * Is Immediately Fulfilled
	 */
	@Getter
	@Setter
	private String isImmediatelyFulfilled;
	/**
	 * Default Password
	 */
	@Getter
	@Setter
	private String defaultPassword;
	/**
	 * Item Cancel Status
	 */
	@Getter
	@Setter
	private String itemCancelStatus;
	/**
	 * Auto Order Cc Try Exp
	 */
	@Getter
	@Setter
	private String autoOrderCcTryExp;
	/**
	 * Auth Declined Message
	 */
	@Getter
	@Setter
	private String authDeclinedMessage;
	/**
	 * Prod Search Exclude Variants
	 */
	@Getter
	@Setter
	private String prodSearchExcludeVariants;
	/**
	 * Ship If Capture Fails
	 */
	@Getter
	@Setter
	private String shipIfCaptureFails;
	/**
	 * Show Prices With Vat Tax
	 */
	@Getter
	@Setter
	private String showPricesWithVatTax;
	/**
	 * Default Currency Uom Id
	 */
	@Getter
	@Setter
	private String defaultCurrencyUomId;
	/**
	 * Order Decimal Quantity
	 */
	@Getter
	@Setter
	private String orderDecimalQuantity;
	/**
	 * Prorate Shipping
	 */
	@Getter
	@Setter
	private String prorateShipping;
	/**
	 * Dig Prod Upload Category Id
	 */
	@Getter
	@Setter
	private String digProdUploadCategoryId;
	/**
	 * Req Return Inventory Receive
	 */
	@Getter
	@Setter
	private String reqReturnInventoryReceive;
	/**
	 * Auth Error Message
	 */
	@Getter
	@Setter
	private String authErrorMessage;
	/**
	 * Set Owner Upon Issuance
	 */
	@Getter
	@Setter
	private String setOwnerUponIssuance;
	/**
	 * Check Gc Balance
	 */
	@Getter
	@Setter
	private String checkGcBalance;
	/**
	 * Auto Order Cc Try Later Nsf
	 */
	@Getter
	@Setter
	private String autoOrderCcTryLaterNsf;
	/**
	 * Add To Cart Replace Upsell
	 */
	@Getter
	@Setter
	private String addToCartReplaceUpsell;
	/**
	 * Vat Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String vatTaxAuthGeoId;
	/**
	 * Vat Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String vatTaxAuthPartyId;
	/**
	 * Days To Cancel Non Pay
	 */
	@Getter
	@Setter
	private Long daysToCancelNonPay;
	/**
	 * Requirement Method Enum Id
	 */
	@Getter
	@Setter
	private String requirementMethodEnumId;
	/**
	 * Pay To Party Id
	 */
	@Getter
	@Setter
	private String payToPartyId;
	/**
	 * Default Locale String
	 */
	@Getter
	@Setter
	private String defaultLocaleString;

	public ProductStoreGroupAndMember(GenericValue value) {
		productStoreGroupTypeId = (String) value
				.get(FIELD_PRODUCT_STORE_GROUP_TYPE_ID);
		primaryParentGroupId = (String) value
				.get(FIELD_PRIMARY_PARENT_GROUP_ID);
		productStoreGroupName = (String) value
				.get(FIELD_PRODUCT_STORE_GROUP_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		productStoreGroupId = (String) value.get(FIELD_PRODUCT_STORE_GROUP_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		viewCartOnAdd = (String) value.get(FIELD_VIEW_CART_ON_ADD);
		requireCustomerRole = (String) value.get(FIELD_REQUIRE_CUSTOMER_ROLE);
		companyName = (String) value.get(FIELD_COMPANY_NAME);
		headerDeclinedStatus = (String) value.get(FIELD_HEADER_DECLINED_STATUS);
		requireInventory = (String) value.get(FIELD_REQUIRE_INVENTORY);
		checkInventory = (String) value.get(FIELD_CHECK_INVENTORY);
		autoApproveInvoice = (String) value.get(FIELD_AUTO_APPROVE_INVOICE);
		addToCartRemoveIncompat = (String) value
				.get(FIELD_ADD_TO_CART_REMOVE_INCOMPAT);
		enableAutoSuggestionList = (String) value
				.get(FIELD_ENABLE_AUTO_SUGGESTION_LIST);
		defaultSalesChannelEnumId = (String) value
				.get(FIELD_DEFAULT_SALES_CHANNEL_ENUM_ID);
		autoApproveOrder = (String) value.get(FIELD_AUTO_APPROVE_ORDER);
		allowPassword = (String) value.get(FIELD_ALLOW_PASSWORD);
		showTaxIsExempt = (String) value.get(FIELD_SHOW_TAX_IS_EXEMPT);
		oldHeaderLogo = (String) value.get(FIELD_OLD_HEADER_LOGO);
		autoSaveCart = (String) value.get(FIELD_AUTO_SAVE_CART);
		inventoryFacilityId = (String) value.get(FIELD_INVENTORY_FACILITY_ID);
		headerApprovedStatus = (String) value.get(FIELD_HEADER_APPROVED_STATUS);
		oldHeaderMiddleBackground = (String) value
				.get(FIELD_OLD_HEADER_MIDDLE_BACKGROUND);
		defaultTimeZoneString = (String) value
				.get(FIELD_DEFAULT_TIME_ZONE_STRING);
		prorateTaxes = (String) value.get(FIELD_PRORATE_TAXES);
		showCheckoutGiftOptions = (String) value
				.get(FIELD_SHOW_CHECKOUT_GIFT_OPTIONS);
		oldStyleSheet = (String) value.get(FIELD_OLD_STYLE_SHEET);
		manualAuthIsCapture = (String) value.get(FIELD_MANUAL_AUTH_IS_CAPTURE);
		itemDeclinedStatus = (String) value.get(FIELD_ITEM_DECLINED_STATUS);
		visualThemeId = (String) value.get(FIELD_VISUAL_THEME_ID);
		storeCreditAccountEnumId = (String) value
				.get(FIELD_STORE_CREDIT_ACCOUNT_ENUM_ID);
		showOutOfStockProducts = (String) value
				.get(FIELD_SHOW_OUT_OF_STOCK_PRODUCTS);
		itemApprovedStatus = (String) value.get(FIELD_ITEM_APPROVED_STATUS);
		allowComment = (String) value.get(FIELD_ALLOW_COMMENT);
		storeCreditValidDays = (Long) value.get(FIELD_STORE_CREDIT_VALID_DAYS);
		splitPayPrefPerShpGrp = (String) value
				.get(FIELD_SPLIT_PAY_PREF_PER_SHP_GRP);
		authFraudMessage = (String) value.get(FIELD_AUTH_FRAUD_MESSAGE);
		managedByLot = (String) value.get(FIELD_MANAGED_BY_LOT);
		reqShipAddrForDigItems = (String) value
				.get(FIELD_REQ_SHIP_ADDR_FOR_DIG_ITEMS);
		oneInventoryFacility = (String) value.get(FIELD_ONE_INVENTORY_FACILITY);
		orderNumberPrefix = (String) value.get(FIELD_ORDER_NUMBER_PREFIX);
		autoInvoiceDigitalItems = (String) value
				.get(FIELD_AUTO_INVOICE_DIGITAL_ITEMS);
		subtitle = (String) value.get(FIELD_SUBTITLE);
		reserveOrderEnumId = (String) value.get(FIELD_RESERVE_ORDER_ENUM_ID);
		isDemoStore = (String) value.get(FIELD_IS_DEMO_STORE);
		retryFailedAuths = (String) value.get(FIELD_RETRY_FAILED_AUTHS);
		selectPaymentTypePerItem = (String) value
				.get(FIELD_SELECT_PAYMENT_TYPE_PER_ITEM);
		balanceResOnOrderCreation = (String) value
				.get(FIELD_BALANCE_RES_ON_ORDER_CREATION);
		autoApproveReviews = (String) value.get(FIELD_AUTO_APPROVE_REVIEWS);
		explodeOrderItems = (String) value.get(FIELD_EXPLODE_ORDER_ITEMS);
		usePrimaryEmailUsername = (String) value
				.get(FIELD_USE_PRIMARY_EMAIL_USERNAME);
		headerCancelStatus = (String) value.get(FIELD_HEADER_CANCEL_STATUS);
		title = (String) value.get(FIELD_TITLE);
		primaryStoreGroupId = (String) value.get(FIELD_PRIMARY_STORE_GROUP_ID);
		oldHeaderRightBackground = (String) value
				.get(FIELD_OLD_HEADER_RIGHT_BACKGROUND);
		enableDigProdUpload = (String) value.get(FIELD_ENABLE_DIG_PROD_UPLOAD);
		autoOrderCcTryOtherCards = (String) value
				.get(FIELD_AUTO_ORDER_CC_TRY_OTHER_CARDS);
		autoOrderCcTryLaterMax = (Long) value
				.get(FIELD_AUTO_ORDER_CC_TRY_LATER_MAX);
		digitalItemApprovedStatus = (String) value
				.get(FIELD_DIGITAL_ITEM_APPROVED_STATUS);
		storeName = (String) value.get(FIELD_STORE_NAME);
		reserveInventory = (String) value.get(FIELD_RESERVE_INVENTORY);
		isImmediatelyFulfilled = (String) value
				.get(FIELD_IS_IMMEDIATELY_FULFILLED);
		defaultPassword = (String) value.get(FIELD_DEFAULT_PASSWORD);
		itemCancelStatus = (String) value.get(FIELD_ITEM_CANCEL_STATUS);
		autoOrderCcTryExp = (String) value.get(FIELD_AUTO_ORDER_CC_TRY_EXP);
		authDeclinedMessage = (String) value.get(FIELD_AUTH_DECLINED_MESSAGE);
		prodSearchExcludeVariants = (String) value
				.get(FIELD_PROD_SEARCH_EXCLUDE_VARIANTS);
		shipIfCaptureFails = (String) value.get(FIELD_SHIP_IF_CAPTURE_FAILS);
		showPricesWithVatTax = (String) value
				.get(FIELD_SHOW_PRICES_WITH_VAT_TAX);
		defaultCurrencyUomId = (String) value
				.get(FIELD_DEFAULT_CURRENCY_UOM_ID);
		orderDecimalQuantity = (String) value.get(FIELD_ORDER_DECIMAL_QUANTITY);
		prorateShipping = (String) value.get(FIELD_PRORATE_SHIPPING);
		digProdUploadCategoryId = (String) value
				.get(FIELD_DIG_PROD_UPLOAD_CATEGORY_ID);
		reqReturnInventoryReceive = (String) value
				.get(FIELD_REQ_RETURN_INVENTORY_RECEIVE);
		authErrorMessage = (String) value.get(FIELD_AUTH_ERROR_MESSAGE);
		setOwnerUponIssuance = (String) value
				.get(FIELD_SET_OWNER_UPON_ISSUANCE);
		checkGcBalance = (String) value.get(FIELD_CHECK_GC_BALANCE);
		autoOrderCcTryLaterNsf = (String) value
				.get(FIELD_AUTO_ORDER_CC_TRY_LATER_NSF);
		addToCartReplaceUpsell = (String) value
				.get(FIELD_ADD_TO_CART_REPLACE_UPSELL);
		vatTaxAuthGeoId = (String) value.get(FIELD_VAT_TAX_AUTH_GEO_ID);
		vatTaxAuthPartyId = (String) value.get(FIELD_VAT_TAX_AUTH_PARTY_ID);
		daysToCancelNonPay = (Long) value.get(FIELD_DAYS_TO_CANCEL_NON_PAY);
		requirementMethodEnumId = (String) value
				.get(FIELD_REQUIREMENT_METHOD_ENUM_ID);
		payToPartyId = (String) value.get(FIELD_PAY_TO_PARTY_ID);
		defaultLocaleString = (String) value.get(FIELD_DEFAULT_LOCALE_STRING);
	}

	public static ProductStoreGroupAndMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreGroupAndMember(value);
	}

	public static List<ProductStoreGroupAndMember> fromValues(
			List<GenericValue> values) {
		List<ProductStoreGroupAndMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreGroupAndMember(value));
		}
		return entities;
	}
}