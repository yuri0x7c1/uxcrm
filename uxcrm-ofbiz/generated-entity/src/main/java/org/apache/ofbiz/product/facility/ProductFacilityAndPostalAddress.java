package org.apache.ofbiz.product.facility;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Facility And Postal Address
 */
public class ProductFacilityAndPostalAddress implements Serializable {

	public static final long serialVersionUID = 9083415154274897920L;
	public static final String NAME = "ProductFacilityAndPostalAddress";
	/**
	 * Last Inventory Count
	 */
	@Getter
	@Setter
	private BigDecimal lastInventoryCount;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
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
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
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

	public enum Fields {
		lastInventoryCount, facilityId, productId, minimumStock, reorderQuantity, daysToShip, fromDate, extension, comments, contactMechId, thruDate, infoString, contactMechTypeId, countryGeoId, houseNumberExt, address2, city, address1, postalCode, postalCodeGeoId, houseNumber, postalCodeExt, attnName, directions, countyGeoId, toName, cityGeoId, municipalityGeoId, stateProvinceGeoId, geoPointId
	}

	public ProductFacilityAndPostalAddress(GenericValue value) {
		lastInventoryCount = (BigDecimal) value.get(Fields.lastInventoryCount
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		productId = (String) value.get(Fields.productId.name());
		minimumStock = (BigDecimal) value.get(Fields.minimumStock.name());
		reorderQuantity = (BigDecimal) value.get(Fields.reorderQuantity.name());
		daysToShip = (Long) value.get(Fields.daysToShip.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		extension = (String) value.get(Fields.extension.name());
		comments = (String) value.get(Fields.comments.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		infoString = (String) value.get(Fields.infoString.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
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