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
 * Budget Type Attr
 */
@FieldNameConstants
public class BudgetTypeAttr implements Serializable {

	public static final long serialVersionUID = 197249408270234624L;
	public static final String NAME = "BudgetTypeAttr";
	/**
	 * Budget Type Id
	 */
	@Getter
	@Setter
	private String budgetTypeId;
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

	public BudgetTypeAttr(GenericValue value) {
		budgetTypeId = (String) value.get(FIELD_BUDGET_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static BudgetTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetTypeAttr(value);
	}

	public static List<BudgetTypeAttr> fromValues(List<GenericValue> values) {
		List<BudgetTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetTypeAttr(value));
		}
		return entities;
	}
}