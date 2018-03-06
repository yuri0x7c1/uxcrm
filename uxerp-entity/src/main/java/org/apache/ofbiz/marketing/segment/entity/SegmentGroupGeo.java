package org.apache.ofbiz.marketing.segment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Segment Group Geo
 */
public class SegmentGroupGeo implements Serializable {

	public static final long serialVersionUID = 63313107681783808L;
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

	public enum Fields {
		segmentGroupId, geoId
	}

	public SegmentGroupGeo(GenericValue value) {
		segmentGroupId = (String) value.get(Fields.segmentGroupId.name());
		geoId = (String) value.get(Fields.geoId.name());
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