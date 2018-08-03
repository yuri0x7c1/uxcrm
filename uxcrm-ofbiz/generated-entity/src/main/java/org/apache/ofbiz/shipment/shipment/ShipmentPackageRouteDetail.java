package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Package Route Detail
 */
public class ShipmentPackageRouteDetail implements Serializable {

	public static final long serialVersionUID = 3357503535996103680L;
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

	public enum Fields {
		shipmentId, shipmentPackageSeqId, shipmentRouteSegmentId, labelPrinted, trackingCode, carrierPartyId, carrierServiceStatusId, shipmentMethodTypeId, statusId, primaryOrderId
	}

	public ShipmentPackageRouteDetail(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		shipmentRouteSegmentId = (String) value
				.get(Fields.shipmentRouteSegmentId.name());
		labelPrinted = (String) value.get(Fields.labelPrinted.name());
		trackingCode = (String) value.get(Fields.trackingCode.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierServiceStatusId = (String) value
				.get(Fields.carrierServiceStatusId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
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