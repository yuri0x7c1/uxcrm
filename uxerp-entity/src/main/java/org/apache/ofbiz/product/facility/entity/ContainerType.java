package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Container Type
 */
public class ContainerType implements Serializable {

	public static final long serialVersionUID = 7899624305412795392L;
	public static final String NAME = "ContainerType";
	/**
	 * Container Type Id
	 */
	@Getter
	@Setter
	private String containerTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		containerTypeId, description
	}

	public ContainerType(GenericValue value) {
		containerTypeId = (String) value.get(Fields.containerTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContainerType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContainerType(value);
	}

	public static List<ContainerType> fromValues(List<GenericValue> values) {
		List<ContainerType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContainerType(value));
		}
		return entities;
	}
}