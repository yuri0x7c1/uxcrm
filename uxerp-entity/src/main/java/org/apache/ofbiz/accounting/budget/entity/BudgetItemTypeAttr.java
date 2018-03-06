package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Item Type Attr
 */
public class BudgetItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 1629406866263651328L;
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

	public enum Fields {
		budgetItemTypeId, attrName, description
	}

	public BudgetItemTypeAttr(GenericValue value) {
		budgetItemTypeId = (String) value.get(Fields.budgetItemTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
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