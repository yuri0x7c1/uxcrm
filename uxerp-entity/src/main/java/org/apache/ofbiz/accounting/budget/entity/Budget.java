package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget
 */
public class Budget implements Serializable {

	public static final long serialVersionUID = 2213967893792707584L;
	public static final String NAME = "Budget";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Budget Type Id
	 */
	@Getter
	@Setter
	private String budgetTypeId;
	/**
	 * Custom Time Period Id
	 */
	@Getter
	@Setter
	private String customTimePeriodId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		budgetId, budgetTypeId, customTimePeriodId, comments
	}

	public Budget(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetTypeId = (String) value.get(Fields.budgetTypeId.name());
		customTimePeriodId = (String) value.get(Fields.customTimePeriodId
				.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static Budget fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Budget(value);
	}

	public static List<Budget> fromValues(List<GenericValue> values) {
		List<Budget> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Budget(value));
		}
		return entities;
	}
}