package org.apache.ofbiz.accounting.budget;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Status
 */
public class BudgetStatus implements Serializable {

	public static final long serialVersionUID = 1673175557131022336L;
	public static final String NAME = "BudgetStatus";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
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
		budgetId, statusId, statusDate, comments, changeByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public BudgetStatus(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		comments = (String) value.get(Fields.comments.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static BudgetStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetStatus(value);
	}

	public static List<BudgetStatus> fromValues(List<GenericValue> values) {
		List<BudgetStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetStatus(value));
		}
		return entities;
	}
}