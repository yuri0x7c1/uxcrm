package org.apache.ofbiz.party.party;

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
public class PartyRoleAndContactMechDetail implements Serializable {

	public static final long serialVersionUID = 2607058443001799680L;
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

	public enum Fields {
		personComments, partyGroupComments, lastModifiedDate, externalId, isUnread, partyTypeId, lastModifiedByUserLogin, dataSourceId, createdDate, statusId, preferredCurrencyUomId, partyId, createdByUserLogin, roleTypeId, parentTypeId, hasTable, description, yearsWithEmployer, lastName, occupation, gender, employmentStatusEnumId, socialSecurityNumber, suffix, mothersMaidenName, middleNameLocal, existingCustomer, residenceStatusEnumId, nickname, memberId, height, passportNumber, lastNameLocal, monthsWithEmployer, weight, birthDate, otherLocal, firstName, cardId, middleName, firstNameLocal, passportExpireDate, salutation, personalTitle, deceasedDate, totalYearsWorkExperience, maritalStatus, tickerSymbol, logoImageUrl, groupName, groupNameLocal, numEmployees, officeSiteName, annualRevenue, extension, comments, verified, monthsWithContactMech, contactMechId, thruDate, fromDate, allowSolicitation, yearsWithContactMech, infoString, contactMechTypeId, paCountryGeoId, paHouseNumberExt, paAddress2, paCity, paAddress1, paPostalCode, paPostalCodeGeoId, paHouseNumber, paPostalCodeExt, paContactMechId, paAttnName, paDirections, paCountyGeoId, paToName, paCityGeoId, paMunicipalityGeoId, paStateProvinceGeoId, paGeoPointId, tnAreaCode, tnAskForName, tnCountryCode, tnContactNumber, tnContactMechId
	}

	public PartyRoleAndContactMechDetail(GenericValue value) {
		personComments = (String) value.get(Fields.personComments.name());
		partyGroupComments = (String) value.get(Fields.partyGroupComments
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		externalId = (String) value.get(Fields.externalId.name());
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
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		yearsWithEmployer = (Long) value.get(Fields.yearsWithEmployer.name());
		lastName = (String) value.get(Fields.lastName.name());
		occupation = (String) value.get(Fields.occupation.name());
		gender = (String) value.get(Fields.gender.name());
		employmentStatusEnumId = (String) value
				.get(Fields.employmentStatusEnumId.name());
		socialSecurityNumber = (String) value.get(Fields.socialSecurityNumber
				.name());
		suffix = (String) value.get(Fields.suffix.name());
		mothersMaidenName = (String) value.get(Fields.mothersMaidenName.name());
		middleNameLocal = (String) value.get(Fields.middleNameLocal.name());
		existingCustomer = (String) value.get(Fields.existingCustomer.name());
		residenceStatusEnumId = (String) value.get(Fields.residenceStatusEnumId
				.name());
		nickname = (String) value.get(Fields.nickname.name());
		memberId = (String) value.get(Fields.memberId.name());
		height = (Double) value.get(Fields.height.name());
		passportNumber = (String) value.get(Fields.passportNumber.name());
		lastNameLocal = (String) value.get(Fields.lastNameLocal.name());
		monthsWithEmployer = (Long) value.get(Fields.monthsWithEmployer.name());
		weight = (Double) value.get(Fields.weight.name());
		birthDate = (Date) value.get(Fields.birthDate.name());
		otherLocal = (String) value.get(Fields.otherLocal.name());
		firstName = (String) value.get(Fields.firstName.name());
		cardId = (String) value.get(Fields.cardId.name());
		middleName = (String) value.get(Fields.middleName.name());
		firstNameLocal = (String) value.get(Fields.firstNameLocal.name());
		passportExpireDate = (Date) value.get(Fields.passportExpireDate.name());
		salutation = (String) value.get(Fields.salutation.name());
		personalTitle = (String) value.get(Fields.personalTitle.name());
		deceasedDate = (Date) value.get(Fields.deceasedDate.name());
		totalYearsWorkExperience = (Double) value
				.get(Fields.totalYearsWorkExperience.name());
		maritalStatus = (String) value.get(Fields.maritalStatus.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
		officeSiteName = (String) value.get(Fields.officeSiteName.name());
		annualRevenue = (BigDecimal) value.get(Fields.annualRevenue.name());
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