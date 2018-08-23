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
 * Party Invitation Group Assoc
 */
@FieldNameConstants
public class PartyInvitationGroupAssoc implements Serializable {

	public static final long serialVersionUID = 859074440578747392L;
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

	public PartyInvitationGroupAssoc(GenericValue value) {
		partyInvitationId = (String) value.get(FIELD_PARTY_INVITATION_ID);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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