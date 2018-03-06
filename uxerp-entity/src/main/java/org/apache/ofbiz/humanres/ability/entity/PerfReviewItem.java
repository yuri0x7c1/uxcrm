package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Perf Review Item
 */
public class PerfReviewItem implements Serializable {

	public static final long serialVersionUID = 2738713194458845184L;
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

	public enum Fields {
		employeePartyId, employeeRoleTypeId, perfReviewId, perfReviewItemSeqId, perfReviewItemTypeId, perfRatingTypeId, comments
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