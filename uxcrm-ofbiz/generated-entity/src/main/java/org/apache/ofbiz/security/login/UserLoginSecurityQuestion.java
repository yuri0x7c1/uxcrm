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
 * User Login Security Question
 */
@FieldNameConstants
public class UserLoginSecurityQuestion implements Serializable {

	public static final long serialVersionUID = 4908570467427917824L;
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

	public UserLoginSecurityQuestion(GenericValue value) {
		questionEnumId = (String) value.get(FIELD_QUESTION_ENUM_ID);
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		securityAnswer = (String) value.get(FIELD_SECURITY_ANSWER);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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