package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item And Detail
 */
@FieldNameConstants
public class InventoryItemAndDetail implements Serializable {

	public static final long serialVersionUID = 1373058038979058688L;
	public static final String NAME = "InventoryItemAndDetail";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Datetime Received
	 */
	@Getter
	@Setter
	private Timestamp datetimeReceived;
	/**
	 * Datetime Manufactured
	 */
	@Getter
	@Setter
	private Timestamp datetimeManufactured;
	/**
	 * Expire Date
	 */
	@Getter
	@Setter
	private Timestamp expireDate;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
	/**
	 * Lot Id
	 */
	@Getter
	@Setter
	private String lotId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Bin Number
	 */
	@Getter
	@Setter
	private String binNumber;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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
	 * Accounting Quantity Total
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityTotal;
	/**
	 * Old Quantity On Hand
	 */
	@Getter
	@Setter
	private BigDecimal oldQuantityOnHand;
	/**
	 * Old Available To Promise
	 */
	@Getter
	@Setter
	private BigDecimal oldAvailableToPromise;
	/**
	 * Serial Number
	 */
	@Getter
	@Setter
	private String serialNumber;
	/**
	 * Soft Identifier
	 */
	@Getter
	@Setter
	private String softIdentifier;
	/**
	 * Activation Number
	 */
	@Getter
	@Setter
	private String activationNumber;
	/**
	 * Activation Valid Thru
	 */
	@Getter
	@Setter
	private Timestamp activationValidThru;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Inventory Item Fixed Asset Id
	 */
	@Getter
	@Setter
	private String inventoryItemFixedAssetId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
	/**
	 * Inventory Item Detail Seq Id
	 */
	@Getter
	@Setter
	private String inventoryItemDetailSeqId;
	/**
	 * Accounting Quantity Diff
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityDiff;
	/**
	 * Physical Inventory Id
	 */
	@Getter
	@Setter
	private String physicalInventoryId;
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;
	/**
	 * Receipt Id
	 */
	@Getter
	@Setter
	private String receiptId;
	/**
	 * Quantity On Hand Diff
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandDiff;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Available To Promise Diff
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseDiff;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Return Item Seq Id
	 */
	@Getter
	@Setter
	private String returnItemSeqId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;

	public InventoryItemAndDetail(GenericValue value) {
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		inventoryItemTypeId = (String) value.get(FIELD_INVENTORY_ITEM_TYPE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		datetimeReceived = (Timestamp) value.get(FIELD_DATETIME_RECEIVED);
		datetimeManufactured = (Timestamp) value
				.get(FIELD_DATETIME_MANUFACTURED);
		expireDate = (Timestamp) value.get(FIELD_EXPIRE_DATE);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		containerId = (String) value.get(FIELD_CONTAINER_ID);
		lotId = (String) value.get(FIELD_LOT_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		binNumber = (String) value.get(FIELD_BIN_NUMBER);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		quantityOnHandTotal = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_TOTAL);
		availableToPromiseTotal = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_TOTAL);
		accountingQuantityTotal = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_TOTAL);
		oldQuantityOnHand = (BigDecimal) value.get(FIELD_OLD_QUANTITY_ON_HAND);
		oldAvailableToPromise = (BigDecimal) value
				.get(FIELD_OLD_AVAILABLE_TO_PROMISE);
		serialNumber = (String) value.get(FIELD_SERIAL_NUMBER);
		softIdentifier = (String) value.get(FIELD_SOFT_IDENTIFIER);
		activationNumber = (String) value.get(FIELD_ACTIVATION_NUMBER);
		activationValidThru = (Timestamp) value
				.get(FIELD_ACTIVATION_VALID_THRU);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		inventoryItemFixedAssetId = (String) value
				.get(FIELD_INVENTORY_ITEM_FIXED_ASSET_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		inventoryItemDetailSeqId = (String) value
				.get(FIELD_INVENTORY_ITEM_DETAIL_SEQ_ID);
		accountingQuantityDiff = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_DIFF);
		physicalInventoryId = (String) value.get(FIELD_PHYSICAL_INVENTORY_ID);
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		returnId = (String) value.get(FIELD_RETURN_ID);
		reasonEnumId = (String) value.get(FIELD_REASON_ENUM_ID);
		receiptId = (String) value.get(FIELD_RECEIPT_ID);
		quantityOnHandDiff = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_DIFF);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		availableToPromiseDiff = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_DIFF);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		effectiveDate = (Timestamp) value.get(FIELD_EFFECTIVE_DATE);
	}

	public static InventoryItemAndDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemAndDetail(value);
	}

	public static List<InventoryItemAndDetail> fromValues(
			List<GenericValue> values) {
		List<InventoryItemAndDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemAndDetail(value));
		}
		return entities;
	}
}