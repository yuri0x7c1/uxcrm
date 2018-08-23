package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event And Subscr
 */
@FieldNameConstants
public class CommunicationEventAndSubscr implements Serializable {

	public static final long serialVersionUID = 6499321135847987200L;
	public static final String NAME = "CommunicationEventAndSubscr";
	/**
	 * Subscription Id
	 */
	@Getter
	@Setter
	private String subscriptionId;
	/**
	 * Max Life Time Uom Id
	 */
	@Getter
	@Setter
	private String maxLifeTimeUomId;
	/**
	 * Use Time Uom Id
	 */
	@Getter
	@Setter
	private String useTimeUomId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Subscription Resource Id
	 */
	@Getter
	@Setter
	private String subscriptionResourceId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Subscription Type Id
	 */
	@Getter
	@Setter
	private String subscriptionTypeId;
	/**
	 * Cancl Autm Ext Time Uom Id
	 */
	@Getter
	@Setter
	private String canclAutmExtTimeUomId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Grace Period On Expiry Uom Id
	 */
	@Getter
	@Setter
	private String gracePeriodOnExpiryUomId;
	/**
	 * Available Time
	 */
	@Getter
	@Setter
	private Long availableTime;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Party Need Id
	 */
	@Getter
	@Setter
	private String partyNeedId;
	/**
	 * Use Time
	 */
	@Getter
	@Setter
	private Long useTime;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Purchase From Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseFromDate;
	/**
	 * Need Type Id
	 */
	@Getter
	@Setter
	private String needTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Use Count Limit
	 */
	@Getter
	@Setter
	private Long useCountLimit;
	/**
	 * Expiration Completed Date
	 */
	@Getter
	@Setter
	private Timestamp expirationCompletedDate;
	/**
	 * Available Time Uom Id
	 */
	@Getter
	@Setter
	private String availableTimeUomId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Cancl Autm Ext Time
	 */
	@Getter
	@Setter
	private Long canclAutmExtTime;
	/**
	 * Originated From Role Type Id
	 */
	@Getter
	@Setter
	private String originatedFromRoleTypeId;
	/**
	 * Automatic Extend
	 */
	@Getter
	@Setter
	private String automaticExtend;
	/**
	 * Originated From Party Id
	 */
	@Getter
	@Setter
	private String originatedFromPartyId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Max Life Time
	 */
	@Getter
	@Setter
	private Long maxLifeTime;
	/**
	 * Purchase Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseThruDate;
	/**
	 * External Subscription Id
	 */
	@Getter
	@Setter
	private String externalSubscriptionId;
	/**
	 * Grace Period On Expiry
	 */
	@Getter
	@Setter
	private Long gracePeriodOnExpiry;

	public CommunicationEventAndSubscr(GenericValue value) {
		subscriptionId = (String) value.get(FIELD_SUBSCRIPTION_ID);
		maxLifeTimeUomId = (String) value.get(FIELD_MAX_LIFE_TIME_UOM_ID);
		useTimeUomId = (String) value.get(FIELD_USE_TIME_UOM_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		subscriptionResourceId = (String) value
				.get(FIELD_SUBSCRIPTION_RESOURCE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		subscriptionTypeId = (String) value.get(FIELD_SUBSCRIPTION_TYPE_ID);
		canclAutmExtTimeUomId = (String) value
				.get(FIELD_CANCL_AUTM_EXT_TIME_UOM_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		gracePeriodOnExpiryUomId = (String) value
				.get(FIELD_GRACE_PERIOD_ON_EXPIRY_UOM_ID);
		availableTime = (Long) value.get(FIELD_AVAILABLE_TIME);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		partyNeedId = (String) value.get(FIELD_PARTY_NEED_ID);
		useTime = (Long) value.get(FIELD_USE_TIME);
		partyId = (String) value.get(FIELD_PARTY_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		purchaseFromDate = (Timestamp) value.get(FIELD_PURCHASE_FROM_DATE);
		needTypeId = (String) value.get(FIELD_NEED_TYPE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		useCountLimit = (Long) value.get(FIELD_USE_COUNT_LIMIT);
		expirationCompletedDate = (Timestamp) value
				.get(FIELD_EXPIRATION_COMPLETED_DATE);
		availableTimeUomId = (String) value.get(FIELD_AVAILABLE_TIME_UOM_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		canclAutmExtTime = (Long) value.get(FIELD_CANCL_AUTM_EXT_TIME);
		originatedFromRoleTypeId = (String) value
				.get(FIELD_ORIGINATED_FROM_ROLE_TYPE_ID);
		automaticExtend = (String) value.get(FIELD_AUTOMATIC_EXTEND);
		originatedFromPartyId = (String) value
				.get(FIELD_ORIGINATED_FROM_PARTY_ID);
		communicationEventId = (String) value.get(FIELD_COMMUNICATION_EVENT_ID);
		maxLifeTime = (Long) value.get(FIELD_MAX_LIFE_TIME);
		purchaseThruDate = (Timestamp) value.get(FIELD_PURCHASE_THRU_DATE);
		externalSubscriptionId = (String) value
				.get(FIELD_EXTERNAL_SUBSCRIPTION_ID);
		gracePeriodOnExpiry = (Long) value.get(FIELD_GRACE_PERIOD_ON_EXPIRY);
	}

	public static CommunicationEventAndSubscr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventAndSubscr(value);
	}

	public static List<CommunicationEventAndSubscr> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventAndSubscr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventAndSubscr(value));
		}
		return entities;
	}
}