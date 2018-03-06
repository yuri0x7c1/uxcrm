package org.apache.ofbiz.security.login.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login Session
 */
public class UserLoginSession implements Serializable {

	public static final long serialVersionUID = 693278519541387264L;
	public static final String NAME = "UserLoginSession";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Saved Date
	 */
	@Getter
	@Setter
	private Timestamp savedDate;
	/**
	 * Session Data
	 */
	@Getter
	@Setter
	private String sessionData;

	public enum Fields {
		userLoginId, savedDate, sessionData
	}

	public UserLoginSession(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		savedDate = (Timestamp) value.get(Fields.savedDate.name());
		sessionData = (String) value.get(Fields.sessionData.name());
	}

	public static UserLoginSession fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginSession(value);
	}

	public static List<UserLoginSession> fromValues(List<GenericValue> values) {
		List<UserLoginSession> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginSession(value));
		}
		return entities;
	}
}