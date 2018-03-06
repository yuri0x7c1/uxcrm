package org.apache.ofbiz.marketing.segment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Segment Group Type
 */
public class SegmentGroupType implements Serializable {

	public static final long serialVersionUID = 1157173161229541376L;
	public static final String NAME = "SegmentGroupType";
	/**
	 * Segment Group Type Id
	 */
	@Getter
	@Setter
	private String segmentGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		segmentGroupTypeId, description
	}

	public SegmentGroupType(GenericValue value) {
		segmentGroupTypeId = (String) value.get(Fields.segmentGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SegmentGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SegmentGroupType(value);
	}

	public static List<SegmentGroupType> fromValues(List<GenericValue> values) {
		List<SegmentGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SegmentGroupType(value));
		}
		return entities;
	}
}