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
 * Budget Revision Impact
 */
public class BudgetRevisionImpact implements Serializable {

	public static final long serialVersionUID = 7588359037200963584L;
	public static final String NAME = "BudgetRevisionImpact";
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
	 * Revision Seq Id
	 */
	@Getter
	@Setter
	private String revisionSeqId;
	/**
	 * Revised Amount
	 */
	@Getter
	@Setter
	private BigDecimal revisedAmount;
	/**
	 * Add Delete Flag
	 */
	@Getter
	@Setter
	private String addDeleteFlag;
	/**
	 * Revision Reason
	 */
	@Getter
	@Setter
	private String revisionReason;
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
		budgetId, budgetItemSeqId, revisionSeqId, revisedAmount, addDeleteFlag, revisionReason, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetRevisionImpact(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		revisionSeqId = (String) value.get(Fields.revisionSeqId.name());
		revisedAmount = (BigDecimal) value.get(Fields.revisedAmount.name());
		addDeleteFlag = (String) value.get(Fields.addDeleteFlag.name());
		revisionReason = (String) value.get(Fields.revisionReason.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static BudgetRevisionImpact fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetRevisionImpact(value);
	}

	public static List<BudgetRevisionImpact> fromValues(
			List<GenericValue> values) {
		List<BudgetRevisionImpact> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetRevisionImpact(value));
		}
		return entities;
	}
}