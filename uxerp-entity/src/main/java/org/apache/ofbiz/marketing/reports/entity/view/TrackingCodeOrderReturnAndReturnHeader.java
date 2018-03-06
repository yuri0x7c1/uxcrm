package org.apache.ofbiz.marketing.reports.entity.view;

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
public class TrackingCodeOrderReturnAndReturnHeader implements Serializable {

	public static final long serialVersionUID = 9011233815705726976L;
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

	public enum Fields {
		returnId, orderId, orderItemSeqId, trackingCodeId, siteId, hasExported, affiliateReferredTimeStamp, statusId
	}

	public TrackingCodeOrderReturnAndReturnHeader(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		siteId = (String) value.get(Fields.siteId.name());
		hasExported = (String) value.get(Fields.hasExported.name());
		affiliateReferredTimeStamp = (Timestamp) value
				.get(Fields.affiliateReferredTimeStamp.name());
		statusId = (String) value.get(Fields.statusId.name());
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