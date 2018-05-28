package org.apache.ofbiz.product.store;

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
public class ProductStore implements Serializable {

	public static final long serialVersionUID = 7875498603112254464L;
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

	public enum Fields {
		productStoreId, primaryStoreGroupId, storeName, companyName, title, subtitle, payToPartyId, daysToCancelNonPay, manualAuthIsCapture, prorateShipping, prorateTaxes, viewCartOnAdd, autoSaveCart, autoApproveReviews, isDemoStore, isImmediatelyFulfilled, inventoryFacilityId, oneInventoryFacility, checkInventory, reserveInventory, reserveOrderEnumId, requireInventory, balanceResOnOrderCreation, requirementMethodEnumId, orderNumberPrefix, defaultLocaleString, defaultCurrencyUomId, defaultTimeZoneString, defaultSalesChannelEnumId, allowPassword, defaultPassword, explodeOrderItems, checkGcBalance, retryFailedAuths, headerApprovedStatus, itemApprovedStatus, digitalItemApprovedStatus, headerDeclinedStatus, itemDeclinedStatus, headerCancelStatus, itemCancelStatus, authDeclinedMessage, authFraudMessage, authErrorMessage, visualThemeId, storeCreditAccountEnumId, usePrimaryEmailUsername, requireCustomerRole, autoInvoiceDigitalItems, reqShipAddrForDigItems, showCheckoutGiftOptions, selectPaymentTypePerItem, showPricesWithVatTax, showTaxIsExempt, vatTaxAuthGeoId, vatTaxAuthPartyId, enableAutoSuggestionList, enableDigProdUpload, prodSearchExcludeVariants, digProdUploadCategoryId, autoOrderCcTryExp, autoOrderCcTryOtherCards, autoOrderCcTryLaterNsf, autoOrderCcTryLaterMax, storeCreditValidDays, autoApproveInvoice, autoApproveOrder, shipIfCaptureFails, setOwnerUponIssuance, reqReturnInventoryReceive, addToCartRemoveIncompat, addToCartReplaceUpsell, splitPayPrefPerShpGrp, managedByLot, showOutOfStockProducts, orderDecimalQuantity, allowComment, oldStyleSheet, oldHeaderLogo, oldHeaderMiddleBackground, oldHeaderRightBackground, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductStore(GenericValue value) {
		productStoreId = (String) value.get(Fields.productStoreId.name());
		primaryStoreGroupId = (String) value.get(Fields.primaryStoreGroupId
				.name());
		storeName = (String) value.get(Fields.storeName.name());
		companyName = (String) value.get(Fields.companyName.name());
		title = (String) value.get(Fields.title.name());
		subtitle = (String) value.get(Fields.subtitle.name());
		payToPartyId = (String) value.get(Fields.payToPartyId.name());
		daysToCancelNonPay = (Long) value.get(Fields.daysToCancelNonPay.name());
		manualAuthIsCapture = (String) value.get(Fields.manualAuthIsCapture
				.name());
		prorateShipping = (String) value.get(Fields.prorateShipping.name());
		prorateTaxes = (String) value.get(Fields.prorateTaxes.name());
		viewCartOnAdd = (String) value.get(Fields.viewCartOnAdd.name());
		autoSaveCart = (String) value.get(Fields.autoSaveCart.name());
		autoApproveReviews = (String) value.get(Fields.autoApproveReviews
				.name());
		isDemoStore = (String) value.get(Fields.isDemoStore.name());
		isImmediatelyFulfilled = (String) value
				.get(Fields.isImmediatelyFulfilled.name());
		inventoryFacilityId = (String) value.get(Fields.inventoryFacilityId
				.name());
		oneInventoryFacility = (String) value.get(Fields.oneInventoryFacility
				.name());
		checkInventory = (String) value.get(Fields.checkInventory.name());
		reserveInventory = (String) value.get(Fields.reserveInventory.name());
		reserveOrderEnumId = (String) value.get(Fields.reserveOrderEnumId
				.name());
		requireInventory = (String) value.get(Fields.requireInventory.name());
		balanceResOnOrderCreation = (String) value
				.get(Fields.balanceResOnOrderCreation.name());
		requirementMethodEnumId = (String) value
				.get(Fields.requirementMethodEnumId.name());
		orderNumberPrefix = (String) value.get(Fields.orderNumberPrefix.name());
		defaultLocaleString = (String) value.get(Fields.defaultLocaleString
				.name());
		defaultCurrencyUomId = (String) value.get(Fields.defaultCurrencyUomId
				.name());
		defaultTimeZoneString = (String) value.get(Fields.defaultTimeZoneString
				.name());
		defaultSalesChannelEnumId = (String) value
				.get(Fields.defaultSalesChannelEnumId.name());
		allowPassword = (String) value.get(Fields.allowPassword.name());
		defaultPassword = (String) value.get(Fields.defaultPassword.name());
		explodeOrderItems = (String) value.get(Fields.explodeOrderItems.name());
		checkGcBalance = (String) value.get(Fields.checkGcBalance.name());
		retryFailedAuths = (String) value.get(Fields.retryFailedAuths.name());
		headerApprovedStatus = (String) value.get(Fields.headerApprovedStatus
				.name());
		itemApprovedStatus = (String) value.get(Fields.itemApprovedStatus
				.name());
		digitalItemApprovedStatus = (String) value
				.get(Fields.digitalItemApprovedStatus.name());
		headerDeclinedStatus = (String) value.get(Fields.headerDeclinedStatus
				.name());
		itemDeclinedStatus = (String) value.get(Fields.itemDeclinedStatus
				.name());
		headerCancelStatus = (String) value.get(Fields.headerCancelStatus
				.name());
		itemCancelStatus = (String) value.get(Fields.itemCancelStatus.name());
		authDeclinedMessage = (String) value.get(Fields.authDeclinedMessage
				.name());
		authFraudMessage = (String) value.get(Fields.authFraudMessage.name());
		authErrorMessage = (String) value.get(Fields.authErrorMessage.name());
		visualThemeId = (String) value.get(Fields.visualThemeId.name());
		storeCreditAccountEnumId = (String) value
				.get(Fields.storeCreditAccountEnumId.name());
		usePrimaryEmailUsername = (String) value
				.get(Fields.usePrimaryEmailUsername.name());
		requireCustomerRole = (String) value.get(Fields.requireCustomerRole
				.name());
		autoInvoiceDigitalItems = (String) value
				.get(Fields.autoInvoiceDigitalItems.name());
		reqShipAddrForDigItems = (String) value
				.get(Fields.reqShipAddrForDigItems.name());
		showCheckoutGiftOptions = (String) value
				.get(Fields.showCheckoutGiftOptions.name());
		selectPaymentTypePerItem = (String) value
				.get(Fields.selectPaymentTypePerItem.name());
		showPricesWithVatTax = (String) value.get(Fields.showPricesWithVatTax
				.name());
		showTaxIsExempt = (String) value.get(Fields.showTaxIsExempt.name());
		vatTaxAuthGeoId = (String) value.get(Fields.vatTaxAuthGeoId.name());
		vatTaxAuthPartyId = (String) value.get(Fields.vatTaxAuthPartyId.name());
		enableAutoSuggestionList = (String) value
				.get(Fields.enableAutoSuggestionList.name());
		enableDigProdUpload = (String) value.get(Fields.enableDigProdUpload
				.name());
		prodSearchExcludeVariants = (String) value
				.get(Fields.prodSearchExcludeVariants.name());
		digProdUploadCategoryId = (String) value
				.get(Fields.digProdUploadCategoryId.name());
		autoOrderCcTryExp = (String) value.get(Fields.autoOrderCcTryExp.name());
		autoOrderCcTryOtherCards = (String) value
				.get(Fields.autoOrderCcTryOtherCards.name());
		autoOrderCcTryLaterNsf = (String) value
				.get(Fields.autoOrderCcTryLaterNsf.name());
		autoOrderCcTryLaterMax = (Long) value.get(Fields.autoOrderCcTryLaterMax
				.name());
		storeCreditValidDays = (Long) value.get(Fields.storeCreditValidDays
				.name());
		autoApproveInvoice = (String) value.get(Fields.autoApproveInvoice
				.name());
		autoApproveOrder = (String) value.get(Fields.autoApproveOrder.name());
		shipIfCaptureFails = (String) value.get(Fields.shipIfCaptureFails
				.name());
		setOwnerUponIssuance = (String) value.get(Fields.setOwnerUponIssuance
				.name());
		reqReturnInventoryReceive = (String) value
				.get(Fields.reqReturnInventoryReceive.name());
		addToCartRemoveIncompat = (String) value
				.get(Fields.addToCartRemoveIncompat.name());
		addToCartReplaceUpsell = (String) value
				.get(Fields.addToCartReplaceUpsell.name());
		splitPayPrefPerShpGrp = (String) value.get(Fields.splitPayPrefPerShpGrp
				.name());
		managedByLot = (String) value.get(Fields.managedByLot.name());
		showOutOfStockProducts = (String) value
				.get(Fields.showOutOfStockProducts.name());
		orderDecimalQuantity = (String) value.get(Fields.orderDecimalQuantity
				.name());
		allowComment = (String) value.get(Fields.allowComment.name());
		oldStyleSheet = (String) value.get(Fields.oldStyleSheet.name());
		oldHeaderLogo = (String) value.get(Fields.oldHeaderLogo.name());
		oldHeaderMiddleBackground = (String) value
				.get(Fields.oldHeaderMiddleBackground.name());
		oldHeaderRightBackground = (String) value
				.get(Fields.oldHeaderRightBackground.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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