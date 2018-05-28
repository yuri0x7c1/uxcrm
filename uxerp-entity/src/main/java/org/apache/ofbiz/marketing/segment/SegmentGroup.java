package org.apache.ofbiz.marketing.segment;

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
public class SegmentGroup implements Serializable {

	public static final long serialVersionUID = 797548108719226880L;
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

	public enum Fields {
		segmentGroupId, segmentGroupTypeId, description, productStoreId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SegmentGroup(GenericValue value) {
		segmentGroupId = (String) value.get(Fields.segmentGroupId.name());
		segmentGroupTypeId = (String) value.get(Fields.segmentGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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