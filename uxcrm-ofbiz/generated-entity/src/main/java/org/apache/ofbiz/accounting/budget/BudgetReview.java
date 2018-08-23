package org.apache.ofbiz.accounting.budget;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Review
 */
@FieldNameConstants
public class BudgetReview implements Serializable {

	public static final long serialVersionUID = 8263387217247677440L;
	public static final String NAME = "BudgetReview";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Budget Review Id
	 */
	@Getter
	@Setter
	private String budgetReviewId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Budget Review Result Type Id
	 */
	@Getter
	@Setter
	private String budgetReviewResultTypeId;
	/**
	 * Review Date
	 */
	@Getter
	@Setter
	private Timestamp reviewDate;
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

	public BudgetReview(GenericValue value) {
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		budgetReviewId = (String) value.get(FIELD_BUDGET_REVIEW_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		budgetReviewResultTypeId = (String) value
				.get(FIELD_BUDGET_REVIEW_RESULT_TYPE_ID);
		reviewDate = (Timestamp) value.get(FIELD_REVIEW_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BudgetReview fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetReview(value);
	}

	public static List<BudgetReview> fromValues(List<GenericValue> values) {
		List<BudgetReview> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetReview(value));
		}
		return entities;
	}
}