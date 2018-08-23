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
 * User Login Session
 */
@FieldNameConstants
public class UserLoginSession implements Serializable {

	public static final long serialVersionUID = 3315796839100786688L;
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

	public UserLoginSession(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		savedDate = (Timestamp) value.get(FIELD_SAVED_DATE);
		sessionData = (String) value.get(FIELD_SESSION_DATA);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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