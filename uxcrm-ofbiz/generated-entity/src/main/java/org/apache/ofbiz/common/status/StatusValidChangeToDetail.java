package org.apache.ofbiz.common.status;

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

	public static final long serialVersionUID = 620694916339169280L;
	public static final String NAME = "StatusValidChangeToDetail";
	/**
	 * Condition Expression
	 */
	@Getter
	@Setter
	private String conditionExpression;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Status Code
	 */
	@Getter
	@Setter
	private String statusCode;

	public enum Fields {
		conditionExpression, statusId, statusIdTo, transitionName, statusTypeId, description, sequenceId, statusCode
	}

	public StatusValidChangeToDetail(GenericValue value) {
		conditionExpression = (String) value.get(Fields.conditionExpression
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusIdTo = (String) value.get(Fields.statusIdTo.name());
		transitionName = (String) value.get(Fields.transitionName.name());
		statusTypeId = (String) value.get(Fields.statusTypeId.name());
		description = (String) value.get(Fields.description.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		statusCode = (String) value.get(Fields.statusCode.name());
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