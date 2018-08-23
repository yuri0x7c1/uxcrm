package org.apache.ofbiz.shipment.shipment;

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
 * Shipment And Item
 */
@FieldNameConstants
public class ShipmentAndItem implements Serializable {

	public static final long serialVersionUID = 9035180510171554816L;
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

	public ShipmentAndItem(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentTypeId = (String) value.get(FIELD_SHIPMENT_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		primaryOrderId = (String) value.get(FIELD_PRIMARY_ORDER_ID);
		estimatedReadyDate = (Timestamp) value.get(FIELD_ESTIMATED_READY_DATE);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		estimatedArrivalDate = (Timestamp) value
				.get(FIELD_ESTIMATED_ARRIVAL_DATE);
		latestCancelDate = (Timestamp) value.get(FIELD_LATEST_CANCEL_DATE);
		estimatedShipCost = (BigDecimal) value.get(FIELD_ESTIMATED_SHIP_COST);
		handlingInstructions = (String) value.get(FIELD_HANDLING_INSTRUCTIONS);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		destinationFacilityId = (String) value
				.get(FIELD_DESTINATION_FACILITY_ID);
		originContactMechId = (String) value.get(FIELD_ORIGIN_CONTACT_MECH_ID);
		destinationContactMechId = (String) value
				.get(FIELD_DESTINATION_CONTACT_MECH_ID);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		shipmentContentDescription = (String) value
				.get(FIELD_SHIPMENT_CONTENT_DESCRIPTION);
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