package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Ics Avs Override
 */
public class PartyIcsAvsOverride implements Serializable {

	public static final long serialVersionUID = 523905727000507392L;
	public static final String NAME = "PartyIcsAvsOverride";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Avs Decline String
	 */
	@Getter
	@Setter
	private String avsDeclineString;
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
		partyId, avsDeclineString, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PartyIcsAvsOverride(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		avsDeclineString = (String) value.get(Fields.avsDeclineString.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static PartyIcsAvsOverride fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIcsAvsOverride(value);
	}

	public static List<PartyIcsAvsOverride> fromValues(List<GenericValue> values) {
		List<PartyIcsAvsOverride> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIcsAvsOverride(value));
		}
		return entities;
	}
}