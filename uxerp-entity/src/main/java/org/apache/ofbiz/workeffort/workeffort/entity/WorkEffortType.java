package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Type
 */
public class WorkEffortType implements Serializable {

	public static final long serialVersionUID = 4267554810576760832L;
	public static final String NAME = "WorkEffortType";
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
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
		workEffortTypeId, parentTypeId, hasTable, description
	}

	public WorkEffortType(GenericValue value) {
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkEffortType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortType(value);
	}

	public static List<WorkEffortType> fromValues(List<GenericValue> values) {
		List<WorkEffortType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortType(value));
		}
		return entities;
	}
}