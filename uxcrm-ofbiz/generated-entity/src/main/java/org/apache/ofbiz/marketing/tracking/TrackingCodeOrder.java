package org.apache.ofbiz.marketing.tracking;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code Order
 */
@FieldNameConstants
public class TrackingCodeOrder implements Serializable {

	public static final long serialVersionUID = 411354273909898240L;
	public static final String NAME = "TrackingCodeOrder";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Tracking Code Type Id
	 */
	@Getter
	@Setter
	private String trackingCodeTypeId;
	/**
	 * Tracking Code Id
	 */
	@Getter
	@Setter
	private String trackingCodeId;
	/**
	 * Is Billable
	 */
	@Getter
	@Setter
	private String isBillable;
	/**
	 * Site Id
	 */
	@Getter
	@Setter
	private String siteId;
	/**
	 * Has Exported
	 */
	@Getter
	@Setter
	private String hasExported;
	/**
	 * Affiliate Referred Time Stamp
	 */
	@Getter
	@Setter
	private Timestamp affiliateReferredTimeStamp;
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

	public TrackingCodeOrder(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		trackingCodeTypeId = (String) value.get(FIELD_TRACKING_CODE_TYPE_ID);
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
		isBillable = (String) value.get(FIELD_IS_BILLABLE);
		siteId = (String) value.get(FIELD_SITE_ID);
		hasExported = (String) value.get(FIELD_HAS_EXPORTED);
		affiliateReferredTimeStamp = (Timestamp) value
				.get(FIELD_AFFILIATE_REFERRED_TIME_STAMP);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TrackingCodeOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeOrder(value);
	}

	public static List<TrackingCodeOrder> fromValues(List<GenericValue> values) {
		List<TrackingCodeOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeOrder(value));
		}
		return entities;
	}
}