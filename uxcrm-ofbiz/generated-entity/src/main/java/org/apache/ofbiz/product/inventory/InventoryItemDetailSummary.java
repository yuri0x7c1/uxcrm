package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Detail Summary
 */
@FieldNameConstants
public class InventoryItemDetailSummary implements Serializable {

	public static final long serialVersionUID = 4803501574852734976L;
	public static final String NAME = "InventoryItemDetailSummary";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
	/**
	 * Accounting Quantity Total
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityTotal;

	public InventoryItemDetailSummary(GenericValue value) {
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		availableToPromiseTotal = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_TOTAL);
		quantityOnHandTotal = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_TOTAL);
		accountingQuantityTotal = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_TOTAL);
	}

	public static InventoryItemDetailSummary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemDetailSummary(value);
	}

	public static List<InventoryItemDetailSummary> fromValues(
			List<GenericValue> values) {
		List<InventoryItemDetailSummary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemDetailSummary(value));
		}
		return entities;
	}
}