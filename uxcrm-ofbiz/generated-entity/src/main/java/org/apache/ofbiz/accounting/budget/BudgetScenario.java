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
 * Budget Scenario
 */
@FieldNameConstants
public class BudgetScenario implements Serializable {

	public static final long serialVersionUID = 3627370833040785408L;
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

	public BudgetScenario(GenericValue value) {
		budgetScenarioId = (String) value.get(FIELD_BUDGET_SCENARIO_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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