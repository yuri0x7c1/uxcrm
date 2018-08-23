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
 * User Login Password History
 */
@FieldNameConstants
public class UserLoginPasswordHistory implements Serializable {

	public static final long serialVersionUID = 3060714779451673600L;
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

	public UserLoginPasswordHistory(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		currentPassword = (String) value.get(FIELD_CURRENT_PASSWORD);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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