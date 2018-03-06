package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Priority Type
 */
public class PriorityType implements Serializable {

	public static final long serialVersionUID = 7060736133070949376L;
	public static final String NAME = "PriorityType";
	/**
	 * Priority Type Id
	 */
	@Getter
	@Setter
	private String priorityTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		priorityTypeId, description
	}

	public PriorityType(GenericValue value) {
		priorityTypeId = (String) value.get(Fields.priorityTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PriorityType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PriorityType(value);
	}

	public static List<PriorityType> fromValues(List<GenericValue> values) {
		List<PriorityType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PriorityType(value));
		}
		return entities;
	}
}