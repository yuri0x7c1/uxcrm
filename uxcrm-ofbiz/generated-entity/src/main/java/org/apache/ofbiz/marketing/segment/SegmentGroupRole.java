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
 * Segment Group Role
 */
@FieldNameConstants
public class SegmentGroupRole implements Serializable {

	public static final long serialVersionUID = 2479981050658722816L;
	public static final String NAME = "SegmentGroupRole";
	/**
	 * Segment Group Id
	 */
	@Getter
	@Setter
	private String segmentGroupId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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

	public SegmentGroupRole(GenericValue value) {
		segmentGroupId = (String) value.get(FIELD_SEGMENT_GROUP_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SegmentGroupRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SegmentGroupRole(value);
	}

	public static List<SegmentGroupRole> fromValues(List<GenericValue> values) {
		List<SegmentGroupRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SegmentGroupRole(value));
		}
		return entities;
	}
}