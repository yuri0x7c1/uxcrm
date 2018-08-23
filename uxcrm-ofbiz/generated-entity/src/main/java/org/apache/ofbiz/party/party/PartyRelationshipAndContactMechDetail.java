package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyRelationshipAndContactMechDetail implements Serializable {

	public static final long serialVersionUID = 26299742637145088L;
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

	public PartyRelationshipAndContactMechDetail(GenericValue value) {
		firstName = (String) value.get(FIELD_FIRST_NAME);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
		firstNameLocal = (String) value.get(FIELD_FIRST_NAME_LOCAL);
		lastNameLocal = (String) value.get(FIELD_LAST_NAME_LOCAL);
		personalTitle = (String) value.get(FIELD_PERSONAL_TITLE);
		suffix = (String) value.get(FIELD_SUFFIX);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		partyStatusId = (String) value.get(FIELD_PARTY_STATUS_ID);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		isUnread = (String) value.get(FIELD_IS_UNREAD);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		preferredCurrencyUomId = (String) value
				.get(FIELD_PREFERRED_CURRENCY_UOM_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		positionTitle = (String) value.get(FIELD_POSITION_TITLE);
		comments = (String) value.get(FIELD_COMMENTS);
		priorityTypeId = (String) value.get(FIELD_PRIORITY_TYPE_ID);
		permissionsEnumId = (String) value.get(FIELD_PERMISSIONS_ENUM_ID);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		relationshipName = (String) value.get(FIELD_RELATIONSHIP_NAME);
		securityGroupId = (String) value.get(FIELD_SECURITY_GROUP_ID);
		partyRelationshipTypeId = (String) value
				.get(FIELD_PARTY_RELATIONSHIP_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		infoString = (String) value.get(FIELD_INFO_STRING);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		paCountryGeoId = (String) value.get(FIELD_PA_COUNTRY_GEO_ID);
		paHouseNumberExt = (String) value.get(FIELD_PA_HOUSE_NUMBER_EXT);
		paAddress2 = (String) value.get(FIELD_PA_ADDRESS2);
		paCity = (String) value.get(FIELD_PA_CITY);
		paAddress1 = (String) value.get(FIELD_PA_ADDRESS1);
		paPostalCode = (String) value.get(FIELD_PA_POSTAL_CODE);
		paPostalCodeGeoId = (String) value.get(FIELD_PA_POSTAL_CODE_GEO_ID);
		paHouseNumber = (Long) value.get(FIELD_PA_HOUSE_NUMBER);
		paPostalCodeExt = (String) value.get(FIELD_PA_POSTAL_CODE_EXT);
		paContactMechId = (String) value.get(FIELD_PA_CONTACT_MECH_ID);
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
		tnContactMechId = (String) value.get(FIELD_TN_CONTACT_MECH_ID);
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