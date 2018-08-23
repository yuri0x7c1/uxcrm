package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class WorkEffortNoteAndData implements Serializable {

	public static final long serialVersionUID = 4850428598304630784L;
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

	public WorkEffortNoteAndData(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		internalNote = (String) value.get(FIELD_INTERNAL_NOTE);
		noteId = (String) value.get(FIELD_NOTE_ID);
		noteName = (String) value.get(FIELD_NOTE_NAME);
		noteInfo = (String) value.get(FIELD_NOTE_INFO);
		noteParty = (String) value.get(FIELD_NOTE_PARTY);
		noteDateTime = (Timestamp) value.get(FIELD_NOTE_DATE_TIME);
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