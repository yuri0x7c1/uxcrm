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
 * User Login History
 */
@FieldNameConstants
public class UserLoginHistory implements Serializable {

	public static final long serialVersionUID = 4764667535510536192L;
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
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public UserLoginHistory(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		visitId = (String) value.get(FIELD_VISIT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		passwordUsed = (String) value.get(FIELD_PASSWORD_USED);
		successfulLogin = (String) value.get(FIELD_SUCCESSFUL_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
		partyId = (String) value.get(FIELD_PARTY_ID);
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