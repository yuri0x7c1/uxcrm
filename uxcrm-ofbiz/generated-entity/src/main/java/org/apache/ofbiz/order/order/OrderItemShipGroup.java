package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OrderItemShipGroup implements Serializable {

	public static final long serialVersionUID = 5280554852121863168L;
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

	public OrderItemShipGroup(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		supplierPartyId = (String) value.get(FIELD_SUPPLIER_PARTY_ID);
		vendorPartyId = (String) value.get(FIELD_VENDOR_PARTY_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierRoleTypeId = (String) value.get(FIELD_CARRIER_ROLE_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		telecomContactMechId = (String) value
				.get(FIELD_TELECOM_CONTACT_MECH_ID);
		trackingNumber = (String) value.get(FIELD_TRACKING_NUMBER);
		shippingInstructions = (String) value.get(FIELD_SHIPPING_INSTRUCTIONS);
		maySplit = (String) value.get(FIELD_MAY_SPLIT);
		giftMessage = (String) value.get(FIELD_GIFT_MESSAGE);
		isGift = (String) value.get(FIELD_IS_GIFT);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		shipByDate = (Timestamp) value.get(FIELD_SHIP_BY_DATE);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		estimatedDeliveryDate = (Timestamp) value
				.get(FIELD_ESTIMATED_DELIVERY_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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