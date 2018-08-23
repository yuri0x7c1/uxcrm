package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ShipmentRouteSegment implements Serializable {

	public static final long serialVersionUID = 5223845365799627776L;
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

	public ShipmentRouteSegment(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentRouteSegmentId = (String) value
				.get(FIELD_SHIPMENT_ROUTE_SEGMENT_ID);
		deliveryId = (String) value.get(FIELD_DELIVERY_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		destFacilityId = (String) value.get(FIELD_DEST_FACILITY_ID);
		originContactMechId = (String) value.get(FIELD_ORIGIN_CONTACT_MECH_ID);
		originTelecomNumberId = (String) value
				.get(FIELD_ORIGIN_TELECOM_NUMBER_ID);
		destContactMechId = (String) value.get(FIELD_DEST_CONTACT_MECH_ID);
		destTelecomNumberId = (String) value.get(FIELD_DEST_TELECOM_NUMBER_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		carrierServiceStatusId = (String) value
				.get(FIELD_CARRIER_SERVICE_STATUS_ID);
		carrierDeliveryZone = (String) value.get(FIELD_CARRIER_DELIVERY_ZONE);
		carrierRestrictionCodes = (String) value
				.get(FIELD_CARRIER_RESTRICTION_CODES);
		carrierRestrictionDesc = (String) value
				.get(FIELD_CARRIER_RESTRICTION_DESC);
		billingWeight = (BigDecimal) value.get(FIELD_BILLING_WEIGHT);
		billingWeightUomId = (String) value.get(FIELD_BILLING_WEIGHT_UOM_ID);
		actualTransportCost = (BigDecimal) value
				.get(FIELD_ACTUAL_TRANSPORT_COST);
		actualServiceCost = (BigDecimal) value.get(FIELD_ACTUAL_SERVICE_COST);
		actualOtherCost = (BigDecimal) value.get(FIELD_ACTUAL_OTHER_COST);
		actualCost = (BigDecimal) value.get(FIELD_ACTUAL_COST);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		actualStartDate = (Timestamp) value.get(FIELD_ACTUAL_START_DATE);
		actualArrivalDate = (Timestamp) value.get(FIELD_ACTUAL_ARRIVAL_DATE);
		estimatedStartDate = (Timestamp) value.get(FIELD_ESTIMATED_START_DATE);
		estimatedArrivalDate = (Timestamp) value
				.get(FIELD_ESTIMATED_ARRIVAL_DATE);
		trackingIdNumber = (String) value.get(FIELD_TRACKING_ID_NUMBER);
		trackingDigest = (String) value.get(FIELD_TRACKING_DIGEST);
		updatedByUserLoginId = (String) value
				.get(FIELD_UPDATED_BY_USER_LOGIN_ID);
		lastUpdatedDate = (Timestamp) value.get(FIELD_LAST_UPDATED_DATE);
		homeDeliveryType = (String) value.get(FIELD_HOME_DELIVERY_TYPE);
		homeDeliveryDate = (Timestamp) value.get(FIELD_HOME_DELIVERY_DATE);
		thirdPartyAccountNumber = (String) value
				.get(FIELD_THIRD_PARTY_ACCOUNT_NUMBER);
		thirdPartyPostalCode = (String) value
				.get(FIELD_THIRD_PARTY_POSTAL_CODE);
		thirdPartyCountryGeoCode = (String) value
				.get(FIELD_THIRD_PARTY_COUNTRY_GEO_CODE);
		upsHighValueReport = (byte[]) value.get(FIELD_UPS_HIGH_VALUE_REPORT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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