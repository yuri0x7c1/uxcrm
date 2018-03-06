package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Req Fulf Type
 */
public class WorkReqFulfType implements Serializable {

	public static final long serialVersionUID = 4102538750562009088L;
	public static final String NAME = "WorkReqFulfType";
	/**
	 * Work Req Fulf Type Id
	 */
	@Getter
	@Setter
	private String workReqFulfTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		workReqFulfTypeId, description
	}

	public WorkReqFulfType(GenericValue value) {
		workReqFulfTypeId = (String) value.get(Fields.workReqFulfTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static WorkReqFulfType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkReqFulfType(value);
	}

	public static List<WorkReqFulfType> fromValues(List<GenericValue> values) {
		List<WorkReqFulfType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkReqFulfType(value));
		}
		return entities;
	}
}