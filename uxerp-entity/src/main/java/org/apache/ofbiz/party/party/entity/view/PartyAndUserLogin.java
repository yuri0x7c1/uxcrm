package org.apache.ofbiz.party.party.entity.view;

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
public class PartyAndUserLogin implements Serializable {

	public static final long serialVersionUID = 1854694692353890304L;
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

	public enum Fields {
		partyId, partyTypeId, userLoginId, currentPassword, passwordHint, enabled, disabledDateTime, successiveFailedLogins
	}

	public PartyAndUserLogin(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		currentPassword = (String) value.get(Fields.currentPassword.name());
		passwordHint = (String) value.get(Fields.passwordHint.name());
		enabled = (String) value.get(Fields.enabled.name());
		disabledDateTime = (Timestamp) value
				.get(Fields.disabledDateTime.name());
		successiveFailedLogins = (Long) value.get(Fields.successiveFailedLogins
				.name());
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