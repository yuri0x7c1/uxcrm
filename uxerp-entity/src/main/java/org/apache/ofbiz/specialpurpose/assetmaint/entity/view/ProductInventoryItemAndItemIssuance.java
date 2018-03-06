package org.apache.ofbiz.specialpurpose.assetmaint.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Inventory Item And Item Issuance
 */
public class ProductInventoryItemAndItemIssuance implements Serializable {

	public static final long serialVersionUID = 4533630213008616448L;
	public static final String NAME = "ProductInventoryItemAndItemIssuance";
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
	/**
	 * Issued Date Time
	 */
	@Getter
	@Setter
	private Timestamp issuedDateTime;
	/**
	 * Issued By User Login Id
	 */
	@Getter
	@Setter
	private String issuedByUserLoginId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
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
	 * Product Type Id
	 */
	@Getter
	@Setter
	private String productTypeId;
	/**
	 * Primary Product Category Id
	 */
	@Getter
	@Setter
	private String primaryProductCategoryId;
	/**
	 * Manufacturer Party Id
	 */
	@Getter
	@Setter
	private String manufacturerPartyId;
	/**
	 * Introduction Date
	 */
	@Getter
	@Setter
	private Timestamp introductionDate;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Require Inventory
	 */
	@Getter
	@Setter
	private String requireInventory;
	/**
	 * Taxable
	 */
	@Getter
	@Setter
	private String taxable;
	/**
	 * Charge Shipping
	 */
	@Getter
	@Setter
	private String chargeShipping;
	/**
	 * Is Virtual
	 */
	@Getter
	@Setter
	private String isVirtual;
	/**
	 * Is Variant
	 */
	@Getter
	@Setter
	private String isVariant;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;

	public enum Fields {
		itemIssuanceId, orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId, shipmentId, shipmentItemSeqId, fixedAssetId, maintHistSeqId, issuedDateTime, issuedByUserLoginId, quantity, cancelQuantity, inventoryItemTypeId, productId, partyId, ownerPartyId, statusId, datetimeReceived, datetimeManufactured, expireDate, facilityId, containerId, lotId, uomId, binNumber, locationSeqId, comments, quantityOnHandTotal, availableToPromiseTotal, accountingQuantityTotal, oldQuantityOnHand, oldAvailableToPromise, serialNumber, softIdentifier, activationNumber, activationValidThru, unitCost, currencyUomId, productTypeId, primaryProductCategoryId, manufacturerPartyId, introductionDate, internalName, description, requireInventory, taxable, chargeShipping, isVirtual, isVariant, createdDate, createdByUserLogin
	}

	public ProductInventoryItemAndItemIssuance(GenericValue value) {
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		issuedDateTime = (Timestamp) value.get(Fields.issuedDateTime.name());
		issuedByUserLoginId = (String) value.get(Fields.issuedByUserLoginId
				.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
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
		productTypeId = (String) value.get(Fields.productTypeId.name());
		primaryProductCategoryId = (String) value
				.get(Fields.primaryProductCategoryId.name());
		manufacturerPartyId = (String) value.get(Fields.manufacturerPartyId
				.name());
		introductionDate = (Timestamp) value
				.get(Fields.introductionDate.name());
		internalName = (String) value.get(Fields.internalName.name());
		description = (String) value.get(Fields.description.name());
		requireInventory = (String) value.get(Fields.requireInventory.name());
		taxable = (String) value.get(Fields.taxable.name());
		chargeShipping = (String) value.get(Fields.chargeShipping.name());
		isVirtual = (String) value.get(Fields.isVirtual.name());
		isVariant = (String) value.get(Fields.isVariant.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
	}

	public static ProductInventoryItemAndItemIssuance fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductInventoryItemAndItemIssuance(value);
	}

	public static List<ProductInventoryItemAndItemIssuance> fromValues(
			List<GenericValue> values) {
		List<ProductInventoryItemAndItemIssuance> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductInventoryItemAndItemIssuance(value));
		}
		return entities;
	}
}