package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party And Contact Mech
 */
public class PartyAndContactMech implements Serializable {

	public static final long serialVersionUID = 5135623180634561536L;
	public static final String NAME = "PartyAndContactMech";
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Unread
	 */
	@Getter
	@Setter
	private String isUnread;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Preferred Currency Uom Id
	 */
	@Getter
	@Setter
	private String preferredCurrencyUomId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
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
	 * Pa Contact Mech Id
	 */
	@Getter
	@Setter
	private String paContactMechId;
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
	/**
	 * Tn Contact Mech Id
	 */
	@Getter
	@Setter
	private String tnContactMechId;

	public enum Fields {
		lastModifiedDate, externalId, description, isUnread, partyTypeId, lastModifiedByUserLogin, dataSourceId, createdDate, statusId, preferredCurrencyUomId, partyId, createdByUserLogin, roleTypeId, extension, comments, verified, monthsWithContactMech, contactMechId, thruDate, fromDate, allowSolicitation, yearsWithContactMech, infoString, contactMechTypeId, paCountryGeoId, paHouseNumberExt, paAddress2, paCity, paAddress1, paPostalCode, paPostalCodeGeoId, paHouseNumber, paPostalCodeExt, paContactMechId, paAttnName, paDirections, paCountyGeoId, paToName, paCityGeoId, paMunicipalityGeoId, paStateProvinceGeoId, paGeoPointId, tnAreaCode, tnAskForName, tnCountryCode, tnContactNumber, tnContactMechId
	}

	public PartyAndContactMech(GenericValue value) {
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		externalId = (String) value.get(Fields.externalId.name());
		description = (String) value.get(Fields.description.name());
		isUnread = (String) value.get(Fields.isUnread.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		partyId = (String) value.get(Fields.partyId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
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
		infoString = (String) value.get(Fields.infoString.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		paCountryGeoId = (String) value.get(Fields.paCountryGeoId.name());
		paHouseNumberExt = (String) value.get(Fields.paHouseNumberExt.name());
		paAddress2 = (String) value.get(Fields.paAddress2.name());
		paCity = (String) value.get(Fields.paCity.name());
		paAddress1 = (String) value.get(Fields.paAddress1.name());
		paPostalCode = (String) value.get(Fields.paPostalCode.name());
		paPostalCodeGeoId = (String) value.get(Fields.paPostalCodeGeoId.name());
		paHouseNumber = (Long) value.get(Fields.paHouseNumber.name());
		paPostalCodeExt = (String) value.get(Fields.paPostalCodeExt.name());
		paContactMechId = (String) value.get(Fields.paContactMechId.name());
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
		tnContactMechId = (String) value.get(Fields.tnContactMechId.name());
	}

	public static PartyAndContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndContactMech(value);
	}

	public static List<PartyAndContactMech> fromValues(List<GenericValue> values) {
		List<PartyAndContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndContactMech(value));
		}
		return entities;
	}
}