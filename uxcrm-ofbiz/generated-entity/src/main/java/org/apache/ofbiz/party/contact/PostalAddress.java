package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Postal Address
 */
@FieldNameConstants
public class PostalAddress implements Serializable {

	public static final long serialVersionUID = 1102142759123439616L;
	public static final String NAME = "PostalAddress";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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

	public PostalAddress(GenericValue value) {
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		toName = (String) value.get(FIELD_TO_NAME);
		attnName = (String) value.get(FIELD_ATTN_NAME);
		address1 = (String) value.get(FIELD_ADDRESS1);
		address2 = (String) value.get(FIELD_ADDRESS2);
		houseNumber = (Long) value.get(FIELD_HOUSE_NUMBER);
		houseNumberExt = (String) value.get(FIELD_HOUSE_NUMBER_EXT);
		directions = (String) value.get(FIELD_DIRECTIONS);
		city = (String) value.get(FIELD_CITY);
		cityGeoId = (String) value.get(FIELD_CITY_GEO_ID);
		postalCode = (String) value.get(FIELD_POSTAL_CODE);
		postalCodeExt = (String) value.get(FIELD_POSTAL_CODE_EXT);
		countryGeoId = (String) value.get(FIELD_COUNTRY_GEO_ID);
		stateProvinceGeoId = (String) value.get(FIELD_STATE_PROVINCE_GEO_ID);
		countyGeoId = (String) value.get(FIELD_COUNTY_GEO_ID);
		municipalityGeoId = (String) value.get(FIELD_MUNICIPALITY_GEO_ID);
		postalCodeGeoId = (String) value.get(FIELD_POSTAL_CODE_GEO_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PostalAddress fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PostalAddress(value);
	}

	public static List<PostalAddress> fromValues(List<GenericValue> values) {
		List<PostalAddress> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PostalAddress(value));
		}
		return entities;
	}
}