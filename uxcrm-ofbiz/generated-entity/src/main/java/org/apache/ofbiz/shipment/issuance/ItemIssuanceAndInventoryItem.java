package org.apache.ofbiz.shipment.issuance;

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
 * Item Issuance And Inventory Item
 */
@FieldNameConstants
public class ItemIssuanceAndInventoryItem implements Serializable {

	public static final long serialVersionUID = 7458362662181193728L;
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

	public ItemIssuanceAndInventoryItem(GenericValue value) {
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
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		inventoryItemFixedAssetId = (String) value
				.get(FIELD_INVENTORY_ITEM_FIXED_ASSET_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		orderId = (String) value.get(FIELD_ORDER_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		issuedDateTime = (Timestamp) value.get(FIELD_ISSUED_DATE_TIME);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		issuedByUserLoginId = (String) value.get(FIELD_ISSUED_BY_USER_LOGIN_ID);
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