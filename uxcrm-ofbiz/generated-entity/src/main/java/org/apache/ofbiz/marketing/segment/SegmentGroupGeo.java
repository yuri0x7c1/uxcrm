package org.apache.ofbiz.marketing.segment;

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
public class SegmentGroupGeo implements Serializable {

	public static final long serialVersionUID = 6116226762061467648L;
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

	public enum Fields {
		segmentGroupId, geoId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SegmentGroupGeo(GenericValue value) {
		segmentGroupId = (String) value.get(Fields.segmentGroupId.name());
		geoId = (String) value.get(Fields.geoId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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