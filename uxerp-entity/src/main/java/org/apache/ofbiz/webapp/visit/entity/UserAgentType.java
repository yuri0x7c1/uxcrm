package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Agent Type
 */
public class UserAgentType implements Serializable {

	public static final long serialVersionUID = 407028905712933888L;
	public static final String NAME = "UserAgentType";
	/**
	 * User Agent Type Id
	 */
	@Getter
	@Setter
	private String userAgentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		userAgentTypeId, description
	}

	public UserAgentType(GenericValue value) {
		userAgentTypeId = (String) value.get(Fields.userAgentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static UserAgentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserAgentType(value);
	}

	public static List<UserAgentType> fromValues(List<GenericValue> values) {
		List<UserAgentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserAgentType(value));
		}
		return entities;
	}
}