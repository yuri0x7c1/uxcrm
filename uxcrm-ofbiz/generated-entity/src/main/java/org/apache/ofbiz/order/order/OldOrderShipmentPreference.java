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
 * Old Order Shipment Preference
 */
@FieldNameConstants
public class OldOrderShipmentPreference implements Serializable {

	public static final long serialVersionUID = 8177539148763761664L;
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

	public OldOrderShipmentPreference(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierRoleTypeId = (String) value.get(FIELD_CARRIER_ROLE_TYPE_ID);
		trackingNumber = (String) value.get(FIELD_TRACKING_NUMBER);
		shippingInstructions = (String) value.get(FIELD_SHIPPING_INSTRUCTIONS);
		maySplit = (String) value.get(FIELD_MAY_SPLIT);
		giftMessage = (String) value.get(FIELD_GIFT_MESSAGE);
		isGift = (String) value.get(FIELD_IS_GIFT);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		shipBeforeDate = (Timestamp) value.get(FIELD_SHIP_BEFORE_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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