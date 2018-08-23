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
 * Party And User Login And Person
 */
@FieldNameConstants
public class PartyAndUserLoginAndPerson implements Serializable {

	public static final long serialVersionUID = 6486850133065091072L;
	public static final String NAME = "PartyAndUserLoginAndPerson";
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
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;

	public PartyAndUserLoginAndPerson(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		currentPassword = (String) value.get(FIELD_CURRENT_PASSWORD);
		passwordHint = (String) value.get(FIELD_PASSWORD_HINT);
		enabled = (String) value.get(FIELD_ENABLED);
		disabledDateTime = (Timestamp) value.get(FIELD_DISABLED_DATE_TIME);
		successiveFailedLogins = (Long) value
				.get(FIELD_SUCCESSIVE_FAILED_LOGINS);
		lastName = (String) value.get(FIELD_LAST_NAME);
		firstName = (String) value.get(FIELD_FIRST_NAME);
	}

	public static PartyAndUserLoginAndPerson fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndUserLoginAndPerson(value);
	}

	public static List<PartyAndUserLoginAndPerson> fromValues(
			List<GenericValue> values) {
		List<PartyAndUserLoginAndPerson> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndUserLoginAndPerson(value));
		}
		return entities;
	}
}