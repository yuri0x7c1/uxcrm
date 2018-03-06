package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Identification
 */
public class PartyIdentification implements Serializable {

	public static final long serialVersionUID = 4831000781481210880L;
	public static final String NAME = "PartyIdentification";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Identification Type Id
	 */
	@Getter
	@Setter
	private String partyIdentificationTypeId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;

	public enum Fields {
		partyId, partyIdentificationTypeId, idValue
	}

	public PartyIdentification(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyIdentificationTypeId = (String) value
				.get(Fields.partyIdentificationTypeId.name());
		idValue = (String) value.get(Fields.idValue.name());
	}

	public static PartyIdentification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIdentification(value);
	}

	public static List<PartyIdentification> fromValues(List<GenericValue> values) {
		List<PartyIdentification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIdentification(value));
		}
		return entities;
	}
}