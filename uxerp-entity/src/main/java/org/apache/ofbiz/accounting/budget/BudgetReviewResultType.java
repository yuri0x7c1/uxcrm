package org.apache.ofbiz.accounting.budget;

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
public class BudgetReviewResultType implements Serializable {

	public static final long serialVersionUID = 4735164796388158464L;
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

	public enum Fields {
		budgetReviewResultTypeId, description, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetReviewResultType(GenericValue value) {
		budgetReviewResultTypeId = (String) value
				.get(Fields.budgetReviewResultTypeId.name());
		description = (String) value.get(Fields.description.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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