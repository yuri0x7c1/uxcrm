package org.apache.ofbiz.product.inventory;

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

	public static final long serialVersionUID = 2970736286974464000L;
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

	public enum Fields {
		inventoryItemId, availableToPromiseTotal, quantityOnHandTotal, accountingQuantityTotal
	}

	public InventoryItemDetailSummary(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		accountingQuantityTotal = (BigDecimal) value
				.get(Fields.accountingQuantityTotal.name());
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