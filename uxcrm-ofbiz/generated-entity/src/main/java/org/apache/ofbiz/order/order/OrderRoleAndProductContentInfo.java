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
 * Order Role And Product Content Info
 */
@FieldNameConstants
public class OrderRoleAndProductContentInfo implements Serializable {

	public static final long serialVersionUID = 1774643978400292864L;
	public static final String NAME = "OrderRoleAndProductContentInfo";
	/**
	 * Product Name
	 */
	@Getter
	@Setter
	private String productName;
	/**
	 * Content Status Id
	 */
	@Getter
	@Setter
	private String contentStatusId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Purchase From Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseFromDate;
	/**
	 * Use Time Uom Id
	 */
	@Getter
	@Setter
	private String useTimeUomId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Use Count Limit
	 */
	@Getter
	@Setter
	private Long useCountLimit;
	/**
	 * Product Content Type Id
	 */
	@Getter
	@Setter
	private String productContentTypeId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Use Role Type Id
	 */
	@Getter
	@Setter
	private String useRoleTypeId;
	/**
	 * Use Time
	 */
	@Getter
	@Setter
	private Long useTime;
	/**
	 * Purchase Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseThruDate;
	/**
	 * Owner Content Id
	 */
	@Getter
	@Setter
	private String ownerContentId;
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
	/**
	 * Child Leaf Count
	 */
	@Getter
	@Setter
	private Long childLeafCount;
	/**
	 * Privilege Enum Id
	 */
	@Getter
	@Setter
	private String privilegeEnumId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Template Data Resource Id
	 */
	@Getter
	@Setter
	private String templateDataResourceId;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Instance Of Content Id
	 */
	@Getter
	@Setter
	private String instanceOfContentId;
	/**
	 * Service Name
	 */
	@Getter
	@Setter
	private String serviceName;
	/**
	 * Custom Method Id
	 */
	@Getter
	@Setter
	private String customMethodId;
	/**
	 * Character Set Id
	 */
	@Getter
	@Setter
	private String characterSetId;
	/**
	 * Content Name
	 */
	@Getter
	@Setter
	private String contentName;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Locale String
	 */
	@Getter
	@Setter
	private String localeString;
	/**
	 * Decorator Content Id
	 */
	@Getter
	@Setter
	private String decoratorContentId;
	/**
	 * Child Branch Count
	 */
	@Getter
	@Setter
	private Long childBranchCount;

	public OrderRoleAndProductContentInfo(GenericValue value) {
		productName = (String) value.get(FIELD_PRODUCT_NAME);
		contentStatusId = (String) value.get(FIELD_CONTENT_STATUS_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
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
		purchaseFromDate = (Timestamp) value.get(FIELD_PURCHASE_FROM_DATE);
		useTimeUomId = (String) value.get(FIELD_USE_TIME_UOM_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		useCountLimit = (Long) value.get(FIELD_USE_COUNT_LIMIT);
		productContentTypeId = (String) value
				.get(FIELD_PRODUCT_CONTENT_TYPE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		useRoleTypeId = (String) value.get(FIELD_USE_ROLE_TYPE_ID);
		useTime = (Long) value.get(FIELD_USE_TIME);
		purchaseThruDate = (Timestamp) value.get(FIELD_PURCHASE_THRU_DATE);
		ownerContentId = (String) value.get(FIELD_OWNER_CONTENT_ID);
		contentTypeId = (String) value.get(FIELD_CONTENT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		mimeTypeId = (String) value.get(FIELD_MIME_TYPE_ID);
		childLeafCount = (Long) value.get(FIELD_CHILD_LEAF_COUNT);
		privilegeEnumId = (String) value.get(FIELD_PRIVILEGE_ENUM_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		templateDataResourceId = (String) value
				.get(FIELD_TEMPLATE_DATA_RESOURCE_ID);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		instanceOfContentId = (String) value.get(FIELD_INSTANCE_OF_CONTENT_ID);
		serviceName = (String) value.get(FIELD_SERVICE_NAME);
		customMethodId = (String) value.get(FIELD_CUSTOM_METHOD_ID);
		characterSetId = (String) value.get(FIELD_CHARACTER_SET_ID);
		contentName = (String) value.get(FIELD_CONTENT_NAME);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		localeString = (String) value.get(FIELD_LOCALE_STRING);
		decoratorContentId = (String) value.get(FIELD_DECORATOR_CONTENT_ID);
		childBranchCount = (Long) value.get(FIELD_CHILD_BRANCH_COUNT);
	}

	public static OrderRoleAndProductContentInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderRoleAndProductContentInfo(value);
	}

	public static List<OrderRoleAndProductContentInfo> fromValues(
			List<GenericValue> values) {
		List<OrderRoleAndProductContentInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderRoleAndProductContentInfo(value));
		}
		return entities;
	}
}