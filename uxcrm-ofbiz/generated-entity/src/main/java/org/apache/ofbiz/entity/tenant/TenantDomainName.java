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
 * Tenant Domain Name
 */
@FieldNameConstants
public class TenantDomainName implements Serializable {

	public static final long serialVersionUID = 8697703956493709312L;
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

	public TenantDomainName(GenericValue value) {
		tenantId = (String) value.get(FIELD_TENANT_ID);
		domainName = (String) value.get(FIELD_DOMAIN_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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