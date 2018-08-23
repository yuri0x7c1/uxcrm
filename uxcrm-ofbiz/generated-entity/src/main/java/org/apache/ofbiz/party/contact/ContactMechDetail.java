package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Detail
 */
@FieldNameConstants
public class ContactMechDetail implements Serializable {

	public static final long serialVersionUID = 7830379706012722176L;
	public static final String NAME = "ContactMechDetail";
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
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Pa Country Geo Id
	 */
	@Getter
	@Setter
	private String paCountryGeoId;
	/**
	 * Pa House Number Ext
	 */
	@Getter
	@Setter
	private String paHouseNumberExt;
	/**
	 * Pa Address 2
	 */
	@Getter
	@Setter
	private String paAddress2;
	/**
	 * Pa City
	 */
	@Getter
	@Setter
	private String paCity;
	/**
	 * Pa Address 1
	 */
	@Getter
	@Setter
	private String paAddress1;
	/**
	 * Pa Postal Code
	 */
	@Getter
	@Setter
	private String paPostalCode;
	/**
	 * Pa Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String paPostalCodeGeoId;
	/**
	 * Pa House Number
	 */
	@Getter
	@Setter
	private Long paHouseNumber;
	/**
	 * Pa Postal Code Ext
	 */
	@Getter
	@Setter
	private String paPostalCodeExt;
	/**
	 * Pa Attn Name
	 */
	@Getter
	@Setter
	private String paAttnName;
	/**
	 * Pa Directions
	 */
	@Getter
	@Setter
	private String paDirections;
	/**
	 * Pa County Geo Id
	 */
	@Getter
	@Setter
	private String paCountyGeoId;
	/**
	 * Pa To Name
	 */
	@Getter
	@Setter
	private String paToName;
	/**
	 * Pa City Geo Id
	 */
	@Getter
	@Setter
	private String paCityGeoId;
	/**
	 * Pa Municipality Geo Id
	 */
	@Getter
	@Setter
	private String paMunicipalityGeoId;
	/**
	 * Pa State Province Geo Id
	 */
	@Getter
	@Setter
	private String paStateProvinceGeoId;
	/**
	 * Pa Geo Point Id
	 */
	@Getter
	@Setter
	private String paGeoPointId;
	/**
	 * Tn Area Code
	 */
	@Getter
	@Setter
	private String tnAreaCode;
	/**
	 * Tn Ask For Name
	 */
	@Getter
	@Setter
	private String tnAskForName;
	/**
	 * Tn Country Code
	 */
	@Getter
	@Setter
	private String tnCountryCode;
	/**
	 * Tn Contact Number
	 */
	@Getter
	@Setter
	private String tnContactNumber;

	public ContactMechDetail(GenericValue value) {
		infoString = (String) value.get(FIELD_INFO_STRING);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		paCountryGeoId = (String) value.get(FIELD_PA_COUNTRY_GEO_ID);
		paHouseNumberExt = (String) value.get(FIELD_PA_HOUSE_NUMBER_EXT);
		paAddress2 = (String) value.get(FIELD_PA_ADDRESS2);
		paCity = (String) value.get(FIELD_PA_CITY);
		paAddress1 = (String) value.get(FIELD_PA_ADDRESS1);
		paPostalCode = (String) value.get(FIELD_PA_POSTAL_CODE);
		paPostalCodeGeoId = (String) value.get(FIELD_PA_POSTAL_CODE_GEO_ID);
		paHouseNumber = (Long) value.get(FIELD_PA_HOUSE_NUMBER);
		paPostalCodeExt = (String) value.get(FIELD_PA_POSTAL_CODE_EXT);
		paAttnName = (String) value.get(FIELD_PA_ATTN_NAME);
		paDirections = (String) value.get(FIELD_PA_DIRECTIONS);
		paCountyGeoId = (String) value.get(FIELD_PA_COUNTY_GEO_ID);
		paToName = (String) value.get(FIELD_PA_TO_NAME);
		paCityGeoId = (String) value.get(FIELD_PA_CITY_GEO_ID);
		paMunicipalityGeoId = (String) value.get(FIELD_PA_MUNICIPALITY_GEO_ID);
		paStateProvinceGeoId = (String) value
				.get(FIELD_PA_STATE_PROVINCE_GEO_ID);
		paGeoPointId = (String) value.get(FIELD_PA_GEO_POINT_ID);
		tnAreaCode = (String) value.get(FIELD_TN_AREA_CODE);
		tnAskForName = (String) value.get(FIELD_TN_ASK_FOR_NAME);
		tnCountryCode = (String) value.get(FIELD_TN_COUNTRY_CODE);
		tnContactNumber = (String) value.get(FIELD_TN_CONTACT_NUMBER);
	}

	public static ContactMechDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechDetail(value);
	}

	public static List<ContactMechDetail> fromValues(List<GenericValue> values) {
		List<ContactMechDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechDetail(value));
		}
		return entities;
	}
}