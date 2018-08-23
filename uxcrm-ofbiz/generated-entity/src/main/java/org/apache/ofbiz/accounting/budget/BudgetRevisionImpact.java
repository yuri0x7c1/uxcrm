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
 * Budget Revision Impact
 */
@FieldNameConstants
public class BudgetRevisionImpact implements Serializable {

	public static final long serialVersionUID = 1803093043303354368L;
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

	public BudgetRevisionImpact(GenericValue value) {
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		revisionSeqId = (String) value.get(FIELD_REVISION_SEQ_ID);
		revisedAmount = (BigDecimal) value.get(FIELD_REVISED_AMOUNT);
		addDeleteFlag = (String) value.get(FIELD_ADD_DELETE_FLAG);
		revisionReason = (String) value.get(FIELD_REVISION_REASON);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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