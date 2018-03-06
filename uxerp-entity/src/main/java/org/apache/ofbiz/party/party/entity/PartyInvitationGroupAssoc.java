package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Invitation Group Assoc
 */
public class PartyInvitationGroupAssoc implements Serializable {

	public static final long serialVersionUID = 6257538516192044032L;
	public static final String NAME = "PartyInvitationGroupAssoc";
	/**
	 * Party Invitation Id
	 */
	@Getter
	@Setter
	private String partyInvitationId;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;

	public enum Fields {
		partyInvitationId, partyIdTo
	}

	public PartyInvitationGroupAssoc(GenericValue value) {
		partyInvitationId = (String) value.get(Fields.partyInvitationId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
	}

	public static PartyInvitationGroupAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyInvitationGroupAssoc(value);
	}

	public static List<PartyInvitationGroupAssoc> fromValues(
			List<GenericValue> values) {
		List<PartyInvitationGroupAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyInvitationGroupAssoc(value));
		}
		return entities;
	}
}