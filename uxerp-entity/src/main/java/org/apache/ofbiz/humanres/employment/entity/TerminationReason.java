package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Termination Reason
 */
public class TerminationReason implements Serializable {

	public static final long serialVersionUID = 8116079174423451648L;
	public static final String NAME = "TerminationReason";
	/**
	 * Termination Reason Id
	 */
	@Getter
	@Setter
	private String terminationReasonId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		terminationReasonId, description
	}

	public TerminationReason(GenericValue value) {
		terminationReasonId = (String) value.get(Fields.terminationReasonId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TerminationReason fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TerminationReason(value);
	}

	public static List<TerminationReason> fromValues(List<GenericValue> values) {
		List<TerminationReason> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TerminationReason(value));
		}
		return entities;
	}
}