package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Reason
 */
public class ReturnReason implements Serializable {

	public static final long serialVersionUID = 2221464792871390208L;
	public static final String NAME = "ReturnReason";
	/**
	 * Return Reason Id
	 */
	@Getter
	@Setter
	private String returnReasonId;
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

	public enum Fields {
		returnReasonId, description, sequenceId
	}

	public ReturnReason(GenericValue value) {
		returnReasonId = (String) value.get(Fields.returnReasonId.name());
		description = (String) value.get(Fields.description.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
	}

	public static ReturnReason fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnReason(value);
	}

	public static List<ReturnReason> fromValues(List<GenericValue> values) {
		List<ReturnReason> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnReason(value));
		}
		return entities;
	}
}