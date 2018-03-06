package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Container
 */
public class Container implements Serializable {

	public static final long serialVersionUID = 6895620978121664512L;
	public static final String NAME = "Container";
	/**
	 * Container Id
	 */
	@Getter
	@Setter
	private String containerId;
	/**
	 * Container Type Id
	 */
	@Getter
	@Setter
	private String containerTypeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		containerId, containerTypeId, facilityId, description
	}

	public Container(GenericValue value) {
		containerId = (String) value.get(Fields.containerId.name());
		containerTypeId = (String) value.get(Fields.containerTypeId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static Container fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Container(value);
	}

	public static List<Container> fromValues(List<GenericValue> values) {
		List<Container> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Container(value));
		}
		return entities;
	}
}