package org.apache.ofbiz.product.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Detail For Sum
 */
public class InventoryItemDetailForSum implements Serializable {

	public static final long serialVersionUID = 1410280867157545984L;
	public static final String NAME = "InventoryItemDetailForSum";
	/**
	 * Quantity On Hand Sum
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandSum;
	/**
	 * Accounting Quantity Sum
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantitySum;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
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
		quantityOnHandSum, accountingQuantitySum, inventoryItemTypeId, facilityId, productId, unitCost, currencyUomId, effectiveDate, orderId, ownerPartyId, quantityOnHandDiff, accountingQuantityDiff
	}

	public InventoryItemDetailForSum(GenericValue value) {
		quantityOnHandSum = (BigDecimal) value.get(Fields.quantityOnHandSum
				.name());
		accountingQuantitySum = (BigDecimal) value
				.get(Fields.accountingQuantitySum.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		productId = (String) value.get(Fields.productId.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		orderId = (String) value.get(Fields.orderId.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		quantityOnHandDiff = (BigDecimal) value.get(Fields.quantityOnHandDiff
				.name());
		accountingQuantityDiff = (BigDecimal) value
				.get(Fields.accountingQuantityDiff.name());
	}

	public static InventoryItemDetailForSum fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemDetailForSum(value);
	}

	public static List<InventoryItemDetailForSum> fromValues(
			List<GenericValue> values) {
		List<InventoryItemDetailForSum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemDetailForSum(value));
		}
		return entities;
	}
}