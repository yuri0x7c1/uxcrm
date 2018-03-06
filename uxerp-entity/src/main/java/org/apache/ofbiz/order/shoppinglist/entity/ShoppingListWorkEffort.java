package org.apache.ofbiz.order.shoppinglist.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List Work Effort
 */
public class ShoppingListWorkEffort implements Serializable {

	public static final long serialVersionUID = 4691278064860402688L;
	public static final String NAME = "ShoppingListWorkEffort";
	/**
	 * Shopping List Id
	 */
	@Getter
	@Setter
	private String shoppingListId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;

	public enum Fields {
		shoppingListId, workEffortId
	}

	public ShoppingListWorkEffort(GenericValue value) {
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
	}

	public static ShoppingListWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShoppingListWorkEffort(value);
	}

	public static List<ShoppingListWorkEffort> fromValues(
			List<GenericValue> values) {
		List<ShoppingListWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShoppingListWorkEffort(value));
		}
		return entities;
	}
}