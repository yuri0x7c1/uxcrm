package org.apache.ofbiz.common.property;

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
public class SystemProperty implements Serializable {

	public static final long serialVersionUID = 9002069445887006720L;
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

	public enum Fields {
		systemResourceId, systemPropertyId, systemPropertyValue, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SystemProperty(GenericValue value) {
		systemResourceId = (String) value.get(Fields.systemResourceId.name());
		systemPropertyId = (String) value.get(Fields.systemPropertyId.name());
		systemPropertyValue = (String) value.get(Fields.systemPropertyValue
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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