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
 * Segment Group Type
 */
@FieldNameConstants
public class SegmentGroupType implements Serializable {

	public static final long serialVersionUID = 4390377857845234688L;
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

	public SegmentGroupType(GenericValue value) {
		segmentGroupTypeId = (String) value.get(FIELD_SEGMENT_GROUP_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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