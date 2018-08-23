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
 * Product Store
 */
@FieldNameConstants
public class ProductStore implements Serializable {

	public static final long serialVersionUID = 8033679824175923200L;
	public static final String NAME = "ProductStore";
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Primary Store Group Id
	 */
	@Getter
	@Setter
	private String primaryStoreGroupId;
	/**
	 * Store Name
	 */
	@Getter
	@Setter
	private String storeName;
	/**
	 * Company Name
	 */
	@Getter
	@Setter
	private String companyName;
	/**
	 * Title
	 */
	@Getter
	@Setter
	private String title;
	/**
	 * Subtitle
	 */
	@Getter
	@Setter
	private String subtitle;
	/**
	 * Pay To Party Id
	 */
	@Getter
	@Setter
	private String payToPartyId;
	/**
	 * Days To Cancel Non Pay
	 */
	@Getter
	@Setter
	private Long daysToCancelNonPay;
	/**
	 * Manual Auth Is Capture
	 */
	@Getter
	@Setter
	private String manualAuthIsCapture;
	/**
	 * Prorate Shipping
	 */
	@Getter
	@Setter
	private String prorateShipping;
	/**
	 * Prorate Taxes
	 */
	@Getter
	@Setter
	private String prorateTaxes;
	/**
	 * View Cart On Add
	 */
	@Getter
	@Setter
	private String viewCartOnAdd;
	/**
	 * Auto Save Cart
	 */
	@Getter
	@Setter
	private String autoSaveCart;
	/**
	 * Auto Approve Reviews
	 */
	@Getter
	@Setter
	private String autoApproveReviews;
	/**
	 * Is Demo Store
	 */
	@Getter
	@Setter
	private String isDemoStore;
	/**
	 * Is Immediately Fulfilled
	 */
	@Getter
	@Setter
	private String isImmediatelyFulfilled;
	/**
	 * Inventory Facility Id
	 */
	@Getter
	@Setter
	private String inventoryFacilityId;
	/**
	 * One Inventory Facility
	 */
	@Getter
	@Setter
	private String oneInventoryFacility;
	/**
	 * Check Inventory
	 */
	@Getter
	@Setter
	private String checkInventory;
	/**
	 * Reserve Inventory
	 */
	@Getter
	@Setter
	private String reserveInventory;
	/**
	 * Reserve Order Enum Id
	 */
	@Getter
	@Setter
	private String reserveOrderEnumId;
	/**
	 * Require Inventory
	 */
	@Getter
	@Setter
	private String requireInventory;
	/**
	 * Balance Res On Order Creation
	 */
	@Getter
	@Setter
	private String balanceResOnOrderCreation;
	/**
	 * Requirement Method Enum Id
	 */
	@Getter
	@Setter
	private String requirementMethodEnumId;
	/**
	 * Order Number Prefix
	 */
	@Getter
	@Setter
	private String orderNumberPrefix;
	/**
	 * Default Locale String
	 */
	@Getter
	@Setter
	private String defaultLocaleString;
	/**
	 * Default Currency Uom Id
	 */
	@Getter
	@Setter
	private String defaultCurrencyUomId;
	/**
	 * Default Time Zone String
	 */
	@Getter
	@Setter
	private String defaultTimeZoneString;
	/**
	 * Default Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String defaultSalesChannelEnumId;
	/**
	 * Allow Password
	 */
	@Getter
	@Setter
	private String allowPassword;
	/**
	 * Default Password
	 */
	@Getter
	@Setter
	private String defaultPassword;
	/**
	 * Explode Order Items
	 */
	@Getter
	@Setter
	private String explodeOrderItems;
	/**
	 * Check Gc Balance
	 */
	@Getter
	@Setter
	private String checkGcBalance;
	/**
	 * Retry Failed Auths
	 */
	@Getter
	@Setter
	private String retryFailedAuths;
	/**
	 * Header Approved Status
	 */
	@Getter
	@Setter
	private String headerApprovedStatus;
	/**
	 * Item Approved Status
	 */
	@Getter
	@Setter
	private String itemApprovedStatus;
	/**
	 * Digital Item Approved Status
	 */
	@Getter
	@Setter
	private String digitalItemApprovedStatus;
	/**
	 * Header Declined Status
	 */
	@Getter
	@Setter
	private String headerDeclinedStatus;
	/**
	 * Item Declined Status
	 */
	@Getter
	@Setter
	private String itemDeclinedStatus;
	/**
	 * Header Cancel Status
	 */
	@Getter
	@Setter
	private String headerCancelStatus;
	/**
	 * Item Cancel Status
	 */
	@Getter
	@Setter
	private String itemCancelStatus;
	/**
	 * Auth Declined Message
	 */
	@Getter
	@Setter
	private String authDeclinedMessage;
	/**
	 * Auth Fraud Message
	 */
	@Getter
	@Setter
	private String authFraudMessage;
	/**
	 * Auth Error Message
	 */
	@Getter
	@Setter
	private String authErrorMessage;
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
	 * Use Primary Email Username
	 */
	@Getter
	@Setter
	private String usePrimaryEmailUsername;
	/**
	 * Require Customer Role
	 */
	@Getter
	@Setter
	private String requireCustomerRole;
	/**
	 * Auto Invoice Digital Items
	 */
	@Getter
	@Setter
	private String autoInvoiceDigitalItems;
	/**
	 * Req Ship Addr For Dig Items
	 */
	@Getter
	@Setter
	private String reqShipAddrForDigItems;
	/**
	 * Show Checkout Gift Options
	 */
	@Getter
	@Setter
	private String showCheckoutGiftOptions;
	/**
	 * Select Payment Type Per Item
	 */
	@Getter
	@Setter
	private String selectPaymentTypePerItem;
	/**
	 * Show Prices With Vat Tax
	 */
	@Getter
	@Setter
	private String showPricesWithVatTax;
	/**
	 * Show Tax Is Exempt
	 */
	@Getter
	@Setter
	private String showTaxIsExempt;
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
	 * Enable Auto Suggestion List
	 */
	@Getter
	@Setter
	private String enableAutoSuggestionList;
	/**
	 * Enable Dig Prod Upload
	 */
	@Getter
	@Setter
	private String enableDigProdUpload;
	/**
	 * Prod Search Exclude Variants
	 */
	@Getter
	@Setter
	private String prodSearchExcludeVariants;
	/**
	 * Dig Prod Upload Category Id
	 */
	@Getter
	@Setter
	private String digProdUploadCategoryId;
	/**
	 * Auto Order Cc Try Exp
	 */
	@Getter
	@Setter
	private String autoOrderCcTryExp;
	/**
	 * Auto Order Cc Try Other Cards
	 */
	@Getter
	@Setter
	private String autoOrderCcTryOtherCards;
	/**
	 * Auto Order Cc Try Later Nsf
	 */
	@Getter
	@Setter
	private String autoOrderCcTryLaterNsf;
	/**
	 * Auto Order Cc Try Later Max
	 */
	@Getter
	@Setter
	private Long autoOrderCcTryLaterMax;
	/**
	 * Store Credit Valid Days
	 */
	@Getter
	@Setter
	private Long storeCreditValidDays;
	/**
	 * Auto Approve Invoice
	 */
	@Getter
	@Setter
	private String autoApproveInvoice;
	/**
	 * Auto Approve Order
	 */
	@Getter
	@Setter
	private String autoApproveOrder;
	/**
	 * Ship If Capture Fails
	 */
	@Getter
	@Setter
	private String shipIfCaptureFails;
	/**
	 * Set Owner Upon Issuance
	 */
	@Getter
	@Setter
	private String setOwnerUponIssuance;
	/**
	 * Req Return Inventory Receive
	 */
	@Getter
	@Setter
	private String reqReturnInventoryReceive;
	/**
	 * Add To Cart Remove Incompat
	 */
	@Getter
	@Setter
	private String addToCartRemoveIncompat;
	/**
	 * Add To Cart Replace Upsell
	 */
	@Getter
	@Setter
	private String addToCartReplaceUpsell;
	/**
	 * Split Pay Pref Per Shp Grp
	 */
	@Getter
	@Setter
	private String splitPayPrefPerShpGrp;
	/**
	 * Managed By Lot
	 */
	@Getter
	@Setter
	private String managedByLot;
	/**
	 * Show Out Of Stock Products
	 */
	@Getter
	@Setter
	private String showOutOfStockProducts;
	/**
	 * Order Decimal Quantity
	 */
	@Getter
	@Setter
	private String orderDecimalQuantity;
	/**
	 * Allow Comment
	 */
	@Getter
	@Setter
	private String allowComment;
	/**
	 * Old Style Sheet
	 */
	@Getter
	@Setter
	private String oldStyleSheet;
	/**
	 * Old Header Logo
	 */
	@Getter
	@Setter
	private String oldHeaderLogo;
	/**
	 * Old Header Middle Background
	 */
	@Getter
	@Setter
	private String oldHeaderMiddleBackground;
	/**
	 * Old Header Right Background
	 */
	@Getter
	@Setter
	private String oldHeaderRightBackground;
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

	public ProductStore(GenericValue value) {
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		primaryStoreGroupId = (String) value.get(FIELD_PRIMARY_STORE_GROUP_ID);
		storeName = (String) value.get(FIELD_STORE_NAME);
		companyName = (String) value.get(FIELD_COMPANY_NAME);
		title = (String) value.get(FIELD_TITLE);
		subtitle = (String) value.get(FIELD_SUBTITLE);
		payToPartyId = (String) value.get(FIELD_PAY_TO_PARTY_ID);
		daysToCancelNonPay = (Long) value.get(FIELD_DAYS_TO_CANCEL_NON_PAY);
		manualAuthIsCapture = (String) value.get(FIELD_MANUAL_AUTH_IS_CAPTURE);
		prorateShipping = (String) value.get(FIELD_PRORATE_SHIPPING);
		prorateTaxes = (String) value.get(FIELD_PRORATE_TAXES);
		viewCartOnAdd = (String) value.get(FIELD_VIEW_CART_ON_ADD);
		autoSaveCart = (String) value.get(FIELD_AUTO_SAVE_CART);
		autoApproveReviews = (String) value.get(FIELD_AUTO_APPROVE_REVIEWS);
		isDemoStore = (String) value.get(FIELD_IS_DEMO_STORE);
		isImmediatelyFulfilled = (String) value
				.get(FIELD_IS_IMMEDIATELY_FULFILLED);
		inventoryFacilityId = (String) value.get(FIELD_INVENTORY_FACILITY_ID);
		oneInventoryFacility = (String) value.get(FIELD_ONE_INVENTORY_FACILITY);
		checkInventory = (String) value.get(FIELD_CHECK_INVENTORY);
		reserveInventory = (String) value.get(FIELD_RESERVE_INVENTORY);
		reserveOrderEnumId = (String) value.get(FIELD_RESERVE_ORDER_ENUM_ID);
		requireInventory = (String) value.get(FIELD_REQUIRE_INVENTORY);
		balanceResOnOrderCreation = (String) value
				.get(FIELD_BALANCE_RES_ON_ORDER_CREATION);
		requirementMethodEnumId = (String) value
				.get(FIELD_REQUIREMENT_METHOD_ENUM_ID);
		orderNumberPrefix = (String) value.get(FIELD_ORDER_NUMBER_PREFIX);
		defaultLocaleString = (String) value.get(FIELD_DEFAULT_LOCALE_STRING);
		defaultCurrencyUomId = (String) value
				.get(FIELD_DEFAULT_CURRENCY_UOM_ID);
		defaultTimeZoneString = (String) value
				.get(FIELD_DEFAULT_TIME_ZONE_STRING);
		defaultSalesChannelEnumId = (String) value
				.get(FIELD_DEFAULT_SALES_CHANNEL_ENUM_ID);
		allowPassword = (String) value.get(FIELD_ALLOW_PASSWORD);
		defaultPassword = (String) value.get(FIELD_DEFAULT_PASSWORD);
		explodeOrderItems = (String) value.get(FIELD_EXPLODE_ORDER_ITEMS);
		checkGcBalance = (String) value.get(FIELD_CHECK_GC_BALANCE);
		retryFailedAuths = (String) value.get(FIELD_RETRY_FAILED_AUTHS);
		headerApprovedStatus = (String) value.get(FIELD_HEADER_APPROVED_STATUS);
		itemApprovedStatus = (String) value.get(FIELD_ITEM_APPROVED_STATUS);
		digitalItemApprovedStatus = (String) value
				.get(FIELD_DIGITAL_ITEM_APPROVED_STATUS);
		headerDeclinedStatus = (String) value.get(FIELD_HEADER_DECLINED_STATUS);
		itemDeclinedStatus = (String) value.get(FIELD_ITEM_DECLINED_STATUS);
		headerCancelStatus = (String) value.get(FIELD_HEADER_CANCEL_STATUS);
		itemCancelStatus = (String) value.get(FIELD_ITEM_CANCEL_STATUS);
		authDeclinedMessage = (String) value.get(FIELD_AUTH_DECLINED_MESSAGE);
		authFraudMessage = (String) value.get(FIELD_AUTH_FRAUD_MESSAGE);
		authErrorMessage = (String) value.get(FIELD_AUTH_ERROR_MESSAGE);
		visualThemeId = (String) value.get(FIELD_VISUAL_THEME_ID);
		storeCreditAccountEnumId = (String) value
				.get(FIELD_STORE_CREDIT_ACCOUNT_ENUM_ID);
		usePrimaryEmailUsername = (String) value
				.get(FIELD_USE_PRIMARY_EMAIL_USERNAME);
		requireCustomerRole = (String) value.get(FIELD_REQUIRE_CUSTOMER_ROLE);
		autoInvoiceDigitalItems = (String) value
				.get(FIELD_AUTO_INVOICE_DIGITAL_ITEMS);
		reqShipAddrForDigItems = (String) value
				.get(FIELD_REQ_SHIP_ADDR_FOR_DIG_ITEMS);
		showCheckoutGiftOptions = (String) value
				.get(FIELD_SHOW_CHECKOUT_GIFT_OPTIONS);
		selectPaymentTypePerItem = (String) value
				.get(FIELD_SELECT_PAYMENT_TYPE_PER_ITEM);
		showPricesWithVatTax = (String) value
				.get(FIELD_SHOW_PRICES_WITH_VAT_TAX);
		showTaxIsExempt = (String) value.get(FIELD_SHOW_TAX_IS_EXEMPT);
		vatTaxAuthGeoId = (String) value.get(FIELD_VAT_TAX_AUTH_GEO_ID);
		vatTaxAuthPartyId = (String) value.get(FIELD_VAT_TAX_AUTH_PARTY_ID);
		enableAutoSuggestionList = (String) value
				.get(FIELD_ENABLE_AUTO_SUGGESTION_LIST);
		enableDigProdUpload = (String) value.get(FIELD_ENABLE_DIG_PROD_UPLOAD);
		prodSearchExcludeVariants = (String) value
				.get(FIELD_PROD_SEARCH_EXCLUDE_VARIANTS);
		digProdUploadCategoryId = (String) value
				.get(FIELD_DIG_PROD_UPLOAD_CATEGORY_ID);
		autoOrderCcTryExp = (String) value.get(FIELD_AUTO_ORDER_CC_TRY_EXP);
		autoOrderCcTryOtherCards = (String) value
				.get(FIELD_AUTO_ORDER_CC_TRY_OTHER_CARDS);
		autoOrderCcTryLaterNsf = (String) value
				.get(FIELD_AUTO_ORDER_CC_TRY_LATER_NSF);
		autoOrderCcTryLaterMax = (Long) value
				.get(FIELD_AUTO_ORDER_CC_TRY_LATER_MAX);
		storeCreditValidDays = (Long) value.get(FIELD_STORE_CREDIT_VALID_DAYS);
		autoApproveInvoice = (String) value.get(FIELD_AUTO_APPROVE_INVOICE);
		autoApproveOrder = (String) value.get(FIELD_AUTO_APPROVE_ORDER);
		shipIfCaptureFails = (String) value.get(FIELD_SHIP_IF_CAPTURE_FAILS);
		setOwnerUponIssuance = (String) value
				.get(FIELD_SET_OWNER_UPON_ISSUANCE);
		reqReturnInventoryReceive = (String) value
				.get(FIELD_REQ_RETURN_INVENTORY_RECEIVE);
		addToCartRemoveIncompat = (String) value
				.get(FIELD_ADD_TO_CART_REMOVE_INCOMPAT);
		addToCartReplaceUpsell = (String) value
				.get(FIELD_ADD_TO_CART_REPLACE_UPSELL);
		splitPayPrefPerShpGrp = (String) value
				.get(FIELD_SPLIT_PAY_PREF_PER_SHP_GRP);
		managedByLot = (String) value.get(FIELD_MANAGED_BY_LOT);
		showOutOfStockProducts = (String) value
				.get(FIELD_SHOW_OUT_OF_STOCK_PRODUCTS);
		orderDecimalQuantity = (String) value.get(FIELD_ORDER_DECIMAL_QUANTITY);
		allowComment = (String) value.get(FIELD_ALLOW_COMMENT);
		oldStyleSheet = (String) value.get(FIELD_OLD_STYLE_SHEET);
		oldHeaderLogo = (String) value.get(FIELD_OLD_HEADER_LOGO);
		oldHeaderMiddleBackground = (String) value
				.get(FIELD_OLD_HEADER_MIDDLE_BACKGROUND);
		oldHeaderRightBackground = (String) value
				.get(FIELD_OLD_HEADER_RIGHT_BACKGROUND);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductStore fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStore(value);
	}

	public static List<ProductStore> fromValues(List<GenericValue> values) {
		List<ProductStore> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStore(value));
		}
		return entities;
	}
}