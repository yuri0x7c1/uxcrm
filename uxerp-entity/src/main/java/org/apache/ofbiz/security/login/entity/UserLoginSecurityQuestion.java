package org.apache.ofbiz.security.login.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login Security Question
 */
public class UserLoginSecurityQuestion implements Serializable {

	public static final long serialVersionUID = 2389138174906456064L;
	public static final String NAME = "UserLoginSecurityQuestion";
	/**
	 * Question Enum Id
	 */
	@Getter
	@Setter
	private String questionEnumId;
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Security Answer
	 */
	@Getter
	@Setter
	private String securityAnswer;

	public enum Fields {
		questionEnumId, userLoginId, securityAnswer
	}

	public UserLoginSecurityQuestion(GenericValue value) {
		questionEnumId = (String) value.get(Fields.questionEnumId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		securityAnswer = (String) value.get(Fields.securityAnswer.name());
	}

	public static UserLoginSecurityQuestion fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginSecurityQuestion(value);
	}

	public static List<UserLoginSecurityQuestion> fromValues(
			List<GenericValue> values) {
		List<UserLoginSecurityQuestion> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginSecurityQuestion(value));
		}
		return entities;
	}
}