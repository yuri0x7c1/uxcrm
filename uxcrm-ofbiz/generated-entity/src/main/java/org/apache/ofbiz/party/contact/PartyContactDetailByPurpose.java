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
 * Party Contact Detail By Purpose
 */
@FieldNameConstants
public class PartyContactDetailByPurpose implements Serializable {

	public static final long serialVersionUID = 2765502204551288832L;
	public static final String NAME = "PartyContactDetailByPurpose";
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Purpose From Date
	 */
	@Getter
	@Setter
	private Timestamp purposeFromDate;
	/**
	 * Purpose Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purposeThruDate;
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
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
	 * Verified
	 */
	@Getter
	@Setter
	private String verified;
	/**
	 * Months With Contact Mech
	 */
	@Getter
	@Setter
	private Long monthsWithContactMech;
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
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Allow Solicitation
	 */
	@Getter
	@Setter
	private String allowSolicitation;
	/**
	 * Years With Contact Mech
	 */
	@Getter
	@Setter
	private Long yearsWithContactMech;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Area Code
	 */
	@Getter
	@Setter
	private String areaCode;
	/**
	 * Ask For Name
	 */
	@Getter
	@Setter
	private String askForName;
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Contact Number
	 */
	@Getter
	@Setter
	private String contactNumber;
	/**
	 * State Geo Name
	 */
	@Getter
	@Setter
	private String stateGeoName;
	/**
	 * State Geo Type Id
	 */
	@Getter
	@Setter
	private String stateGeoTypeId;
	/**
	 * State Geo Id
	 */
	@Getter
	@Setter
	private String stateGeoId;
	/**
	 * State Geo Code
	 */
	@Getter
	@Setter
	private String stateGeoCode;
	/**
	 * State Abbreviation
	 */
	@Getter
	@Setter
	private String stateAbbreviation;
	/**
	 * State Geo Sec Code
	 */
	@Getter
	@Setter
	private String stateGeoSecCode;
	/**
	 * State Well Known Text
	 */
	@Getter
	@Setter
	private String stateWellKnownText;
	/**
	 * County Geo Name
	 */
	@Getter
	@Setter
	private String countyGeoName;
	/**
	 * County Geo Type Id
	 */
	@Getter
	@Setter
	private String countyGeoTypeId;
	/**
	 * County Geo Code
	 */
	@Getter
	@Setter
	private String countyGeoCode;
	/**
	 * County Abbreviation
	 */
	@Getter
	@Setter
	private String countyAbbreviation;
	/**
	 * County Geo Sec Code
	 */
	@Getter
	@Setter
	private String countyGeoSecCode;
	/**
	 * County Well Known Text
	 */
	@Getter
	@Setter
	private String countyWellKnownText;
	/**
	 * Country Geo Name
	 */
	@Getter
	@Setter
	private String countryGeoName;
	/**
	 * Country Geo Type Id
	 */
	@Getter
	@Setter
	private String countryGeoTypeId;
	/**
	 * Country Geo Code
	 */
	@Getter
	@Setter
	private String countryGeoCode;
	/**
	 * Country Abbreviation
	 */
	@Getter
	@Setter
	private String countryAbbreviation;
	/**
	 * Country Geo Sec Code
	 */
	@Getter
	@Setter
	private String countryGeoSecCode;
	/**
	 * Country Well Known Text
	 */
	@Getter
	@Setter
	private String countryWellKnownText;

	public PartyContactDetailByPurpose(GenericValue value) {
		contactMechPurposeTypeId = (String) value
				.get(FIELD_CONTACT_MECH_PURPOSE_TYPE_ID);
		purposeFromDate = (Timestamp) value.get(FIELD_PURPOSE_FROM_DATE);
		purposeThruDate = (Timestamp) value.get(FIELD_PURPOSE_THRU_DATE);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		infoString = (String) value.get(FIELD_INFO_STRING);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		extension = (String) value.get(FIELD_EXTENSION);
		comments = (String) value.get(FIELD_COMMENTS);
		verified = (String) value.get(FIELD_VERIFIED);
		monthsWithContactMech = (Long) value
				.get(FIELD_MONTHS_WITH_CONTACT_MECH);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		allowSolicitation = (String) value.get(FIELD_ALLOW_SOLICITATION);
		yearsWithContactMech = (Long) value.get(FIELD_YEARS_WITH_CONTACT_MECH);
		partyId = (String) value.get(FIELD_PARTY_ID);
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
		areaCode = (String) value.get(FIELD_AREA_CODE);
		askForName = (String) value.get(FIELD_ASK_FOR_NAME);
		countryCode = (String) value.get(FIELD_COUNTRY_CODE);
		contactNumber = (String) value.get(FIELD_CONTACT_NUMBER);
		stateGeoName = (String) value.get(FIELD_STATE_GEO_NAME);
		stateGeoTypeId = (String) value.get(FIELD_STATE_GEO_TYPE_ID);
		stateGeoId = (String) value.get(FIELD_STATE_GEO_ID);
		stateGeoCode = (String) value.get(FIELD_STATE_GEO_CODE);
		stateAbbreviation = (String) value.get(FIELD_STATE_ABBREVIATION);
		stateGeoSecCode = (String) value.get(FIELD_STATE_GEO_SEC_CODE);
		stateWellKnownText = (String) value.get(FIELD_STATE_WELL_KNOWN_TEXT);
		countyGeoName = (String) value.get(FIELD_COUNTY_GEO_NAME);
		countyGeoTypeId = (String) value.get(FIELD_COUNTY_GEO_TYPE_ID);
		countyGeoCode = (String) value.get(FIELD_COUNTY_GEO_CODE);
		countyAbbreviation = (String) value.get(FIELD_COUNTY_ABBREVIATION);
		countyGeoSecCode = (String) value.get(FIELD_COUNTY_GEO_SEC_CODE);
		countyWellKnownText = (String) value.get(FIELD_COUNTY_WELL_KNOWN_TEXT);
		countryGeoName = (String) value.get(FIELD_COUNTRY_GEO_NAME);
		countryGeoTypeId = (String) value.get(FIELD_COUNTRY_GEO_TYPE_ID);
		countryGeoCode = (String) value.get(FIELD_COUNTRY_GEO_CODE);
		countryAbbreviation = (String) value.get(FIELD_COUNTRY_ABBREVIATION);
		countryGeoSecCode = (String) value.get(FIELD_COUNTRY_GEO_SEC_CODE);
		countryWellKnownText = (String) value
				.get(FIELD_COUNTRY_WELL_KNOWN_TEXT);
	}

	public static PartyContactDetailByPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContactDetailByPurpose(value);
	}

	public static List<PartyContactDetailByPurpose> fromValues(
			List<GenericValue> values) {
		List<PartyContactDetailByPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContactDetailByPurpose(value));
		}
		return entities;
	}
}