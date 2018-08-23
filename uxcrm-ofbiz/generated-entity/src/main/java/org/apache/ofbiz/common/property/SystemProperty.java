package org.apache.ofbiz.common.property;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * System Property
 */
@FieldNameConstants
public class SystemProperty implements Serializable {

	public static final long serialVersionUID = 6990035932889171968L;
	public static final String NAME = "SystemProperty";
	/**
	 * System Resource Id
	 */
	@Getter
	@Setter
	private String systemResourceId;
	/**
	 * System Property Id
	 */
	@Getter
	@Setter
	private String systemPropertyId;
	/**
	 * System Property Value
	 */
	@Getter
	@Setter
	private String systemPropertyValue;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public SystemProperty(GenericValue value) {
		systemResourceId = (String) value.get(FIELD_SYSTEM_RESOURCE_ID);
		systemPropertyId = (String) value.get(FIELD_SYSTEM_PROPERTY_ID);
		systemPropertyValue = (String) value.get(FIELD_SYSTEM_PROPERTY_VALUE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SystemProperty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SystemProperty(value);
	}

	public static List<SystemProperty> fromValues(List<GenericValue> values) {
		List<SystemProperty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SystemProperty(value));
		}
		return entities;
	}
}