package org.apache.ofbiz.party.party.entity.view;

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

	public static final long serialVersionUID = 1460987100887422976L;
	public static final String NAME = "PartyRelationshipAndContactMechDetail";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Preferred Currency Uom Id
	 */
	@Getter
	@Setter
	private String preferredCurrencyUomId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
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
	 * Is Unread
	 */
	@Getter
	@Setter
	private String isUnread;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
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
	 * Priority Type Id
	 */
	@Getter
	@Setter
	private String priorityTypeId;
	/**
	 * Party Relationship Type Id
	 */
	@Getter
	@Setter
	private String partyRelationshipTypeId;
	/**
	 * Permissions Enum Id
	 */
	@Getter
	@Setter
	private String permissionsEnumId;
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
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Area Code
	 */
	@Getter
	@Setter
	private String areaCode;
	/**
	 * Contact Number
	 */
	@Getter
	@Setter
	private String contactNumber;
	/**
	 * Ask For Name
	 */
	@Getter
	@Setter
	private String askForName;
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

	public enum Fields {
		partyId, partyTypeId, externalId, preferredCurrencyUomId, description, statusId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, dataSourceId, isUnread, partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, fromDate, thruDate, relationshipName, securityGroupId, priorityTypeId, partyRelationshipTypeId, permissionsEnumId, positionTitle, comments, contactMechId, contactMechTypeId, infoString, toName, attnName, address1, address2, houseNumber, houseNumberExt, directions, city, cityGeoId, postalCode, postalCodeExt, countryGeoId, stateProvinceGeoId, countyGeoId, municipalityGeoId, postalCodeGeoId, geoPointId, countryCode, areaCode, contactNumber, askForName, firstName, middleName, lastName, firstNameLocal, lastNameLocal, personalTitle, suffix, groupName, groupNameLocal
	}

	public PartyRelationshipAndContactMechDetail(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		externalId = (String) value.get(Fields.externalId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		description = (String) value.get(Fields.description.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		isUnread = (String) value.get(Fields.isUnread.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		relationshipName = (String) value.get(Fields.relationshipName.name());
		securityGroupId = (String) value.get(Fields.securityGroupId.name());
		priorityTypeId = (String) value.get(Fields.priorityTypeId.name());
		partyRelationshipTypeId = (String) value
				.get(Fields.partyRelationshipTypeId.name());
		permissionsEnumId = (String) value.get(Fields.permissionsEnumId.name());
		positionTitle = (String) value.get(Fields.positionTitle.name());
		comments = (String) value.get(Fields.comments.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
		toName = (String) value.get(Fields.toName.name());
		attnName = (String) value.get(Fields.attnName.name());
		address1 = (String) value.get(Fields.address1.name());
		address2 = (String) value.get(Fields.address2.name());
		houseNumber = (Long) value.get(Fields.houseNumber.name());
		houseNumberExt = (String) value.get(Fields.houseNumberExt.name());
		directions = (String) value.get(Fields.directions.name());
		city = (String) value.get(Fields.city.name());
		cityGeoId = (String) value.get(Fields.cityGeoId.name());
		postalCode = (String) value.get(Fields.postalCode.name());
		postalCodeExt = (String) value.get(Fields.postalCodeExt.name());
		countryGeoId = (String) value.get(Fields.countryGeoId.name());
		stateProvinceGeoId = (String) value.get(Fields.stateProvinceGeoId
				.name());
		countyGeoId = (String) value.get(Fields.countyGeoId.name());
		municipalityGeoId = (String) value.get(Fields.municipalityGeoId.name());
		postalCodeGeoId = (String) value.get(Fields.postalCodeGeoId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		countryCode = (String) value.get(Fields.countryCode.name());
		areaCode = (String) value.get(Fields.areaCode.name());
		contactNumber = (String) value.get(Fields.contactNumber.name());
		askForName = (String) value.get(Fields.askForName.name());
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		firstNameLocal = (String) value.get(Fields.firstNameLocal.name());
		lastNameLocal = (String) value.get(Fields.lastNameLocal.name());
		personalTitle = (String) value.get(Fields.personalTitle.name());
		suffix = (String) value.get(Fields.suffix.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
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