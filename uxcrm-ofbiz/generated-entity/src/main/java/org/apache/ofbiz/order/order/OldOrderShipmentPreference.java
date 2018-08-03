package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Order Shipment Preference
 */
public class OldOrderShipmentPreference implements Serializable {

	public static final long serialVersionUID = 1478837389231460352L;
	public static final String NAME = "OldOrderShipmentPreference";
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
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Carrier Role Type Id
	 */
	@Getter
	@Setter
	private String carrierRoleTypeId;
	/**
	 * Tracking Number
	 */
	@Getter
	@Setter
	private String trackingNumber;
	/**
	 * Shipping Instructions
	 */
	@Getter
	@Setter
	private String shippingInstructions;
	/**
	 * May Split
	 */
	@Getter
	@Setter
	private String maySplit;
	/**
	 * Gift Message
	 */
	@Getter
	@Setter
	private String giftMessage;
	/**
	 * Is Gift
	 */
	@Getter
	@Setter
	private String isGift;
	/**
	 * Ship After Date
	 */
	@Getter
	@Setter
	private Timestamp shipAfterDate;
	/**
	 * Ship Before Date
	 */
	@Getter
	@Setter
	private Timestamp shipBeforeDate;
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		orderId, orderItemSeqId, shipmentMethodTypeId, carrierPartyId, carrierRoleTypeId, trackingNumber, shippingInstructions, maySplit, giftMessage, isGift, shipAfterDate, shipBeforeDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldOrderShipmentPreference(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierRoleTypeId = (String) value.get(Fields.carrierRoleTypeId.name());
		trackingNumber = (String) value.get(Fields.trackingNumber.name());
		shippingInstructions = (String) value.get(Fields.shippingInstructions
				.name());
		maySplit = (String) value.get(Fields.maySplit.name());
		giftMessage = (String) value.get(Fields.giftMessage.name());
		isGift = (String) value.get(Fields.isGift.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		shipBeforeDate = (Timestamp) value.get(Fields.shipBeforeDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldOrderShipmentPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldOrderShipmentPreference(value);
	}

	public static List<OldOrderShipmentPreference> fromValues(
			List<GenericValue> values) {
		List<OldOrderShipmentPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldOrderShipmentPreference(value));
		}
		return entities;
	}
}