package org.apache.ofbiz.humanres.ability;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Perf Review Item Type
 */
public class PerfReviewItemType implements Serializable {

	public static final long serialVersionUID = 1476633047101821952L;
	public static final String NAME = "PerfReviewItemType";
	/**
	 * Perf Review Item Type Id
	 */
	@Getter
	@Setter
	private String perfReviewItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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
		perfReviewItemTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PerfReviewItemType(GenericValue value) {
		perfReviewItemTypeId = (String) value.get(Fields.perfReviewItemTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PerfReviewItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PerfReviewItemType(value);
	}

	public static List<PerfReviewItemType> fromValues(List<GenericValue> values) {
		List<PerfReviewItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PerfReviewItemType(value));
		}
		return entities;
	}
}