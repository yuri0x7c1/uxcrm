package org.apache.ofbiz.marketing.segment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Segment Group Type
 */
public class SegmentGroupType implements Serializable {

	public static final long serialVersionUID = 1999708427539697664L;
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
		segmentGroupTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SegmentGroupType(GenericValue value) {
		segmentGroupTypeId = (String) value.get(Fields.segmentGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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