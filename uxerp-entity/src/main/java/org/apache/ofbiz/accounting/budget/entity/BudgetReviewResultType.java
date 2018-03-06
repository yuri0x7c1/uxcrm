package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Review Result Type
 */
public class BudgetReviewResultType implements Serializable {

	public static final long serialVersionUID = 5930932569272128512L;
	public static final String NAME = "BudgetReviewResultType";
	/**
	 * Budget Review Result Type Id
	 */
	@Getter
	@Setter
	private String budgetReviewResultTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		budgetReviewResultTypeId, description, comments
	}

	public BudgetReviewResultType(GenericValue value) {
		budgetReviewResultTypeId = (String) value
				.get(Fields.budgetReviewResultTypeId.name());
		description = (String) value.get(Fields.description.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static BudgetReviewResultType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetReviewResultType(value);
	}

	public static List<BudgetReviewResultType> fromValues(
			List<GenericValue> values) {
		List<BudgetReviewResultType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetReviewResultType(value));
		}
		return entities;
	}
}