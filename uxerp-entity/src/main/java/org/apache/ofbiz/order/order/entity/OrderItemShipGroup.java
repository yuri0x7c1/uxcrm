package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Ship Group
 */
public class OrderItemShipGroup implements Serializable {

	public static final long serialVersionUID = 4152288416779760640L;
	public static final String NAME = "OrderItemShipGroup";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Supplier Party Id
	 */
	@Getter
	@Setter
	private String supplierPartyId;
	/**
	 * Vendor Party Id
	 */
	@Getter
	@Setter
	private String vendorPartyId;
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
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Telecom Contact Mech Id
	 */
	@Getter
	@Setter
	private String telecomContactMechId;
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
	 * Ship By Date
	 */
	@Getter
	@Setter
	private Timestamp shipByDate;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Estimated Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedDeliveryDate;

	public enum Fields {
		orderId, shipGroupSeqId, shipmentMethodTypeId, supplierPartyId, vendorPartyId, carrierPartyId, carrierRoleTypeId, facilityId, contactMechId, telecomContactMechId, trackingNumber, shippingInstructions, maySplit, giftMessage, isGift, shipAfterDate, shipByDate, estimatedShipDate, estimatedDeliveryDate
	}

	public OrderItemShipGroup(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		supplierPartyId = (String) value.get(Fields.supplierPartyId.name());
		vendorPartyId = (String) value.get(Fields.vendorPartyId.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierRoleTypeId = (String) value.get(Fields.carrierRoleTypeId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		telecomContactMechId = (String) value.get(Fields.telecomContactMechId
				.name());
		trackingNumber = (String) value.get(Fields.trackingNumber.name());
		shippingInstructions = (String) value.get(Fields.shippingInstructions
				.name());
		maySplit = (String) value.get(Fields.maySplit.name());
		giftMessage = (String) value.get(Fields.giftMessage.name());
		isGift = (String) value.get(Fields.isGift.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		shipByDate = (Timestamp) value.get(Fields.shipByDate.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		estimatedDeliveryDate = (Timestamp) value
				.get(Fields.estimatedDeliveryDate.name());
	}

	public static OrderItemShipGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemShipGroup(value);
	}

	public static List<OrderItemShipGroup> fromValues(List<GenericValue> values) {
		List<OrderItemShipGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemShipGroup(value));
		}
		return entities;
	}
}