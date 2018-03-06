package org.apache.ofbiz.security.securitygroup.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Security Permission
 */
public class SecurityPermission implements Serializable {

	public static final long serialVersionUID = 8366490993102185472L;
	public static final String NAME = "SecurityPermission";
	/**
	 * Permission Id
	 */
	@Getter
	@Setter
	private String permissionId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		permissionId, description
	}

	public SecurityPermission(GenericValue value) {
		permissionId = (String) value.get(Fields.permissionId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SecurityPermission fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SecurityPermission(value);
	}

	public static List<SecurityPermission> fromValues(List<GenericValue> values) {
		List<SecurityPermission> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SecurityPermission(value));
		}
		return entities;
	}
}