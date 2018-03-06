package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Work Eff
 */
public class CommunicationEventWorkEff implements Serializable {

	public static final long serialVersionUID = 1188028927431271424L;
	public static final String NAME = "CommunicationEventWorkEff";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		workEffortId, communicationEventId, description
	}

	public CommunicationEventWorkEff(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CommunicationEventWorkEff fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventWorkEff(value);
	}

	public static List<CommunicationEventWorkEff> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventWorkEff> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventWorkEff(value));
		}
		return entities;
	}
}