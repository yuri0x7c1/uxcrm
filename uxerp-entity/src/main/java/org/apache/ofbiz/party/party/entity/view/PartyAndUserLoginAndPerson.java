package org.apache.ofbiz.party.party.entity.view;

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
public class PartyAndUserLoginAndPerson implements Serializable {

	public static final long serialVersionUID = 3180231353807590400L;
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

	public enum Fields {
		partyId, partyTypeId, createdDate, statusId, userLoginId, currentPassword, passwordHint, enabled, disabledDateTime, successiveFailedLogins, lastName, firstName
	}

	public PartyAndUserLoginAndPerson(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		currentPassword = (String) value.get(Fields.currentPassword.name());
		passwordHint = (String) value.get(Fields.passwordHint.name());
		enabled = (String) value.get(Fields.enabled.name());
		disabledDateTime = (Timestamp) value
				.get(Fields.disabledDateTime.name());
		successiveFailedLogins = (Long) value.get(Fields.successiveFailedLogins
				.name());
		lastName = (String) value.get(Fields.lastName.name());
		firstName = (String) value.get(Fields.firstName.name());
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