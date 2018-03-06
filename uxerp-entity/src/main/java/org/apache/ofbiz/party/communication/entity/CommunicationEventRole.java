package org.apache.ofbiz.party.communication.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Communication Event Role
 */
public class CommunicationEventRole implements Serializable {

	public static final long serialVersionUID = 2284876546637809664L;
	public static final String NAME = "CommunicationEventRole";
	/**
	 * Communication Event Id
	 */
	@Getter
	@Setter
	private String communicationEventId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public enum Fields {
		communicationEventId, partyId, roleTypeId, contactMechId, statusId
	}

	public CommunicationEventRole(GenericValue value) {
		communicationEventId = (String) value.get(Fields.communicationEventId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		statusId = (String) value.get(Fields.statusId.name());
	}

	public static CommunicationEventRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommunicationEventRole(value);
	}

	public static List<CommunicationEventRole> fromValues(
			List<GenericValue> values) {
		List<CommunicationEventRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommunicationEventRole(value));
		}
		return entities;
	}
}