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
 * Tracking Code Order And Order Header
 */
@FieldNameConstants
public class TrackingCodeOrderAndOrderHeader implements Serializable {

	public static final long serialVersionUID = 754358102710004736L;
	public static final String NAME = "TrackingCodeOrderAndOrderHeader";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
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

	public TrackingCodeOrderAndOrderHeader(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
		siteId = (String) value.get(FIELD_SITE_ID);
		hasExported = (String) value.get(FIELD_HAS_EXPORTED);
		affiliateReferredTimeStamp = (Timestamp) value
				.get(FIELD_AFFILIATE_REFERRED_TIME_STAMP);
		statusId = (String) value.get(FIELD_STATUS_ID);
	}

	public static TrackingCodeOrderAndOrderHeader fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeOrderAndOrderHeader(value);
	}

	public static List<TrackingCodeOrderAndOrderHeader> fromValues(
			List<GenericValue> values) {
		List<TrackingCodeOrderAndOrderHeader> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeOrderAndOrderHeader(value));
		}
		return entities;
	}
}