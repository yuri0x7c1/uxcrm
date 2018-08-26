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
import java.math.BigDecimal;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.ofbiz.entity.GenericValue;

/**
 * Create Party Group
 */
@Service
@Slf4j
public class CreatePartyGroupService implements Serializable {

	public static final long serialVersionUID = 8413375832610137088L;
	public static final String NAME = "createPartyGroup";
	@Autowired
	private LocalDispatcher dispatcher;

	@NoArgsConstructor
	public static class In {
		/**
		 * Annual Revenue
		 */
		@Getter
		@Setter
		private BigDecimal annualRevenue;
		/**
		 * Comments
		 */
		@Getter
		@Setter
		private String comments;
		/**
		 * Description
		 */
		@Getter
		@Setter
		private String description;
		/**
		 * External Id
		 */
		@Getter
		@Setter
		private String externalId;
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
		 * Logo Image Url
		 */
		@Getter
		@Setter
		private String logoImageUrl;
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
		 * Preferred Currency Uom Id
		 */
		@Getter
		@Setter
		private String preferredCurrencyUomId;
		/**
		 * Status Id
		 */
		@Getter
		@Setter
		private String statusId;
		/**
		 * Ticker Symbol
		 */
		@Getter
		@Setter
		private String tickerSymbol;
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
			map.put("annualRevenue", annualRevenue);
			map.put("comments", comments);
			map.put("description", description);
			map.put("externalId", externalId);
			map.put("groupName", groupName);
			map.put("groupNameLocal", groupNameLocal);
			map.put("locale", locale);
			map.put("login.password", loginPassword);
			map.put("login.username", loginUsername);
			map.put("logoImageUrl", logoImageUrl);
			map.put("numEmployees", numEmployees);
			map.put("officeSiteName", officeSiteName);
			map.put("partyId", partyId);
			map.put("partyTypeId", partyTypeId);
			map.put("preferredCurrencyUomId", preferredCurrencyUomId);
			map.put("statusId", statusId);
			map.put("tickerSymbol", tickerSymbol);
			map.put("timeZone", timeZone);
			map.put("userLogin", userLogin);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			annualRevenue = (java.math.BigDecimal) map.get("annualRevenue");
			comments = (String) map.get("comments");
			description = (String) map.get("description");
			externalId = (String) map.get("externalId");
			groupName = (String) map.get("groupName");
			groupNameLocal = (String) map.get("groupNameLocal");
			locale = (java.util.Locale) map.get("locale");
			loginPassword = (String) map.get("login.password");
			loginUsername = (String) map.get("login.username");
			logoImageUrl = (String) map.get("logoImageUrl");
			numEmployees = (Long) map.get("numEmployees");
			officeSiteName = (String) map.get("officeSiteName");
			partyId = (String) map.get("partyId");
			partyTypeId = (String) map.get("partyTypeId");
			preferredCurrencyUomId = (String) map.get("preferredCurrencyUomId");
			statusId = (String) map.get("statusId");
			tickerSymbol = (String) map.get("tickerSymbol");
			timeZone = (java.util.TimeZone) map.get("timeZone");
			userLogin = (org.apache.ofbiz.entity.GenericValue) map
					.get("userLogin");
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