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
 * Product Subscription Resource
 */
@FieldNameConstants
public class ProductSubscriptionResource implements Serializable {

	public static final long serialVersionUID = 3804264929093011456L;
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

	public ProductSubscriptionResource(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		subscriptionResourceId = (String) value
				.get(FIELD_SUBSCRIPTION_RESOURCE_ID);
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
		useRoleTypeId = (String) value.get(FIELD_USE_ROLE_TYPE_ID);
		automaticExtend = (String) value.get(FIELD_AUTOMATIC_EXTEND);
		canclAutmExtTime = (Long) value.get(FIELD_CANCL_AUTM_EXT_TIME);
		canclAutmExtTimeUomId = (String) value
				.get(FIELD_CANCL_AUTM_EXT_TIME_UOM_ID);
		gracePeriodOnExpiry = (Long) value.get(FIELD_GRACE_PERIOD_ON_EXPIRY);
		gracePeriodOnExpiryUomId = (String) value
				.get(FIELD_GRACE_PERIOD_ON_EXPIRY_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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