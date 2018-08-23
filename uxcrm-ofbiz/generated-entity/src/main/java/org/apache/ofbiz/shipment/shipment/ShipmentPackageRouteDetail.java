package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Package Route Detail
 */
@FieldNameConstants
public class ShipmentPackageRouteDetail implements Serializable {

	public static final long serialVersionUID = 441669448854877184L;
	public static final String NAME = "ShipmentPackageRouteDetail";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Shipment Route Segment Id
	 */
	@Getter
	@Setter
	private String shipmentRouteSegmentId;
	/**
	 * Label Printed
	 */
	@Getter
	@Setter
	private String labelPrinted;
	/**
	 * Tracking Code
	 */
	@Getter
	@Setter
	private String trackingCode;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Carrier Service Status Id
	 */
	@Getter
	@Setter
	private String carrierServiceStatusId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
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

	public ShipmentPackageRouteDetail(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		shipmentRouteSegmentId = (String) value
				.get(FIELD_SHIPMENT_ROUTE_SEGMENT_ID);
		labelPrinted = (String) value.get(FIELD_LABEL_PRINTED);
		trackingCode = (String) value.get(FIELD_TRACKING_CODE);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierServiceStatusId = (String) value
				.get(FIELD_CARRIER_SERVICE_STATUS_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		primaryOrderId = (String) value.get(FIELD_PRIMARY_ORDER_ID);
	}

	public static ShipmentPackageRouteDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentPackageRouteDetail(value);
	}

	public static List<ShipmentPackageRouteDetail> fromValues(
			List<GenericValue> values) {
		List<ShipmentPackageRouteDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentPackageRouteDetail(value));
		}
		return entities;
	}
}