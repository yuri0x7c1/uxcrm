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
 * Segment Group Classification
 */
@FieldNameConstants
public class SegmentGroupClassification implements Serializable {

	public static final long serialVersionUID = 6511171591437713408L;
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

	public SegmentGroupClassification(GenericValue value) {
		segmentGroupId = (String) value.get(FIELD_SEGMENT_GROUP_ID);
		partyClassificationGroupId = (String) value
				.get(FIELD_PARTY_CLASSIFICATION_GROUP_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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