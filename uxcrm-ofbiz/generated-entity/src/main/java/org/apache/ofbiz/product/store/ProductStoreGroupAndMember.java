package org.apache.ofbiz.product.store;

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
public class ProductStoreGroupAndMember implements Serializable {

	public static final long serialVersionUID = 3324936478597746688L;
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

	public enum Fields {
		productStoreGroupTypeId, primaryParentGroupId, productStoreGroupName, description, productStoreGroupId, fromDate, sequenceNum, productStoreId, thruDate, viewCartOnAdd, requireCustomerRole, companyName, headerDeclinedStatus, requireInventory, checkInventory, autoApproveInvoice, addToCartRemoveIncompat, enableAutoSuggestionList, defaultSalesChannelEnumId, autoApproveOrder, allowPassword, showTaxIsExempt, oldHeaderLogo, autoSaveCart, inventoryFacilityId, headerApprovedStatus, oldHeaderMiddleBackground, defaultTimeZoneString, prorateTaxes, showCheckoutGiftOptions, oldStyleSheet, manualAuthIsCapture, itemDeclinedStatus, visualThemeId, storeCreditAccountEnumId, showOutOfStockProducts, itemApprovedStatus, allowComment, storeCreditValidDays, splitPayPrefPerShpGrp, authFraudMessage, managedByLot, reqShipAddrForDigItems, oneInventoryFacility, orderNumberPrefix, autoInvoiceDigitalItems, subtitle, reserveOrderEnumId, isDemoStore, retryFailedAuths, selectPaymentTypePerItem, balanceResOnOrderCreation, autoApproveReviews, explodeOrderItems, usePrimaryEmailUsername, headerCancelStatus, title, primaryStoreGroupId, oldHeaderRightBackground, enableDigProdUpload, autoOrderCcTryOtherCards, autoOrderCcTryLaterMax, digitalItemApprovedStatus, storeName, reserveInventory, isImmediatelyFulfilled, defaultPassword, itemCancelStatus, autoOrderCcTryExp, authDeclinedMessage, prodSearchExcludeVariants, shipIfCaptureFails, showPricesWithVatTax, defaultCurrencyUomId, orderDecimalQuantity, prorateShipping, digProdUploadCategoryId, reqReturnInventoryReceive, authErrorMessage, setOwnerUponIssuance, checkGcBalance, autoOrderCcTryLaterNsf, addToCartReplaceUpsell, vatTaxAuthGeoId, vatTaxAuthPartyId, daysToCancelNonPay, requirementMethodEnumId, payToPartyId, defaultLocaleString
	}

	public ProductStoreGroupAndMember(GenericValue value) {
		productStoreGroupTypeId = (String) value
				.get(Fields.productStoreGroupTypeId.name());
		primaryParentGroupId = (String) value.get(Fields.primaryParentGroupId
				.name());
		productStoreGroupName = (String) value.get(Fields.productStoreGroupName
				.name());
		description = (String) value.get(Fields.description.name());
		productStoreGroupId = (String) value.get(Fields.productStoreGroupId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		viewCartOnAdd = (String) value.get(Fields.viewCartOnAdd.name());
		requireCustomerRole = (String) value.get(Fields.requireCustomerRole
				.name());
		companyName = (String) value.get(Fields.companyName.name());
		headerDeclinedStatus = (String) value.get(Fields.headerDeclinedStatus
				.name());
		requireInventory = (String) value.get(Fields.requireInventory.name());
		checkInventory = (String) value.get(Fields.checkInventory.name());
		autoApproveInvoice = (String) value.get(Fields.autoApproveInvoice
				.name());
		addToCartRemoveIncompat = (String) value
				.get(Fields.addToCartRemoveIncompat.name());
		enableAutoSuggestionList = (String) value
				.get(Fields.enableAutoSuggestionList.name());
		defaultSalesChannelEnumId = (String) value
				.get(Fields.defaultSalesChannelEnumId.name());
		autoApproveOrder = (String) value.get(Fields.autoApproveOrder.name());
		allowPassword = (String) value.get(Fields.allowPassword.name());
		showTaxIsExempt = (String) value.get(Fields.showTaxIsExempt.name());
		oldHeaderLogo = (String) value.get(Fields.oldHeaderLogo.name());
		autoSaveCart = (String) value.get(Fields.autoSaveCart.name());
		inventoryFacilityId = (String) value.get(Fields.inventoryFacilityId
				.name());
		headerApprovedStatus = (String) value.get(Fields.headerApprovedStatus
				.name());
		oldHeaderMiddleBackground = (String) value
				.get(Fields.oldHeaderMiddleBackground.name());
		defaultTimeZoneString = (String) value.get(Fields.defaultTimeZoneString
				.name());
		prorateTaxes = (String) value.get(Fields.prorateTaxes.name());
		showCheckoutGiftOptions = (String) value
				.get(Fields.showCheckoutGiftOptions.name());
		oldStyleSheet = (String) value.get(Fields.oldStyleSheet.name());
		manualAuthIsCapture = (String) value.get(Fields.manualAuthIsCapture
				.name());
		itemDeclinedStatus = (String) value.get(Fields.itemDeclinedStatus
				.name());
		visualThemeId = (String) value.get(Fields.visualThemeId.name());
		storeCreditAccountEnumId = (String) value
				.get(Fields.storeCreditAccountEnumId.name());
		showOutOfStockProducts = (String) value
				.get(Fields.showOutOfStockProducts.name());
		itemApprovedStatus = (String) value.get(Fields.itemApprovedStatus
				.name());
		allowComment = (String) value.get(Fields.allowComment.name());
		storeCreditValidDays = (Long) value.get(Fields.storeCreditValidDays
				.name());
		splitPayPrefPerShpGrp = (String) value.get(Fields.splitPayPrefPerShpGrp
				.name());
		authFraudMessage = (String) value.get(Fields.authFraudMessage.name());
		managedByLot = (String) value.get(Fields.managedByLot.name());
		reqShipAddrForDigItems = (String) value
				.get(Fields.reqShipAddrForDigItems.name());
		oneInventoryFacility = (String) value.get(Fields.oneInventoryFacility
				.name());
		orderNumberPrefix = (String) value.get(Fields.orderNumberPrefix.name());
		autoInvoiceDigitalItems = (String) value
				.get(Fields.autoInvoiceDigitalItems.name());
		subtitle = (String) value.get(Fields.subtitle.name());
		reserveOrderEnumId = (String) value.get(Fields.reserveOrderEnumId
				.name());
		isDemoStore = (String) value.get(Fields.isDemoStore.name());
		retryFailedAuths = (String) value.get(Fields.retryFailedAuths.name());
		selectPaymentTypePerItem = (String) value
				.get(Fields.selectPaymentTypePerItem.name());
		balanceResOnOrderCreation = (String) value
				.get(Fields.balanceResOnOrderCreation.name());
		autoApproveReviews = (String) value.get(Fields.autoApproveReviews
				.name());
		explodeOrderItems = (String) value.get(Fields.explodeOrderItems.name());
		usePrimaryEmailUsername = (String) value
				.get(Fields.usePrimaryEmailUsername.name());
		headerCancelStatus = (String) value.get(Fields.headerCancelStatus
				.name());
		title = (String) value.get(Fields.title.name());
		primaryStoreGroupId = (String) value.get(Fields.primaryStoreGroupId
				.name());
		oldHeaderRightBackground = (String) value
				.get(Fields.oldHeaderRightBackground.name());
		enableDigProdUpload = (String) value.get(Fields.enableDigProdUpload
				.name());
		autoOrderCcTryOtherCards = (String) value
				.get(Fields.autoOrderCcTryOtherCards.name());
		autoOrderCcTryLaterMax = (Long) value.get(Fields.autoOrderCcTryLaterMax
				.name());
		digitalItemApprovedStatus = (String) value
				.get(Fields.digitalItemApprovedStatus.name());
		storeName = (String) value.get(Fields.storeName.name());
		reserveInventory = (String) value.get(Fields.reserveInventory.name());
		isImmediatelyFulfilled = (String) value
				.get(Fields.isImmediatelyFulfilled.name());
		defaultPassword = (String) value.get(Fields.defaultPassword.name());
		itemCancelStatus = (String) value.get(Fields.itemCancelStatus.name());
		autoOrderCcTryExp = (String) value.get(Fields.autoOrderCcTryExp.name());
		authDeclinedMessage = (String) value.get(Fields.authDeclinedMessage
				.name());
		prodSearchExcludeVariants = (String) value
				.get(Fields.prodSearchExcludeVariants.name());
		shipIfCaptureFails = (String) value.get(Fields.shipIfCaptureFails
				.name());
		showPricesWithVatTax = (String) value.get(Fields.showPricesWithVatTax
				.name());
		defaultCurrencyUomId = (String) value.get(Fields.defaultCurrencyUomId
				.name());
		orderDecimalQuantity = (String) value.get(Fields.orderDecimalQuantity
				.name());
		prorateShipping = (String) value.get(Fields.prorateShipping.name());
		digProdUploadCategoryId = (String) value
				.get(Fields.digProdUploadCategoryId.name());
		reqReturnInventoryReceive = (String) value
				.get(Fields.reqReturnInventoryReceive.name());
		authErrorMessage = (String) value.get(Fields.authErrorMessage.name());
		setOwnerUponIssuance = (String) value.get(Fields.setOwnerUponIssuance
				.name());
		checkGcBalance = (String) value.get(Fields.checkGcBalance.name());
		autoOrderCcTryLaterNsf = (String) value
				.get(Fields.autoOrderCcTryLaterNsf.name());
		addToCartReplaceUpsell = (String) value
				.get(Fields.addToCartReplaceUpsell.name());
		vatTaxAuthGeoId = (String) value.get(Fields.vatTaxAuthGeoId.name());
		vatTaxAuthPartyId = (String) value.get(Fields.vatTaxAuthPartyId.name());
		daysToCancelNonPay = (Long) value.get(Fields.daysToCancelNonPay.name());
		requirementMethodEnumId = (String) value
				.get(Fields.requirementMethodEnumId.name());
		payToPartyId = (String) value.get(Fields.payToPartyId.name());
		defaultLocaleString = (String) value.get(Fields.defaultLocaleString
				.name());
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