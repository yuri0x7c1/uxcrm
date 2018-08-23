package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyInvitationRoleAssoc implements Serializable {

	public static final long serialVersionUID = 3902196661021468672L;
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

	public PartyInvitationRoleAssoc(GenericValue value) {
		partyInvitationId = (String) value.get(FIELD_PARTY_INVITATION_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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