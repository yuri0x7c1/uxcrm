package org.apache.ofbiz.webapp.visit.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * User Agent Method Type
 */
public class UserAgentMethodType implements Serializable {

	public static final long serialVersionUID = 5004835393033030656L;
	public static final String NAME = "UserAgentMethodType";
	/**
	 * User Agent Method Type Id
	 */
	@Getter
	@Setter
	private String userAgentMethodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		userAgentMethodTypeId, description
	}

	public UserAgentMethodType(GenericValue value) {
		userAgentMethodTypeId = (String) value.get(Fields.userAgentMethodTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static UserAgentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new UserAgentMethodType(value);
	}

	public static List<UserAgentMethodType> fromValues(List<GenericValue> values) {
		List<UserAgentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new UserAgentMethodType(value));
		}
		return entities;
	}
}