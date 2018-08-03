package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Relationship And Contact Mech Detail
 */
public class PartyRelationshipAndContactMechDetail implements Serializable {

	public static final long serialVersionUID = 8497217066032728064L;
	public static final String NAME = "PartyRelationshipAndContactMechDetail";
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * First Name Local
	 */
	@Getter
	@Setter
	private String firstNameLocal;
	/**
	 * Last Name Local
	 */
	@Getter
	@Setter
	private String lastNameLocal;
	/**
	 * Personal Title
	 */
	@Getter
	@Setter
	private String personalTitle;
	/**
	 * Suffix
	 */
	@Getter
	@Setter
	private String suffix;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Group Name Local
	 */
	@Getter
	@Setter
	private String groupNameLocal;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Party Status Id
	 */
	@Getter
	@Setter
	private String partyStatusId;
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
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Position Title
	 */
	@Getter
	@Setter
	private String positionTitle;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Priority Type Id
	 */
	@Getter
	@Setter
	private String priorityTypeId;
	/**
	 * Permissions Enum Id
	 */
	@Getter
	@Setter
	private String permissionsEnumId;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
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
	 * Relationship Name
	 */
	@Getter
	@Setter
	private String relationshipName;
	/**
	 * Security Group Id
	 */
	@Getter
	@Setter
	private String securityGroupId;
	/**
	 * Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String partyRelationshipTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
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
		firstName, middleName, lastName, firstNameLocal, lastNameLocal, personalTitle, suffix, groupName, groupNameLocal, contactMechId, partyStatusId, lastModifiedDate, externalId, description, isUnread, partyTypeId, lastModifiedByUserLogin, dataSourceId, createdDate, preferredCurrencyUomId, partyId, createdByUserLogin, roleTypeIdTo, partyIdFrom, positionTitle, comments, priorityTypeId, permissionsEnumId, roleTypeIdFrom, thruDate, fromDate, relationshipName, securityGroupId, partyRelationshipTypeId, statusId, partyIdTo, infoString, contactMechTypeId, paCountryGeoId, paHouseNumberExt, paAddress2, paCity, paAddress1, paPostalCode, paPostalCodeGeoId, paHouseNumber, paPostalCodeExt, paContactMechId, paAttnName, paDirections, paCountyGeoId, paToName, paCityGeoId, paMunicipalityGeoId, paStateProvinceGeoId, paGeoPointId, tnAreaCode, tnAskForName, tnCountryCode, tnContactNumber, tnContactMechId
	}

	public PartyRelationshipAndContactMechDetail(GenericValue value) {
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		firstNameLocal = (String) value.get(Fields.firstNameLocal.name());
		lastNameLocal = (String) value.get(Fields.lastNameLocal.name());
		personalTitle = (String) value.get(Fields.personalTitle.name());
		suffix = (String) value.get(Fields.suffix.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		partyStatusId = (String) value.get(Fields.partyStatusId.name());
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
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		partyId = (String) value.get(Fields.partyId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		positionTitle = (String) value.get(Fields.positionTitle.name());
		comments = (String) value.get(Fields.comments.name());
		priorityTypeId = (String) value.get(Fields.priorityTypeId.name());
		permissionsEnumId = (String) value.get(Fields.permissionsEnumId.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		relationshipName = (String) value.get(Fields.relationshipName.name());
		securityGroupId = (String) value.get(Fields.securityGroupId.name());
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
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

	public static PartyRelationshipAndContactMechDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRelationshipAndContactMechDetail(value);
	}

	public static List<PartyRelationshipAndContactMechDetail> fromValues(
			List<GenericValue> values) {
		List<PartyRelationshipAndContactMechDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRelationshipAndContactMechDetail(value));
		}
		return entities;
	}
}