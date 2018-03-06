package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Trans Box
 */
public class WorkEffortTransBox implements Serializable {

	public static final long serialVersionUID = 8523395384635558912L;
	public static final String NAME = "WorkEffortTransBox";
	/**
	 * Process Work Effort Id
	 */
	@Getter
	@Setter
	private String processWorkEffortId;
	/**
	 * To Activity Id
	 */
	@Getter
	@Setter
	private String toActivityId;
	/**
	 * Transition Id
	 */
	@Getter
	@Setter
	private String transitionId;

	public enum Fields {
		processWorkEffortId, toActivityId, transitionId
	}

	public WorkEffortTransBox(GenericValue value) {
		processWorkEffortId = (String) value.get(Fields.processWorkEffortId
				.name());
		toActivityId = (String) value.get(Fields.toActivityId.name());
		transitionId = (String) value.get(Fields.transitionId.name());
	}

	public static WorkEffortTransBox fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortTransBox(value);
	}

	public static List<WorkEffortTransBox> fromValues(List<GenericValue> values) {
		List<WorkEffortTransBox> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortTransBox(value));
		}
		return entities;
	}
}