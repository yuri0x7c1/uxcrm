package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort And Inventory Assign
 */
@FieldNameConstants
public class WorkEffortAndInventoryAssign implements Serializable {

	public static final long serialVersionUID = 5658010321894240256L;
	public static final String NAME = "WorkEffortAndInventoryAssign";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
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
	 * Quantity
	 */
	@Getter
	@Setter
	private Double quantity;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public WorkEffortAndInventoryAssign(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		uomId = (String) value.get(FIELD_UOM_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		quantity = (Double) value.get(FIELD_QUANTITY);
		statusId = (String) value.get(FIELD_STATUS_ID);
	}

	public static WorkEffortAndInventoryAssign fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAndInventoryAssign(value);
	}

	public static List<WorkEffortAndInventoryAssign> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAndInventoryAssign> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAndInventoryAssign(value));
		}
		return entities;
	}
}