package org.apache.ofbiz.common;

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
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.GenericValue;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.ofbiz.widget.renderer.VisualTheme;
import org.apache.ofbiz.entity.util.EntityListIterator;

/**
 * Execute Find
 */
@Component
@Slf4j
public class ExecuteFindService implements Serializable {

	public static final long serialVersionUID = 6240672083839978496L;
	public static final String NAME = "executeFind";
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
		 * Field List
		 */
		@Getter
		@Setter
		private List fieldList;
		/**
		 * Order By List
		 */
		@Getter
		@Setter
		private List orderByList;
		/**
		 * Max Rows
		 */
		@Getter
		@Setter
		private Integer maxRows;
		/**
		 * Entity Condition List
		 */
		@Getter
		@Setter
		private EntityConditionList entityConditionList;
		/**
		 * No Condition Find
		 */
		@Getter
		@Setter
		private String noConditionFind;
		/**
		 * Distinct
		 */
		@Getter
		@Setter
		private String distinct;
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
		/**
		 * Visual Theme
		 */
		@Getter
		@Setter
		private VisualTheme visualTheme;

		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("entityName", entityName);
			map.put("fieldList", fieldList);
			map.put("orderByList", orderByList);
			map.put("maxRows", maxRows);
			map.put("entityConditionList", entityConditionList);
			map.put("noConditionFind", noConditionFind);
			map.put("distinct", distinct);
			map.put("userLogin", userLogin);
			map.put("login.username", loginUsername);
			map.put("login.password", loginPassword);
			map.put("locale", locale);
			map.put("timeZone", timeZone);
			map.put("visualTheme", visualTheme);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			entityName = (String) map.get("entityName");
			fieldList = (java.util.List) map.get("fieldList");
			orderByList = (java.util.List) map.get("orderByList");
			maxRows = (Integer) map.get("maxRows");
			entityConditionList = (org.apache.ofbiz.entity.condition.EntityConditionList) map
					.get("entityConditionList");
			noConditionFind = (String) map.get("noConditionFind");
			distinct = (String) map.get("distinct");
			userLogin = (org.apache.ofbiz.entity.GenericValue) map
					.get("userLogin");
			loginUsername = (String) map.get("login.username");
			loginPassword = (String) map.get("login.password");
			locale = (java.util.Locale) map.get("locale");
			timeZone = (java.util.TimeZone) map.get("timeZone");
			visualTheme = (org.apache.ofbiz.widget.renderer.VisualTheme) map
					.get("visualTheme");
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
		 * List It
		 */
		@Getter
		@Setter
		private EntityListIterator listIt;
		/**
		 * List Size
		 */
		@Getter
		@Setter
		private Integer listSize;
		/**
		 * Locale
		 */
		@Getter
		@Setter
		private Locale locale;
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
			map.put("errorMessage", errorMessage);
			map.put("errorMessageList", errorMessageList);
			map.put("listIt", listIt);
			map.put("listSize", listSize);
			map.put("locale", locale);
			map.put("responseMessage", responseMessage);
			map.put("successMessage", successMessage);
			map.put("successMessageList", successMessageList);
			map.put("timeZone", timeZone);
			map.put("userLogin", userLogin);
			map.put("visualTheme", visualTheme);
			return map;
		}

		public void fromMap(Map<String, Object> map) {
			Out result = new Out();
			errorMessage = (String) map.get("errorMessage");
			errorMessageList = (java.util.List) map.get("errorMessageList");
			listIt = (org.apache.ofbiz.entity.util.EntityListIterator) map
					.get("listIt");
			listSize = (Integer) map.get("listSize");
			locale = (java.util.Locale) map.get("locale");
			responseMessage = (String) map.get("responseMessage");
			successMessage = (String) map.get("successMessage");
			successMessageList = (java.util.List) map.get("successMessageList");
			timeZone = (java.util.TimeZone) map.get("timeZone");
			userLogin = (org.apache.ofbiz.entity.GenericValue) map
					.get("userLogin");
			visualTheme = (org.apache.ofbiz.widget.renderer.VisualTheme) map
					.get("visualTheme");
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