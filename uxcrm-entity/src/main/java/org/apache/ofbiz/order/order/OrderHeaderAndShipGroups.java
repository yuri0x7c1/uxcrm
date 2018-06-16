package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header And Ship Groups
 */
public class OrderHeaderAndShipGroups implements Serializable {

	public static final long serialVersionUID = 6147209538450972672L;
	public static final String NAME = "OrderHeaderAndShipGroups";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Gift Message
	 */
	@Getter
	@Setter
	private String giftMessage;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Shipping Instructions
	 */
	@Getter
	@Setter
	private String shippingInstructions;
	/**
	 * May Split
	 */
	@Getter
	@Setter
	private String maySplit;
	/**
	 * Ship By Date
	 */
	@Getter
	@Setter
	private Timestamp shipByDate;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Supplier Agreement Id
	 */
	@Getter
	@Setter
	private String supplierAgreementId;
	/**
	 * Estimated Delivery Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedDeliveryDate;
	/**
	 * Vendor Party Id
	 */
	@Getter
	@Setter
	private String vendorPartyId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Telecom Contact Mech Id
	 */
	@Getter
	@Setter
	private String telecomContactMechId;
	/**
	 * Ship After Date
	 */
	@Getter
	@Setter
	private Timestamp shipAfterDate;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Carrier Role Type Id
	 */
	@Getter
	@Setter
	private String carrierRoleTypeId;
	/**
	 * Is Gift
	 */
	@Getter
	@Setter
	private String isGift;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Supplier Party Id
	 */
	@Getter
	@Setter
	private String supplierPartyId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Tracking Number
	 */
	@Getter
	@Setter
	private String trackingNumber;
	/**
	 * Country Geo Id
	 */
	@Getter
	@Setter
	private String countryGeoId;
	/**
	 * House Number Ext
	 */
	@Getter
	@Setter
	private String houseNumberExt;
	/**
	 * Address 2
	 */
	@Getter
	@Setter
	private String address2;
	/**
	 * City
	 */
	@Getter
	@Setter
	private String city;
	/**
	 * Address 1
	 */
	@Getter
	@Setter
	private String address1;
	/**
	 * Postal Code
	 */
	@Getter
	@Setter
	private String postalCode;
	/**
	 * Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String postalCodeGeoId;
	/**
	 * House Number
	 */
	@Getter
	@Setter
	private Long houseNumber;
	/**
	 * Postal Code Ext
	 */
	@Getter
	@Setter
	private String postalCodeExt;
	/**
	 * Attn Name
	 */
	@Getter
	@Setter
	private String attnName;
	/**
	 * Directions
	 */
	@Getter
	@Setter
	private String directions;
	/**
	 * County Geo Id
	 */
	@Getter
	@Setter
	private String countyGeoId;
	/**
	 * To Name
	 */
	@Getter
	@Setter
	private String toName;
	/**
	 * City Geo Id
	 */
	@Getter
	@Setter
	private String cityGeoId;
	/**
	 * Municipality Geo Id
	 */
	@Getter
	@Setter
	private String municipalityGeoId;
	/**
	 * State Province Geo Id
	 */
	@Getter
	@Setter
	private String stateProvinceGeoId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Invoice Per Shipment
	 */
	@Getter
	@Setter
	private String invoicePerShipment;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Terminal Id
	 */
	@Getter
	@Setter
	private String terminalId;
	/**
	 * Is Viewed
	 */
	@Getter
	@Setter
	private String isViewed;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Remaining Sub Total
	 */
	@Getter
	@Setter
	private BigDecimal remainingSubTotal;
	/**
	 * Order Name
	 */
	@Getter
	@Setter
	private String orderName;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Is Rush Order
	 */
	@Getter
	@Setter
	private String isRushOrder;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Auto Order Shopping List Id
	 */
	@Getter
	@Setter
	private String autoOrderShoppingListId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private String priority;
	/**
	 * Transaction Id
	 */
	@Getter
	@Setter
	private String transactionId;
	/**
	 * First Attempt Order Id
	 */
	@Getter
	@Setter
	private String firstAttemptOrderId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Created By
	 */
	@Getter
	@Setter
	private String createdBy;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
	/**
	 * Sync Status Id
	 */
	@Getter
	@Setter
	private String syncStatusId;
	/**
	 * Pick Sheet Printed Date
	 */
	@Getter
	@Setter
	private Timestamp pickSheetPrintedDate;
	/**
	 * Needs Inventory Issuance
	 */
	@Getter
	@Setter
	private String needsInventoryIssuance;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Internal Code
	 */
	@Getter
	@Setter
	private String internalCode;

	public enum Fields {
		facilityId, giftMessage, orderId, shippingInstructions, maySplit, shipByDate, shipGroupSeqId, supplierAgreementId, estimatedDeliveryDate, vendorPartyId, contactMechId, telecomContactMechId, shipAfterDate, carrierPartyId, carrierRoleTypeId, isGift, estimatedShipDate, supplierPartyId, shipmentMethodTypeId, trackingNumber, countryGeoId, houseNumberExt, address2, city, address1, postalCode, postalCodeGeoId, houseNumber, postalCodeExt, attnName, directions, countyGeoId, toName, cityGeoId, municipalityGeoId, stateProvinceGeoId, geoPointId, roleTypeId, partyId, invoicePerShipment, salesChannelEnumId, orderTypeId, billingAccountId, terminalId, isViewed, visitId, agreementId, productStoreId, remainingSubTotal, orderName, webSiteId, isRushOrder, entryDate, grandTotal, autoOrderShoppingListId, externalId, priority, transactionId, firstAttemptOrderId, originFacilityId, statusId, createdBy, currencyUom, syncStatusId, pickSheetPrintedDate, needsInventoryIssuance, orderDate, internalCode
	}

	public OrderHeaderAndShipGroups(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		giftMessage = (String) value.get(Fields.giftMessage.name());
		orderId = (String) value.get(Fields.orderId.name());
		shippingInstructions = (String) value.get(Fields.shippingInstructions
				.name());
		maySplit = (String) value.get(Fields.maySplit.name());
		shipByDate = (Timestamp) value.get(Fields.shipByDate.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		supplierAgreementId = (String) value.get(Fields.supplierAgreementId
				.name());
		estimatedDeliveryDate = (Timestamp) value
				.get(Fields.estimatedDeliveryDate.name());
		vendorPartyId = (String) value.get(Fields.vendorPartyId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		telecomContactMechId = (String) value.get(Fields.telecomContactMechId
				.name());
		shipAfterDate = (Timestamp) value.get(Fields.shipAfterDate.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierRoleTypeId = (String) value.get(Fields.carrierRoleTypeId.name());
		isGift = (String) value.get(Fields.isGift.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		supplierPartyId = (String) value.get(Fields.supplierPartyId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		trackingNumber = (String) value.get(Fields.trackingNumber.name());
		countryGeoId = (String) value.get(Fields.countryGeoId.name());
		houseNumberExt = (String) value.get(Fields.houseNumberExt.name());
		address2 = (String) value.get(Fields.address2.name());
		city = (String) value.get(Fields.city.name());
		address1 = (String) value.get(Fields.address1.name());
		postalCode = (String) value.get(Fields.postalCode.name());
		postalCodeGeoId = (String) value.get(Fields.postalCodeGeoId.name());
		houseNumber = (Long) value.get(Fields.houseNumber.name());
		postalCodeExt = (String) value.get(Fields.postalCodeExt.name());
		attnName = (String) value.get(Fields.attnName.name());
		directions = (String) value.get(Fields.directions.name());
		countyGeoId = (String) value.get(Fields.countyGeoId.name());
		toName = (String) value.get(Fields.toName.name());
		cityGeoId = (String) value.get(Fields.cityGeoId.name());
		municipalityGeoId = (String) value.get(Fields.municipalityGeoId.name());
		stateProvinceGeoId = (String) value.get(Fields.stateProvinceGeoId
				.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		invoicePerShipment = (String) value.get(Fields.invoicePerShipment
				.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		terminalId = (String) value.get(Fields.terminalId.name());
		isViewed = (String) value.get(Fields.isViewed.name());
		visitId = (String) value.get(Fields.visitId.name());
		agreementId = (String) value.get(Fields.agreementId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		remainingSubTotal = (BigDecimal) value.get(Fields.remainingSubTotal
				.name());
		orderName = (String) value.get(Fields.orderName.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		isRushOrder = (String) value.get(Fields.isRushOrder.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		autoOrderShoppingListId = (String) value
				.get(Fields.autoOrderShoppingListId.name());
		externalId = (String) value.get(Fields.externalId.name());
		priority = (String) value.get(Fields.priority.name());
		transactionId = (String) value.get(Fields.transactionId.name());
		firstAttemptOrderId = (String) value.get(Fields.firstAttemptOrderId
				.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdBy = (String) value.get(Fields.createdBy.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		syncStatusId = (String) value.get(Fields.syncStatusId.name());
		pickSheetPrintedDate = (Timestamp) value
				.get(Fields.pickSheetPrintedDate.name());
		needsInventoryIssuance = (String) value
				.get(Fields.needsInventoryIssuance.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		internalCode = (String) value.get(Fields.internalCode.name());
	}

	public static OrderHeaderAndShipGroups fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderAndShipGroups(value);
	}

	public static List<OrderHeaderAndShipGroups> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderAndShipGroups> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderAndShipGroups(value));
		}
		return entities;
	}
}