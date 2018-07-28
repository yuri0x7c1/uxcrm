package org.apache.ofbiz.party.contact;

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
public class PartyContactDetailByPurpose implements Serializable {

	public static final long serialVersionUID = 129304824609922048L;
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

	public enum Fields {
		contactMechPurposeTypeId, purposeFromDate, purposeThruDate, contactMechTypeId, infoString, roleTypeId, extension, comments, verified, monthsWithContactMech, contactMechId, thruDate, fromDate, allowSolicitation, yearsWithContactMech, partyId, countryGeoId, houseNumberExt, address2, city, address1, postalCode, postalCodeGeoId, houseNumber, postalCodeExt, attnName, directions, countyGeoId, toName, cityGeoId, municipalityGeoId, stateProvinceGeoId, geoPointId, areaCode, askForName, countryCode, contactNumber, stateGeoName, stateGeoTypeId, stateGeoId, stateGeoCode, stateAbbreviation, stateGeoSecCode, stateWellKnownText, countyGeoName, countyGeoTypeId, countyGeoCode, countyAbbreviation, countyGeoSecCode, countyWellKnownText, countryGeoName, countryGeoTypeId, countryGeoCode, countryAbbreviation, countryGeoSecCode, countryWellKnownText
	}

	public PartyContactDetailByPurpose(GenericValue value) {
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		purposeFromDate = (Timestamp) value.get(Fields.purposeFromDate.name());
		purposeThruDate = (Timestamp) value.get(Fields.purposeThruDate.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		extension = (String) value.get(Fields.extension.name());
		comments = (String) value.get(Fields.comments.name());
		verified = (String) value.get(Fields.verified.name());
		monthsWithContactMech = (Long) value.get(Fields.monthsWithContactMech
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		allowSolicitation = (String) value.get(Fields.allowSolicitation.name());
		yearsWithContactMech = (Long) value.get(Fields.yearsWithContactMech
				.name());
		partyId = (String) value.get(Fields.partyId.name());
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
		areaCode = (String) value.get(Fields.areaCode.name());
		askForName = (String) value.get(Fields.askForName.name());
		countryCode = (String) value.get(Fields.countryCode.name());
		contactNumber = (String) value.get(Fields.contactNumber.name());
		stateGeoName = (String) value.get(Fields.stateGeoName.name());
		stateGeoTypeId = (String) value.get(Fields.stateGeoTypeId.name());
		stateGeoId = (String) value.get(Fields.stateGeoId.name());
		stateGeoCode = (String) value.get(Fields.stateGeoCode.name());
		stateAbbreviation = (String) value.get(Fields.stateAbbreviation.name());
		stateGeoSecCode = (String) value.get(Fields.stateGeoSecCode.name());
		stateWellKnownText = (String) value.get(Fields.stateWellKnownText
				.name());
		countyGeoName = (String) value.get(Fields.countyGeoName.name());
		countyGeoTypeId = (String) value.get(Fields.countyGeoTypeId.name());
		countyGeoCode = (String) value.get(Fields.countyGeoCode.name());
		countyAbbreviation = (String) value.get(Fields.countyAbbreviation
				.name());
		countyGeoSecCode = (String) value.get(Fields.countyGeoSecCode.name());
		countyWellKnownText = (String) value.get(Fields.countyWellKnownText
				.name());
		countryGeoName = (String) value.get(Fields.countryGeoName.name());
		countryGeoTypeId = (String) value.get(Fields.countryGeoTypeId.name());
		countryGeoCode = (String) value.get(Fields.countryGeoCode.name());
		countryAbbreviation = (String) value.get(Fields.countryAbbreviation
				.name());
		countryGeoSecCode = (String) value.get(Fields.countryGeoSecCode.name());
		countryWellKnownText = (String) value.get(Fields.countryWellKnownText
				.name());
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