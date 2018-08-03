package org.apache.ofbiz.marketing.segment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Segment Group Classification
 */
public class SegmentGroupClassification implements Serializable {

	public static final long serialVersionUID = 5431430243246169088L;
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
		segmentGroupId, partyClassificationGroupId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SegmentGroupClassification(GenericValue value) {
		segmentGroupId = (String) value.get(Fields.segmentGroupId.name());
		partyClassificationGroupId = (String) value
				.get(Fields.partyClassificationGroupId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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