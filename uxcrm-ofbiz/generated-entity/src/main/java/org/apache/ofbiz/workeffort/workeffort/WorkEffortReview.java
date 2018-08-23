package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class WorkEffortReview implements Serializable {

	public static final long serialVersionUID = 460374528285417472L;
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

	public WorkEffortReview(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		reviewDate = (Timestamp) value.get(FIELD_REVIEW_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		postedAnonymous = (String) value.get(FIELD_POSTED_ANONYMOUS);
		rating = (Double) value.get(FIELD_RATING);
		reviewText = (String) value.get(FIELD_REVIEW_TEXT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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