package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Scenario
 */
public class BudgetScenario implements Serializable {

	public static final long serialVersionUID = 3306038863409164288L;
	public static final String NAME = "BudgetScenario";
	/**
	 * Budget Scenario Id
	 */
	@Getter
	@Setter
	private String budgetScenarioId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		budgetScenarioId, description
	}

	public BudgetScenario(GenericValue value) {
		budgetScenarioId = (String) value.get(Fields.budgetScenarioId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static BudgetScenario fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetScenario(value);
	}

	public static List<BudgetScenario> fromValues(List<GenericValue> values) {
		List<BudgetScenario> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetScenario(value));
		}
		return entities;
	}
}