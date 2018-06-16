package org.apache.ofbiz.order.requirement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Requirement Budget Allocation
 */
public class RequirementBudgetAllocation implements Serializable {

	public static final long serialVersionUID = 4893350317147161600L;
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
		budgetId, budgetItemSeqId, requirementId, amount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public RequirementBudgetAllocation(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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