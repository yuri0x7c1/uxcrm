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
 * Budget Scenario Application
 */
@FieldNameConstants
public class BudgetScenarioApplication implements Serializable {

	public static final long serialVersionUID = 8033872073337392128L;
	public static final String NAME = "BudgetScenarioApplication";
	/**
	 * Budget Scenario Applic Id
	 */
	@Getter
	@Setter
	private String budgetScenarioApplicId;
	/**
	 * Budget Scenario Id
	 */
	@Getter
	@Setter
	private String budgetScenarioId;
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Budget Item Seq Id
	 */
	@Getter
	@Setter
	private String budgetItemSeqId;
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

	public BudgetScenarioApplication(GenericValue value) {
		budgetScenarioApplicId = (String) value
				.get(FIELD_BUDGET_SCENARIO_APPLIC_ID);
		budgetScenarioId = (String) value.get(FIELD_BUDGET_SCENARIO_ID);
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		amountChange = (BigDecimal) value.get(FIELD_AMOUNT_CHANGE);
		percentageChange = (BigDecimal) value.get(FIELD_PERCENTAGE_CHANGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BudgetScenarioApplication fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetScenarioApplication(value);
	}

	public static List<BudgetScenarioApplication> fromValues(
			List<GenericValue> values) {
		List<BudgetScenarioApplication> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetScenarioApplication(value));
		}
		return entities;
	}
}