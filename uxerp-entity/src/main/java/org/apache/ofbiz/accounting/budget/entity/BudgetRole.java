package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Role
 */
public class BudgetRole implements Serializable {

	public static final long serialVersionUID = 4674272543915915264L;
	public static final String NAME = "BudgetRole";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;

	public enum Fields {
		budgetId, partyId, roleTypeId
	}

	public BudgetRole(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static BudgetRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetRole(value);
	}

	public static List<BudgetRole> fromValues(List<GenericValue> values) {
		List<BudgetRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetRole(value));
		}
		return entities;
	}
}