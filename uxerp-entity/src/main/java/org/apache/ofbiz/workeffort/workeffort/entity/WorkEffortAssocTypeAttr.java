package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Assoc Type Attr
 */
public class WorkEffortAssocTypeAttr implements Serializable {

	public static final long serialVersionUID = 1014032770501013504L;
	public static final String NAME = "WorkEffortAssocTypeAttr";
	/**
	 * Work Effort Assoc Type Id
	 */
	@Getter
	@Setter
	private String workEffortAssocTypeId;
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
		workEffortAssocTypeId, attrName, description
	}

	public WorkEffortAssocTypeAttr(GenericValue value) {
		workEffortAssocTypeId = (String) value.get(Fields.workEffortAssocTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkEffortAssocTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAssocTypeAttr(value);
	}

	public static List<WorkEffortAssocTypeAttr> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAssocTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAssocTypeAttr(value));
		}
		return entities;
	}
}