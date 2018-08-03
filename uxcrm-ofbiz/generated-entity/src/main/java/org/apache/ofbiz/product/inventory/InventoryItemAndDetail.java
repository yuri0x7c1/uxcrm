package org.apache.ofbiz.product.inventory;

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
public class InventoryItemAndDetail implements Serializable {

	public static final long serialVersionUID = 2665875940964784128L;
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

	public enum Fields {
		inventoryItemId, inventoryItemTypeId, productId, partyId, ownerPartyId, statusId, datetimeReceived, datetimeManufactured, expireDate, facilityId, containerId, lotId, uomId, binNumber, locationSeqId, comments, quantityOnHandTotal, availableToPromiseTotal, accountingQuantityTotal, oldQuantityOnHand, oldAvailableToPromise, serialNumber, softIdentifier, activationNumber, activationValidThru, currencyUomId, inventoryItemFixedAssetId, workEffortId, orderId, description, maintHistSeqId, inventoryItemDetailSeqId, accountingQuantityDiff, physicalInventoryId, itemIssuanceId, returnId, reasonEnumId, receiptId, quantityOnHandDiff, orderItemSeqId, shipmentItemSeqId, shipGroupSeqId, availableToPromiseDiff, shipmentId, unitCost, returnItemSeqId, fixedAssetId, effectiveDate
	}

	public InventoryItemAndDetail(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		productId = (String) value.get(Fields.productId.name());
		partyId = (String) value.get(Fields.partyId.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		statusId = (String) value.get(Fields.statusId.name());
		datetimeReceived = (Timestamp) value
				.get(Fields.datetimeReceived.name());
		datetimeManufactured = (Timestamp) value
				.get(Fields.datetimeManufactured.name());
		expireDate = (Timestamp) value.get(Fields.expireDate.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		containerId = (String) value.get(Fields.containerId.name());
		lotId = (String) value.get(Fields.lotId.name());
		uomId = (String) value.get(Fields.uomId.name());
		binNumber = (String) value.get(Fields.binNumber.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		comments = (String) value.get(Fields.comments.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		accountingQuantityTotal = (BigDecimal) value
				.get(Fields.accountingQuantityTotal.name());
		oldQuantityOnHand = (BigDecimal) value.get(Fields.oldQuantityOnHand
				.name());
		oldAvailableToPromise = (BigDecimal) value
				.get(Fields.oldAvailableToPromise.name());
		serialNumber = (String) value.get(Fields.serialNumber.name());
		softIdentifier = (String) value.get(Fields.softIdentifier.name());
		activationNumber = (String) value.get(Fields.activationNumber.name());
		activationValidThru = (Timestamp) value.get(Fields.activationValidThru
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		inventoryItemFixedAssetId = (String) value
				.get(Fields.inventoryItemFixedAssetId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		orderId = (String) value.get(Fields.orderId.name());
		description = (String) value.get(Fields.description.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		inventoryItemDetailSeqId = (String) value
				.get(Fields.inventoryItemDetailSeqId.name());
		accountingQuantityDiff = (BigDecimal) value
				.get(Fields.accountingQuantityDiff.name());
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		returnId = (String) value.get(Fields.returnId.name());
		reasonEnumId = (String) value.get(Fields.reasonEnumId.name());
		receiptId = (String) value.get(Fields.receiptId.name());
		quantityOnHandDiff = (BigDecimal) value.get(Fields.quantityOnHandDiff
				.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		availableToPromiseDiff = (BigDecimal) value
				.get(Fields.availableToPromiseDiff.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
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