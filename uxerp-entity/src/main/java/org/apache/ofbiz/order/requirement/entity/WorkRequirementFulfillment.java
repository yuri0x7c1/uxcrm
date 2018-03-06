package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Requirement Fulfillment
 */
public class WorkRequirementFulfillment implements Serializable {

	public static final long serialVersionUID = 4782796960127947776L;
	public static final String NAME = "WorkRequirementFulfillment";
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Work Req Fulf Type Id
	 */
	@Getter
	@Setter
	private String workReqFulfTypeId;

	public enum Fields {
		requirementId, workEffortId, workReqFulfTypeId
	}

	public WorkRequirementFulfillment(GenericValue value) {
		requirementId = (String) value.get(Fields.requirementId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		workReqFulfTypeId = (String) value.get(Fields.workReqFulfTypeId.name());
	}

	public static WorkRequirementFulfillment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkRequirementFulfillment(value);
	}

	public static List<WorkRequirementFulfillment> fromValues(
			List<GenericValue> values) {
		List<WorkRequirementFulfillment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkRequirementFulfillment(value));
		}
		return entities;
	}
}