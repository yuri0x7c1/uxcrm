package org.apache.ofbiz.marketing.segment;

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
public class SegmentGroupRole implements Serializable {

	public static final long serialVersionUID = 2248702413959677952L;
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

	public enum Fields {
		segmentGroupId, partyId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SegmentGroupRole(GenericValue value) {
		segmentGroupId = (String) value.get(Fields.segmentGroupId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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