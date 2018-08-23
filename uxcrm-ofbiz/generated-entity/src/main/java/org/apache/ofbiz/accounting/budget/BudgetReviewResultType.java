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
 * Budget Review Result Type
 */
@FieldNameConstants
public class BudgetReviewResultType implements Serializable {

	public static final long serialVersionUID = 1827905084693502976L;
	public static final String NAME = "BudgetReviewResultType";
	/**
	 * Budget Review Result Type Id
	 */
	@Getter
	@Setter
	private String budgetReviewResultTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public BudgetReviewResultType(GenericValue value) {
		budgetReviewResultTypeId = (String) value
				.get(FIELD_BUDGET_REVIEW_RESULT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BudgetReviewResultType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetReviewResultType(value);
	}

	public static List<BudgetReviewResultType> fromValues(
			List<GenericValue> values) {
		List<BudgetReviewResultType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetReviewResultType(value));
		}
		return entities;
	}
}