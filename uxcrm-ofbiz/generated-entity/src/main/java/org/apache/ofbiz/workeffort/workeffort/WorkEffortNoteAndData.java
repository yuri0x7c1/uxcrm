package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Note And Data
 */
public class WorkEffortNoteAndData implements Serializable {

	public static final long serialVersionUID = 4970256104293610496L;
	public static final String NAME = "WorkEffortNoteAndData";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Internal Note
	 */
	@Getter
	@Setter
	private String internalNote;
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
	 * Note Party
	 */
	@Getter
	@Setter
	private String noteParty;
	/**
	 * Note Date Time
	 */
	@Getter
	@Setter
	private Timestamp noteDateTime;

	public enum Fields {
		workEffortId, internalNote, noteId, noteName, noteInfo, noteParty, noteDateTime
	}

	public WorkEffortNoteAndData(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		internalNote = (String) value.get(Fields.internalNote.name());
		noteId = (String) value.get(Fields.noteId.name());
		noteName = (String) value.get(Fields.noteName.name());
		noteInfo = (String) value.get(Fields.noteInfo.name());
		noteParty = (String) value.get(Fields.noteParty.name());
		noteDateTime = (Timestamp) value.get(Fields.noteDateTime.name());
	}

	public static WorkEffortNoteAndData fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortNoteAndData(value);
	}

	public static List<WorkEffortNoteAndData> fromValues(
			List<GenericValue> values) {
		List<WorkEffortNoteAndData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortNoteAndData(value));
		}
		return entities;
	}
}