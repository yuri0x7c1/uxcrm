package org.apache.ofbiz.bi.fact.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Fact
 */
public class InventoryItemFact implements Serializable {

	public static final long serialVersionUID = 8282332507738066944L;
	public static final String NAME = "InventoryItemFact";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Product Dim Id
	 */
	@Getter
	@Setter
	private String productDimId;
	/**
	 * Orig Currency Dim Id
	 */
	@Getter
	@Setter
	private String origCurrencyDimId;
	/**
	 * Inventory Date Dim Id
	 */
	@Getter
	@Setter
	private String inventoryDateDimId;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Soldout Amount
	 */
	@Getter
	@Setter
	private BigDecimal soldoutAmount;

	public enum Fields {
		inventoryItemId, facilityId, productDimId, origCurrencyDimId, inventoryDateDimId, quantityOnHandTotal, availableToPromiseTotal, unitCost, soldoutAmount
	}

	public InventoryItemFact(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		productDimId = (String) value.get(Fields.productDimId.name());
		origCurrencyDimId = (String) value.get(Fields.origCurrencyDimId.name());
		inventoryDateDimId = (String) value.get(Fields.inventoryDateDimId
				.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		soldoutAmount = (BigDecimal) value.get(Fields.soldoutAmount.name());
	}

	public static InventoryItemFact fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemFact(value);
	}

	public static List<InventoryItemFact> fromValues(List<GenericValue> values) {
		List<InventoryItemFact> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemFact(value));
		}
		return entities;
	}
}