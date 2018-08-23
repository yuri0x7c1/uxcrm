package org.apache.ofbiz.marketing.segment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Segment Group Geo
 */
@FieldNameConstants
public class SegmentGroupGeo implements Serializable {

	public static final long serialVersionUID = 1288942246778723328L;
	public static final String NAME = "SegmentGroupGeo";
	/**
	 * Segment Group Id
	 */
	@Getter
	@Setter
	private String segmentGroupId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
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

	public SegmentGroupGeo(GenericValue value) {
		segmentGroupId = (String) value.get(FIELD_SEGMENT_GROUP_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SegmentGroupGeo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SegmentGroupGeo(value);
	}

	public static List<SegmentGroupGeo> fromValues(List<GenericValue> values) {
		List<SegmentGroupGeo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SegmentGroupGeo(value));
		}
		return entities;
	}
}