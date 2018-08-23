package org.apache.ofbiz.humanres.ability;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PerfReviewItemType implements Serializable {

	public static final long serialVersionUID = 1102630241232105472L;
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

	public PerfReviewItemType(GenericValue value) {
		perfReviewItemTypeId = (String) value
				.get(FIELD_PERF_REVIEW_ITEM_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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