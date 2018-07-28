package org.apache.ofbiz.party.party;

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
public class PartyInvitation implements Serializable {

	public static final long serialVersionUID = 1976603060815473664L;
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

	public enum Fields {
		partyInvitationId, partyIdFrom, partyId, toName, emailAddress, statusId, lastInviteDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyInvitation(GenericValue value) {
		partyInvitationId = (String) value.get(Fields.partyInvitationId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyId = (String) value.get(Fields.partyId.name());
		toName = (String) value.get(Fields.toName.name());
		emailAddress = (String) value.get(Fields.emailAddress.name());
		statusId = (String) value.get(Fields.statusId.name());
		lastInviteDate = (Timestamp) value.get(Fields.lastInviteDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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