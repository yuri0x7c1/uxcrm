package org.apache.ofbiz.product.inventory.entity.view;

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
public class InventoryItemDetailSummary implements Serializable {

	public static final long serialVersionUID = 4757525640304111616L;
	public static final String NAME = "InventoryItemDetailSummary";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Available To Promise Diff
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseDiff;
	/**
	 * Quantity On Hand Diff
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandDiff;
	/**
	 * Accounting Quantity Diff
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityDiff;

	public enum Fields {
		inventoryItemId, availableToPromiseDiff, quantityOnHandDiff, accountingQuantityDiff
	}

	public InventoryItemDetailSummary(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		availableToPromiseDiff = (BigDecimal) value
				.get(Fields.availableToPromiseDiff.name());
		quantityOnHandDiff = (BigDecimal) value.get(Fields.quantityOnHandDiff
				.name());
		accountingQuantityDiff = (BigDecimal) value
				.get(Fields.accountingQuantityDiff.name());
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