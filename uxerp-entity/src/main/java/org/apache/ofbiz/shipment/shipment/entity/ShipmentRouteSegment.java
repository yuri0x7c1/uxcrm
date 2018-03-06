package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Route Segment
 */
public class ShipmentRouteSegment implements Serializable {

	public static final long serialVersionUID = 6050184864240653312L;
	public static final String NAME = "ShipmentRouteSegment";
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
	 * Delivery Id
	 */
	@Getter
	@Setter
	private String deliveryId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Dest Facility Id
	 */
	@Getter
	@Setter
	private String destFacilityId;
	/**
	 * Origin Contact Mech Id
	 */
	@Getter
	@Setter
	private String originContactMechId;
	/**
	 * Origin Telecom Number Id
	 */
	@Getter
	@Setter
	private String originTelecomNumberId;
	/**
	 * Dest Contact Mech Id
	 */
	@Getter
	@Setter
	private String destContactMechId;
	/**
	 * Dest Telecom Number Id
	 */
	@Getter
	@Setter
	private String destTelecomNumberId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Carrier Service Status Id
	 */
	@Getter
	@Setter
	private String carrierServiceStatusId;
	/**
	 * Carrier Delivery Zone
	 */
	@Getter
	@Setter
	private String carrierDeliveryZone;
	/**
	 * Carrier Restriction Codes
	 */
	@Getter
	@Setter
	private String carrierRestrictionCodes;
	/**
	 * Carrier Restriction Desc
	 */
	@Getter
	@Setter
	private String carrierRestrictionDesc;
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
	 * Actual Transport Cost
	 */
	@Getter
	@Setter
	private BigDecimal actualTransportCost;
	/**
	 * Actual Service Cost
	 */
	@Getter
	@Setter
	private BigDecimal actualServiceCost;
	/**
	 * Actual Other Cost
	 */
	@Getter
	@Setter
	private BigDecimal actualOtherCost;
	/**
	 * Actual Cost
	 */
	@Getter
	@Setter
	private BigDecimal actualCost;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Actual Arrival Date
	 */
	@Getter
	@Setter
	private Timestamp actualArrivalDate;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Estimated Arrival Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedArrivalDate;
	/**
	 * Tracking Id Number
	 */
	@Getter
	@Setter
	private String trackingIdNumber;
	/**
	 * Tracking Digest
	 */
	@Getter
	@Setter
	private String trackingDigest;
	/**
	 * Updated By User Login Id
	 */
	@Getter
	@Setter
	private String updatedByUserLoginId;
	/**
	 * Last Updated Date
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedDate;
	/**
	 * Home Delivery Type
	 */
	@Getter
	@Setter
	private String homeDeliveryType;
	/**
	 * Home Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp homeDeliveryDate;
	/**
	 * Third Party Account Number
	 */
	@Getter
	@Setter
	private String thirdPartyAccountNumber;
	/**
	 * Third Party Postal Code
	 */
	@Getter
	@Setter
	private String thirdPartyPostalCode;
	/**
	 * Third Party Country Geo Code
	 */
	@Getter
	@Setter
	private String thirdPartyCountryGeoCode;
	/**
	 * Ups High Value Report
	 */
	@Getter
	@Setter
	private byte[] upsHighValueReport;

	public enum Fields {
		shipmentId, shipmentRouteSegmentId, deliveryId, originFacilityId, destFacilityId, originContactMechId, originTelecomNumberId, destContactMechId, destTelecomNumberId, carrierPartyId, shipmentMethodTypeId, carrierServiceStatusId, carrierDeliveryZone, carrierRestrictionCodes, carrierRestrictionDesc, billingWeight, billingWeightUomId, actualTransportCost, actualServiceCost, actualOtherCost, actualCost, currencyUomId, actualStartDate, actualArrivalDate, estimatedStartDate, estimatedArrivalDate, trackingIdNumber, trackingDigest, updatedByUserLoginId, lastUpdatedDate, homeDeliveryType, homeDeliveryDate, thirdPartyAccountNumber, thirdPartyPostalCode, thirdPartyCountryGeoCode, upsHighValueReport
	}

	public ShipmentRouteSegment(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentRouteSegmentId = (String) value
				.get(Fields.shipmentRouteSegmentId.name());
		deliveryId = (String) value.get(Fields.deliveryId.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		destFacilityId = (String) value.get(Fields.destFacilityId.name());
		originContactMechId = (String) value.get(Fields.originContactMechId
				.name());
		originTelecomNumberId = (String) value.get(Fields.originTelecomNumberId
				.name());
		destContactMechId = (String) value.get(Fields.destContactMechId.name());
		destTelecomNumberId = (String) value.get(Fields.destTelecomNumberId
				.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		carrierServiceStatusId = (String) value
				.get(Fields.carrierServiceStatusId.name());
		carrierDeliveryZone = (String) value.get(Fields.carrierDeliveryZone
				.name());
		carrierRestrictionCodes = (String) value
				.get(Fields.carrierRestrictionCodes.name());
		carrierRestrictionDesc = (String) value
				.get(Fields.carrierRestrictionDesc.name());
		billingWeight = (BigDecimal) value.get(Fields.billingWeight.name());
		billingWeightUomId = (String) value.get(Fields.billingWeightUomId
				.name());
		actualTransportCost = (BigDecimal) value.get(Fields.actualTransportCost
				.name());
		actualServiceCost = (BigDecimal) value.get(Fields.actualServiceCost
				.name());
		actualOtherCost = (BigDecimal) value.get(Fields.actualOtherCost.name());
		actualCost = (BigDecimal) value.get(Fields.actualCost.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		actualArrivalDate = (Timestamp) value.get(Fields.actualArrivalDate
				.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		estimatedArrivalDate = (Timestamp) value
				.get(Fields.estimatedArrivalDate.name());
		trackingIdNumber = (String) value.get(Fields.trackingIdNumber.name());
		trackingDigest = (String) value.get(Fields.trackingDigest.name());
		updatedByUserLoginId = (String) value.get(Fields.updatedByUserLoginId
				.name());
		lastUpdatedDate = (Timestamp) value.get(Fields.lastUpdatedDate.name());
		homeDeliveryType = (String) value.get(Fields.homeDeliveryType.name());
		homeDeliveryDate = (Timestamp) value
				.get(Fields.homeDeliveryDate.name());
		thirdPartyAccountNumber = (String) value
				.get(Fields.thirdPartyAccountNumber.name());
		thirdPartyPostalCode = (String) value.get(Fields.thirdPartyPostalCode
				.name());
		thirdPartyCountryGeoCode = (String) value
				.get(Fields.thirdPartyCountryGeoCode.name());
		upsHighValueReport = (byte[]) value.get(Fields.upsHighValueReport
				.name());
	}

	public static ShipmentRouteSegment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentRouteSegment(value);
	}

	public static List<ShipmentRouteSegment> fromValues(
			List<GenericValue> values) {
		List<ShipmentRouteSegment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentRouteSegment(value));
		}
		return entities;
	}
}