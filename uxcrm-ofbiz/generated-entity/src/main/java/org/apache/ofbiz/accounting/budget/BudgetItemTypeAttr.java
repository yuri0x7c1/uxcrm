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
 * Budget Item Type Attr
 */
@FieldNameConstants
public class BudgetItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 8352030110664494080L;
	public static final String NAME = "BudgetItemTypeAttr";
	/**
	 * Budget Item Type Id
	 */
	@Getter
	@Setter
	private String budgetItemTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public BudgetItemTypeAttr(GenericValue value) {
		budgetItemTypeId = (String) value.get(FIELD_BUDGET_ITEM_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BudgetItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetItemTypeAttr(value);
	}

	public static List<BudgetItemTypeAttr> fromValues(List<GenericValue> values) {
		List<BudgetItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetItemTypeAttr(value));
		}
		return entities;
	}
}