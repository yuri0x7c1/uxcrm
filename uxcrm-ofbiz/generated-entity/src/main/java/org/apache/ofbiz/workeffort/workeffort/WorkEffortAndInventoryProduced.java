package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortAndInventoryProduced implements Serializable {

	public static final long serialVersionUID = 5343306991096954880L;
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

	public enum Fields {
		productId, currencyUomId, unitCost, lotId, quantityOnHandTotal, workEffortId, inventoryItemId
	}

	public WorkEffortAndInventoryProduced(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		lotId = (String) value.get(Fields.lotId.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
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