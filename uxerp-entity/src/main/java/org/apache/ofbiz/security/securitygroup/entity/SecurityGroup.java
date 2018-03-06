package org.apache.ofbiz.security.securitygroup.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Security Group
 */
public class SecurityGroup implements Serializable {

	public static final long serialVersionUID = 4165349741251228672L;
	public static final String NAME = "SecurityGroup";
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		groupId, description
	}

	public SecurityGroup(GenericValue value) {
		groupId = (String) value.get(Fields.groupId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SecurityGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SecurityGroup(value);
	}

	public static List<SecurityGroup> fromValues(List<GenericValue> values) {
		List<SecurityGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SecurityGroup(value));
		}
		return entities;
	}
}