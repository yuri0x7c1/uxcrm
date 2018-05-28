package org.apache.ofbiz.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import org.apache.ofbiz.service.LocalDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.sql.Timestamp;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.collections.MapUtils;
import org.apache.ofbiz.entity.GenericValue;

/**
 * Perform Find List
 */
@Component
@Slf4j
public class PerformFindListService implements Serializable {

	public static final long serialVersionUID = 3769828294724243456L;
	public static final String NAME = "performFindList";
	@Autowired
	private LocalDispatcher dispatcher;

	@Builder
	@AllArgsConstructor
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
		 * View Index
		 */
		@Getter
		@Setter
		private Integer viewIndex;
		/**
		 * View Size
		 */
		@Getter
		@Setter
		private Integer viewSize;
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
			map.put("entityName", entityName);
			map.put("inputFields", inputFields);
			map.put("orderBy", orderBy);
			map.put("noConditionFind", noConditionFind);
			map.put("filterByDate", filterByDate);
			map.put("filterByDateValue", filterByDateValue);
			map.put("viewIndex", viewIndex);
			map.put("viewSize", viewSize);
			map.put("locale", locale);
			map.put("login.password", loginPassword);
			map.put("login.username", loginUsername);
			map.put("timeZone", timeZone);
			map.put("userLogin", userLogin);
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
			viewIndex = (Integer) map.get("viewIndex");
			viewSize = (Integer) map.get("viewSize");
			locale = (java.util.Locale) map.get("locale");
			loginPassword = (String) map.get("login.password");
			loginUsername = (String) map.get("login.username");
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
		 * List
		 */
		@Getter
		@Setter
		private List list;
		/**
		 * List Size
		 */
		@Getter
		@Setter
		private Integer listSize;
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
		private List<String> errorMessageList;
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
		private List<String> successMessageList;

		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("listSize", listSize);
			map.put("queryString", queryString);
			map.put("queryStringMap", queryStringMap);
			map.put("errorMessage", errorMessage);
			map.put("errorMessageList", errorMessageList);
			map.put("responseMessage", responseMessage);
			map.put("successMessage", successMessage);
			map.put("successMessageList", successMessageList);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			if (map.get("list") != null) {
				list = (java.util.List) map.get("list");
			}
			listSize = (Integer) map.get("listSize");
			queryString = (String) map.get("queryString");
			queryStringMap = (java.util.Map) map.get("queryStringMap");
			errorMessage = (String) map.get("errorMessage");
			errorMessageList = (List<String>) map.get("errorMessageList");
			responseMessage = (String) map.get("responseMessage");
			successMessage = (String) map.get("successMessage");
			successMessageList = (List<String>) map.get("successMessageList");
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