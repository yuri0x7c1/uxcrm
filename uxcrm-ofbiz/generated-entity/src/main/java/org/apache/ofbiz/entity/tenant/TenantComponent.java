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
 * Tenant Component
 */
@FieldNameConstants
public class TenantComponent implements Serializable {

	public static final long serialVersionUID = 472172324532405248L;
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

	public TenantComponent(GenericValue value) {
		tenantId = (String) value.get(FIELD_TENANT_ID);
		componentName = (String) value.get(FIELD_COMPONENT_NAME);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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