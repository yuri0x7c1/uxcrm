package org.apache.ofbiz.security.securitygroup;

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
public class UserLoginAndSecurityGroup implements Serializable {

	public static final long serialVersionUID = 7849919997090635776L;
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

	public enum Fields {
		userLoginId, fromDate, groupId, thruDate, successiveFailedLogins, passwordHint, externalAuthId, lastTimeZone, enabled, lastLocale, currentPassword, isSystem, disabledDateTime, disabledBy, hasLoggedOut, userLdapDn, requirePasswordChange, lastCurrencyUom, partyId
	}

	public UserLoginAndSecurityGroup(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		groupId = (String) value.get(Fields.groupId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		successiveFailedLogins = (Long) value.get(Fields.successiveFailedLogins
				.name());
		passwordHint = (String) value.get(Fields.passwordHint.name());
		externalAuthId = (String) value.get(Fields.externalAuthId.name());
		lastTimeZone = (String) value.get(Fields.lastTimeZone.name());
		enabled = (String) value.get(Fields.enabled.name());
		lastLocale = (String) value.get(Fields.lastLocale.name());
		currentPassword = (String) value.get(Fields.currentPassword.name());
		isSystem = (String) value.get(Fields.isSystem.name());
		disabledDateTime = (Timestamp) value
				.get(Fields.disabledDateTime.name());
		disabledBy = (String) value.get(Fields.disabledBy.name());
		hasLoggedOut = (String) value.get(Fields.hasLoggedOut.name());
		userLdapDn = (String) value.get(Fields.userLdapDn.name());
		requirePasswordChange = (String) value.get(Fields.requirePasswordChange
				.name());
		lastCurrencyUom = (String) value.get(Fields.lastCurrencyUom.name());
		partyId = (String) value.get(Fields.partyId.name());
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