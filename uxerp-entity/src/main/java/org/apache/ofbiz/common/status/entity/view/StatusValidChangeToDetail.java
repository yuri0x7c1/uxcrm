package org.apache.ofbiz.common.status.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Status Valid Change To Detail
 */
public class StatusValidChangeToDetail implements Serializable {

	public static final long serialVersionUID = 8309215326322411520L;
	public static final String NAME = "StatusValidChangeToDetail";
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
	/**
	 * Status Type Id
	 */
	@Getter
	@Setter
	private String statusTypeId;
	/**
	 * Status Code
	 */
	@Getter
	@Setter
	private String statusCode;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		statusId, statusIdTo, conditionExpression, transitionName, statusTypeId, statusCode, sequenceId, description
	}

	public StatusValidChangeToDetail(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		statusIdTo = (String) value.get(Fields.statusIdTo.name());
		conditionExpression = (String) value.get(Fields.conditionExpression
				.name());
		transitionName = (String) value.get(Fields.transitionName.name());
		statusTypeId = (String) value.get(Fields.statusTypeId.name());
		statusCode = (String) value.get(Fields.statusCode.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static StatusValidChangeToDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new StatusValidChangeToDetail(value);
	}

	public static List<StatusValidChangeToDetail> fromValues(
			List<GenericValue> values) {
		List<StatusValidChangeToDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new StatusValidChangeToDetail(value));
		}
		return entities;
	}
}