package org.apache.ofbiz.order.shoppinglist;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ShoppingListWorkEffort implements Serializable {

	public static final long serialVersionUID = 1454361469670771712L;
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

	public ShoppingListWorkEffort(GenericValue value) {
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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