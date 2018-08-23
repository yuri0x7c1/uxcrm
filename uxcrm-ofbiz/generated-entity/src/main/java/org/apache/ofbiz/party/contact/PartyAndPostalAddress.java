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
 * Party And Postal Address
 */
@FieldNameConstants
public class PartyAndPostalAddress implements Serializable {

	public static final long serialVersionUID = 7170394397649608704L;
	public static final String NAME = "PartyAndPostalAddress";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Allow Solicitation
	 */
	@Getter
	@Setter
	private String allowSolicitation;
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

	public PartyAndPostalAddress(GenericValue value) {
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		infoString = (String) value.get(FIELD_INFO_STRING);
		comments = (String) value.get(FIELD_COMMENTS);
		extension = (String) value.get(FIELD_EXTENSION);
		allowSolicitation = (String) value.get(FIELD_ALLOW_SOLICITATION);
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

	public static PartyAndPostalAddress fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndPostalAddress(value);
	}

	public static List<PartyAndPostalAddress> fromValues(
			List<GenericValue> values) {
		List<PartyAndPostalAddress> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndPostalAddress(value));
		}
		return entities;
	}
}