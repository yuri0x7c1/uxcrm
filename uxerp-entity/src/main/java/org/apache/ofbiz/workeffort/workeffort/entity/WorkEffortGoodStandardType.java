package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Good Standard Type
 */
public class WorkEffortGoodStandardType implements Serializable {

	public static final long serialVersionUID = 2498917119607374848L;
	public static final String NAME = "WorkEffortGoodStandardType";
	/**
	 * Work Effort Good Std Type Id
	 */
	@Getter
	@Setter
	private String workEffortGoodStdTypeId;
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
		workEffortGoodStdTypeId, parentTypeId, hasTable, description
	}

	public WorkEffortGoodStandardType(GenericValue value) {
		workEffortGoodStdTypeId = (String) value
				.get(Fields.workEffortGoodStdTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkEffortGoodStandardType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortGoodStandardType(value);
	}

	public static List<WorkEffortGoodStandardType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortGoodStandardType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortGoodStandardType(value));
		}
		return entities;
	}
}