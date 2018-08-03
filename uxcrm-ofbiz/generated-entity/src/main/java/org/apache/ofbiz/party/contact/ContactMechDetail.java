package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Detail
 */
public class ContactMechDetail implements Serializable {

	public static final long serialVersionUID = 2803423331309016064L;
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

	public enum Fields {
		infoString, contactMechTypeId, contactMechId, paCountryGeoId, paHouseNumberExt, paAddress2, paCity, paAddress1, paPostalCode, paPostalCodeGeoId, paHouseNumber, paPostalCodeExt, paAttnName, paDirections, paCountyGeoId, paToName, paCityGeoId, paMunicipalityGeoId, paStateProvinceGeoId, paGeoPointId, tnAreaCode, tnAskForName, tnCountryCode, tnContactNumber
	}

	public ContactMechDetail(GenericValue value) {
		infoString = (String) value.get(Fields.infoString.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		paCountryGeoId = (String) value.get(Fields.paCountryGeoId.name());
		paHouseNumberExt = (String) value.get(Fields.paHouseNumberExt.name());
		paAddress2 = (String) value.get(Fields.paAddress2.name());
		paCity = (String) value.get(Fields.paCity.name());
		paAddress1 = (String) value.get(Fields.paAddress1.name());
		paPostalCode = (String) value.get(Fields.paPostalCode.name());
		paPostalCodeGeoId = (String) value.get(Fields.paPostalCodeGeoId.name());
		paHouseNumber = (Long) value.get(Fields.paHouseNumber.name());
		paPostalCodeExt = (String) value.get(Fields.paPostalCodeExt.name());
		paAttnName = (String) value.get(Fields.paAttnName.name());
		paDirections = (String) value.get(Fields.paDirections.name());
		paCountyGeoId = (String) value.get(Fields.paCountyGeoId.name());
		paToName = (String) value.get(Fields.paToName.name());
		paCityGeoId = (String) value.get(Fields.paCityGeoId.name());
		paMunicipalityGeoId = (String) value.get(Fields.paMunicipalityGeoId
				.name());
		paStateProvinceGeoId = (String) value.get(Fields.paStateProvinceGeoId
				.name());
		paGeoPointId = (String) value.get(Fields.paGeoPointId.name());
		tnAreaCode = (String) value.get(Fields.tnAreaCode.name());
		tnAskForName = (String) value.get(Fields.tnAskForName.name());
		tnCountryCode = (String) value.get(Fields.tnCountryCode.name());
		tnContactNumber = (String) value.get(Fields.tnContactNumber.name());
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