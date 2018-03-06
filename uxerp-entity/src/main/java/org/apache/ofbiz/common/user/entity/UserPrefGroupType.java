package org.apache.ofbiz.common.user.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Pref Group Type
 */
public class UserPrefGroupType implements Serializable {

	public static final long serialVersionUID = 8952686783971790848L;
	public static final String NAME = "UserPrefGroupType";
	/**
	 * User Pref Group Type Id
	 */
	@Getter
	@Setter
	private String userPrefGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		userPrefGroupTypeId, description
	}

	public UserPrefGroupType(GenericValue value) {
		userPrefGroupTypeId = (String) value.get(Fields.userPrefGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static UserPrefGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserPrefGroupType(value);
	}

	public static List<UserPrefGroupType> fromValues(List<GenericValue> values) {
		List<UserPrefGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserPrefGroupType(value));
		}
		return entities;
	}
}