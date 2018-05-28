package org.apache.ofbiz.shipment.shipment;

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
public class ShipmentManifestView implements Serializable {

	public static final long serialVersionUID = 4815624430062092288L;
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

	public enum Fields {
		shipmentId, shipmentItemSeqId, productId, quantity, shipmentContentDescription, internalName, itemIssuanceId, orderId, orderItemSeqId, inventoryItemId, issuedDateTime, issuedByUserLoginId, issuedQuantity, packageQuantity, shipmentPackageSeqId, packageDateCreated, weight, weightUomAbbreviation, weightUomDescription, trackingCode, boxNumber, shipmentRouteSegmentId, deliveryId, originFacilityId, destFacilityId, originContactMechId, originTelecomNumberId, destContactMechId, destTelecomNumberId, carrierPartyId, shipmentMethodTypeId, actualCost, actualStartDate, actualArrivalDate, estimatedStartDate, estimatedArrivalDate, originFacilityName, destFacilityName, originToName, originAttnName, originAddress1, originAddress2, originDirections, originCity, originPostalCode, originCountryGeoId, originStateProvinceGeoId, originPostalCodeGeoId, originCountryCode, originAreaCode, originContactNumber, destToName, destAttnName, destAddress1, destAddress2, destDirections, destCity, destPostalCode, destCountryGeoId, destStateProvinceGeoId, destPostalCodeGeoId, destCountryCode, destAreaCode, destContactNumber, carrierFirstName, carrierLastName, carrierGroupName, shipmentMethodDescription
	}

	public ShipmentManifestView(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		shipmentContentDescription = (String) value
				.get(Fields.shipmentContentDescription.name());
		internalName = (String) value.get(Fields.internalName.name());
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		issuedDateTime = (Timestamp) value.get(Fields.issuedDateTime.name());
		issuedByUserLoginId = (String) value.get(Fields.issuedByUserLoginId
				.name());
		issuedQuantity = (BigDecimal) value.get(Fields.issuedQuantity.name());
		packageQuantity = (BigDecimal) value.get(Fields.packageQuantity.name());
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		packageDateCreated = (Timestamp) value.get(Fields.packageDateCreated
				.name());
		weight = (BigDecimal) value.get(Fields.weight.name());
		weightUomAbbreviation = (String) value.get(Fields.weightUomAbbreviation
				.name());
		weightUomDescription = (String) value.get(Fields.weightUomDescription
				.name());
		trackingCode = (String) value.get(Fields.trackingCode.name());
		boxNumber = (String) value.get(Fields.boxNumber.name());
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
		actualCost = (BigDecimal) value.get(Fields.actualCost.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		actualArrivalDate = (Timestamp) value.get(Fields.actualArrivalDate
				.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		estimatedArrivalDate = (Timestamp) value
				.get(Fields.estimatedArrivalDate.name());
		originFacilityName = (String) value.get(Fields.originFacilityName
				.name());
		destFacilityName = (String) value.get(Fields.destFacilityName.name());
		originToName = (String) value.get(Fields.originToName.name());
		originAttnName = (String) value.get(Fields.originAttnName.name());
		originAddress1 = (String) value.get(Fields.originAddress1.name());
		originAddress2 = (String) value.get(Fields.originAddress2.name());
		originDirections = (String) value.get(Fields.originDirections.name());
		originCity = (String) value.get(Fields.originCity.name());
		originPostalCode = (String) value.get(Fields.originPostalCode.name());
		originCountryGeoId = (String) value.get(Fields.originCountryGeoId
				.name());
		originStateProvinceGeoId = (String) value
				.get(Fields.originStateProvinceGeoId.name());
		originPostalCodeGeoId = (String) value.get(Fields.originPostalCodeGeoId
				.name());
		originCountryCode = (String) value.get(Fields.originCountryCode.name());
		originAreaCode = (String) value.get(Fields.originAreaCode.name());
		originContactNumber = (String) value.get(Fields.originContactNumber
				.name());
		destToName = (String) value.get(Fields.destToName.name());
		destAttnName = (String) value.get(Fields.destAttnName.name());
		destAddress1 = (String) value.get(Fields.destAddress1.name());
		destAddress2 = (String) value.get(Fields.destAddress2.name());
		destDirections = (String) value.get(Fields.destDirections.name());
		destCity = (String) value.get(Fields.destCity.name());
		destPostalCode = (String) value.get(Fields.destPostalCode.name());
		destCountryGeoId = (String) value.get(Fields.destCountryGeoId.name());
		destStateProvinceGeoId = (String) value
				.get(Fields.destStateProvinceGeoId.name());
		destPostalCodeGeoId = (String) value.get(Fields.destPostalCodeGeoId
				.name());
		destCountryCode = (String) value.get(Fields.destCountryCode.name());
		destAreaCode = (String) value.get(Fields.destAreaCode.name());
		destContactNumber = (String) value.get(Fields.destContactNumber.name());
		carrierFirstName = (String) value.get(Fields.carrierFirstName.name());
		carrierLastName = (String) value.get(Fields.carrierLastName.name());
		carrierGroupName = (String) value.get(Fields.carrierGroupName.name());
		shipmentMethodDescription = (String) value
				.get(Fields.shipmentMethodDescription.name());
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