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
 * Perf Review Item
 */
@FieldNameConstants
public class PerfReviewItem implements Serializable {

	public static final long serialVersionUID = 3064150917461367808L;
	public static final String NAME = "PerfReviewItem";
	/**
	 * Employee Party Id
	 */
	@Getter
	@Setter
	private String employeePartyId;
	/**
	 * Employee Role Type Id
	 */
	@Getter
	@Setter
	private String employeeRoleTypeId;
	/**
	 * Perf Review Id
	 */
	@Getter
	@Setter
	private String perfReviewId;
	/**
	 * Perf Review Item Seq Id
	 */
	@Getter
	@Setter
	private String perfReviewItemSeqId;
	/**
	 * Perf Review Item Type Id
	 */
	@Getter
	@Setter
	private String perfReviewItemTypeId;
	/**
	 * Perf Rating Type Id
	 */
	@Getter
	@Setter
	private String perfRatingTypeId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public PerfReviewItem(GenericValue value) {
		employeePartyId = (String) value.get(FIELD_EMPLOYEE_PARTY_ID);
		employeeRoleTypeId = (String) value.get(FIELD_EMPLOYEE_ROLE_TYPE_ID);
		perfReviewId = (String) value.get(FIELD_PERF_REVIEW_ID);
		perfReviewItemSeqId = (String) value.get(FIELD_PERF_REVIEW_ITEM_SEQ_ID);
		perfReviewItemTypeId = (String) value
				.get(FIELD_PERF_REVIEW_ITEM_TYPE_ID);
		perfRatingTypeId = (String) value.get(FIELD_PERF_RATING_TYPE_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PerfReviewItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PerfReviewItem(value);
	}

	public static List<PerfReviewItem> fromValues(List<GenericValue> values) {
		List<PerfReviewItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PerfReviewItem(value));
		}
		return entities;
	}
}