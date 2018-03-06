package org.apache.ofbiz.marketing.tracking.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code Order Return
 */
public class TrackingCodeOrderReturn implements Serializable {

	public static final long serialVersionUID = 95195975423736832L;
	public static final String NAME = "TrackingCodeOrderReturn";
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

	public enum Fields {
		returnId, orderId, orderItemSeqId, trackingCodeTypeId, trackingCodeId, isBillable, siteId, hasExported, affiliateReferredTimeStamp
	}

	public TrackingCodeOrderReturn(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		trackingCodeTypeId = (String) value.get(Fields.trackingCodeTypeId
				.name());
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		isBillable = (String) value.get(Fields.isBillable.name());
		siteId = (String) value.get(Fields.siteId.name());
		hasExported = (String) value.get(Fields.hasExported.name());
		affiliateReferredTimeStamp = (Timestamp) value
				.get(Fields.affiliateReferredTimeStamp.name());
	}

	public static TrackingCodeOrderReturn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeOrderReturn(value);
	}

	public static List<TrackingCodeOrderReturn> fromValues(
			List<GenericValue> values) {
		List<TrackingCodeOrderReturn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeOrderReturn(value));
		}
		return entities;
	}
}