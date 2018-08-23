package org.apache.ofbiz.marketing.reports;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code Order Return And Return Header
 */
@FieldNameConstants
public class TrackingCodeOrderReturnAndReturnHeader implements Serializable {

	public static final long serialVersionUID = 7352974503207105536L;
	public static final String NAME = "TrackingCodeOrderReturnAndReturnHeader";
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
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
	 * Tracking Code Id
	 */
	@Getter
	@Setter
	private String trackingCodeId;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public TrackingCodeOrderReturnAndReturnHeader(GenericValue value) {
		returnId = (String) value.get(FIELD_RETURN_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
		siteId = (String) value.get(FIELD_SITE_ID);
		hasExported = (String) value.get(FIELD_HAS_EXPORTED);
		affiliateReferredTimeStamp = (Timestamp) value
				.get(FIELD_AFFILIATE_REFERRED_TIME_STAMP);
		statusId = (String) value.get(FIELD_STATUS_ID);
	}

	public static TrackingCodeOrderReturnAndReturnHeader fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeOrderReturnAndReturnHeader(value);
	}

	public static List<TrackingCodeOrderReturnAndReturnHeader> fromValues(
			List<GenericValue> values) {
		List<TrackingCodeOrderReturnAndReturnHeader> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeOrderReturnAndReturnHeader(value));
		}
		return entities;
	}
}