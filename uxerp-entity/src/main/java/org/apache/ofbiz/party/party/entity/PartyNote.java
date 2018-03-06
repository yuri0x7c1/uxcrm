package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Note
 */
public class PartyNote implements Serializable {

	public static final long serialVersionUID = 618926519668725760L;
	public static final String NAME = "PartyNote";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;

	public enum Fields {
		partyId, noteId
	}

	public PartyNote(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		noteId = (String) value.get(Fields.noteId.name());
	}

	public static PartyNote fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PartyNote(value);
	}

	public static List<PartyNote> fromValues(List<GenericValue> values) {
		List<PartyNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyNote(value));
		}
		return entities;
	}
}