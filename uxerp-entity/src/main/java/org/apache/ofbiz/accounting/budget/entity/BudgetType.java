package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Type
 */
public class BudgetType implements Serializable {

	public static final long serialVersionUID = 8844874581429869568L;
	public static final String NAME = "BudgetType";
	/**
	 * Budget Type Id
	 */
	@Getter
	@Setter
	private String budgetTypeId;
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
		budgetTypeId, parentTypeId, hasTable, description
	}

	public BudgetType(GenericValue value) {
		budgetTypeId = (String) value.get(Fields.budgetTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static BudgetType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetType(value);
	}

	public static List<BudgetType> fromValues(List<GenericValue> values) {
		List<BudgetType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetType(value));
		}
		return entities;
	}
}