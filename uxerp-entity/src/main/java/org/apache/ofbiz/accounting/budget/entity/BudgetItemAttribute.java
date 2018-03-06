package org.apache.ofbiz.accounting.budget.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Budget Item Attribute
 */
public class BudgetItemAttribute implements Serializable {

	public static final long serialVersionUID = 5846624782707489792L;
	public static final String NAME = "BudgetItemAttribute";
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
		budgetId, budgetItemSeqId, attrName, attrValue, attrDescription
	}

	public BudgetItemAttribute(GenericValue value) {
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static BudgetItemAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BudgetItemAttribute(value);
	}

	public static List<BudgetItemAttribute> fromValues(List<GenericValue> values) {
		List<BudgetItemAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BudgetItemAttribute(value));
		}
		return entities;
	}
}