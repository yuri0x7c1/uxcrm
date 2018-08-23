package org.apache.ofbiz.security.securitygroup;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Login Security Group
 */
@FieldNameConstants
public class UserLoginSecurityGroup implements Serializable {

	public static final long serialVersionUID = 933662803844790272L;
	public static final String NAME = "UserLoginSecurityGroup";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
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

	public UserLoginSecurityGroup(GenericValue value) {
		userLoginId = (String) value.get(FIELD_USER_LOGIN_ID);
		groupId = (String) value.get(FIELD_GROUP_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static UserLoginSecurityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserLoginSecurityGroup(value);
	}

	public static List<UserLoginSecurityGroup> fromValues(
			List<GenericValue> values) {
		List<UserLoginSecurityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserLoginSecurityGroup(value));
		}
		return entities;
	}
}