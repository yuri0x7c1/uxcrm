package org.apache.ofbiz.party.party;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party And Person
 */
public class PartyAndPerson implements Serializable {

	public static final long serialVersionUID = 8125329645785458688L;
	public static final String NAME = "PartyAndPerson";
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
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public enum Fields {
		lastModifiedDate, externalId, description, isUnread, partyTypeId, lastModifiedByUserLogin, dataSourceId, createdDate, statusId, preferredCurrencyUomId, partyId, createdByUserLogin, yearsWithEmployer, lastName, occupation, gender, employmentStatusEnumId, socialSecurityNumber, suffix, mothersMaidenName, middleNameLocal, existingCustomer, residenceStatusEnumId, nickname, memberId, height, passportNumber, lastNameLocal, comments, monthsWithEmployer, weight, birthDate, otherLocal, firstName, cardId, middleName, firstNameLocal, passportExpireDate, salutation, personalTitle, deceasedDate, totalYearsWorkExperience, maritalStatus
	}

	public PartyAndPerson(GenericValue value) {
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
		comments = (String) value.get(Fields.comments.name());
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
	}

	public static PartyAndPerson fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndPerson(value);
	}

	public static List<PartyAndPerson> fromValues(List<GenericValue> values) {
		List<PartyAndPerson> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndPerson(value));
		}
		return entities;
	}
}