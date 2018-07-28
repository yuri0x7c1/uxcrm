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
 * Budget Scenario Application
 */
public class BudgetScenarioApplication implements Serializable {

	public static final long serialVersionUID = 6753974571299384320L;
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

	public enum Fields {
		budgetScenarioApplicId, budgetScenarioId, budgetId, budgetItemSeqId, amountChange, percentageChange, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetScenarioApplication(GenericValue value) {
		budgetScenarioApplicId = (String) value
				.get(Fields.budgetScenarioApplicId.name());
		budgetScenarioId = (String) value.get(Fields.budgetScenarioId.name());
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
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