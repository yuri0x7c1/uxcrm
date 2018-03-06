package org.apache.ofbiz.entity.tenant.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tenant
 */
public class Tenant implements Serializable {

	public static final long serialVersionUID = 4677108331789416448L;
	public static final String NAME = "Tenant";
	/**
	 * Tenant Id
	 */
	@Getter
	@Setter
	private String tenantId;
	/**
	 * Tenant Name
	 */
	@Getter
	@Setter
	private String tenantName;
	/**
	 * Initial Path
	 */
	@Getter
	@Setter
	private String initialPath;
	/**
	 * Disabled
	 */
	@Getter
	@Setter
	private String disabled;

	public enum Fields {
		tenantId, tenantName, initialPath, disabled
	}

	public Tenant(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		tenantName = (String) value.get(Fields.tenantName.name());
		initialPath = (String) value.get(Fields.initialPath.name());
		disabled = (String) value.get(Fields.disabled.name());
	}

	public static Tenant fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Tenant(value);
	}

	public static List<Tenant> fromValues(List<GenericValue> values) {
		List<Tenant> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Tenant(value));
		}
		return entities;
	}
}