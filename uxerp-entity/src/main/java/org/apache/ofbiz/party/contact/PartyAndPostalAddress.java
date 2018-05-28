package org.apache.ofbiz.party.contact;

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
public class PartyAndPostalAddress implements Serializable {

	public static final long serialVersionUID = 4806765714002264064L;
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

	public enum Fields {
		contactMechId, partyId, statusId, fromDate, thruDate, partyTypeId, contactMechTypeId, infoString, comments, extension, allowSolicitation, countryGeoId, houseNumberExt, address2, city, address1, postalCode, postalCodeGeoId, houseNumber, postalCodeExt, attnName, directions, countyGeoId, toName, cityGeoId, municipalityGeoId, stateProvinceGeoId, geoPointId
	}

	public PartyAndPostalAddress(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		partyId = (String) value.get(Fields.partyId.name());
		statusId = (String) value.get(Fields.statusId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
		comments = (String) value.get(Fields.comments.name());
		extension = (String) value.get(Fields.extension.name());
		allowSolicitation = (String) value.get(Fields.allowSolicitation.name());
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