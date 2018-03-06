package org.apache.ofbiz.product.facility.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Facility And Postal Address
 */
public class ProductFacilityAndPostalAddress implements Serializable {

	public static final long serialVersionUID = 2820324696849600512L;
	public static final String NAME = "ProductFacilityAndPostalAddress";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Minimum Stock
	 */
	@Getter
	@Setter
	private BigDecimal minimumStock;
	/**
	 * Reorder Quantity
	 */
	@Getter
	@Setter
	private BigDecimal reorderQuantity;
	/**
	 * Days To Ship
	 */
	@Getter
	@Setter
	private Long daysToShip;
	/**
	 * Last Inventory Count
	 */
	@Getter
	@Setter
	private BigDecimal lastInventoryCount;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
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
	 * House Number
	 */
	@Getter
	@Setter
	private Long houseNumber;
	/**
	 * House Number Ext
	 */
	@Getter
	@Setter
	private String houseNumberExt;
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
	 * City Geo Id
	 */
	@Getter
	@Setter
	private String cityGeoId;
	/**
	 * Postal Code
	 */
	@Getter
	@Setter
	private String postalCode;
	/**
	 * Postal Code Ext
	 */
	@Getter
	@Setter
	private String postalCodeExt;
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
	 * County Geo Id
	 */
	@Getter
	@Setter
	private String countyGeoId;
	/**
	 * Municipality Geo Id
	 */
	@Getter
	@Setter
	private String municipalityGeoId;
	/**
	 * Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String postalCodeGeoId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;

	public enum Fields {
		productId, facilityId, minimumStock, reorderQuantity, daysToShip, lastInventoryCount, contactMechId, fromDate, thruDate, extension, comments, contactMechTypeId, infoString, toName, attnName, address1, address2, houseNumber, houseNumberExt, directions, city, cityGeoId, postalCode, postalCodeExt, countryGeoId, stateProvinceGeoId, countyGeoId, municipalityGeoId, postalCodeGeoId, geoPointId
	}

	public ProductFacilityAndPostalAddress(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		reorderQuantity = (BigDecimal) value.get(Fields.reorderQuantity.name());
		daysToShip = (Long) value.get(Fields.daysToShip.name());
		lastInventoryCount = (BigDecimal) value.get(Fields.lastInventoryCount
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		extension = (String) value.get(Fields.extension.name());
		comments = (String) value.get(Fields.comments.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
		toName = (String) value.get(Fields.toName.name());
		attnName = (String) value.get(Fields.attnName.name());
		address1 = (String) value.get(Fields.address1.name());
		address2 = (String) value.get(Fields.address2.name());
		houseNumber = (Long) value.get(Fields.houseNumber.name());
		houseNumberExt = (String) value.get(Fields.houseNumberExt.name());
		directions = (String) value.get(Fields.directions.name());
		city = (String) value.get(Fields.city.name());
		cityGeoId = (String) value.get(Fields.cityGeoId.name());
		postalCode = (String) value.get(Fields.postalCode.name());
		postalCodeExt = (String) value.get(Fields.postalCodeExt.name());
		countryGeoId = (String) value.get(Fields.countryGeoId.name());
		stateProvinceGeoId = (String) value.get(Fields.stateProvinceGeoId
				.name());
		countyGeoId = (String) value.get(Fields.countyGeoId.name());
		municipalityGeoId = (String) value.get(Fields.municipalityGeoId.name());
		postalCodeGeoId = (String) value.get(Fields.postalCodeGeoId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
	}

	public static ProductFacilityAndPostalAddress fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFacilityAndPostalAddress(value);
	}

	public static List<ProductFacilityAndPostalAddress> fromValues(
			List<GenericValue> values) {
		List<ProductFacilityAndPostalAddress> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFacilityAndPostalAddress(value));
		}
		return entities;
	}
}