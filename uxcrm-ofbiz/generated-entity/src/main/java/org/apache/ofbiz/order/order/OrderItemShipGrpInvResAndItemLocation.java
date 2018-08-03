package org.apache.ofbiz.order.order;

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
public class OrderItemShipGrpInvResAndItemLocation implements Serializable {

	public static final long serialVersionUID = 4948003768234417152L;
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

	public enum Fields {
		orderItemStatusId, orderItemSeqId, quantity, orderId, promisedDatetime, priority, shipGroupSeqId, sequenceId, oldPickStartDate, currentPromisedDate, inventoryItemId, quantityNotAvailable, createdDatetime, reserveOrderEnumId, reservedDatetime, softIdentifier, binNumber, oldAvailableToPromise, quantityOnHandTotal, datetimeManufactured, expireDate, oldQuantityOnHand, partyId, containerId, availableToPromiseTotal, inventoryItemTypeId, locationSeqId, facilityId, comments, serialNumber, productId, lotId, uomId, accountingQuantityTotal, ownerPartyId, activationValidThru, activationNumber, currencyUomId, statusId, unitCost, fixedAssetId, datetimeReceived, sectionId, aisleId, areaId, positionId, levelId, geoPointId, locationTypeEnumId
	}

	public OrderItemShipGrpInvResAndItemLocation(GenericValue value) {
		orderItemStatusId = (String) value.get(Fields.orderItemStatusId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		orderId = (String) value.get(Fields.orderId.name());
		promisedDatetime = (Timestamp) value
				.get(Fields.promisedDatetime.name());
		priority = (String) value.get(Fields.priority.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		sequenceId = (Long) value.get(Fields.sequenceId.name());
		oldPickStartDate = (Timestamp) value
				.get(Fields.oldPickStartDate.name());
		currentPromisedDate = (Timestamp) value.get(Fields.currentPromisedDate
				.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		quantityNotAvailable = (BigDecimal) value
				.get(Fields.quantityNotAvailable.name());
		createdDatetime = (Timestamp) value.get(Fields.createdDatetime.name());
		reserveOrderEnumId = (String) value.get(Fields.reserveOrderEnumId
				.name());
		reservedDatetime = (Timestamp) value
				.get(Fields.reservedDatetime.name());
		softIdentifier = (String) value.get(Fields.softIdentifier.name());
		binNumber = (String) value.get(Fields.binNumber.name());
		oldAvailableToPromise = (BigDecimal) value
				.get(Fields.oldAvailableToPromise.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		datetimeManufactured = (Timestamp) value
				.get(Fields.datetimeManufactured.name());
		expireDate = (Timestamp) value.get(Fields.expireDate.name());
		oldQuantityOnHand = (BigDecimal) value.get(Fields.oldQuantityOnHand
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		containerId = (String) value.get(Fields.containerId.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		comments = (String) value.get(Fields.comments.name());
		serialNumber = (String) value.get(Fields.serialNumber.name());
		productId = (String) value.get(Fields.productId.name());
		lotId = (String) value.get(Fields.lotId.name());
		uomId = (String) value.get(Fields.uomId.name());
		accountingQuantityTotal = (BigDecimal) value
				.get(Fields.accountingQuantityTotal.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		activationValidThru = (Timestamp) value.get(Fields.activationValidThru
				.name());
		activationNumber = (String) value.get(Fields.activationNumber.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		statusId = (String) value.get(Fields.statusId.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		datetimeReceived = (Timestamp) value
				.get(Fields.datetimeReceived.name());
		sectionId = (String) value.get(Fields.sectionId.name());
		aisleId = (String) value.get(Fields.aisleId.name());
		areaId = (String) value.get(Fields.areaId.name());
		positionId = (String) value.get(Fields.positionId.name());
		levelId = (String) value.get(Fields.levelId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		locationTypeEnumId = (String) value.get(Fields.locationTypeEnumId
				.name());
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