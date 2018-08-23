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
 * Party Invitation
 */
@FieldNameConstants
public class PartyInvitation implements Serializable {

	public static final long serialVersionUID = 5077792031805255680L;
	public static final String NAME = "PartyInvitation";
	/**
	 * Party Invitation Id
	 */
	@Getter
	@Setter
	private String partyInvitationId;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * To Name
	 */
	@Getter
	@Setter
	private String toName;
	/**
	 * Email Address
	 */
	@Getter
	@Setter
	private String emailAddress;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Last Invite Date
	 */
	@Getter
	@Setter
	private Timestamp lastInviteDate;
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

	public PartyInvitation(GenericValue value) {
		partyInvitationId = (String) value.get(FIELD_PARTY_INVITATION_ID);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyId = (String) value.get(FIELD_PARTY_ID);
		toName = (String) value.get(FIELD_TO_NAME);
		emailAddress = (String) value.get(FIELD_EMAIL_ADDRESS);
		statusId = (String) value.get(FIELD_STATUS_ID);
		lastInviteDate = (Timestamp) value.get(FIELD_LAST_INVITE_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PartyInvitation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyInvitation(value);
	}

	public static List<PartyInvitation> fromValues(List<GenericValue> values) {
		List<PartyInvitation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyInvitation(value));
		}
		return entities;
	}
}