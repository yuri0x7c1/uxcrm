package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Item Type
 */
public class BudgetItemType implements Serializable {

	public static final long serialVersionUID = 7604406933057136640L;
	public static final String NAME = "BudgetItemType";
	/**
	 * Budget Item Type Id
	 */
	@Getter
	@Setter
	private String budgetItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		budgetItemTypeId, parentTypeId, hasTable, description
	}

	public BudgetItemType(GenericValue value) {
		budgetItemTypeId = (String) value.get(Fields.budgetItemTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static BudgetItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetItemType(value);
	}

	public static List<BudgetItemType> fromValues(List<GenericValue> values) {
		List<BudgetItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetItemType(value));
		}
		return entities;
	}
}