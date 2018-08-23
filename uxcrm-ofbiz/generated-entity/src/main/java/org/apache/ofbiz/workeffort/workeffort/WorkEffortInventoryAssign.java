package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Inventory Assign
 */
@FieldNameConstants
public class WorkEffortInventoryAssign implements Serializable {

	public static final long serialVersionUID = 4528853547312382976L;
	public static final String NAME = "WorkEffortInventoryAssign";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private Double quantity;
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

	public WorkEffortInventoryAssign(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		quantity = (Double) value.get(FIELD_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortInventoryAssign fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortInventoryAssign(value);
	}

	public static List<WorkEffortInventoryAssign> fromValues(
			List<GenericValue> values) {
		List<WorkEffortInventoryAssign> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortInventoryAssign(value));
		}
		return entities;
	}
}