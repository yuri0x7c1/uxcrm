package org.apache.ofbiz.party.communication;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Sum
 */
public class CommunicationEventSum implements Serializable {

	public static final long serialVersionUID = 4875904710721843200L;
	public static final String NAME = "CommunicationEventSum";
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private Long communicationEventId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;

	public enum Fields {
		communicationEventId, statusId, partyIdTo
	}

	public CommunicationEventSum(GenericValue value) {
		communicationEventId = (Long) value.get(Fields.communicationEventId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
	}

	public static CommunicationEventSum fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventSum(value);
	}

	public static List<CommunicationEventSum> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventSum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventSum(value));
		}
		return entities;
	}
}