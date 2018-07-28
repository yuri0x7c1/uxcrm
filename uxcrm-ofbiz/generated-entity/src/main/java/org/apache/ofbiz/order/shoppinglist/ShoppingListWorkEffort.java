package org.apache.ofbiz.order.shoppinglist;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List Work Effort
 */
public class ShoppingListWorkEffort implements Serializable {

	public static final long serialVersionUID = 4921839673846076416L;
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
		shoppingListId, workEffortId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShoppingListWorkEffort(GenericValue value) {
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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