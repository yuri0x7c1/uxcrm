package org.apache.ofbiz.entity.tenant.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tenant Key Encrypting Key
 */
public class TenantKeyEncryptingKey implements Serializable {

	public static final long serialVersionUID = 2932452876071089152L;
	public static final String NAME = "TenantKeyEncryptingKey";
	/**
	 * Tenant Id
	 */
	@Getter
	@Setter
	private String tenantId;
	/**
	 * Kek Text
	 */
	@Getter
	@Setter
	private String kekText;

	public enum Fields {
		tenantId, kekText
	}

	public TenantKeyEncryptingKey(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		kekText = (String) value.get(Fields.kekText.name());
	}

	public static TenantKeyEncryptingKey fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TenantKeyEncryptingKey(value);
	}

	public static List<TenantKeyEncryptingKey> fromValues(
			List<GenericValue> values) {
		List<TenantKeyEncryptingKey> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TenantKeyEncryptingKey(value));
		}
		return entities;
	}
}