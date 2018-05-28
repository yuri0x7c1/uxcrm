package org.apache.ofbiz.humanres.employment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.sql.Date;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Employment And Person
 */
public class EmploymentAndPerson implements Serializable {

	public static final long serialVersionUID = 4063097425192457216L;
	public static final String NAME = "EmploymentAndPerson";
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
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Termination Reason Id
	 */
	@Getter
	@Setter
	private String terminationReasonId;
	/**
	 * Termination Type Id
	 */
	@Getter
	@Setter
	private String terminationTypeId;
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
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
		roleTypeIdTo, fromDate, partyIdFrom, terminationReasonId, terminationTypeId, partyIdTo, roleTypeIdFrom, thruDate, yearsWithEmployer, lastName, occupation, gender, employmentStatusEnumId, socialSecurityNumber, suffix, mothersMaidenName, middleNameLocal, existingCustomer, residenceStatusEnumId, nickname, partyId, memberId, height, passportNumber, lastNameLocal, comments, monthsWithEmployer, weight, birthDate, otherLocal, firstName, cardId, middleName, firstNameLocal, passportExpireDate, salutation, personalTitle, deceasedDate, totalYearsWorkExperience, maritalStatus
	}

	public EmploymentAndPerson(GenericValue value) {
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		terminationReasonId = (String) value.get(Fields.terminationReasonId
				.name());
		terminationTypeId = (String) value.get(Fields.terminationTypeId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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
		partyId = (String) value.get(Fields.partyId.name());
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

	public static EmploymentAndPerson fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmploymentAndPerson(value);
	}

	public static List<EmploymentAndPerson> fromValues(List<GenericValue> values) {
		List<EmploymentAndPerson> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmploymentAndPerson(value));
		}
		return entities;
	}
}