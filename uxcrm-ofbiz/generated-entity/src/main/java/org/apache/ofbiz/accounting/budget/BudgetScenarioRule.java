package org.apache.ofbiz.accounting.budget;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Scenario Rule
 */
public class BudgetScenarioRule implements Serializable {

	public static final long serialVersionUID = 1547632486431780864L;
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
		budgetScenarioId, budgetItemTypeId, amountChange, percentageChange, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetScenarioRule(GenericValue value) {
		budgetScenarioId = (String) value.get(Fields.budgetScenarioId.name());
		budgetItemTypeId = (String) value.get(Fields.budgetItemTypeId.name());
		amountChange = (BigDecimal) value.get(Fields.amountChange.name());
		percentageChange = (BigDecimal) value.get(Fields.percentageChange
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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