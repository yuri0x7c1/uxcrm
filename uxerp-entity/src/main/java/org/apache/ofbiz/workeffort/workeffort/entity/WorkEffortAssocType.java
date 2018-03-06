package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Assoc Type
 */
public class WorkEffortAssocType implements Serializable {

	public static final long serialVersionUID = 1888961696813772800L;
	public static final String NAME = "WorkEffortAssocType";
	/**
	 * Work Effort Assoc Type Id
	 */
	@Getter
	@Setter
	private String workEffortAssocTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		workEffortAssocTypeId, parentTypeId, hasTable, description
	}

	public WorkEffortAssocType(GenericValue value) {
		workEffortAssocTypeId = (String) value.get(Fields.workEffortAssocTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkEffortAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAssocType(value);
	}

	public static List<WorkEffortAssocType> fromValues(List<GenericValue> values) {
		List<WorkEffortAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAssocType(value));
		}
		return entities;
	}
}