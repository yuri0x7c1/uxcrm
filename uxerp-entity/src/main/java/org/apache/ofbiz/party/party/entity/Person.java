package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Person
 */
public class Person implements Serializable {

	public static final long serialVersionUID = 5520253234094297088L;
	public static final String NAME = "Person";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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

	public enum Fields {
		partyId, salutation, firstName, middleName, lastName, personalTitle, suffix, nickname, firstNameLocal, middleNameLocal, lastNameLocal, otherLocal, memberId, gender, birthDate, deceasedDate, height, weight, mothersMaidenName, maritalStatus, socialSecurityNumber, passportNumber, passportExpireDate, totalYearsWorkExperience, comments, employmentStatusEnumId, residenceStatusEnumId, occupation, yearsWithEmployer, monthsWithEmployer, existingCustomer, cardId
	}

	public Person(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
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
	}

	public static Person fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Person(value);
	}

	public static List<Person> fromValues(List<GenericValue> values) {
		List<Person> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Person(value));
		}
		return entities;
	}
}