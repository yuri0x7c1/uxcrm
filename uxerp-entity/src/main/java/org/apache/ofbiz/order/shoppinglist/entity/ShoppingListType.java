package org.apache.ofbiz.order.shoppinglist.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List Type
 */
public class ShoppingListType implements Serializable {

	public static final long serialVersionUID = 5916161595647538176L;
	public static final String NAME = "ShoppingListType";
	/**
	 * Shopping List Type Id
	 */
	@Getter
	@Setter
	private String shoppingListTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		shoppingListTypeId, description
	}

	public ShoppingListType(GenericValue value) {
		shoppingListTypeId = (String) value.get(Fields.shoppingListTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ShoppingListType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShoppingListType(value);
	}

	public static List<ShoppingListType> fromValues(List<GenericValue> values) {
		List<ShoppingListType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShoppingListType(value));
		}
		return entities;
	}
}