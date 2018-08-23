package org.apache.ofbiz.product.subscription;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Subscription
 */
@FieldNameConstants
public class Subscription implements Serializable {

	public static final long serialVersionUID = 5593096759765378048L;
	public static final String NAME = "Subscription";
	/**
	 * Subscription Id
	 */
	@Getter
	@Setter
	private String subscriptionId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Subscription Resource Id
	 */
	@Getter
	@Setter
	private String subscriptionResourceId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Originated From Party Id
	 */
	@Getter
	@Setter
	private String originatedFromPartyId;
	/**
	 * Originated From Role Type Id
	 */
	@Getter
	@Setter
	private String originatedFromRoleTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Party Need Id
	 */
	@Getter
	@Setter
	private String partyNeedId;
	/**
	 * Need Type Id
	 */
	@Getter
	@Setter
	private String needTypeId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Subscription Type Id
	 */
	@Getter
	@Setter
	private String subscriptionTypeId;
	/**
	 * External Subscription Id
	 */
	@Getter
	@Setter
	private String externalSubscriptionId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Purchase From Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseFromDate;
	/**
	 * Purchase Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseThruDate;
	/**
	 * Max Life Time
	 */
	@Getter
	@Setter
	private Long maxLifeTime;
	/**
	 * Max Life Time Uom Id
	 */
	@Getter
	@Setter
	private String maxLifeTimeUomId;
	/**
	 * Available Time
	 */
	@Getter
	@Setter
	private Long availableTime;
	/**
	 * Available Time Uom Id
	 */
	@Getter
	@Setter
	private String availableTimeUomId;
	/**
	 * Use Count Limit
	 */
	@Getter
	@Setter
	private Long useCountLimit;
	/**
	 * Use Time
	 */
	@Getter
	@Setter
	private Long useTime;
	/**
	 * Use Time Uom Id
	 */
	@Getter
	@Setter
	private String useTimeUomId;
	/**
	 * Automatic Extend
	 */
	@Getter
	@Setter
	private String automaticExtend;
	/**
	 * Cancl Autm Ext Time
	 */
	@Getter
	@Setter
	private Long canclAutmExtTime;
	/**
	 * Cancl Autm Ext Time Uom Id
	 */
	@Getter
	@Setter
	private String canclAutmExtTimeUomId;
	/**
	 * Grace Period On Expiry
	 */
	@Getter
	@Setter
	private Long gracePeriodOnExpiry;
	/**
	 * Grace Period On Expiry Uom Id
	 */
	@Getter
	@Setter
	private String gracePeriodOnExpiryUomId;
	/**
	 * Expiration Completed Date
	 */
	@Getter
	@Setter
	private Timestamp expirationCompletedDate;
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

	public Subscription(GenericValue value) {
		subscriptionId = (String) value.get(FIELD_SUBSCRIPTION_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		subscriptionResourceId = (String) value
				.get(FIELD_SUBSCRIPTION_RESOURCE_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		originatedFromPartyId = (String) value
				.get(FIELD_ORIGINATED_FROM_PARTY_ID);
		originatedFromRoleTypeId = (String) value
				.get(FIELD_ORIGINATED_FROM_ROLE_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		partyNeedId = (String) value.get(FIELD_PARTY_NEED_ID);
		needTypeId = (String) value.get(FIELD_NEED_TYPE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		subscriptionTypeId = (String) value.get(FIELD_SUBSCRIPTION_TYPE_ID);
		externalSubscriptionId = (String) value
				.get(FIELD_EXTERNAL_SUBSCRIPTION_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		purchaseFromDate = (Timestamp) value.get(FIELD_PURCHASE_FROM_DATE);
		purchaseThruDate = (Timestamp) value.get(FIELD_PURCHASE_THRU_DATE);
		maxLifeTime = (Long) value.get(FIELD_MAX_LIFE_TIME);
		maxLifeTimeUomId = (String) value.get(FIELD_MAX_LIFE_TIME_UOM_ID);
		availableTime = (Long) value.get(FIELD_AVAILABLE_TIME);
		availableTimeUomId = (String) value.get(FIELD_AVAILABLE_TIME_UOM_ID);
		useCountLimit = (Long) value.get(FIELD_USE_COUNT_LIMIT);
		useTime = (Long) value.get(FIELD_USE_TIME);
		useTimeUomId = (String) value.get(FIELD_USE_TIME_UOM_ID);
		automaticExtend = (String) value.get(FIELD_AUTOMATIC_EXTEND);
		canclAutmExtTime = (Long) value.get(FIELD_CANCL_AUTM_EXT_TIME);
		canclAutmExtTimeUomId = (String) value
				.get(FIELD_CANCL_AUTM_EXT_TIME_UOM_ID);
		gracePeriodOnExpiry = (Long) value.get(FIELD_GRACE_PERIOD_ON_EXPIRY);
		gracePeriodOnExpiryUomId = (String) value
				.get(FIELD_GRACE_PERIOD_ON_EXPIRY_UOM_ID);
		expirationCompletedDate = (Timestamp) value
				.get(FIELD_EXPIRATION_COMPLETED_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Subscription fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Subscription(value);
	}

	public static List<Subscription> fromValues(List<GenericValue> values) {
		List<Subscription> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Subscription(value));
		}
		return entities;
	}
}