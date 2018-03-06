package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Attribute
 */
public class WorkEffortAttribute implements Serializable {

	public static final long serialVersionUID = 5858033999215938560L;
	public static final String NAME = "WorkEffortAttribute";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		workEffortId, attrName, attrValue, attrDescription
	}

	public WorkEffortAttribute(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static WorkEffortAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAttribute(value);
	}

	public static List<WorkEffortAttribute> fromValues(List<GenericValue> values) {
		List<WorkEffortAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAttribute(value));
		}
		return entities;
	}
}