package org.apache.ofbiz.security.login;

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
public class UserLoginSecurityQuestion implements Serializable {

	public static final long serialVersionUID = 5320465474993316864L;
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

	public enum Fields {
		questionEnumId, userLoginId, securityAnswer, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UserLoginSecurityQuestion(GenericValue value) {
		questionEnumId = (String) value.get(Fields.questionEnumId.name());
		userLoginId = (String) value.get(Fields.userLoginId.name());
		securityAnswer = (String) value.get(Fields.securityAnswer.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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