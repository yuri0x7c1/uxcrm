package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Invitation Role Assoc
 */
public class PartyInvitationRoleAssoc implements Serializable {

	public static final long serialVersionUID = 383217581695824896L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		partyInvitationId, roleTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyInvitationRoleAssoc(GenericValue value) {
		partyInvitationId = (String) value.get(Fields.partyInvitationId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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