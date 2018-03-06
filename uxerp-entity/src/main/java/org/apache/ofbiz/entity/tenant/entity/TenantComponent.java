package org.apache.ofbiz.entity.tenant.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tenant Component
 */
public class TenantComponent implements Serializable {

	public static final long serialVersionUID = 7863207360838778880L;
	public static final String NAME = "TenantComponent";
	/**
	 * Tenant Id
	 */
	@Getter
	@Setter
	private String tenantId;
	/**
	 * Component Name
	 */
	@Getter
	@Setter
	private String componentName;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		tenantId, componentName, sequenceNum
	}

	public TenantComponent(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		componentName = (String) value.get(Fields.componentName.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static TenantComponent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TenantComponent(value);
	}

	public static List<TenantComponent> fromValues(List<GenericValue> values) {
		List<TenantComponent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TenantComponent(value));
		}
		return entities;
	}
}