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
 * Work Effort Inventory Produced
 */
@FieldNameConstants
public class WorkEffortInventoryProduced implements Serializable {

	public static final long serialVersionUID = 4343598882950189056L;
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

	public WorkEffortInventoryProduced(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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