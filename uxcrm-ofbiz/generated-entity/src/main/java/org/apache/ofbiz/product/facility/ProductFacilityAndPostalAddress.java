package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductFacilityAndPostalAddress implements Serializable {

	public static final long serialVersionUID = 9194758090675943424L;
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

	public ProductFacilityAndPostalAddress(GenericValue value) {
		lastInventoryCount = (BigDecimal) value.get(FIELD_LAST_INVENTORY_COUNT);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		minimumStock = (BigDecimal) value.get(FIELD_MINIMUM_STOCK);
		reorderQuantity = (BigDecimal) value.get(FIELD_REORDER_QUANTITY);
		daysToShip = (Long) value.get(FIELD_DAYS_TO_SHIP);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		extension = (String) value.get(FIELD_EXTENSION);
		comments = (String) value.get(FIELD_COMMENTS);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		infoString = (String) value.get(FIELD_INFO_STRING);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
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