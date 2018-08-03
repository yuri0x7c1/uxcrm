package org.apache.ofbiz.marketing.reports;

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
public class TrackingCodeOrderAndOrderHeader implements Serializable {

	public static final long serialVersionUID = 8780703291405715456L;
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

	public enum Fields {
		orderId, trackingCodeId, siteId, hasExported, affiliateReferredTimeStamp, statusId
	}

	public TrackingCodeOrderAndOrderHeader(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		siteId = (String) value.get(Fields.siteId.name());
		hasExported = (String) value.get(Fields.hasExported.name());
		affiliateReferredTimeStamp = (Timestamp) value
				.get(Fields.affiliateReferredTimeStamp.name());
		statusId = (String) value.get(Fields.statusId.name());
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