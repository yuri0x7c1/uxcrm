package org.apache.ofbiz.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.ofbiz.common.theme.VisualTheme;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.service.LocalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Prepare Find
 */
@Component
@Slf4j
public class PrepareFindService implements Serializable {

	public static final long serialVersionUID = 895520504585652224L;
	public static final String NAME = "prepareFind";
	@Autowired
	private LocalDispatcher dispatcher;

	@NoArgsConstructor
	public static class In {
		/**
		 * Entity Name
		 */
		@Getter
		@Setter
		private String entityName;
		/**
		 * Input Fields
		 */
		@Getter
		@Setter
		private Map inputFields;
		/**
		 * Order By
		 */
		@Getter
		@Setter
		private String orderBy;
		/**
		 * No Condition Find
		 */
		@Getter
		@Setter
		private String noConditionFind;
		/**
		 * Filter By Date
		 */
		@Getter
		@Setter
		private String filterByDate;
		/**
		 * Filter By Date Value
		 */
		@Getter
		@Setter
		private Timestamp filterByDateValue;
		/**
		 * From Date Name
		 */
		@Getter
		@Setter
		private String fromDateName;
		/**
		 * Thru Date Name
		 */
		@Getter
		@Setter
		private String thruDateName;
		/**
		 * User Login
		 */
		@Getter
		@Setter
		private GenericValue userLogin;
		/**
		 * Login . Username
		 */
		@Getter
		@Setter
		private String loginUsername;
		/**
		 * Login . Password
		 */
		@Getter
		@Setter
		private String loginPassword;
		/**
		 * Locale
		 */
		@Getter
		@Setter
		private Locale locale;
		/**
		 * Time Zone
		 */
		@Getter
		@Setter
		private TimeZone timeZone;

		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("entityName", entityName);
			map.put("inputFields", inputFields);
			map.put("orderBy", orderBy);
			map.put("noConditionFind", noConditionFind);
			map.put("filterByDate", filterByDate);
			map.put("filterByDateValue", filterByDateValue);
			map.put("fromDateName", fromDateName);
			map.put("thruDateName", thruDateName);
			map.put("userLogin", userLogin);
			map.put("login.username", loginUsername);
			map.put("login.password", loginPassword);
			map.put("locale", locale);
			map.put("timeZone", timeZone);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			entityName = (String) map.get("entityName");
			inputFields = (java.util.Map) map.get("inputFields");
			orderBy = (String) map.get("orderBy");
			noConditionFind = (String) map.get("noConditionFind");
			filterByDate = (String) map.get("filterByDate");
			filterByDateValue = (java.sql.Timestamp) map
					.get("filterByDateValue");
			fromDateName = (String) map.get("fromDateName");
			thruDateName = (String) map.get("thruDateName");
			userLogin = (org.apache.ofbiz.entity.GenericValue) map
					.get("userLogin");
			loginUsername = (String) map.get("login.username");
			loginPassword = (String) map.get("login.password");
			locale = (java.util.Locale) map.get("locale");
			timeZone = (java.util.TimeZone) map.get("timeZone");
		}

		public In(Map<String, Object> map) {
			fromMap(map);
		}
	}

	@NoArgsConstructor
	public static class Out {
		/**
		 * Entity Condition List
		 */
		@Getter
		@Setter
		private EntityConditionList entityConditionList;
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
		 * Order By List
		 */
		@Getter
		@Setter
		private List orderByList;
		/**
		 * Query String
		 */
		@Getter
		@Setter
		private String queryString;
		/**
		 * Query String Map
		 */
		@Getter
		@Setter
		private Map queryStringMap;
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
		/**
		 * Visual Theme
		 */
		@Getter
		@Setter
		private VisualTheme visualTheme;

		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("entityConditionList", entityConditionList);
			map.put("errorMessage", errorMessage);
			map.put("errorMessageList", errorMessageList);
			map.put("locale", locale);
			map.put("orderByList", orderByList);
			map.put("queryString", queryString);
			map.put("queryStringMap", queryStringMap);
			map.put("responseMessage", responseMessage);
			map.put("successMessage", successMessage);
			map.put("successMessageList", successMessageList);
			map.put("timeZone", timeZone);
			map.put("userLogin", userLogin);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			Out result = new Out();
			entityConditionList = (org.apache.ofbiz.entity.condition.EntityConditionList) map
					.get("entityConditionList");
			errorMessage = (String) map.get("errorMessage");
			errorMessageList = (java.util.List) map.get("errorMessageList");
			locale = (java.util.Locale) map.get("locale");
			orderByList = (java.util.List) map.get("orderByList");
			queryString = (String) map.get("queryString");
			queryStringMap = (java.util.Map) map.get("queryStringMap");
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