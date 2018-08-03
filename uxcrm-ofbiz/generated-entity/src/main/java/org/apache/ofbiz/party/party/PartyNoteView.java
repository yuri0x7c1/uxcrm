package org.apache.ofbiz.party.party;

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

	public static final long serialVersionUID = 8046917573623760896L;
	public static final String NAME = "PartyNoteView";
	/**
	 * Target Party Id
	 */
	@Getter
	@Setter
	private String targetPartyId;
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
	/**
	 * Note Party
	 */
	@Getter
	@Setter
	private String noteParty;

	public enum Fields {
		targetPartyId, noteId, noteName, noteInfo, noteDateTime, noteParty
	}

	public PartyNoteView(GenericValue value) {
		targetPartyId = (String) value.get(Fields.targetPartyId.name());
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
		noteParty = (String) value.get(Fields.noteParty.name());
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