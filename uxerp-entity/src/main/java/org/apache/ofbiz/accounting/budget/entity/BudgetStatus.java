package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Status
 */
public class BudgetStatus implements Serializable {

	public static final long serialVersionUID = 5843642129926273024L;
	public static final String NAME = "BudgetStatus";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;

	public enum Fields {
		budgetId, statusId, statusDate, comments, changeByUserLoginId
	}

	public BudgetStatus(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		comments = (String) value.get(Fields.comments.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
	}

	public static BudgetStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetStatus(value);
	}

	public static List<BudgetStatus> fromValues(List<GenericValue> values) {
		List<BudgetStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetStatus(value));
		}
		return entities;
	}
}