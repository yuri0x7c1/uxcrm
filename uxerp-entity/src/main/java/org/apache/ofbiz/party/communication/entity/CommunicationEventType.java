package org.apache.ofbiz.party.communication.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Type
 */
public class CommunicationEventType implements Serializable {

	public static final long serialVersionUID = 1215710570136064000L;
	public static final String NAME = "CommunicationEventType";
	/**
	 * Communication Event Type Id
	 */
	@Getter
	@Setter
	private String communicationEventTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;

	public enum Fields {
		communicationEventTypeId, parentTypeId, hasTable, description, contactMechTypeId
	}

	public CommunicationEventType(GenericValue value) {
		communicationEventTypeId = (String) value
				.get(Fields.communicationEventTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
	}

	public static CommunicationEventType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventType(value);
	}

	public static List<CommunicationEventType> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventType(value));
		}
		return entities;
	}
}