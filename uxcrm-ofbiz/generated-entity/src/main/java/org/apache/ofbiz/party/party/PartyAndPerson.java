package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyAndPerson implements Serializable {

	public static final long serialVersionUID = 5807518075372006400L;
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

	public PartyAndPerson(GenericValue value) {
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
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
		comments = (String) value.get(FIELD_COMMENTS);
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