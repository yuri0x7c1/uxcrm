package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Invitation Role Assoc
 */
public class PartyInvitationRoleAssoc implements Serializable {

	public static final long serialVersionUID = 2446932104302259200L;
	public static final String NAME = "PartyInvitationRoleAssoc";
	/**
	 * Party Invitation Id
	 */
	@Getter
	@Setter
	private String partyInvitationId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;

	public enum Fields {
		partyInvitationId, roleTypeId
	}

	public PartyInvitationRoleAssoc(GenericValue value) {
		partyInvitationId = (String) value.get(Fields.partyInvitationId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static PartyInvitationRoleAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyInvitationRoleAssoc(value);
	}

	public static List<PartyInvitationRoleAssoc> fromValues(
			List<GenericValue> values) {
		List<PartyInvitationRoleAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyInvitationRoleAssoc(value));
		}
		return entities;
	}
}