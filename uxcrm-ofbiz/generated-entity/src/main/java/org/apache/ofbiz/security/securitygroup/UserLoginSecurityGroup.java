package org.apache.ofbiz.security.securitygroup;

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
public class UserLoginSecurityGroup implements Serializable {

	public static final long serialVersionUID = 2701717988636325888L;
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

	public enum Fields {
		userLoginId, groupId, fromDate, thruDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public UserLoginSecurityGroup(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		groupId = (String) value.get(Fields.groupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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