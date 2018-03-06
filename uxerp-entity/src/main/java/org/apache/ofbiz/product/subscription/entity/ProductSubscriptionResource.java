package org.apache.ofbiz.product.subscription.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Subscription Resource
 */
public class ProductSubscriptionResource implements Serializable {

	public static final long serialVersionUID = 3009363215710351360L;
	public static final String NAME = "ProductSubscriptionResource";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Subscription Resource Id
	 */
	@Getter
	@Setter
	private String subscriptionResourceId;
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
	 * Use Role Type Id
	 */
	@Getter
	@Setter
	private String useRoleTypeId;
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

	public enum Fields {
		productId, subscriptionResourceId, fromDate, thruDate, purchaseFromDate, purchaseThruDate, maxLifeTime, maxLifeTimeUomId, availableTime, availableTimeUomId, useCountLimit, useTime, useTimeUomId, useRoleTypeId, automaticExtend, canclAutmExtTime, canclAutmExtTimeUomId, gracePeriodOnExpiry, gracePeriodOnExpiryUomId
	}

	public ProductSubscriptionResource(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		subscriptionResourceId = (String) value
				.get(Fields.subscriptionResourceId.name());
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
		useRoleTypeId = (String) value.get(Fields.useRoleTypeId.name());
		automaticExtend = (String) value.get(Fields.automaticExtend.name());
		canclAutmExtTime = (Long) value.get(Fields.canclAutmExtTime.name());
		canclAutmExtTimeUomId = (String) value.get(Fields.canclAutmExtTimeUomId
				.name());
		gracePeriodOnExpiry = (Long) value.get(Fields.gracePeriodOnExpiry
				.name());
		gracePeriodOnExpiryUomId = (String) value
				.get(Fields.gracePeriodOnExpiryUomId.name());
	}

	public static ProductSubscriptionResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductSubscriptionResource(value);
	}

	public static List<ProductSubscriptionResource> fromValues(
			List<GenericValue> values) {
		List<ProductSubscriptionResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductSubscriptionResource(value));
		}
		return entities;
	}
}