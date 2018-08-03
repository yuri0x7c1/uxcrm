package org.apache.ofbiz.entity.tenant;

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
public class TenantDomainName implements Serializable {

	public static final long serialVersionUID = 2758774187552834560L;
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

	public enum Fields {
		tenantId, domainName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TenantDomainName(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		domainName = (String) value.get(Fields.domainName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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