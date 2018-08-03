package org.apache.ofbiz.accounting.budget;

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
public class BudgetReview implements Serializable {

	public static final long serialVersionUID = 6223267561122100224L;
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

	public enum Fields {
		budgetId, budgetReviewId, partyId, budgetReviewResultTypeId, reviewDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetReview(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetReviewId = (String) value.get(Fields.budgetReviewId.name());
		partyId = (String) value.get(Fields.partyId.name());
		budgetReviewResultTypeId = (String) value
				.get(Fields.budgetReviewResultTypeId.name());
		reviewDate = (Timestamp) value.get(Fields.reviewDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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