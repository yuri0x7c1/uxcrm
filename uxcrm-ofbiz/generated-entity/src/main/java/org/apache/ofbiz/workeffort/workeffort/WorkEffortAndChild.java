package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort And Child
 */
public class WorkEffortAndChild implements Serializable {

	public static final long serialVersionUID = 1496954067141557248L;
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

	public enum Fields {
		workEffortId, workEffortName, workEffortTypeId, workEffortParentId, currentStatusId, childWorkEffortId, childWorkEffortName, childWorkEffortTypeId, childCurrentStatusId
	}

	public WorkEffortAndChild(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		workEffortParentId = (String) value.get(Fields.workEffortParentId
				.name());
		currentStatusId = (String) value.get(Fields.currentStatusId.name());
		childWorkEffortId = (String) value.get(Fields.childWorkEffortId.name());
		childWorkEffortName = (String) value.get(Fields.childWorkEffortName
				.name());
		childWorkEffortTypeId = (String) value.get(Fields.childWorkEffortTypeId
				.name());
		childCurrentStatusId = (String) value.get(Fields.childCurrentStatusId
				.name());
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