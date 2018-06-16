package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment And Item
 */
public class ShipmentAndItem implements Serializable {

	public static final long serialVersionUID = 7640104991745653760L;
	public static final String NAME = "ShipmentAndItem";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Type Id
	 */
	@Getter
	@Setter
	private String shipmentTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Primary Order Id
	 */
	@Getter
	@Setter
	private String primaryOrderId;
	/**
	 * Estimated Ready Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedReadyDate;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Estimated Arrival Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedArrivalDate;
	/**
	 * Latest Cancel Date
	 */
	@Getter
	@Setter
	private Timestamp latestCancelDate;
	/**
	 * Estimated Ship Cost
	 */
	@Getter
	@Setter
	private BigDecimal estimatedShipCost;
	/**
	 * Handling Instructions
	 */
	@Getter
	@Setter
	private String handlingInstructions;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Destination Facility Id
	 */
	@Getter
	@Setter
	private String destinationFacilityId;
	/**
	 * Origin Contact Mech Id
	 */
	@Getter
	@Setter
	private String originContactMechId;
	/**
	 * Destination Contact Mech Id
	 */
	@Getter
	@Setter
	private String destinationContactMechId;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Shipment Content Description
	 */
	@Getter
	@Setter
	private String shipmentContentDescription;

	public enum Fields {
		shipmentId, shipmentTypeId, statusId, primaryOrderId, estimatedReadyDate, estimatedShipDate, estimatedArrivalDate, latestCancelDate, estimatedShipCost, handlingInstructions, originFacilityId, destinationFacilityId, originContactMechId, destinationContactMechId, partyIdTo, partyIdFrom, shipmentItemSeqId, productId, quantity, shipmentContentDescription
	}

	public ShipmentAndItem(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentTypeId = (String) value.get(Fields.shipmentTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
		estimatedReadyDate = (Timestamp) value.get(Fields.estimatedReadyDate
				.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		estimatedArrivalDate = (Timestamp) value
				.get(Fields.estimatedArrivalDate.name());
		latestCancelDate = (Timestamp) value
				.get(Fields.latestCancelDate.name());
		estimatedShipCost = (BigDecimal) value.get(Fields.estimatedShipCost
				.name());
		handlingInstructions = (String) value.get(Fields.handlingInstructions
				.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		destinationFacilityId = (String) value.get(Fields.destinationFacilityId
				.name());
		originContactMechId = (String) value.get(Fields.originContactMechId
				.name());
		destinationContactMechId = (String) value
				.get(Fields.destinationContactMechId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		shipmentContentDescription = (String) value
				.get(Fields.shipmentContentDescription.name());
	}

	public static ShipmentAndItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentAndItem(value);
	}

	public static List<ShipmentAndItem> fromValues(List<GenericValue> values) {
		List<ShipmentAndItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentAndItem(value));
		}
		return entities;
	}
}