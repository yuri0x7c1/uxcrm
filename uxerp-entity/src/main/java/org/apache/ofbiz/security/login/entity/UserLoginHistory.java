package org.apache.ofbiz.security.login.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login History
 */
public class UserLoginHistory implements Serializable {

	public static final long serialVersionUID = 8345744388099227648L;
	public static final String NAME = "UserLoginHistory";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
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
	 * Password Used
	 */
	@Getter
	@Setter
	private String passwordUsed;
	/**
	 * Successful Login
	 */
	@Getter
	@Setter
	private String successfulLogin;

	public enum Fields {
		userLoginId, visitId, fromDate, thruDate, passwordUsed, successfulLogin
	}

	public UserLoginHistory(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		visitId = (String) value.get(Fields.visitId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		passwordUsed = (String) value.get(Fields.passwordUsed.name());
		successfulLogin = (String) value.get(Fields.successfulLogin.name());
	}

	public static UserLoginHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginHistory(value);
	}

	public static List<UserLoginHistory> fromValues(List<GenericValue> values) {
		List<UserLoginHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginHistory(value));
		}
		return entities;
	}
}