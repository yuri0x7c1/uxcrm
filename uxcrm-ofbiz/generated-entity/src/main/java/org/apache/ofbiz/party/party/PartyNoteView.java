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
 * Party Note View
 */
@FieldNameConstants
public class PartyNoteView implements Serializable {

	public static final long serialVersionUID = 4233197151193950208L;
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

	public PartyNoteView(GenericValue value) {
		targetPartyId = (String) value.get(FIELD_TARGET_PARTY_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
		noteParty = (String) value.get(FIELD_NOTE_PARTY);
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