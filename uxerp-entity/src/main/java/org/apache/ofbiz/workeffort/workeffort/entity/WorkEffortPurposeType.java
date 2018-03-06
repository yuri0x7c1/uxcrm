package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Purpose Type
 */
public class WorkEffortPurposeType implements Serializable {

	public static final long serialVersionUID = 55130300073957376L;
	public static final String NAME = "WorkEffortPurposeType";
	/**
	 * Work Effort Purpose Type Id
	 */
	@Getter
	@Setter
	private String workEffortPurposeTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		workEffortPurposeTypeId, parentTypeId, description
	}

	public WorkEffortPurposeType(GenericValue value) {
		workEffortPurposeTypeId = (String) value
				.get(Fields.workEffortPurposeTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkEffortPurposeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortPurposeType(value);
	}

	public static List<WorkEffortPurposeType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortPurposeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortPurposeType(value));
		}
		return entities;
	}
}