package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Ics Avs Override
 */
public class PartyIcsAvsOverride implements Serializable {

	public static final long serialVersionUID = 7591085514976096256L;
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

	public enum Fields {
		partyId, avsDeclineString
	}

	public PartyIcsAvsOverride(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		avsDeclineString = (String) value.get(Fields.avsDeclineString.name());
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