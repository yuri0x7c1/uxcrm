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
 * Tenant
 */
@FieldNameConstants
public class Tenant implements Serializable {

	public static final long serialVersionUID = 957475094944325632L;
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

	public Tenant(GenericValue value) {
		tenantId = (String) value.get(FIELD_TENANT_ID);
		tenantName = (String) value.get(FIELD_TENANT_NAME);
		initialPath = (String) value.get(FIELD_INITIAL_PATH);
		disabled = (String) value.get(FIELD_DISABLED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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