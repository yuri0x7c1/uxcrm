package org.apache.ofbiz.party.party;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import org.apache.ofbiz.service.LocalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.ofbiz.entity.GenericValue;

/**
 * Create Person
 */
@Service
@Slf4j
public class CreatePersonService implements Serializable {

	public static final long serialVersionUID = 1117866654671563776L;
	public static final String NAME = "createPerson";
	@Autowired
	private LocalDispatcher dispatcher;

	@NoArgsConstructor
	public static class In {
		/**
		 * Birth Date
		 */
		@Getter
		@Setter
		private Date birthDate;
		/**
		 * Card Id
		 */
		@Getter
		@Setter
		private String cardId;
		/**
		 * Comments
		 */
		@Getter
		@Setter
		private String comments;
		/**
		 * Deceased Date
		 */
		@Getter
		@Setter
		private Date deceasedDate;
		/**
		 * Description
		 */
		@Getter
		@Setter
		private String description;
		/**
		 * Employment Status Enum Id
		 */
		@Getter
		@Setter
		private String employmentStatusEnumId;
		/**
		 * Existing Customer
		 */
		@Getter
		@Setter
		private String existingCustomer;
		/**
		 * External Id
		 */
		@Getter
		@Setter
		private String externalId;
		/**
		 * First Name
		 */
		@Getter
		@Setter
		private String firstName;
		/**
		 * First Name Local
		 */
		@Getter
		@Setter
		private String firstNameLocal;
		/**
		 * Gender
		 */
		@Getter
		@Setter
		private String gender;
		/**
		 * Height
		 */
		@Getter
		@Setter
		private Double height;
		/**
		 * Last Name
		 */
		@Getter
		@Setter
		private String lastName;
		/**
		 * Last Name Local
		 */
		@Getter
		@Setter
		private String lastNameLocal;
		/**
		 * Locale
		 */
		@Getter
		@Setter
		private Locale locale;
		/**
		 * Login . Password
		 */
		@Getter
		@Setter
		private String loginPassword;
		/**
		 * Login . Username
		 */
		@Getter
		@Setter
		private String loginUsername;
		/**
		 * Marital Status
		 */
		@Getter
		@Setter
		private String maritalStatus;
		/**
		 * Member Id
		 */
		@Getter
		@Setter
		private String memberId;
		/**
		 * Middle Name
		 */
		@Getter
		@Setter
		private String middleName;
		/**
		 * Middle Name Local
		 */
		@Getter
		@Setter
		private String middleNameLocal;
		/**
		 * Months With Employer
		 */
		@Getter
		@Setter
		private Long monthsWithEmployer;
		/**
		 * Mothers Maiden Name
		 */
		@Getter
		@Setter
		private String mothersMaidenName;
		/**
		 * Nickname
		 */
		@Getter
		@Setter
		private String nickname;
		/**
		 * Occupation
		 */
		@Getter
		@Setter
		private String occupation;
		/**
		 * Other Local
		 */
		@Getter
		@Setter
		private String otherLocal;
		/**
		 * Party Id
		 */
		@Getter
		@Setter
		private String partyId;
		/**
		 * Passport Expire Date
		 */
		@Getter
		@Setter
		private Date passportExpireDate;
		/**
		 * Passport Number
		 */
		@Getter
		@Setter
		private String passportNumber;
		/**
		 * Personal Title
		 */
		@Getter
		@Setter
		private String personalTitle;
		/**
		 * Preferred Currency Uom Id
		 */
		@Getter
		@Setter
		private String preferredCurrencyUomId;
		/**
		 * Residence Status Enum Id
		 */
		@Getter
		@Setter
		private String residenceStatusEnumId;
		/**
		 * Salutation
		 */
		@Getter
		@Setter
		private String salutation;
		/**
		 * Social Security Number
		 */
		@Getter
		@Setter
		private String socialSecurityNumber;
		/**
		 * Status Id
		 */
		@Getter
		@Setter
		private String statusId;
		/**
		 * Suffix
		 */
		@Getter
		@Setter
		private String suffix;
		/**
		 * Time Zone
		 */
		@Getter
		@Setter
		private TimeZone timeZone;
		/**
		 * Total Years Work Experience
		 */
		@Getter
		@Setter
		private Double totalYearsWorkExperience;
		/**
		 * User Login
		 */
		@Getter
		@Setter
		private GenericValue userLogin;
		/**
		 * Weight
		 */
		@Getter
		@Setter
		private Double weight;
		/**
		 * Years With Employer
		 */
		@Getter
		@Setter
		private Long yearsWithEmployer;

		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("birthDate", birthDate);
			map.put("cardId", cardId);
			map.put("comments", comments);
			map.put("deceasedDate", deceasedDate);
			map.put("description", description);
			map.put("employmentStatusEnumId", employmentStatusEnumId);
			map.put("existingCustomer", existingCustomer);
			map.put("externalId", externalId);
			map.put("firstName", firstName);
			map.put("firstNameLocal", firstNameLocal);
			map.put("gender", gender);
			map.put("height", height);
			map.put("lastName", lastName);
			map.put("lastNameLocal", lastNameLocal);
			map.put("locale", locale);
			map.put("login.password", loginPassword);
			map.put("login.username", loginUsername);
			map.put("maritalStatus", maritalStatus);
			map.put("memberId", memberId);
			map.put("middleName", middleName);
			map.put("middleNameLocal", middleNameLocal);
			map.put("monthsWithEmployer", monthsWithEmployer);
			map.put("mothersMaidenName", mothersMaidenName);
			map.put("nickname", nickname);
			map.put("occupation", occupation);
			map.put("otherLocal", otherLocal);
			map.put("partyId", partyId);
			map.put("passportExpireDate", passportExpireDate);
			map.put("passportNumber", passportNumber);
			map.put("personalTitle", personalTitle);
			map.put("preferredCurrencyUomId", preferredCurrencyUomId);
			map.put("residenceStatusEnumId", residenceStatusEnumId);
			map.put("salutation", salutation);
			map.put("socialSecurityNumber", socialSecurityNumber);
			map.put("statusId", statusId);
			map.put("suffix", suffix);
			map.put("timeZone", timeZone);
			map.put("totalYearsWorkExperience", totalYearsWorkExperience);
			map.put("userLogin", userLogin);
			map.put("weight", weight);
			map.put("yearsWithEmployer", yearsWithEmployer);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			birthDate = (java.sql.Date) map.get("birthDate");
			cardId = (String) map.get("cardId");
			comments = (String) map.get("comments");
			deceasedDate = (java.sql.Date) map.get("deceasedDate");
			description = (String) map.get("description");
			employmentStatusEnumId = (String) map.get("employmentStatusEnumId");
			existingCustomer = (String) map.get("existingCustomer");
			externalId = (String) map.get("externalId");
			firstName = (String) map.get("firstName");
			firstNameLocal = (String) map.get("firstNameLocal");
			gender = (String) map.get("gender");
			height = (Double) map.get("height");
			lastName = (String) map.get("lastName");
			lastNameLocal = (String) map.get("lastNameLocal");
			locale = (java.util.Locale) map.get("locale");
			loginPassword = (String) map.get("login.password");
			loginUsername = (String) map.get("login.username");
			maritalStatus = (String) map.get("maritalStatus");
			memberId = (String) map.get("memberId");
			middleName = (String) map.get("middleName");
			middleNameLocal = (String) map.get("middleNameLocal");
			monthsWithEmployer = (Long) map.get("monthsWithEmployer");
			mothersMaidenName = (String) map.get("mothersMaidenName");
			nickname = (String) map.get("nickname");
			occupation = (String) map.get("occupation");
			otherLocal = (String) map.get("otherLocal");
			partyId = (String) map.get("partyId");
			passportExpireDate = (java.sql.Date) map.get("passportExpireDate");
			passportNumber = (String) map.get("passportNumber");
			personalTitle = (String) map.get("personalTitle");
			preferredCurrencyUomId = (String) map.get("preferredCurrencyUomId");
			residenceStatusEnumId = (String) map.get("residenceStatusEnumId");
			salutation = (String) map.get("salutation");
			socialSecurityNumber = (String) map.get("socialSecurityNumber");
			statusId = (String) map.get("statusId");
			suffix = (String) map.get("suffix");
			timeZone = (java.util.TimeZone) map.get("timeZone");
			totalYearsWorkExperience = (Double) map
					.get("totalYearsWorkExperience");
			userLogin = (org.apache.ofbiz.entity.GenericValue) map
					.get("userLogin");
			weight = (Double) map.get("weight");
			yearsWithEmployer = (Long) map.get("yearsWithEmployer");
		}

		public In(Map<String, Object> map) {
			fromMap(map);
		}
	}

	@NoArgsConstructor
	public static class Out {
		/**
		 * Error Message
		 */
		@Getter
		@Setter
		private String errorMessage;
		/**
		 * Error Message List
		 */
		@Getter
		@Setter
		private List errorMessageList;
		/**
		 * Locale
		 */
		@Getter
		@Setter
		private Locale locale;
		/**
		 * Party Id
		 */
		@Getter
		@Setter
		private String partyId;
		/**
		 * Response Message
		 */
		@Getter
		@Setter
		private String responseMessage;
		/**
		 * Success Message
		 */
		@Getter
		@Setter
		private String successMessage;
		/**
		 * Success Message List
		 */
		@Getter
		@Setter
		private List successMessageList;
		/**
		 * Time Zone
		 */
		@Getter
		@Setter
		private TimeZone timeZone;
		/**
		 * User Login
		 */
		@Getter
		@Setter
		private GenericValue userLogin;

		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errorMessage", errorMessage);
			map.put("errorMessageList", errorMessageList);
			map.put("locale", locale);
			map.put("partyId", partyId);
			map.put("responseMessage", responseMessage);
			map.put("successMessage", successMessage);
			map.put("successMessageList", successMessageList);
			map.put("timeZone", timeZone);
			map.put("userLogin", userLogin);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			errorMessage = (String) map.get("errorMessage");
			errorMessageList = (java.util.List) map.get("errorMessageList");
			locale = (java.util.Locale) map.get("locale");
			partyId = (String) map.get("partyId");
			responseMessage = (String) map.get("responseMessage");
			successMessage = (String) map.get("successMessage");
			successMessageList = (java.util.List) map.get("successMessageList");
			timeZone = (java.util.TimeZone) map.get("timeZone");
			userLogin = (org.apache.ofbiz.entity.GenericValue) map
					.get("userLogin");
		}

		public Out(Map<String, Object> map) {
			fromMap(map);
		}
	}

	public Out runSync(In in) {
		Map<String, Object> result = null;
		try {
			result = dispatcher.runSync(NAME, in.toMap());
		} catch (Exception e) {
			log.error("Error", e);
		}
		return new Out(result);
	}
}