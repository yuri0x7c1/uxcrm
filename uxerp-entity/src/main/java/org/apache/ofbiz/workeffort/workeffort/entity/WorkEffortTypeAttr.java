package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Type Attr
 */
public class WorkEffortTypeAttr implements Serializable {

	public static final long serialVersionUID = 254906033929888768L;
	public static final String NAME = "WorkEffortTypeAttr";
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		workEffortTypeId, attrName, description
	}

	public WorkEffortTypeAttr(GenericValue value) {
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkEffortTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortTypeAttr(value);
	}

	public static List<WorkEffortTypeAttr> fromValues(List<GenericValue> values) {
		List<WorkEffortTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortTypeAttr(value));
		}
		return entities;
	}
}