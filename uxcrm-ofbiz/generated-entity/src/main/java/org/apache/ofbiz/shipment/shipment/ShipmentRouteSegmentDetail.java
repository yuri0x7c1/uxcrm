package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ShipmentRouteSegmentDetail implements Serializable {

	public static final long serialVersionUID = 4083436800627456000L;
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

	public ShipmentRouteSegmentDetail(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentRouteSegmentId = (String) value
				.get(FIELD_SHIPMENT_ROUTE_SEGMENT_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierServiceStatusId = (String) value
				.get(FIELD_CARRIER_SERVICE_STATUS_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		billingWeight = (BigDecimal) value.get(FIELD_BILLING_WEIGHT);
		billingWeightUomId = (String) value.get(FIELD_BILLING_WEIGHT_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		primaryOrderId = (String) value.get(FIELD_PRIMARY_ORDER_ID);
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