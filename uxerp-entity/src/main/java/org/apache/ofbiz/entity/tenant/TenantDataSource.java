package org.apache.ofbiz.entity.tenant;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tenant Data Source
 */
public class TenantDataSource implements Serializable {

	public static final long serialVersionUID = 9140695853203441664L;
	public static final String NAME = "TenantDataSource";
	/**
	 * Tenant Id
	 */
	@Getter
	@Setter
	private String tenantId;
	/**
	 * Entity Group Name
	 */
	@Getter
	@Setter
	private String entityGroupName;
	/**
	 * Jdbc Uri
	 */
	@Getter
	@Setter
	private String jdbcUri;
	/**
	 * Jdbc Username
	 */
	@Getter
	@Setter
	private String jdbcUsername;
	/**
	 * Jdbc Password
	 */
	@Getter
	@Setter
	private String jdbcPassword;
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
		tenantId, entityGroupName, jdbcUri, jdbcUsername, jdbcPassword, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TenantDataSource(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		entityGroupName = (String) value.get(Fields.entityGroupName.name());
		jdbcUri = (String) value.get(Fields.jdbcUri.name());
		jdbcUsername = (String) value.get(Fields.jdbcUsername.name());
		jdbcPassword = (String) value.get(Fields.jdbcPassword.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TenantDataSource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TenantDataSource(value);
	}

	public static List<TenantDataSource> fromValues(List<GenericValue> values) {
		List<TenantDataSource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TenantDataSource(value));
		}
		return entities;
	}
}