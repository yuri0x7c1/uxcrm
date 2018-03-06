package org.apache.ofbiz.shipment.shipment.entity.view;

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

	public static final long serialVersionUID = 168382781425412096L;
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
	 * Shipment Package Seq Id
	 */
	@Getter
	@Setter
	private String shipmentPackageSeqId;
	/**
	 * Date Created
	 */
	@Getter
	@Setter
	private Timestamp dateCreated;
	/**
	 * Weight
	 */
	@Getter
	@Setter
	private BigDecimal weight;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
	 * Facility Name
	 */
	@Getter
	@Setter
	private String facilityName;
	/**
	 * To Name
	 */
	@Getter
	@Setter
	private String toName;
	/**
	 * Attn Name
	 */
	@Getter
	@Setter
	private String attnName;
	/**
	 * Address 1
	 */
	@Getter
	@Setter
	private String address1;
	/**
	 * Address 2
	 */
	@Getter
	@Setter
	private String address2;
	/**
	 * Directions
	 */
	@Getter
	@Setter
	private String directions;
	/**
	 * City
	 */
	@Getter
	@Setter
	private String city;
	/**
	 * Postal Code
	 */
	@Getter
	@Setter
	private String postalCode;
	/**
	 * Country Geo Id
	 */
	@Getter
	@Setter
	private String countryGeoId;
	/**
	 * State Province Geo Id
	 */
	@Getter
	@Setter
	private String stateProvinceGeoId;
	/**
	 * Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String postalCodeGeoId;
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Area Code
	 */
	@Getter
	@Setter
	private String areaCode;
	/**
	 * Contact Number
	 */
	@Getter
	@Setter
	private String contactNumber;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;

	public enum Fields {
		shipmentId, shipmentItemSeqId, productId, quantity, shipmentContentDescription, internalName, itemIssuanceId, orderId, orderItemSeqId, inventoryItemId, issuedDateTime, issuedByUserLoginId, shipmentPackageSeqId, dateCreated, weight, abbreviation, description, trackingCode, boxNumber, shipmentRouteSegmentId, deliveryId, originFacilityId, destFacilityId, originContactMechId, originTelecomNumberId, destContactMechId, destTelecomNumberId, carrierPartyId, shipmentMethodTypeId, actualCost, actualStartDate, actualArrivalDate, estimatedStartDate, estimatedArrivalDate, facilityName, toName, attnName, address1, address2, directions, city, postalCode, countryGeoId, stateProvinceGeoId, postalCodeGeoId, countryCode, areaCode, contactNumber, firstName, lastName, groupName
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
		shipmentPackageSeqId = (String) value.get(Fields.shipmentPackageSeqId
				.name());
		dateCreated = (Timestamp) value.get(Fields.dateCreated.name());
		weight = (BigDecimal) value.get(Fields.weight.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		description = (String) value.get(Fields.description.name());
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
		facilityName = (String) value.get(Fields.facilityName.name());
		toName = (String) value.get(Fields.toName.name());
		attnName = (String) value.get(Fields.attnName.name());
		address1 = (String) value.get(Fields.address1.name());
		address2 = (String) value.get(Fields.address2.name());
		directions = (String) value.get(Fields.directions.name());
		city = (String) value.get(Fields.city.name());
		postalCode = (String) value.get(Fields.postalCode.name());
		countryGeoId = (String) value.get(Fields.countryGeoId.name());
		stateProvinceGeoId = (String) value.get(Fields.stateProvinceGeoId
				.name());
		postalCodeGeoId = (String) value.get(Fields.postalCodeGeoId.name());
		countryCode = (String) value.get(Fields.countryCode.name());
		areaCode = (String) value.get(Fields.areaCode.name());
		contactNumber = (String) value.get(Fields.contactNumber.name());
		firstName = (String) value.get(Fields.firstName.name());
		lastName = (String) value.get(Fields.lastName.name());
		groupName = (String) value.get(Fields.groupName.name());
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