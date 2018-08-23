package org.apache.ofbiz.entity.tenant;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TenantKeyEncryptingKey implements Serializable {

	public static final long serialVersionUID = 2274300384796663808L;
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

	public TenantKeyEncryptingKey(GenericValue value) {
		tenantId = (String) value.get(FIELD_TENANT_ID);
		kekText = (String) value.get(FIELD_KEK_TEXT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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