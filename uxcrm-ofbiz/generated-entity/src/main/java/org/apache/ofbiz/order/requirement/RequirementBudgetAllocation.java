package org.apache.ofbiz.order.requirement;

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
 * Requirement Budget Allocation
 */
@FieldNameConstants
public class RequirementBudgetAllocation implements Serializable {

	public static final long serialVersionUID = 6830706738887746560L;
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

	public RequirementBudgetAllocation(GenericValue value) {
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		requirementId = (String) value.get(FIELD_REQUIREMENT_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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