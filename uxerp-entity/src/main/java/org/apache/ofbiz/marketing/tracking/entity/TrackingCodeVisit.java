package org.apache.ofbiz.marketing.tracking.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code Visit
 */
public class TrackingCodeVisit implements Serializable {

	public static final long serialVersionUID = 4858547110303773696L;
	public static final String NAME = "TrackingCodeVisit";
	/**
	 * Tracking Code Id
	 */
	@Getter
	@Setter
	private String trackingCodeId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Source Enum Id
	 */
	@Getter
	@Setter
	private String sourceEnumId;

	public enum Fields {
		trackingCodeId, visitId, fromDate, sourceEnumId
	}

	public TrackingCodeVisit(GenericValue value) {
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		visitId = (String) value.get(Fields.visitId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		sourceEnumId = (String) value.get(Fields.sourceEnumId.name());
	}

	public static TrackingCodeVisit fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeVisit(value);
	}

	public static List<TrackingCodeVisit> fromValues(List<GenericValue> values) {
		List<TrackingCodeVisit> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeVisit(value));
		}
		return entities;
	}
}