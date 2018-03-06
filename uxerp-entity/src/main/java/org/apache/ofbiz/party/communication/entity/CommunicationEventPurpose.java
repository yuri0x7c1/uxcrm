package org.apache.ofbiz.party.communication.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Purpose
 */
public class CommunicationEventPurpose implements Serializable {

	public static final long serialVersionUID = 690999235754009600L;
	public static final String NAME = "CommunicationEventPurpose";
	/**
	 * Communication Event Prp Typ Id
	 */
	@Getter
	@Setter
	private String communicationEventPrpTypId;
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
		communicationEventPrpTypId, communicationEventId, description
	}

	public CommunicationEventPurpose(GenericValue value) {
		communicationEventPrpTypId = (String) value
				.get(Fields.communicationEventPrpTypId.name());
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CommunicationEventPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventPurpose(value);
	}

	public static List<CommunicationEventPurpose> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventPurpose(value));
		}
		return entities;
	}
}