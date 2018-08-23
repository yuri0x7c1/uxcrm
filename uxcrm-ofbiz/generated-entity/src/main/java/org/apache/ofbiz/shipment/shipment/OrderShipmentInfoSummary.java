package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Shipment Info Summary
 */
@FieldNameConstants
public class OrderShipmentInfoSummary implements Serializable {

	public static final long serialVersionUID = 3188824743572529152L;
	public static final String NAME = "OrderShipmentInfoSummary";
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
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Shipment Route Segment Id
	 */
	@Getter
	@Setter
	private String shipmentRouteSegmentId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Tracking Code
	 */
	@Getter
	@Setter
	private String trackingCode;
	/**
	 * Box Number
	 */
	@Getter
	@Setter
	private String boxNumber;

	public OrderShipmentInfoSummary(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		shipmentRouteSegmentId = (String) value
				.get(FIELD_SHIPMENT_ROUTE_SEGMENT_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		actualStartDate = (Timestamp) value.get(FIELD_ACTUAL_START_DATE);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		trackingCode = (String) value.get(FIELD_TRACKING_CODE);
		boxNumber = (String) value.get(FIELD_BOX_NUMBER);
	}

	public static OrderShipmentInfoSummary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderShipmentInfoSummary(value);
	}

	public static List<OrderShipmentInfoSummary> fromValues(
			List<GenericValue> values) {
		List<OrderShipmentInfoSummary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderShipmentInfoSummary(value));
		}
		return entities;
	}
}