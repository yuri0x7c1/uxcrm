package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Scenario Rule
 */
public class BudgetScenarioRule implements Serializable {

	public static final long serialVersionUID = 3388806292439432192L;
	public static final String NAME = "BudgetScenarioRule";
	/**
	 * Budget Scenario Id
	 */
	@Getter
	@Setter
	private String budgetScenarioId;
	/**
	 * Budget Item Type Id
	 */
	@Getter
	@Setter
	private String budgetItemTypeId;
	/**
	 * Amount Change
	 */
	@Getter
	@Setter
	private BigDecimal amountChange;
	/**
	 * Percentage Change
	 */
	@Getter
	@Setter
	private BigDecimal percentageChange;

	public enum Fields {
		budgetScenarioId, budgetItemTypeId, amountChange, percentageChange
	}

	public BudgetScenarioRule(GenericValue value) {
		budgetScenarioId = (String) value.get(Fields.budgetScenarioId.name());
		budgetItemTypeId = (String) value.get(Fields.budgetItemTypeId.name());
		amountChange = (BigDecimal) value.get(Fields.amountChange.name());
		percentageChange = (BigDecimal) value.get(Fields.percentageChange
				.name());
	}

	public static BudgetScenarioRule fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetScenarioRule(value);
	}

	public static List<BudgetScenarioRule> fromValues(List<GenericValue> values) {
		List<BudgetScenarioRule> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetScenarioRule(value));
		}
		return entities;
	}
}