package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Deliverable Prod
 */
public class WorkEffortDeliverableProd implements Serializable {

	public static final long serialVersionUID = 7271133142492292096L;
	public static final String NAME = "WorkEffortDeliverableProd";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;

	public enum Fields {
		workEffortId, deliverableId
	}

	public WorkEffortDeliverableProd(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		deliverableId = (String) value.get(Fields.deliverableId.name());
	}

	public static WorkEffortDeliverableProd fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortDeliverableProd(value);
	}

	public static List<WorkEffortDeliverableProd> fromValues(
			List<GenericValue> values) {
		List<WorkEffortDeliverableProd> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortDeliverableProd(value));
		}
		return entities;
	}
}