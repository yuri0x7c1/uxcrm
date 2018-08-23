package org.apache.ofbiz.security.securitygroup;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login And Security Group
 */
@FieldNameConstants
public class UserLoginAndSecurityGroup implements Serializable {

	public static final long serialVersionUID = 4407059409461608448L;
	public static final String NAME = "UserLoginAndSecurityGroup";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Successive Failed Logins
	 */
	@Getter
	@Setter
	private Long successiveFailedLogins;
	/**
	 * Password Hint
	 */
	@Getter
	@Setter
	private String passwordHint;
	/**
	 * External Auth Id
	 */
	@Getter
	@Setter
	private String externalAuthId;
	/**
	 * Last Time Zone
	 */
	@Getter
	@Setter
	private String lastTimeZone;
	/**
	 * Enabled
	 */
	@Getter
	@Setter
	private String enabled;
	/**
	 * Last Locale
	 */
	@Getter
	@Setter
	private String lastLocale;
	/**
	 * Current Password
	 */
	@Getter
	@Setter
	private String currentPassword;
	/**
	 * Is System
	 */
	@Getter
	@Setter
	private String isSystem;
	/**
	 * Disabled Date Time
	 */
	@Getter
	@Setter
	private Timestamp disabledDateTime;
	/**
	 * Disabled By
	 */
	@Getter
	@Setter
	private String disabledBy;
	/**
	 * Has Logged Out
	 */
	@Getter
	@Setter
	private String hasLoggedOut;
	/**
	 * User Ldap Dn
	 */
	@Getter
	@Setter
	private String userLdapDn;
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public UserLoginAndSecurityGroup(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		groupId = (String) value.get(FIELD_GROUP_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		successiveFailedLogins = (Long) value
				.get(FIELD_SUCCESSIVE_FAILED_LOGINS);
		passwordHint = (String) value.get(FIELD_PASSWORD_HINT);
		externalAuthId = (String) value.get(FIELD_EXTERNAL_AUTH_ID);
		lastTimeZone = (String) value.get(FIELD_LAST_TIME_ZONE);
		enabled = (String) value.get(FIELD_ENABLED);
		lastLocale = (String) value.get(FIELD_LAST_LOCALE);
		currentPassword = (String) value.get(FIELD_CURRENT_PASSWORD);
		isSystem = (String) value.get(FIELD_IS_SYSTEM);
		disabledDateTime = (Timestamp) value.get(FIELD_DISABLED_DATE_TIME);
		disabledBy = (String) value.get(FIELD_DISABLED_BY);
		hasLoggedOut = (String) value.get(FIELD_HAS_LOGGED_OUT);
		userLdapDn = (String) value.get(FIELD_USER_LDAP_DN);
		requirePasswordChange = (String) value
				.get(FIELD_REQUIRE_PASSWORD_CHANGE);
		lastCurrencyUom = (String) value.get(FIELD_LAST_CURRENCY_UOM);
		partyId = (String) value.get(FIELD_PARTY_ID);
	}

	public static UserLoginAndSecurityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginAndSecurityGroup(value);
	}

	public static List<UserLoginAndSecurityGroup> fromValues(
			List<GenericValue> values) {
		List<UserLoginAndSecurityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginAndSecurityGroup(value));
		}
		return entities;
	}
}