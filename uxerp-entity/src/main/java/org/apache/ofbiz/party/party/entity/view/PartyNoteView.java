package org.apache.ofbiz.party.party.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Note View
 */
public class PartyNoteView implements Serializable {

	public static final long serialVersionUID = 8826362365479353344L;
	public static final String NAME = "PartyNoteView";
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
	/**
	 * Note Name
	 */
	@Getter
	@Setter
	private String noteName;
	/**
	 * Note Info
	 */
	@Getter
	@Setter
	private String noteInfo;
	/**
	 * Note Date Time
	 */
	@Getter
	@Setter
	private Timestamp noteDateTime;

	public enum Fields {
		partyId, noteId, noteName, noteInfo, noteDateTime
	}

	public PartyNoteView(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
	}

	public static PartyNoteView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyNoteView(value);
	}

	public static List<PartyNoteView> fromValues(List<GenericValue> values) {
		List<PartyNoteView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyNoteView(value));
		}
		return entities;
	}
}