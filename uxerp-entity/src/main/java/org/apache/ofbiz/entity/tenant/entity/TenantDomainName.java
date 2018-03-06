package org.apache.ofbiz.entity.tenant.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tenant Domain Name
 */
public class TenantDomainName implements Serializable {

	public static final long serialVersionUID = 1763372855798378496L;
	public static final String NAME = "TenantDomainName";
	/**
	 * Tenant Id
	 */
	@Getter
	@Setter
	private String tenantId;
	/**
	 * Domain Name
	 */
	@Getter
	@Setter
	private String domainName;

	public enum Fields {
		tenantId, domainName
	}

	public TenantDomainName(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		domainName = (String) value.get(Fields.domainName.name());
	}

	public static TenantDomainName fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TenantDomainName(value);
	}

	public static List<TenantDomainName> fromValues(List<GenericValue> values) {
		List<TenantDomainName> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TenantDomainName(value));
		}
		return entities;
	}
}