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
 * Work Effort And Inventory Produced
 */
@FieldNameConstants
public class WorkEffortAndInventoryProduced implements Serializable {

	public static final long serialVersionUID = 3902936446390232064L;
	public static final String NAME = "WorkEffortAndInventoryProduced";
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
	 * Lot Id
	 */
	@Getter
	@Setter
	private String lotId;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
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

	public WorkEffortAndInventoryProduced(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		lotId = (String) value.get(FIELD_LOT_ID);
		quantityOnHandTotal = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_TOTAL);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
	}

	public static WorkEffortAndInventoryProduced fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAndInventoryProduced(value);
	}

	public static List<WorkEffortAndInventoryProduced> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAndInventoryProduced> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAndInventoryProduced(value));
		}
		return entities;
	}
}