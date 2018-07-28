package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Route Segment Detail
 */
public class ShipmentRouteSegmentDetail implements Serializable {

	public static final long serialVersionUID = 5544268920836796416L;
	public static final String NAME = "ShipmentRouteSegmentDetail";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Route Segment Id
	 */
	@Getter
	@Setter
	private String shipmentRouteSegmentId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
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
	 * Billing Weight
	 */
	@Getter
	@Setter
	private BigDecimal billingWeight;
	/**
	 * Billing Weight Uom Id
	 */
	@Getter
	@Setter
	private String billingWeightUomId;
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
		shipmentId, shipmentRouteSegmentId, originFacilityId, carrierPartyId, carrierServiceStatusId, shipmentMethodTypeId, billingWeight, billingWeightUomId, statusId, primaryOrderId
	}

	public ShipmentRouteSegmentDetail(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentRouteSegmentId = (String) value
				.get(Fields.shipmentRouteSegmentId.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierServiceStatusId = (String) value
				.get(Fields.carrierServiceStatusId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		billingWeight = (BigDecimal) value.get(Fields.billingWeight.name());
		billingWeightUomId = (String) value.get(Fields.billingWeightUomId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		primaryOrderId = (String) value.get(Fields.primaryOrderId.name());
	}

	public static ShipmentRouteSegmentDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentRouteSegmentDetail(value);
	}

	public static List<ShipmentRouteSegmentDetail> fromValues(
			List<GenericValue> values) {
		List<ShipmentRouteSegmentDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentRouteSegmentDetail(value));
		}
		return entities;
	}
}