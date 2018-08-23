package org.apache.ofbiz.accounting.budget;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class BudgetScenarioRule implements Serializable {

	public static final long serialVersionUID = 2322811118087844864L;
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

	public BudgetScenarioRule(GenericValue value) {
		budgetScenarioId = (String) value.get(FIELD_BUDGET_SCENARIO_ID);
		budgetItemTypeId = (String) value.get(FIELD_BUDGET_ITEM_TYPE_ID);
		amountChange = (BigDecimal) value.get(FIELD_AMOUNT_CHANGE);
		percentageChange = (BigDecimal) value.get(FIELD_PERCENTAGE_CHANGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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