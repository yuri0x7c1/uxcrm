package org.apache.ofbiz.party.party.entity;

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

	public static final long serialVersionUID = 129381254212350976L;
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

	public enum Fields {
		partyInvitationId, partyIdFrom, partyId, toName, emailAddress, statusId, lastInviteDate
	}

	public PartyInvitation(GenericValue value) {
		partyInvitationId = (String) value.get(Fields.partyInvitationId.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyId = (String) value.get(Fields.partyId.name());
		toName = (String) value.get(Fields.toName.name());
		emailAddress = (String) value.get(Fields.emailAddress.name());
		statusId = (String) value.get(Fields.statusId.name());
		lastInviteDate = (Timestamp) value.get(Fields.lastInviteDate.name());
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