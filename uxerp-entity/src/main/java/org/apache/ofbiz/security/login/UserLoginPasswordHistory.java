package org.apache.ofbiz.security.login;

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

	public static final long serialVersionUID = 1720325858505133056L;
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

	public enum Fields {
		userLoginId, fromDate, thruDate, currentPassword, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UserLoginPasswordHistory(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		currentPassword = (String) value.get(Fields.currentPassword.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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