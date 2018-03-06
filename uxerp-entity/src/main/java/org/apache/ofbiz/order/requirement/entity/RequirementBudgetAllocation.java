package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Budget Allocation
 */
public class RequirementBudgetAllocation implements Serializable {

	public static final long serialVersionUID = 4018615693957984256L;
	public static final String NAME = "RequirementBudgetAllocation";
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
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public enum Fields {
		budgetId, budgetItemSeqId, requirementId, amount
	}

	public RequirementBudgetAllocation(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
	}

	public static RequirementBudgetAllocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RequirementBudgetAllocation(value);
	}

	public static List<RequirementBudgetAllocation> fromValues(
			List<GenericValue> values) {
		List<RequirementBudgetAllocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RequirementBudgetAllocation(value));
		}
		return entities;
	}
}