package org.apache.ofbiz.security.securitygroup.entity;

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

	public static final long serialVersionUID = 2578650430971590656L;
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

	public enum Fields {
		userLoginId, groupId, fromDate, thruDate
	}

	public UserLoginSecurityGroup(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		groupId = (String) value.get(Fields.groupId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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