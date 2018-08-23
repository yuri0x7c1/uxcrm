package org.apache.ofbiz.accounting.ledger;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Budget Xref
 */
@FieldNameConstants
public class GlBudgetXref implements Serializable {

	public static final long serialVersionUID = 5850977492236469248L;
	public static final String NAME = "GlBudgetXref";
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Budget Item Type Id
	 */
	@Getter
	@Setter
	private String budgetItemTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Allocation Percentage
	 */
	@Getter
	@Setter
	private BigDecimal allocationPercentage;
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

	public GlBudgetXref(GenericValue value) {
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		budgetItemTypeId = (String) value.get(FIELD_BUDGET_ITEM_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		allocationPercentage = (BigDecimal) value
				.get(FIELD_ALLOCATION_PERCENTAGE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GlBudgetXref fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlBudgetXref(value);
	}

	public static List<GlBudgetXref> fromValues(List<GenericValue> values) {
		List<GlBudgetXref> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlBudgetXref(value));
		}
		return entities;
	}
}