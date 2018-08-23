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
 * Tracking Code Type
 */
@FieldNameConstants
public class TrackingCodeType implements Serializable {

	public static final long serialVersionUID = 4796973936191306752L;
	public static final String NAME = "TrackingCodeType";
	/**
	 * Tracking Code Type Id
	 */
	@Getter
	@Setter
	private String trackingCodeTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public TrackingCodeType(GenericValue value) {
		trackingCodeTypeId = (String) value.get(FIELD_TRACKING_CODE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TrackingCodeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrackingCodeType(value);
	}

	public static List<TrackingCodeType> fromValues(List<GenericValue> values) {
		List<TrackingCodeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrackingCodeType(value));
		}
		return entities;
	}
}