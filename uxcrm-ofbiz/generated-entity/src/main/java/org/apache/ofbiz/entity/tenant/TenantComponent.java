package org.apache.ofbiz.entity.tenant;

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
public class TenantComponent implements Serializable {

	public static final long serialVersionUID = 4153353974432164864L;
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

	public enum Fields {
		tenantId, componentName, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TenantComponent(GenericValue value) {
		tenantId = (String) value.get(Fields.tenantId.name());
		componentName = (String) value.get(Fields.componentName.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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