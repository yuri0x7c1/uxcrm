package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class InventoryItemDetailForSum implements Serializable {

	public static final long serialVersionUID = 5118642724316442624L;
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

	public InventoryItemDetailForSum(GenericValue value) {
		quantityOnHandSum = (BigDecimal) value.get(FIELD_QUANTITY_ON_HAND_SUM);
		accountingQuantitySum = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_SUM);
		inventoryItemTypeId = (String) value.get(FIELD_INVENTORY_ITEM_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		effectiveDate = (Timestamp) value.get(FIELD_EFFECTIVE_DATE);
		orderId = (String) value.get(FIELD_ORDER_ID);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		quantityOnHandDiff = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_DIFF);
		accountingQuantityDiff = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_DIFF);
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