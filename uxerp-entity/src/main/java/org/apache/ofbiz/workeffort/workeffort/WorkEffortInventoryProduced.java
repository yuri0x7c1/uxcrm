package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Inventory Produced
 */
public class WorkEffortInventoryProduced implements Serializable {

	public static final long serialVersionUID = 7167862622670131200L;
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
		workEffortId, inventoryItemId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortInventoryProduced(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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