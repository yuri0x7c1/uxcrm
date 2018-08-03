package org.apache.ofbiz.humanres.ability;

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
public class PerfReviewItem implements Serializable {

	public static final long serialVersionUID = 3855764386862134272L;
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

	public enum Fields {
		employeePartyId, employeeRoleTypeId, perfReviewId, perfReviewItemSeqId, perfReviewItemTypeId, perfRatingTypeId, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PerfReviewItem(GenericValue value) {
		employeePartyId = (String) value.get(Fields.employeePartyId.name());
		employeeRoleTypeId = (String) value.get(Fields.employeeRoleTypeId
				.name());
		perfReviewId = (String) value.get(Fields.perfReviewId.name());
		perfReviewItemSeqId = (String) value.get(Fields.perfReviewItemSeqId
				.name());
		perfReviewItemTypeId = (String) value.get(Fields.perfReviewItemTypeId
				.name());
		perfRatingTypeId = (String) value.get(Fields.perfRatingTypeId.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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