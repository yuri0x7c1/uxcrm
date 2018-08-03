package org.apache.ofbiz.entity.tenant;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tenant
 */
public class Tenant implements Serializable {

	public static final long serialVersionUID = 6285581629662977024L;
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
		tenantId, tenantName, initialPath, disabled, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Tenant(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		tenantName = (String) value.get(Fields.tenantName.name());
		initialPath = (String) value.get(Fields.initialPath.name());
		disabled = (String) value.get(Fields.disabled.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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