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
 * Budget Item
 */
@FieldNameConstants
public class BudgetItem implements Serializable {

	public static final long serialVersionUID = 9104993839208103936L;
	public static final String NAME = "BudgetItem";
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
	 * Budget Item Type Id
	 */
	@Getter
	@Setter
	private String budgetItemTypeId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Purpose
	 */
	@Getter
	@Setter
	private String purpose;
	/**
	 * Justification
	 */
	@Getter
	@Setter
	private String justification;
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

	public BudgetItem(GenericValue value) {
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		budgetItemTypeId = (String) value.get(FIELD_BUDGET_ITEM_TYPE_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		purpose = (String) value.get(FIELD_PURPOSE);
		justification = (String) value.get(FIELD_JUSTIFICATION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BudgetItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetItem(value);
	}

	public static List<BudgetItem> fromValues(List<GenericValue> values) {
		List<BudgetItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetItem(value));
		}
		return entities;
	}
}