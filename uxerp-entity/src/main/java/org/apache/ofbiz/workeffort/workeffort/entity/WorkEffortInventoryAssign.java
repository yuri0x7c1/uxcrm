package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Inventory Assign
 */
public class WorkEffortInventoryAssign implements Serializable {

	public static final long serialVersionUID = 8057411158857211904L;
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

	public enum Fields {
		workEffortId, inventoryItemId, statusId, quantity
	}

	public WorkEffortInventoryAssign(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		statusId = (String) value.get(Fields.statusId.name());
		quantity = (Double) value.get(Fields.quantity.name());
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