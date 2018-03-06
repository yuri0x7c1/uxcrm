package org.apache.ofbiz.common.note.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Note Data
 */
public class NoteData implements Serializable {

	public static final long serialVersionUID = 2981956236683170816L;
	public static final String NAME = "NoteData";
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
		noteId, noteName, noteInfo, noteDateTime
	}

	public NoteData(GenericValue value) {
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
	}

	public static NoteData fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new NoteData(value);
	}

	public static List<NoteData> fromValues(List<GenericValue> values) {
		List<NoteData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new NoteData(value));
		}
		return entities;
	}
}