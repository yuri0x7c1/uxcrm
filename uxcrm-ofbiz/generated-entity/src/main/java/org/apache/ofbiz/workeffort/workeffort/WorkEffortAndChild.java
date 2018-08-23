package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort And Child
 */
@FieldNameConstants
public class WorkEffortAndChild implements Serializable {

	public static final long serialVersionUID = 2087759612775102464L;
	public static final String NAME = "WorkEffortAndChild";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Work Effort Parent Id
	 */
	@Getter
	@Setter
	private String workEffortParentId;
	/**
	 * Current Status Id
	 */
	@Getter
	@Setter
	private String currentStatusId;
	/**
	 * Child Work Effort Id
	 */
	@Getter
	@Setter
	private String childWorkEffortId;
	/**
	 * Child Work Effort Name
	 */
	@Getter
	@Setter
	private String childWorkEffortName;
	/**
	 * Child Work Effort Type Id
	 */
	@Getter
	@Setter
	private String childWorkEffortTypeId;
	/**
	 * Child Current Status Id
	 */
	@Getter
	@Setter
	private String childCurrentStatusId;

	public WorkEffortAndChild(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		workEffortName = (String) value.get(FIELD_WORK_EFFORT_NAME);
		workEffortTypeId = (String) value.get(FIELD_WORK_EFFORT_TYPE_ID);
		workEffortParentId = (String) value.get(FIELD_WORK_EFFORT_PARENT_ID);
		currentStatusId = (String) value.get(FIELD_CURRENT_STATUS_ID);
		childWorkEffortId = (String) value.get(FIELD_CHILD_WORK_EFFORT_ID);
		childWorkEffortName = (String) value.get(FIELD_CHILD_WORK_EFFORT_NAME);
		childWorkEffortTypeId = (String) value
				.get(FIELD_CHILD_WORK_EFFORT_TYPE_ID);
		childCurrentStatusId = (String) value
				.get(FIELD_CHILD_CURRENT_STATUS_ID);
	}

	public static WorkEffortAndChild fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAndChild(value);
	}

	public static List<WorkEffortAndChild> fromValues(List<GenericValue> values) {
		List<WorkEffortAndChild> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAndChild(value));
		}
		return entities;
	}
}