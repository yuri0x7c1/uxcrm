package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.sql.Date;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Role And Contact Mech Detail
 */
@FieldNameConstants
public class PartyRoleAndContactMechDetail implements Serializable {

	public static final long serialVersionUID = 2053866207503934464L;
	public static final String NAME = "PartyRoleAndContactMechDetail";
	/**
	 * Person Comments
	 */
	@Getter
	@Setter
	private String personComments;
	/**
	 * Party Group Comments
	 */
	@Getter
	@Setter
	private String partyGroupComments;
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
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Years With Employer
	 */
	@Getter
	@Setter
	private Long yearsWithEmployer;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Occupation
	 */
	@Getter
	@Setter
	private String occupation;
	/**
	 * Gender
	 */
	@Getter
	@Setter
	private String gender;
	/**
	 * Employment Status Enum Id
	 */
	@Getter
	@Setter
	private String employmentStatusEnumId;
	/**
	 * Social Security Number
	 */
	@Getter
	@Setter
	private String socialSecurityNumber;
	/**
	 * Suffix
	 */
	@Getter
	@Setter
	private String suffix;
	/**
	 * Mothers Maiden Name
	 */
	@Getter
	@Setter
	private String mothersMaidenName;
	/**
	 * Middle Name Local
	 */
	@Getter
	@Setter
	private String middleNameLocal;
	/**
	 * Existing Customer
	 */
	@Getter
	@Setter
	private String existingCustomer;
	/**
	 * Residence Status Enum Id
	 */
	@Getter
	@Setter
	private String residenceStatusEnumId;
	/**
	 * Nickname
	 */
	@Getter
	@Setter
	private String nickname;
	/**
	 * Member Id
	 */
	@Getter
	@Setter
	private String memberId;
	/**
	 * Height
	 */
	@Getter
	@Setter
	private Double height;
	/**
	 * Passport Number
	 */
	@Getter
	@Setter
	private String passportNumber;
	/**
	 * Last Name Local
	 */
	@Getter
	@Setter
	private String lastNameLocal;
	/**
	 * Months With Employer
	 */
	@Getter
	@Setter
	private Long monthsWithEmployer;
	/**
	 * Weight
	 */
	@Getter
	@Setter
	private Double weight;
	/**
	 * Birth Date
	 */
	@Getter
	@Setter
	private Date birthDate;
	/**
	 * Other Local
	 */
	@Getter
	@Setter
	private String otherLocal;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Card Id
	 */
	@Getter
	@Setter
	private String cardId;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * First Name Local
	 */
	@Getter
	@Setter
	private String firstNameLocal;
	/**
	 * Passport Expire Date
	 */
	@Getter
	@Setter
	private Date passportExpireDate;
	/**
	 * Salutation
	 */
	@Getter
	@Setter
	private String salutation;
	/**
	 * Personal Title
	 */
	@Getter
	@Setter
	private String personalTitle;
	/**
	 * Deceased Date
	 */
	@Getter
	@Setter
	private Date deceasedDate;
	/**
	 * Total Years Work Experience
	 */
	@Getter
	@Setter
	private Double totalYearsWorkExperience;
	/**
	 * Marital Status
	 */
	@Getter
	@Setter
	private String maritalStatus;
	/**
	 * Ticker Symbol
	 */
	@Getter
	@Setter
	private String tickerSymbol;
	/**
	 * Logo Image Url
	 */
	@Getter
	@Setter
	private String logoImageUrl;
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
	 * Num Employees
	 */
	@Getter
	@Setter
	private Long numEmployees;
	/**
	 * Office Site Name
	 */
	@Getter
	@Setter
	private String officeSiteName;
	/**
	 * Annual Revenue
	 */
	@Getter
	@Setter
	private BigDecimal annualRevenue;
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

	public PartyRoleAndContactMechDetail(GenericValue value) {
		personComments = (String) value.get(FIELD_PERSON_COMMENTS);
		partyGroupComments = (String) value.get(FIELD_PARTY_GROUP_COMMENTS);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		isUnread = (String) value.get(FIELD_IS_UNREAD);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		preferredCurrencyUomId = (String) value
				.get(FIELD_PREFERRED_CURRENCY_UOM_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		yearsWithEmployer = (Long) value.get(FIELD_YEARS_WITH_EMPLOYER);
		lastName = (String) value.get(FIELD_LAST_NAME);
		occupation = (String) value.get(FIELD_OCCUPATION);
		gender = (String) value.get(FIELD_GENDER);
		employmentStatusEnumId = (String) value
				.get(FIELD_EMPLOYMENT_STATUS_ENUM_ID);
		socialSecurityNumber = (String) value.get(FIELD_SOCIAL_SECURITY_NUMBER);
		suffix = (String) value.get(FIELD_SUFFIX);
		mothersMaidenName = (String) value.get(FIELD_MOTHERS_MAIDEN_NAME);
		middleNameLocal = (String) value.get(FIELD_MIDDLE_NAME_LOCAL);
		existingCustomer = (String) value.get(FIELD_EXISTING_CUSTOMER);
		residenceStatusEnumId = (String) value
				.get(FIELD_RESIDENCE_STATUS_ENUM_ID);
		nickname = (String) value.get(FIELD_NICKNAME);
		memberId = (String) value.get(FIELD_MEMBER_ID);
		height = (Double) value.get(FIELD_HEIGHT);
		passportNumber = (String) value.get(FIELD_PASSPORT_NUMBER);
		lastNameLocal = (String) value.get(FIELD_LAST_NAME_LOCAL);
		monthsWithEmployer = (Long) value.get(FIELD_MONTHS_WITH_EMPLOYER);
		weight = (Double) value.get(FIELD_WEIGHT);
		birthDate = (Date) value.get(FIELD_BIRTH_DATE);
		otherLocal = (String) value.get(FIELD_OTHER_LOCAL);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		cardId = (String) value.get(FIELD_CARD_ID);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		firstNameLocal = (String) value.get(FIELD_FIRST_NAME_LOCAL);
		passportExpireDate = (Date) value.get(FIELD_PASSPORT_EXPIRE_DATE);
		salutation = (String) value.get(FIELD_SALUTATION);
		personalTitle = (String) value.get(FIELD_PERSONAL_TITLE);
		deceasedDate = (Date) value.get(FIELD_DECEASED_DATE);
		totalYearsWorkExperience = (Double) value
				.get(FIELD_TOTAL_YEARS_WORK_EXPERIENCE);
		maritalStatus = (String) value.get(FIELD_MARITAL_STATUS);
		tickerSymbol = (String) value.get(FIELD_TICKER_SYMBOL);
		logoImageUrl = (String) value.get(FIELD_LOGO_IMAGE_URL);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		numEmployees = (Long) value.get(FIELD_NUM_EMPLOYEES);
		officeSiteName = (String) value.get(FIELD_OFFICE_SITE_NAME);
		annualRevenue = (BigDecimal) value.get(FIELD_ANNUAL_REVENUE);
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

	public static PartyRoleAndContactMechDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRoleAndContactMechDetail(value);
	}

	public static List<PartyRoleAndContactMechDetail> fromValues(
			List<GenericValue> values) {
		List<PartyRoleAndContactMechDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRoleAndContactMechDetail(value));
		}
		return entities;
	}
}