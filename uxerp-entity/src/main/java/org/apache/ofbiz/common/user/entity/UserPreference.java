package org.apache.ofbiz.common.user.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Preference
 */
public class UserPreference implements Serializable {

	public static final long serialVersionUID = 8258870696724034560L;
	public static final String NAME = "UserPreference";
	/**
	 * User Login Id
	 */
	@Getter
	@Setter
	private String userLoginId;
	/**
	 * User Pref Type Id
	 */
	@Getter
	@Setter
	private String userPrefTypeId;
	/**
	 * User Pref Group Type Id
	 */
	@Getter
	@Setter
	private String userPrefGroupTypeId;
	/**
	 * User Pref Value
	 */
	@Getter
	@Setter
	private String userPrefValue;
	/**
	 * User Pref Data Type
	 */
	@Getter
	@Setter
	private String userPrefDataType;

	public enum Fields {
		userLoginId, userPrefTypeId, userPrefGroupTypeId, userPrefValue, userPrefDataType
	}

	public UserPreference(GenericValue value) {
		userLoginId = (String) value.get(Fields.userLoginId.name());
		userPrefTypeId = (String) value.get(Fields.userPrefTypeId.name());
		userPrefGroupTypeId = (String) value.get(Fields.userPrefGroupTypeId
				.name());
		userPrefValue = (String) value.get(Fields.userPrefValue.name());
		userPrefDataType = (String) value.get(Fields.userPrefDataType.name());
	}

	public static UserPreference fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserPreference(value);
	}

	public static List<UserPreference> fromValues(List<GenericValue> values) {
		List<UserPreference> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserPreference(value));
		}
		return entities;
	}
}