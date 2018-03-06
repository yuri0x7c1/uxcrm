package org.apache.ofbiz.security.securitygroup.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Security Group Permission
 */
public class SecurityGroupPermission implements Serializable {

	public static final long serialVersionUID = 2546980263378176000L;
	public static final String NAME = "SecurityGroupPermission";
	/**
	 * Group Id
	 */
	@Getter
	@Setter
	private String groupId;
	/**
	 * Permission Id
	 */
	@Getter
	@Setter
	private String permissionId;

	public enum Fields {
		groupId, permissionId
	}

	public SecurityGroupPermission(GenericValue value) {
		groupId = (String) value.get(Fields.groupId.name());
		permissionId = (String) value.get(Fields.permissionId.name());
	}

	public static SecurityGroupPermission fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SecurityGroupPermission(value);
	}

	public static List<SecurityGroupPermission> fromValues(
			List<GenericValue> values) {
		List<SecurityGroupPermission> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SecurityGroupPermission(value));
		}
		return entities;
	}
}