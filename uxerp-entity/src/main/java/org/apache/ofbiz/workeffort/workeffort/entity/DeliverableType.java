package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Deliverable Type
 */
public class DeliverableType implements Serializable {

	public static final long serialVersionUID = 5494983695269479424L;
	public static final String NAME = "DeliverableType";
	/**
	 * Deliverable Type Id
	 */
	@Getter
	@Setter
	private String deliverableTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		deliverableTypeId, description
	}

	public DeliverableType(GenericValue value) {
		deliverableTypeId = (String) value.get(Fields.deliverableTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static DeliverableType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DeliverableType(value);
	}

	public static List<DeliverableType> fromValues(List<GenericValue> values) {
		List<DeliverableType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DeliverableType(value));
		}
		return entities;
	}
}