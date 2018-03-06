package org.apache.ofbiz.accounting.budget.entity;

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

	public static final long serialVersionUID = 8454638007546300416L;
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

	public enum Fields {
		budgetId, budgetReviewId, partyId, budgetReviewResultTypeId, reviewDate
	}

	public BudgetReview(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetReviewId = (String) value.get(Fields.budgetReviewId.name());
		partyId = (String) value.get(Fields.partyId.name());
		budgetReviewResultTypeId = (String) value
				.get(Fields.budgetReviewResultTypeId.name());
		reviewDate = (Timestamp) value.get(Fields.reviewDate.name());
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