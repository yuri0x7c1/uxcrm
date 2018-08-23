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
 * Tracking Code And Visit
 */
@FieldNameConstants
public class TrackingCodeAndVisit implements Serializable {

	public static final long serialVersionUID = 4545287923573361664L;
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
	private Long visitId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;

	public TrackingCodeAndVisit(GenericValue value) {
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
		visitId = (Long) value.get(FIELD_VISIT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
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