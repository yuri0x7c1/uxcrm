package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Person
 */
@FieldNameConstants
public class Person implements Serializable {

	public static final long serialVersionUID = 3629346668989191168L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public Person(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		salutation = (String) value.get(FIELD_SALUTATION);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
		personalTitle = (String) value.get(FIELD_PERSONAL_TITLE);
		suffix = (String) value.get(FIELD_SUFFIX);
		nickname = (String) value.get(FIELD_NICKNAME);
		firstNameLocal = (String) value.get(FIELD_FIRST_NAME_LOCAL);
		middleNameLocal = (String) value.get(FIELD_MIDDLE_NAME_LOCAL);
		lastNameLocal = (String) value.get(FIELD_LAST_NAME_LOCAL);
		otherLocal = (String) value.get(FIELD_OTHER_LOCAL);
		memberId = (String) value.get(FIELD_MEMBER_ID);
		gender = (String) value.get(FIELD_GENDER);
		birthDate = (Date) value.get(FIELD_BIRTH_DATE);
		deceasedDate = (Date) value.get(FIELD_DECEASED_DATE);
		height = (Double) value.get(FIELD_HEIGHT);
		weight = (Double) value.get(FIELD_WEIGHT);
		mothersMaidenName = (String) value.get(FIELD_MOTHERS_MAIDEN_NAME);
		maritalStatus = (String) value.get(FIELD_MARITAL_STATUS);
		socialSecurityNumber = (String) value.get(FIELD_SOCIAL_SECURITY_NUMBER);
		passportNumber = (String) value.get(FIELD_PASSPORT_NUMBER);
		passportExpireDate = (Date) value.get(FIELD_PASSPORT_EXPIRE_DATE);
		totalYearsWorkExperience = (Double) value
				.get(FIELD_TOTAL_YEARS_WORK_EXPERIENCE);
		comments = (String) value.get(FIELD_COMMENTS);
		employmentStatusEnumId = (String) value
				.get(FIELD_EMPLOYMENT_STATUS_ENUM_ID);
		residenceStatusEnumId = (String) value
				.get(FIELD_RESIDENCE_STATUS_ENUM_ID);
		occupation = (String) value.get(FIELD_OCCUPATION);
		yearsWithEmployer = (Long) value.get(FIELD_YEARS_WITH_EMPLOYER);
		monthsWithEmployer = (Long) value.get(FIELD_MONTHS_WITH_EMPLOYER);
		existingCustomer = (String) value.get(FIELD_EXISTING_CUSTOMER);
		cardId = (String) value.get(FIELD_CARD_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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