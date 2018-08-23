package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Ship Grp Inv Res And Item Location
 */
@FieldNameConstants
public class OrderItemShipGrpInvResAndItemLocation implements Serializable {

	public static final long serialVersionUID = 4759511965647285248L;
	public static final String NAME = "OrderItemShipGrpInvResAndItemLocation";
	/**
	 * Order Item Status Id
	 */
	@Getter
	@Setter
	private String orderItemStatusId;
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
	 * Promised Datetime
	 */
	@Getter
	@Setter
	private Timestamp promisedDatetime;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private String priority;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private Long sequenceId;
	/**
	 * Old Pick Start Date
	 */
	@Getter
	@Setter
	private Timestamp oldPickStartDate;
	/**
	 * Current Promised Date
	 */
	@Getter
	@Setter
	private Timestamp currentPromisedDate;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Quantity Not Available
	 */
	@Getter
	@Setter
	private BigDecimal quantityNotAvailable;
	/**
	 * Created Datetime
	 */
	@Getter
	@Setter
	private Timestamp createdDatetime;
	/**
	 * Reserve Order Enum Id
	 */
	@Getter
	@Setter
	private String reserveOrderEnumId;
	/**
	 * Reserved Datetime
	 */
	@Getter
	@Setter
	private Timestamp reservedDatetime;
	/**
	 * Soft Identifier
	 */
	@Getter
	@Setter
	private String softIdentifier;
	/**
	 * Bin Number
	 */
	@Getter
	@Setter
	private String binNumber;
	/**
	 * Old Available To Promise
	 */
	@Getter
	@Setter
	private BigDecimal oldAvailableToPromise;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
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
	 * Old Quantity On Hand
	 */
	@Getter
	@Setter
	private BigDecimal oldQuantityOnHand;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Serial Number
	 */
	@Getter
	@Setter
	private String serialNumber;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * Accounting Quantity Total
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityTotal;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Activation Valid Thru
	 */
	@Getter
	@Setter
	private Timestamp activationValidThru;
	/**
	 * Activation Number
	 */
	@Getter
	@Setter
	private String activationNumber;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Datetime Received
	 */
	@Getter
	@Setter
	private Timestamp datetimeReceived;
	/**
	 * Section Id
	 */
	@Getter
	@Setter
	private String sectionId;
	/**
	 * Aisle Id
	 */
	@Getter
	@Setter
	private String aisleId;
	/**
	 * Area Id
	 */
	@Getter
	@Setter
	private String areaId;
	/**
	 * Position Id
	 */
	@Getter
	@Setter
	private String positionId;
	/**
	 * Level Id
	 */
	@Getter
	@Setter
	private String levelId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
	/**
	 * Location Type Enum Id
	 */
	@Getter
	@Setter
	private String locationTypeEnumId;

	public OrderItemShipGrpInvResAndItemLocation(GenericValue value) {
		orderItemStatusId = (String) value.get(FIELD_ORDER_ITEM_STATUS_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		orderId = (String) value.get(FIELD_ORDER_ID);
		promisedDatetime = (Timestamp) value.get(FIELD_PROMISED_DATETIME);
		priority = (String) value.get(FIELD_PRIORITY);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		sequenceId = (Long) value.get(FIELD_SEQUENCE_ID);
		oldPickStartDate = (Timestamp) value.get(FIELD_OLD_PICK_START_DATE);
		currentPromisedDate = (Timestamp) value
				.get(FIELD_CURRENT_PROMISED_DATE);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		quantityNotAvailable = (BigDecimal) value
				.get(FIELD_QUANTITY_NOT_AVAILABLE);
		createdDatetime = (Timestamp) value.get(FIELD_CREATED_DATETIME);
		reserveOrderEnumId = (String) value.get(FIELD_RESERVE_ORDER_ENUM_ID);
		reservedDatetime = (Timestamp) value.get(FIELD_RESERVED_DATETIME);
		softIdentifier = (String) value.get(FIELD_SOFT_IDENTIFIER);
		binNumber = (String) value.get(FIELD_BIN_NUMBER);
		oldAvailableToPromise = (BigDecimal) value
				.get(FIELD_OLD_AVAILABLE_TO_PROMISE);
		quantityOnHandTotal = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_TOTAL);
		datetimeManufactured = (Timestamp) value
				.get(FIELD_DATETIME_MANUFACTURED);
		expireDate = (Timestamp) value.get(FIELD_EXPIRE_DATE);
		oldQuantityOnHand = (BigDecimal) value.get(FIELD_OLD_QUANTITY_ON_HAND);
		partyId = (String) value.get(FIELD_PARTY_ID);
		containerId = (String) value.get(FIELD_CONTAINER_ID);
		availableToPromiseTotal = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_TOTAL);
		inventoryItemTypeId = (String) value.get(FIELD_INVENTORY_ITEM_TYPE_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		serialNumber = (String) value.get(FIELD_SERIAL_NUMBER);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		lotId = (String) value.get(FIELD_LOT_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		accountingQuantityTotal = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_TOTAL);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		activationValidThru = (Timestamp) value
				.get(FIELD_ACTIVATION_VALID_THRU);
		activationNumber = (String) value.get(FIELD_ACTIVATION_NUMBER);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		datetimeReceived = (Timestamp) value.get(FIELD_DATETIME_RECEIVED);
		sectionId = (String) value.get(FIELD_SECTION_ID);
		aisleId = (String) value.get(FIELD_AISLE_ID);
		areaId = (String) value.get(FIELD_AREA_ID);
		positionId = (String) value.get(FIELD_POSITION_ID);
		levelId = (String) value.get(FIELD_LEVEL_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		locationTypeEnumId = (String) value.get(FIELD_LOCATION_TYPE_ENUM_ID);
	}

	public static OrderItemShipGrpInvResAndItemLocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemShipGrpInvResAndItemLocation(value);
	}

	public static List<OrderItemShipGrpInvResAndItemLocation> fromValues(
			List<GenericValue> values) {
		List<OrderItemShipGrpInvResAndItemLocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemShipGrpInvResAndItemLocation(value));
		}
		return entities;
	}
}