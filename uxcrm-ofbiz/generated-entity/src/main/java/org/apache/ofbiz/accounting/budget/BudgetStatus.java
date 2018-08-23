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
 * Budget Status
 */
@FieldNameConstants
public class BudgetStatus implements Serializable {

	public static final long serialVersionUID = 8653930759305336832L;
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

	public BudgetStatus(GenericValue value) {
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDate = (Timestamp) value.get(FIELD_STATUS_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		changeByUserLoginId = (String) value.get(FIELD_CHANGE_BY_USER_LOGIN_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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