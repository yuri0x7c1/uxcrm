package org.apache.ofbiz.shipment.issuance;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Item Issuance And Inventory Item
 */
public class ItemIssuanceAndInventoryItem implements Serializable {

	public static final long serialVersionUID = 673095256989173760L;
	public static final String NAME = "ItemIssuanceAndInventoryItem";
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
	 * Inventory Item Fixed Asset Id
	 */
	@Getter
	@Setter
	private String inventoryItemFixedAssetId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
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
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Issued Date Time
	 */
	@Getter
	@Setter
	private Timestamp issuedDateTime;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Issued By User Login Id
	 */
	@Getter
	@Setter
	private String issuedByUserLoginId;

	public enum Fields {
		inventoryItemId, inventoryItemTypeId, productId, partyId, ownerPartyId, statusId, datetimeReceived, datetimeManufactured, expireDate, facilityId, containerId, lotId, uomId, binNumber, locationSeqId, comments, quantityOnHandTotal, availableToPromiseTotal, accountingQuantityTotal, oldQuantityOnHand, oldAvailableToPromise, serialNumber, softIdentifier, activationNumber, activationValidThru, unitCost, currencyUomId, inventoryItemFixedAssetId, orderItemSeqId, quantity, orderId, maintHistSeqId, shipmentItemSeqId, shipGroupSeqId, cancelQuantity, itemIssuanceId, shipmentId, issuedDateTime, fixedAssetId, issuedByUserLoginId
	}

	public ItemIssuanceAndInventoryItem(GenericValue value) {
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
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		inventoryItemFixedAssetId = (String) value
				.get(Fields.inventoryItemFixedAssetId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		issuedDateTime = (Timestamp) value.get(Fields.issuedDateTime.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		issuedByUserLoginId = (String) value.get(Fields.issuedByUserLoginId
				.name());
	}

	public static ItemIssuanceAndInventoryItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ItemIssuanceAndInventoryItem(value);
	}

	public static List<ItemIssuanceAndInventoryItem> fromValues(
			List<GenericValue> values) {
		List<ItemIssuanceAndInventoryItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ItemIssuanceAndInventoryItem(value));
		}
		return entities;
	}
}