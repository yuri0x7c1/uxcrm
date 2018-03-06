package org.apache.ofbiz.security.login.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login
 */
public class UserLogin implements Serializable {

	public static final long serialVersionUID = 9063780190748798976L;
	public static final String NAME = "UserLogin";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Current Password
	 */
	@Getter
	@Setter
	private String currentPassword;
	/**
	 * Password Hint
	 */
	@Getter
	@Setter
	private String passwordHint;
	/**
	 * Is System
	 */
	@Getter
	@Setter
	private String isSystem;
	/**
	 * Enabled
	 */
	@Getter
	@Setter
	private String enabled;
	/**
	 * Has Logged Out
	 */
	@Getter
	@Setter
	private String hasLoggedOut;
	/**
	 * Require Password Change
	 */
	@Getter
	@Setter
	private String requirePasswordChange;
	/**
	 * Last Currency Uom
	 */
	@Getter
	@Setter
	private String lastCurrencyUom;
	/**
	 * Last Locale
	 */
	@Getter
	@Setter
	private String lastLocale;
	/**
	 * Last Time Zone
	 */
	@Getter
	@Setter
	private String lastTimeZone;
	/**
	 * Disabled Date Time
	 */
	@Getter
	@Setter
	private Timestamp disabledDateTime;
	/**
	 * Successive Failed Logins
	 */
	@Getter
	@Setter
	private Long successiveFailedLogins;
	/**
	 * External Auth Id
	 */
	@Getter
	@Setter
	private String externalAuthId;
	/**
	 * User Ldap Dn
	 */
	@Getter
	@Setter
	private String userLdapDn;
	/**
	 * Disabled By
	 */
	@Getter
	@Setter
	private String disabledBy;

	public enum Fields {
		userLoginId, currentPassword, passwordHint, isSystem, enabled, hasLoggedOut, requirePasswordChange, lastCurrencyUom, lastLocale, lastTimeZone, disabledDateTime, successiveFailedLogins, externalAuthId, userLdapDn, disabledBy
	}

	public UserLogin(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		currentPassword = (String) value.get(Fields.currentPassword.name());
		passwordHint = (String) value.get(Fields.passwordHint.name());
		isSystem = (String) value.get(Fields.isSystem.name());
		enabled = (String) value.get(Fields.enabled.name());
		hasLoggedOut = (String) value.get(Fields.hasLoggedOut.name());
		requirePasswordChange = (String) value.get(Fields.requirePasswordChange
				.name());
		lastCurrencyUom = (String) value.get(Fields.lastCurrencyUom.name());
		lastLocale = (String) value.get(Fields.lastLocale.name());
		lastTimeZone = (String) value.get(Fields.lastTimeZone.name());
		disabledDateTime = (Timestamp) value
				.get(Fields.disabledDateTime.name());
		successiveFailedLogins = (Long) value.get(Fields.successiveFailedLogins
				.name());
		externalAuthId = (String) value.get(Fields.externalAuthId.name());
		userLdapDn = (String) value.get(Fields.userLdapDn.name());
		disabledBy = (String) value.get(Fields.disabledBy.name());
	}

	public static UserLogin fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new UserLogin(value);
	}

	public static List<UserLogin> fromValues(List<GenericValue> values) {
		List<UserLogin> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLogin(value));
		}
		return entities;
	}
}