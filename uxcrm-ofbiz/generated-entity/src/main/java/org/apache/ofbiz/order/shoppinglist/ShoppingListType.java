package org.apache.ofbiz.order.shoppinglist;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List Type
 */
public class ShoppingListType implements Serializable {

	public static final long serialVersionUID = 1109039054005101568L;
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

	public enum Fields {
		shoppingListTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShoppingListType(GenericValue value) {
		shoppingListTypeId = (String) value.get(Fields.shoppingListTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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