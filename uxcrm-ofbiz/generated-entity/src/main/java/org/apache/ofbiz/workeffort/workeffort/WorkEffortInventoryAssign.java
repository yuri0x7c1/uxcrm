package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortInventoryAssign implements Serializable {

	public static final long serialVersionUID = 1864727571407570944L;
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

	public enum Fields {
		workEffortId, inventoryItemId, statusId, quantity, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortInventoryAssign(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		statusId = (String) value.get(Fields.statusId.name());
		quantity = (Double) value.get(Fields.quantity.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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