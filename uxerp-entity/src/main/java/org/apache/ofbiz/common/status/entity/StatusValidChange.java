package org.apache.ofbiz.common.status.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Status Valid Change
 */
public class StatusValidChange implements Serializable {

	public static final long serialVersionUID = 1992595543181707264L;
	public static final String NAME = "StatusValidChange";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Id To
	 */
	@Getter
	@Setter
	private String statusIdTo;
	/**
	 * Condition Expression
	 */
	@Getter
	@Setter
	private String conditionExpression;
	/**
	 * Transition Name
	 */
	@Getter
	@Setter
	private String transitionName;

	public enum Fields {
		statusId, statusIdTo, conditionExpression, transitionName
	}

	public StatusValidChange(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		statusIdTo = (String) value.get(Fields.statusIdTo.name());
		conditionExpression = (String) value.get(Fields.conditionExpression
				.name());
		transitionName = (String) value.get(Fields.transitionName.name());
	}

	public static StatusValidChange fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new StatusValidChange(value);
	}

	public static List<StatusValidChange> fromValues(List<GenericValue> values) {
		List<StatusValidChange> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new StatusValidChange(value));
		}
		return entities;
	}
}