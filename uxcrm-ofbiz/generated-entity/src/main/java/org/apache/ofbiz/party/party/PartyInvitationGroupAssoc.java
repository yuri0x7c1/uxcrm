package org.apache.ofbiz.party.party;

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
public class PartyInvitationGroupAssoc implements Serializable {

	public static final long serialVersionUID = 5010673392308715520L;
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

	public enum Fields {
		partyInvitationId, partyIdTo, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyInvitationGroupAssoc(GenericValue value) {
		partyInvitationId = (String) value.get(Fields.partyInvitationId.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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