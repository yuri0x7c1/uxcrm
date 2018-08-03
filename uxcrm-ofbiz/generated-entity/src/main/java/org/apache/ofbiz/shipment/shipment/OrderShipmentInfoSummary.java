package org.apache.ofbiz.shipment.shipment;

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
public class OrderShipmentInfoSummary implements Serializable {

	public static final long serialVersionUID = 686125052258052096L;
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

	public enum Fields {
		orderId, orderItemSeqId, shipmentId, shipGroupSeqId, shipmentRouteSegmentId, carrierPartyId, actualStartDate, shipmentMethodTypeId, shipmentPackageSeqId, trackingCode, boxNumber
	}

	public OrderShipmentInfoSummary(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		shipmentRouteSegmentId = (String) value
				.get(Fields.shipmentRouteSegmentId.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		trackingCode = (String) value.get(Fields.trackingCode.name());
		boxNumber = (String) value.get(Fields.boxNumber.name());
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