package org.apache.ofbiz.entity.tenant;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tenant Key Encrypting Key
 */
public class TenantKeyEncryptingKey implements Serializable {

	public static final long serialVersionUID = 3786000027286518784L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		tenantId, kekText, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TenantKeyEncryptingKey(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		kekText = (String) value.get(Fields.kekText.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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