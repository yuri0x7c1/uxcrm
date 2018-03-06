package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Content Type
 */
public class WorkEffortContentType implements Serializable {

	public static final long serialVersionUID = 5458787461195139072L;
	public static final String NAME = "WorkEffortContentType";
	/**
	 * Work Effort Content Type Id
	 */
	@Getter
	@Setter
	private String workEffortContentTypeId;
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
		workEffortContentTypeId, parentTypeId, description
	}

	public WorkEffortContentType(GenericValue value) {
		workEffortContentTypeId = (String) value
				.get(Fields.workEffortContentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkEffortContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortContentType(value);
	}

	public static List<WorkEffortContentType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortContentType(value));
		}
		return entities;
	}
}