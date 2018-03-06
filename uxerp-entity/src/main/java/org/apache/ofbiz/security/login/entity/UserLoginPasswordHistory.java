package org.apache.ofbiz.security.login.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login Password History
 */
public class UserLoginPasswordHistory implements Serializable {

	public static final long serialVersionUID = 7459816473487243264L;
	public static final String NAME = "UserLoginPasswordHistory";
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
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Current Password
	 */
	@Getter
	@Setter
	private String currentPassword;

	public enum Fields {
		userLoginId, fromDate, thruDate, currentPassword
	}

	public UserLoginPasswordHistory(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		currentPassword = (String) value.get(Fields.currentPassword.name());
	}

	public static UserLoginPasswordHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginPasswordHistory(value);
	}

	public static List<UserLoginPasswordHistory> fromValues(
			List<GenericValue> values) {
		List<UserLoginPasswordHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginPasswordHistory(value));
		}
		return entities;
	}
}