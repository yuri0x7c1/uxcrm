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
 * Tracking Code Visit
 */
@FieldNameConstants
public class TrackingCodeVisit implements Serializable {

	public static final long serialVersionUID = 8465857181007336448L;
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

	public TrackingCodeVisit(GenericValue value) {
		trackingCodeId = (String) value.get(FIELD_TRACKING_CODE_ID);
		visitId = (String) value.get(FIELD_VISIT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		sourceEnumId = (String) value.get(FIELD_SOURCE_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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