package org.apache.ofbiz.product.inventory.entity.view;

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

	public static final long serialVersionUID = 2546224178711048192L;
	public static final String NAME = "InventoryItemDetailForSum";
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

	public enum Fields {
		quantityOnHandDiff, accountingQuantityDiff, inventoryItemTypeId, facilityId, productId, unitCost, currencyUomId, effectiveDate, orderId, ownerPartyId
	}

	public InventoryItemDetailForSum(GenericValue value) {
		quantityOnHandDiff = (BigDecimal) value.get(Fields.quantityOnHandDiff
				.name());
		accountingQuantityDiff = (BigDecimal) value
				.get(Fields.accountingQuantityDiff.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		productId = (String) value.get(Fields.productId.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		orderId = (String) value.get(Fields.orderId.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
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