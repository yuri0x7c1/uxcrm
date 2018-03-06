package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Deliverable
 */
public class Deliverable implements Serializable {

	public static final long serialVersionUID = 3696180851697089536L;
	public static final String NAME = "Deliverable";
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;
	/**
	 * Deliverable Type Id
	 */
	@Getter
	@Setter
	private String deliverableTypeId;
	/**
	 * Deliverable Name
	 */
	@Getter
	@Setter
	private String deliverableName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		deliverableId, deliverableTypeId, deliverableName, description
	}

	public Deliverable(GenericValue value) {
		deliverableId = (String) value.get(Fields.deliverableId.name());
		deliverableTypeId = (String) value.get(Fields.deliverableTypeId.name());
		deliverableName = (String) value.get(Fields.deliverableName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static Deliverable fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Deliverable(value);
	}

	public static List<Deliverable> fromValues(List<GenericValue> values) {
		List<Deliverable> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Deliverable(value));
		}
		return entities;
	}
}