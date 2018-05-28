package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login And Party Details
 */
public class UserLoginAndPartyDetails implements Serializable {

	public static final long serialVersionUID = 1875340308277372928L;
	public static final String NAME = "UserLoginAndPartyDetails";
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
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
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
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;

	public enum Fields {
		partyId, partyTypeId, createdDate, statusId, groupName, userLoginId, currentPassword, passwordHint, enabled, disabledDateTime, successiveFailedLogins, lastName, middleName, firstName
	}

	public UserLoginAndPartyDetails(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		groupName = (String) value.get(Fields.groupName.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		currentPassword = (String) value.get(Fields.currentPassword.name());
		passwordHint = (String) value.get(Fields.passwordHint.name());
		enabled = (String) value.get(Fields.enabled.name());
		disabledDateTime = (Timestamp) value
				.get(Fields.disabledDateTime.name());
		successiveFailedLogins = (Long) value.get(Fields.successiveFailedLogins
				.name());
		lastName = (String) value.get(Fields.lastName.name());
		middleName = (String) value.get(Fields.middleName.name());
		firstName = (String) value.get(Fields.firstName.name());
	}

	public static UserLoginAndPartyDetails fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginAndPartyDetails(value);
	}

	public static List<UserLoginAndPartyDetails> fromValues(
			List<GenericValue> values) {
		List<UserLoginAndPartyDetails> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginAndPartyDetails(value));
		}
		return entities;
	}
}