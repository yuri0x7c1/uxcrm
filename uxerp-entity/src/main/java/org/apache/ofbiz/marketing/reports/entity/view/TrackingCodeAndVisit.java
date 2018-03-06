package org.apache.ofbiz.marketing.reports.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tracking Code And Visit
 */
public class TrackingCodeAndVisit implements Serializable {

	public static final long serialVersionUID = 4258473333604704256L;
	public static final String NAME = "TrackingCodeAndVisit";
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

	public enum Fields {
		trackingCodeId, visitId, fromDate
	}

	public TrackingCodeAndVisit(GenericValue value) {
		trackingCodeId = (String) value.get(Fields.trackingCodeId.name());
		visitId = (String) value.get(Fields.visitId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
	}

	public static TrackingCodeAndVisit fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeAndVisit(value);
	}

	public static List<TrackingCodeAndVisit> fromValues(
			List<GenericValue> values) {
		List<TrackingCodeAndVisit> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeAndVisit(value));
		}
		return entities;
	}
}