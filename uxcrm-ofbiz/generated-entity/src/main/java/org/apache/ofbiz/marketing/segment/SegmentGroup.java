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
 * Segment Group
 */
@FieldNameConstants
public class SegmentGroup implements Serializable {

	public static final long serialVersionUID = 1143196360611576832L;
	public static final String NAME = "SegmentGroup";
	/**
	 * Segment Group Id
	 */
	@Getter
	@Setter
	private String segmentGroupId;
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
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
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

	public SegmentGroup(GenericValue value) {
		segmentGroupId = (String) value.get(FIELD_SEGMENT_GROUP_ID);
		segmentGroupTypeId = (String) value.get(FIELD_SEGMENT_GROUP_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SegmentGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SegmentGroup(value);
	}

	public static List<SegmentGroup> fromValues(List<GenericValue> values) {
		List<SegmentGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SegmentGroup(value));
		}
		return entities;
	}
}