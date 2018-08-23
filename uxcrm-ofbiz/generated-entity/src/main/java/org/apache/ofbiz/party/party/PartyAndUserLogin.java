package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party And User Login
 */
@FieldNameConstants
public class PartyAndUserLogin implements Serializable {

	public static final long serialVersionUID = 2529949486214106112L;
	public static final String NAME = "PartyAndUserLogin";
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
	 * Enabled
	 */
	@Getter
	@Setter
	private String enabled;
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

	public PartyAndUserLogin(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		currentPassword = (String) value.get(FIELD_CURRENT_PASSWORD);
		passwordHint = (String) value.get(FIELD_PASSWORD_HINT);
		enabled = (String) value.get(FIELD_ENABLED);
		disabledDateTime = (Timestamp) value.get(FIELD_DISABLED_DATE_TIME);
		successiveFailedLogins = (Long) value
				.get(FIELD_SUCCESSIVE_FAILED_LOGINS);
	}

	public static PartyAndUserLogin fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndUserLogin(value);
	}

	public static List<PartyAndUserLogin> fromValues(List<GenericValue> values) {
		List<PartyAndUserLogin> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndUserLogin(value));
		}
		return entities;
	}
}