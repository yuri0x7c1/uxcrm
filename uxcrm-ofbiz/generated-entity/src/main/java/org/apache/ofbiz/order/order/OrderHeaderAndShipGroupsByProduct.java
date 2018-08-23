package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header And Ship Groups By Product
 */
@FieldNameConstants
public class OrderHeaderAndShipGroupsByProduct implements Serializable {

	public static final long serialVersionUID = 7790252990363582464L;
	public static final String NAME = "OrderHeaderAndShipGroupsByProduct";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Brand Name
	 */
	@Getter
	@Setter
	private String brandName;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
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

	public OrderHeaderAndShipGroupsByProduct(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		brandName = (String) value.get(FIELD_BRAND_NAME);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		giftMessage = (String) value.get(FIELD_GIFT_MESSAGE);
		orderId = (String) value.get(FIELD_ORDER_ID);
		shippingInstructions = (String) value.get(FIELD_SHIPPING_INSTRUCTIONS);
		maySplit = (String) value.get(FIELD_MAY_SPLIT);
		shipByDate = (Timestamp) value.get(FIELD_SHIP_BY_DATE);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		estimatedDeliveryDate = (Timestamp) value
				.get(FIELD_ESTIMATED_DELIVERY_DATE);
		vendorPartyId = (String) value.get(FIELD_VENDOR_PARTY_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		telecomContactMechId = (String) value
				.get(FIELD_TELECOM_CONTACT_MECH_ID);
		shipAfterDate = (Timestamp) value.get(FIELD_SHIP_AFTER_DATE);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierRoleTypeId = (String) value.get(FIELD_CARRIER_ROLE_TYPE_ID);
		isGift = (String) value.get(FIELD_IS_GIFT);
		estimatedShipDate = (Timestamp) value.get(FIELD_ESTIMATED_SHIP_DATE);
		supplierPartyId = (String) value.get(FIELD_SUPPLIER_PARTY_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		trackingNumber = (String) value.get(FIELD_TRACKING_NUMBER);
		countryGeoId = (String) value.get(FIELD_COUNTRY_GEO_ID);
		houseNumberExt = (String) value.get(FIELD_HOUSE_NUMBER_EXT);
		address2 = (String) value.get(FIELD_ADDRESS2);
		city = (String) value.get(FIELD_CITY);
		address1 = (String) value.get(FIELD_ADDRESS1);
		postalCode = (String) value.get(FIELD_POSTAL_CODE);
		postalCodeGeoId = (String) value.get(FIELD_POSTAL_CODE_GEO_ID);
		houseNumber = (Long) value.get(FIELD_HOUSE_NUMBER);
		postalCodeExt = (String) value.get(FIELD_POSTAL_CODE_EXT);
		attnName = (String) value.get(FIELD_ATTN_NAME);
		directions = (String) value.get(FIELD_DIRECTIONS);
		countyGeoId = (String) value.get(FIELD_COUNTY_GEO_ID);
		toName = (String) value.get(FIELD_TO_NAME);
		cityGeoId = (String) value.get(FIELD_CITY_GEO_ID);
		municipalityGeoId = (String) value.get(FIELD_MUNICIPALITY_GEO_ID);
		stateProvinceGeoId = (String) value.get(FIELD_STATE_PROVINCE_GEO_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		invoicePerShipment = (String) value.get(FIELD_INVOICE_PER_SHIPMENT);
		salesChannelEnumId = (String) value.get(FIELD_SALES_CHANNEL_ENUM_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		terminalId = (String) value.get(FIELD_TERMINAL_ID);
		isViewed = (String) value.get(FIELD_IS_VIEWED);
		visitId = (String) value.get(FIELD_VISIT_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		remainingSubTotal = (BigDecimal) value.get(FIELD_REMAINING_SUB_TOTAL);
		orderName = (String) value.get(FIELD_ORDER_NAME);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		isRushOrder = (String) value.get(FIELD_IS_RUSH_ORDER);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		grandTotal = (BigDecimal) value.get(FIELD_GRAND_TOTAL);
		autoOrderShoppingListId = (String) value
				.get(FIELD_AUTO_ORDER_SHOPPING_LIST_ID);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		priority = (String) value.get(FIELD_PRIORITY);
		transactionId = (String) value.get(FIELD_TRANSACTION_ID);
		firstAttemptOrderId = (String) value.get(FIELD_FIRST_ATTEMPT_ORDER_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		createdBy = (String) value.get(FIELD_CREATED_BY);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		syncStatusId = (String) value.get(FIELD_SYNC_STATUS_ID);
		pickSheetPrintedDate = (Timestamp) value
				.get(FIELD_PICK_SHEET_PRINTED_DATE);
		needsInventoryIssuance = (String) value
				.get(FIELD_NEEDS_INVENTORY_ISSUANCE);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		internalCode = (String) value.get(FIELD_INTERNAL_CODE);
	}

	public static OrderHeaderAndShipGroupsByProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderAndShipGroupsByProduct(value);
	}

	public static List<OrderHeaderAndShipGroupsByProduct> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderAndShipGroupsByProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderAndShipGroupsByProduct(value));
		}
		return entities;
	}
}