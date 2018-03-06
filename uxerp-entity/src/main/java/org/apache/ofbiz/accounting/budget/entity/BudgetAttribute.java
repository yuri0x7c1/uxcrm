package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Attribute
 */
public class BudgetAttribute implements Serializable {

	public static final long serialVersionUID = 1242827242546281472L;
	public static final String NAME = "BudgetAttribute";
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		budgetId, attrName, attrValue, attrDescription
	}

	public BudgetAttribute(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static BudgetAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetAttribute(value);
	}

	public static List<BudgetAttribute> fromValues(List<GenericValue> values) {
		List<BudgetAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetAttribute(value));
		}
		return entities;
	}
}