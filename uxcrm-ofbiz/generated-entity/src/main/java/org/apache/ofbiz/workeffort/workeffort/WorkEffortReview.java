package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Review
 */
public class WorkEffortReview implements Serializable {

	public static final long serialVersionUID = 8075721529080964096L;
	public static final String NAME = "WorkEffortReview";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Review Date
	 */
	@Getter
	@Setter
	private Timestamp reviewDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Posted Anonymous
	 */
	@Getter
	@Setter
	private String postedAnonymous;
	/**
	 * Rating
	 */
	@Getter
	@Setter
	private Double rating;
	/**
	 * Review Text
	 */
	@Getter
	@Setter
	private String reviewText;
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
		workEffortId, userLoginId, reviewDate, statusId, postedAnonymous, rating, reviewText, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortReview(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		reviewDate = (Timestamp) value.get(Fields.reviewDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		postedAnonymous = (String) value.get(Fields.postedAnonymous.name());
		rating = (Double) value.get(Fields.rating.name());
		reviewText = (String) value.get(Fields.reviewText.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortReview fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortReview(value);
	}

	public static List<WorkEffortReview> fromValues(List<GenericValue> values) {
		List<WorkEffortReview> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortReview(value));
		}
		return entities;
	}
}