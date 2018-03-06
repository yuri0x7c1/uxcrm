package org.apache.ofbiz.marketing.segment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Segment Group Classification
 */
public class SegmentGroupClassification implements Serializable {

	public static final long serialVersionUID = 7483625338358343680L;
	public static final String NAME = "SegmentGroupClassification";
	/**
	 * Segment Group Id
	 */
	@Getter
	@Setter
	private String segmentGroupId;
	/**
	 * Party Classification Group Id
	 */
	@Getter
	@Setter
	private String partyClassificationGroupId;

	public enum Fields {
		segmentGroupId, partyClassificationGroupId
	}

	public SegmentGroupClassification(GenericValue value) {
		segmentGroupId = (String) value.get(Fields.segmentGroupId.name());
		partyClassificationGroupId = (String) value
				.get(Fields.partyClassificationGroupId.name());
	}

	public static SegmentGroupClassification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SegmentGroupClassification(value);
	}

	public static List<SegmentGroupClassification> fromValues(
			List<GenericValue> values) {
		List<SegmentGroupClassification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SegmentGroupClassification(value));
		}
		return entities;
	}
}