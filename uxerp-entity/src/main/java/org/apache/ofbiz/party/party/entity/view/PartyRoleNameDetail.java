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
 * Party Role Name Detail
 */
public class PartyRoleNameDetail implements Serializable {

	public static final long serialVersionUID = 7023370134305250304L;
	public static final String NAME = "PartyRoleNameDetail";
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

	public enum Fields {
		partyId, partyTypeId, externalId, preferredCurrencyUomId, description, statusId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, dataSourceId, isUnread, roleTypeId, salutation, firstName, middleName, lastName, personalTitle, suffix, nickname, firstNameLocal, middleNameLocal, lastNameLocal, otherLocal, memberId, gender, birthDate, deceasedDate, height, weight, mothersMaidenName, maritalStatus, socialSecurityNumber, passportNumber, passportExpireDate, totalYearsWorkExperience, comments, employmentStatusEnumId, residenceStatusEnumId, occupation, yearsWithEmployer, monthsWithEmployer, existingCustomer, cardId, groupName, groupNameLocal, officeSiteName, annualRevenue, numEmployees, tickerSymbol, logoImageUrl
	}

	public PartyRoleNameDetail(GenericValue value) {
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
	}

	public static PartyRoleNameDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyRoleNameDetail(value);
	}

	public static List<PartyRoleNameDetail> fromValues(List<GenericValue> values) {
		List<PartyRoleNameDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyRoleNameDetail(value));
		}
		return entities;
	}
}