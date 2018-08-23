package org.apache.ofbiz.common.status;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Status Valid Change To Detail
 */
@FieldNameConstants
public class StatusValidChangeToDetail implements Serializable {

	public static final long serialVersionUID = 4552745609327928320L;
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

	public StatusValidChangeToDetail(GenericValue value) {
		conditionExpression = (String) value.get(FIELD_CONDITION_EXPRESSION);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusIdTo = (String) value.get(FIELD_STATUS_ID_TO);
		transitionName = (String) value.get(FIELD_TRANSITION_NAME);
		statusTypeId = (String) value.get(FIELD_STATUS_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		statusCode = (String) value.get(FIELD_STATUS_CODE);
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