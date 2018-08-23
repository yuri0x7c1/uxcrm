package org.apache.ofbiz.security.login;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class UserLogin implements Serializable {

	public static final long serialVersionUID = 6876029763397888000L;
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
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public UserLogin(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		currentPassword = (String) value.get(FIELD_CURRENT_PASSWORD);
		passwordHint = (String) value.get(FIELD_PASSWORD_HINT);
		isSystem = (String) value.get(FIELD_IS_SYSTEM);
		enabled = (String) value.get(FIELD_ENABLED);
		hasLoggedOut = (String) value.get(FIELD_HAS_LOGGED_OUT);
		requirePasswordChange = (String) value
				.get(FIELD_REQUIRE_PASSWORD_CHANGE);
		lastCurrencyUom = (String) value.get(FIELD_LAST_CURRENCY_UOM);
		lastLocale = (String) value.get(FIELD_LAST_LOCALE);
		lastTimeZone = (String) value.get(FIELD_LAST_TIME_ZONE);
		disabledDateTime = (Timestamp) value.get(FIELD_DISABLED_DATE_TIME);
		successiveFailedLogins = (Long) value
				.get(FIELD_SUCCESSIVE_FAILED_LOGINS);
		externalAuthId = (String) value.get(FIELD_EXTERNAL_AUTH_ID);
		userLdapDn = (String) value.get(FIELD_USER_LDAP_DN);
		disabledBy = (String) value.get(FIELD_DISABLED_BY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		partyId = (String) value.get(FIELD_PARTY_ID);
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