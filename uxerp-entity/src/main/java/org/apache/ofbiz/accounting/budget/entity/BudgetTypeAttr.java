package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Type Attr
 */
public class BudgetTypeAttr implements Serializable {

	public static final long serialVersionUID = 5609039573428814848L;
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

	public enum Fields {
		budgetTypeId, attrName, description
	}

	public BudgetTypeAttr(GenericValue value) {
		budgetTypeId = (String) value.get(Fields.budgetTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
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