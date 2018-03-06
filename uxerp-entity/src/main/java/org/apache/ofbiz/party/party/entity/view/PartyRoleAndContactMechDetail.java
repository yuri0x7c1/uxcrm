package org.apache.ofbiz.party.party.entity.view;

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

	public static final long serialVersionUID = 8455320400733464576L;
	public static final String NAME = "PartyRoleAndContactMechDetail";
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
	 * Salutation
	 */
	@Getter
	@Setter
	private String salutation;
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
	 * Nickname
	 */
	@Getter
	@Setter
	private String nickname;
	/**
	 * First Name Local
	 */
	@Getter
	@Setter
	private String firstNameLocal;
	/**
	 * Middle Name Local
	 */
	@Getter
	@Setter
	private String middleNameLocal;
	/**
	 * Last Name Local
	 */
	@Getter
	@Setter
	private String lastNameLocal;
	/**
	 * Other Local
	 */
	@Getter
	@Setter
	private String otherLocal;
	/**
	 * Member Id
	 */
	@Getter
	@Setter
	private String memberId;
	/**
	 * Gender
	 */
	@Getter
	@Setter
	private String gender;
	/**
	 * Birth Date
	 */
	@Getter
	@Setter
	private Date birthDate;
	/**
	 * Deceased Date
	 */
	@Getter
	@Setter
	private Date deceasedDate;
	/**
	 * Height
	 */
	@Getter
	@Setter
	private Double height;
	/**
	 * Weight
	 */
	@Getter
	@Setter
	private Double weight;
	/**
	 * Mothers Maiden Name
	 */
	@Getter
	@Setter
	private String mothersMaidenName;
	/**
	 * Marital Status
	 */
	@Getter
	@Setter
	private String maritalStatus;
	/**
	 * Social Security Number
	 */
	@Getter
	@Setter
	private String socialSecurityNumber;
	/**
	 * Passport Number
	 */
	@Getter
	@Setter
	private String passportNumber;
	/**
	 * Passport Expire Date
	 */
	@Getter
	@Setter
	private Date passportExpireDate;
	/**
	 * Total Years Work Experience
	 */
	@Getter
	@Setter
	private Double totalYearsWorkExperience;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Employment Status Enum Id
	 */
	@Getter
	@Setter
	private String employmentStatusEnumId;
	/**
	 * Residence Status Enum Id
	 */
	@Getter
	@Setter
	private String residenceStatusEnumId;
	/**
	 * Occupation
	 */
	@Getter
	@Setter
	private String occupation;
	/**
	 * Years With Employer
	 */
	@Getter
	@Setter
	private Long yearsWithEmployer;
	/**
	 * Months With Employer
	 */
	@Getter
	@Setter
	private Long monthsWithEmployer;
	/**
	 * Existing Customer
	 */
	@Getter
	@Setter
	private String existingCustomer;
	/**
	 * Card Id
	 */
	@Getter
	@Setter
	private String cardId;
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
	 * Num Employees
	 */
	@Getter
	@Setter
	private Long numEmployees;
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
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Allow Solicitation
	 */
	@Getter
	@Setter
	private String allowSolicitation;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Verified
	 */
	@Getter
	@Setter
	private String verified;
	/**
	 * Years With Contact Mech
	 */
	@Getter
	@Setter
	private Long yearsWithContactMech;
	/**
	 * Months With Contact Mech
	 */
	@Getter
	@Setter
	private Long monthsWithContactMech;
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

	public enum Fields {
		partyId, partyTypeId, externalId, preferredCurrencyUomId, description, statusId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, dataSourceId, isUnread, roleTypeId, parentTypeId, hasTable, salutation, firstName, middleName, lastName, personalTitle, suffix, nickname, firstNameLocal, middleNameLocal, lastNameLocal, otherLocal, memberId, gender, birthDate, deceasedDate, height, weight, mothersMaidenName, maritalStatus, socialSecurityNumber, passportNumber, passportExpireDate, totalYearsWorkExperience, comments, employmentStatusEnumId, residenceStatusEnumId, occupation, yearsWithEmployer, monthsWithEmployer, existingCustomer, cardId, groupName, groupNameLocal, officeSiteName, annualRevenue, numEmployees, tickerSymbol, logoImageUrl, contactMechId, fromDate, thruDate, allowSolicitation, extension, verified, yearsWithContactMech, monthsWithContactMech, contactMechTypeId, infoString, toName, attnName, address1, address2, houseNumber, houseNumberExt, directions, city, cityGeoId, postalCode, postalCodeExt, countryGeoId, stateProvinceGeoId, countyGeoId, municipalityGeoId, postalCodeGeoId, geoPointId, countryCode, areaCode, contactNumber, askForName
	}

	public PartyRoleAndContactMechDetail(GenericValue value) {
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
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		salutation = (String) value.get(Fields.salutation.name());
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		personalTitle = (String) value.get(Fields.personalTitle.name());
		suffix = (String) value.get(Fields.suffix.name());
		nickname = (String) value.get(Fields.nickname.name());
		firstNameLocal = (String) value.get(Fields.firstNameLocal.name());
		middleNameLocal = (String) value.get(Fields.middleNameLocal.name());
		lastNameLocal = (String) value.get(Fields.lastNameLocal.name());
		otherLocal = (String) value.get(Fields.otherLocal.name());
		memberId = (String) value.get(Fields.memberId.name());
		gender = (String) value.get(Fields.gender.name());
		birthDate = (Date) value.get(Fields.birthDate.name());
		deceasedDate = (Date) value.get(Fields.deceasedDate.name());
		height = (Double) value.get(Fields.height.name());
		weight = (Double) value.get(Fields.weight.name());
		mothersMaidenName = (String) value.get(Fields.mothersMaidenName.name());
		maritalStatus = (String) value.get(Fields.maritalStatus.name());
		socialSecurityNumber = (String) value.get(Fields.socialSecurityNumber
				.name());
		passportNumber = (String) value.get(Fields.passportNumber.name());
		passportExpireDate = (Date) value.get(Fields.passportExpireDate.name());
		totalYearsWorkExperience = (Double) value
				.get(Fields.totalYearsWorkExperience.name());
		comments = (String) value.get(Fields.comments.name());
		employmentStatusEnumId = (String) value
				.get(Fields.employmentStatusEnumId.name());
		residenceStatusEnumId = (String) value.get(Fields.residenceStatusEnumId
				.name());
		occupation = (String) value.get(Fields.occupation.name());
		yearsWithEmployer = (Long) value.get(Fields.yearsWithEmployer.name());
		monthsWithEmployer = (Long) value.get(Fields.monthsWithEmployer.name());
		existingCustomer = (String) value.get(Fields.existingCustomer.name());
		cardId = (String) value.get(Fields.cardId.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		officeSiteName = (String) value.get(Fields.officeSiteName.name());
		annualRevenue = (BigDecimal) value.get(Fields.annualRevenue.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		allowSolicitation = (String) value.get(Fields.allowSolicitation.name());
		extension = (String) value.get(Fields.extension.name());
		verified = (String) value.get(Fields.verified.name());
		yearsWithContactMech = (Long) value.get(Fields.yearsWithContactMech
				.name());
		monthsWithContactMech = (Long) value.get(Fields.monthsWithContactMech
				.name());
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