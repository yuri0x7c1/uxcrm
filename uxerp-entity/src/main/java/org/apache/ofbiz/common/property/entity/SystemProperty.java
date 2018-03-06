package org.apache.ofbiz.common.property.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * System Property
 */
public class SystemProperty implements Serializable {

	public static final long serialVersionUID = 7579989113822688256L;
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

	public enum Fields {
		systemResourceId, systemPropertyId, systemPropertyValue, description
	}

	public SystemProperty(GenericValue value) {
		systemResourceId = (String) value.get(Fields.systemResourceId.name());
		systemPropertyId = (String) value.get(Fields.systemPropertyId.name());
		systemPropertyValue = (String) value.get(Fields.systemPropertyValue
				.name());
		description = (String) value.get(Fields.description.name());
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