package org.apache.ofbiz.product.subscription;

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
public class Subscription implements Serializable {

	public static final long serialVersionUID = 6252704851136139264L;
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

	public enum Fields {
		subscriptionId, description, subscriptionResourceId, communicationEventId, contactMechId, originatedFromPartyId, originatedFromRoleTypeId, partyId, roleTypeId, partyNeedId, needTypeId, orderId, orderItemSeqId, productId, productCategoryId, inventoryItemId, subscriptionTypeId, externalSubscriptionId, fromDate, thruDate, purchaseFromDate, purchaseThruDate, maxLifeTime, maxLifeTimeUomId, availableTime, availableTimeUomId, useCountLimit, useTime, useTimeUomId, automaticExtend, canclAutmExtTime, canclAutmExtTimeUomId, gracePeriodOnExpiry, gracePeriodOnExpiryUomId, expirationCompletedDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Subscription(GenericValue value) {
		subscriptionId = (String) value.get(Fields.subscriptionId.name());
		description = (String) value.get(Fields.description.name());
		subscriptionResourceId = (String) value
				.get(Fields.subscriptionResourceId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		originatedFromPartyId = (String) value.get(Fields.originatedFromPartyId
				.name());
		originatedFromRoleTypeId = (String) value
				.get(Fields.originatedFromRoleTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		partyNeedId = (String) value.get(Fields.partyNeedId.name());
		needTypeId = (String) value.get(Fields.needTypeId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		subscriptionTypeId = (String) value.get(Fields.subscriptionTypeId
				.name());
		externalSubscriptionId = (String) value
				.get(Fields.externalSubscriptionId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		purchaseFromDate = (Timestamp) value
				.get(Fields.purchaseFromDate.name());
		purchaseThruDate = (Timestamp) value
				.get(Fields.purchaseThruDate.name());
		maxLifeTime = (Long) value.get(Fields.maxLifeTime.name());
		maxLifeTimeUomId = (String) value.get(Fields.maxLifeTimeUomId.name());
		availableTime = (Long) value.get(Fields.availableTime.name());
		availableTimeUomId = (String) value.get(Fields.availableTimeUomId
				.name());
		useCountLimit = (Long) value.get(Fields.useCountLimit.name());
		useTime = (Long) value.get(Fields.useTime.name());
		useTimeUomId = (String) value.get(Fields.useTimeUomId.name());
		automaticExtend = (String) value.get(Fields.automaticExtend.name());
		canclAutmExtTime = (Long) value.get(Fields.canclAutmExtTime.name());
		canclAutmExtTimeUomId = (String) value.get(Fields.canclAutmExtTimeUomId
				.name());
		gracePeriodOnExpiry = (Long) value.get(Fields.gracePeriodOnExpiry
				.name());
		gracePeriodOnExpiryUomId = (String) value
				.get(Fields.gracePeriodOnExpiryUomId.name());
		expirationCompletedDate = (Timestamp) value
				.get(Fields.expirationCompletedDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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