package org.apache.ofbiz.party.communication;

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
public class CommunicationEventAndSubscr implements Serializable {

	public static final long serialVersionUID = 4771093157126144L;
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

	public enum Fields {
		subscriptionId, maxLifeTimeUomId, useTimeUomId, orderId, subscriptionResourceId, description, subscriptionTypeId, canclAutmExtTimeUomId, contactMechId, gracePeriodOnExpiryUomId, availableTime, productCategoryId, partyNeedId, useTime, partyId, orderItemSeqId, roleTypeId, purchaseFromDate, needTypeId, productId, useCountLimit, expirationCompletedDate, availableTimeUomId, thruDate, inventoryItemId, fromDate, canclAutmExtTime, originatedFromRoleTypeId, automaticExtend, originatedFromPartyId, communicationEventId, maxLifeTime, purchaseThruDate, externalSubscriptionId, gracePeriodOnExpiry
	}

	public CommunicationEventAndSubscr(GenericValue value) {
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		maxLifeTimeUomId = (String) value.get(Fields.maxLifeTimeUomId.name());
		useTimeUomId = (String) value.get(Fields.useTimeUomId.name());
		orderId = (String) value.get(Fields.orderId.name());
		subscriptionResourceId = (String) value
				.get(Fields.subscriptionResourceId.name());
		description = (String) value.get(Fields.description.name());
		subscriptionTypeId = (String) value.get(Fields.subscriptionTypeId
				.name());
		canclAutmExtTimeUomId = (String) value.get(Fields.canclAutmExtTimeUomId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		gracePeriodOnExpiryUomId = (String) value
				.get(Fields.gracePeriodOnExpiryUomId.name());
		availableTime = (Long) value.get(Fields.availableTime.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		partyNeedId = (String) value.get(Fields.partyNeedId.name());
		useTime = (Long) value.get(Fields.useTime.name());
		partyId = (String) value.get(Fields.partyId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		purchaseFromDate = (Timestamp) value
				.get(Fields.purchaseFromDate.name());
		needTypeId = (String) value.get(Fields.needTypeId.name());
		productId = (String) value.get(Fields.productId.name());
		useCountLimit = (Long) value.get(Fields.useCountLimit.name());
		expirationCompletedDate = (Timestamp) value
				.get(Fields.expirationCompletedDate.name());
		availableTimeUomId = (String) value.get(Fields.availableTimeUomId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		canclAutmExtTime = (Long) value.get(Fields.canclAutmExtTime.name());
		originatedFromRoleTypeId = (String) value
				.get(Fields.originatedFromRoleTypeId.name());
		automaticExtend = (String) value.get(Fields.automaticExtend.name());
		originatedFromPartyId = (String) value.get(Fields.originatedFromPartyId
				.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		maxLifeTime = (Long) value.get(Fields.maxLifeTime.name());
		purchaseThruDate = (Timestamp) value
				.get(Fields.purchaseThruDate.name());
		externalSubscriptionId = (String) value
				.get(Fields.externalSubscriptionId.name());
		gracePeriodOnExpiry = (Long) value.get(Fields.gracePeriodOnExpiry
				.name());
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