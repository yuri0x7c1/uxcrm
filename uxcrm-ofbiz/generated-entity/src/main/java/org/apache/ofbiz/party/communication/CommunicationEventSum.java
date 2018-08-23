package org.apache.ofbiz.party.communication;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Sum
 */
@FieldNameConstants
public class CommunicationEventSum implements Serializable {

	public static final long serialVersionUID = 2727436784258548736L;
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

	public CommunicationEventSum(GenericValue value) {
		communicationEventId = (Long) value.get(FIELD_COMMUNICATION_EVENT_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
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