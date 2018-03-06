package org.apache.ofbiz.entity.tenant.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Component
 */
public class Component implements Serializable {

	public static final long serialVersionUID = 4133938499661072384L;
	public static final String NAME = "Component";
	/**
	 * Component Name
	 */
	@Getter
	@Setter
	private String componentName;
	/**
	 * Root Location
	 */
	@Getter
	@Setter
	private String rootLocation;

	public enum Fields {
		componentName, rootLocation
	}

	public Component(GenericValue value) {
		componentName = (String) value.get(Fields.componentName.name());
		rootLocation = (String) value.get(Fields.rootLocation.name());
	}

	public static Component fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Component(value);
	}

	public static List<Component> fromValues(List<GenericValue> values) {
		List<Component> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Component(value));
		}
		return entities;
	}
}