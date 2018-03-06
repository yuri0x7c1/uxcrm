package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Inventory Produced
 */
public class WorkEffortInventoryProduced implements Serializable {

	public static final long serialVersionUID = 6331313071200356352L;
	public static final String NAME = "WorkEffortInventoryProduced";
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

	public enum Fields {
		workEffortId, inventoryItemId
	}

	public WorkEffortInventoryProduced(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
	}

	public static WorkEffortInventoryProduced fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortInventoryProduced(value);
	}

	public static List<WorkEffortInventoryProduced> fromValues(
			List<GenericValue> values) {
		List<WorkEffortInventoryProduced> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortInventoryProduced(value));
		}
		return entities;
	}
}