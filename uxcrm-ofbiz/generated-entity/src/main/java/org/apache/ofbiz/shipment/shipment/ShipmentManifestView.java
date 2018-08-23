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
 * Shipment Manifest View
 */
@FieldNameConstants
public class ShipmentManifestView implements Serializable {

	public static final long serialVersionUID = 4253145805850935296L;
	public static final String NAME = "ShipmentManifestView";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Shipment Content Description
	 */
	@Getter
	@Setter
	private String shipmentContentDescription;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
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
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Issued Date Time
	 */
	@Getter
	@Setter
	private Timestamp issuedDateTime;
	/**
	 * Issued By User Login Id
	 */
	@Getter
	@Setter
	private String issuedByUserLoginId;
	/**
	 * Issued Quantity
	 */
	@Getter
	@Setter
	private BigDecimal issuedQuantity;
	/**
	 * Package Quantity
	 */
	@Getter
	@Setter
	private BigDecimal packageQuantity;
	/**
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Package Date Created
	 */
	@Getter
	@Setter
	private Timestamp packageDateCreated;
	/**
	 * Weight
	 */
	@Getter
	@Setter
	private BigDecimal weight;
	/**
	 * Weight Uom Abbreviation
	 */
	@Getter
	@Setter
	private String weightUomAbbreviation;
	/**
	 * Weight Uom Description
	 */
	@Getter
	@Setter
	private String weightUomDescription;
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
	 * Actual Cost
	 */
	@Getter
	@Setter
	private BigDecimal actualCost;
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
	 * Origin Facility Name
	 */
	@Getter
	@Setter
	private String originFacilityName;
	/**
	 * Dest Facility Name
	 */
	@Getter
	@Setter
	private String destFacilityName;
	/**
	 * Origin To Name
	 */
	@Getter
	@Setter
	private String originToName;
	/**
	 * Origin Attn Name
	 */
	@Getter
	@Setter
	private String originAttnName;
	/**
	 * Origin Address 1
	 */
	@Getter
	@Setter
	private String originAddress1;
	/**
	 * Origin Address 2
	 */
	@Getter
	@Setter
	private String originAddress2;
	/**
	 * Origin Directions
	 */
	@Getter
	@Setter
	private String originDirections;
	/**
	 * Origin City
	 */
	@Getter
	@Setter
	private String originCity;
	/**
	 * Origin Postal Code
	 */
	@Getter
	@Setter
	private String originPostalCode;
	/**
	 * Origin Country Geo Id
	 */
	@Getter
	@Setter
	private String originCountryGeoId;
	/**
	 * Origin State Province Geo Id
	 */
	@Getter
	@Setter
	private String originStateProvinceGeoId;
	/**
	 * Origin Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String originPostalCodeGeoId;
	/**
	 * Origin Country Code
	 */
	@Getter
	@Setter
	private String originCountryCode;
	/**
	 * Origin Area Code
	 */
	@Getter
	@Setter
	private String originAreaCode;
	/**
	 * Origin Contact Number
	 */
	@Getter
	@Setter
	private String originContactNumber;
	/**
	 * Dest To Name
	 */
	@Getter
	@Setter
	private String destToName;
	/**
	 * Dest Attn Name
	 */
	@Getter
	@Setter
	private String destAttnName;
	/**
	 * Dest Address 1
	 */
	@Getter
	@Setter
	private String destAddress1;
	/**
	 * Dest Address 2
	 */
	@Getter
	@Setter
	private String destAddress2;
	/**
	 * Dest Directions
	 */
	@Getter
	@Setter
	private String destDirections;
	/**
	 * Dest City
	 */
	@Getter
	@Setter
	private String destCity;
	/**
	 * Dest Postal Code
	 */
	@Getter
	@Setter
	private String destPostalCode;
	/**
	 * Dest Country Geo Id
	 */
	@Getter
	@Setter
	private String destCountryGeoId;
	/**
	 * Dest State Province Geo Id
	 */
	@Getter
	@Setter
	private String destStateProvinceGeoId;
	/**
	 * Dest Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String destPostalCodeGeoId;
	/**
	 * Dest Country Code
	 */
	@Getter
	@Setter
	private String destCountryCode;
	/**
	 * Dest Area Code
	 */
	@Getter
	@Setter
	private String destAreaCode;
	/**
	 * Dest Contact Number
	 */
	@Getter
	@Setter
	private String destContactNumber;
	/**
	 * Carrier First Name
	 */
	@Getter
	@Setter
	private String carrierFirstName;
	/**
	 * Carrier Last Name
	 */
	@Getter
	@Setter
	private String carrierLastName;
	/**
	 * Carrier Group Name
	 */
	@Getter
	@Setter
	private String carrierGroupName;
	/**
	 * Shipment Method Description
	 */
	@Getter
	@Setter
	private String shipmentMethodDescription;

	public ShipmentManifestView(GenericValue value) {
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		shipmentContentDescription = (String) value
				.get(FIELD_SHIPMENT_CONTENT_DESCRIPTION);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		issuedDateTime = (Timestamp) value.get(FIELD_ISSUED_DATE_TIME);
		issuedByUserLoginId = (String) value.get(FIELD_ISSUED_BY_USER_LOGIN_ID);
		issuedQuantity = (BigDecimal) value.get(FIELD_ISSUED_QUANTITY);
		packageQuantity = (BigDecimal) value.get(FIELD_PACKAGE_QUANTITY);
		shipmentPackageSeqId = (String) value
				.get(FIELD_SHIPMENT_PACKAGE_SEQ_ID);
		packageDateCreated = (Timestamp) value.get(FIELD_PACKAGE_DATE_CREATED);
		weight = (BigDecimal) value.get(FIELD_WEIGHT);
		weightUomAbbreviation = (String) value
				.get(FIELD_WEIGHT_UOM_ABBREVIATION);
		weightUomDescription = (String) value.get(FIELD_WEIGHT_UOM_DESCRIPTION);
		trackingCode = (String) value.get(FIELD_TRACKING_CODE);
		boxNumber = (String) value.get(FIELD_BOX_NUMBER);
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
		actualCost = (BigDecimal) value.get(FIELD_ACTUAL_COST);
		actualStartDate = (Timestamp) value.get(FIELD_ACTUAL_START_DATE);
		actualArrivalDate = (Timestamp) value.get(FIELD_ACTUAL_ARRIVAL_DATE);
		estimatedStartDate = (Timestamp) value.get(FIELD_ESTIMATED_START_DATE);
		estimatedArrivalDate = (Timestamp) value
				.get(FIELD_ESTIMATED_ARRIVAL_DATE);
		originFacilityName = (String) value.get(FIELD_ORIGIN_FACILITY_NAME);
		destFacilityName = (String) value.get(FIELD_DEST_FACILITY_NAME);
		originToName = (String) value.get(FIELD_ORIGIN_TO_NAME);
		originAttnName = (String) value.get(FIELD_ORIGIN_ATTN_NAME);
		originAddress1 = (String) value.get(FIELD_ORIGIN_ADDRESS1);
		originAddress2 = (String) value.get(FIELD_ORIGIN_ADDRESS2);
		originDirections = (String) value.get(FIELD_ORIGIN_DIRECTIONS);
		originCity = (String) value.get(FIELD_ORIGIN_CITY);
		originPostalCode = (String) value.get(FIELD_ORIGIN_POSTAL_CODE);
		originCountryGeoId = (String) value.get(FIELD_ORIGIN_COUNTRY_GEO_ID);
		originStateProvinceGeoId = (String) value
				.get(FIELD_ORIGIN_STATE_PROVINCE_GEO_ID);
		originPostalCodeGeoId = (String) value
				.get(FIELD_ORIGIN_POSTAL_CODE_GEO_ID);
		originCountryCode = (String) value.get(FIELD_ORIGIN_COUNTRY_CODE);
		originAreaCode = (String) value.get(FIELD_ORIGIN_AREA_CODE);
		originContactNumber = (String) value.get(FIELD_ORIGIN_CONTACT_NUMBER);
		destToName = (String) value.get(FIELD_DEST_TO_NAME);
		destAttnName = (String) value.get(FIELD_DEST_ATTN_NAME);
		destAddress1 = (String) value.get(FIELD_DEST_ADDRESS1);
		destAddress2 = (String) value.get(FIELD_DEST_ADDRESS2);
		destDirections = (String) value.get(FIELD_DEST_DIRECTIONS);
		destCity = (String) value.get(FIELD_DEST_CITY);
		destPostalCode = (String) value.get(FIELD_DEST_POSTAL_CODE);
		destCountryGeoId = (String) value.get(FIELD_DEST_COUNTRY_GEO_ID);
		destStateProvinceGeoId = (String) value
				.get(FIELD_DEST_STATE_PROVINCE_GEO_ID);
		destPostalCodeGeoId = (String) value.get(FIELD_DEST_POSTAL_CODE_GEO_ID);
		destCountryCode = (String) value.get(FIELD_DEST_COUNTRY_CODE);
		destAreaCode = (String) value.get(FIELD_DEST_AREA_CODE);
		destContactNumber = (String) value.get(FIELD_DEST_CONTACT_NUMBER);
		carrierFirstName = (String) value.get(FIELD_CARRIER_FIRST_NAME);
		carrierLastName = (String) value.get(FIELD_CARRIER_LAST_NAME);
		carrierGroupName = (String) value.get(FIELD_CARRIER_GROUP_NAME);
		shipmentMethodDescription = (String) value
				.get(FIELD_SHIPMENT_METHOD_DESCRIPTION);
	}

	public static ShipmentManifestView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentManifestView(value);
	}

	public static List<ShipmentManifestView> fromValues(
			List<GenericValue> values) {
		List<ShipmentManifestView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentManifestView(value));
		}
		return entities;
	}
}