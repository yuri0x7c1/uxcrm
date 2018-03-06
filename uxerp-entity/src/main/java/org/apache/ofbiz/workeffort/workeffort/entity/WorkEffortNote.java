package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Note
 */
public class WorkEffortNote implements Serializable {

	public static final long serialVersionUID = 3785175059193590784L;
	public static final String NAME = "WorkEffortNote";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * Internal Note
	 */
	@Getter
	@Setter
	private String internalNote;

	public enum Fields {
		workEffortId, noteId, internalNote
	}

	public WorkEffortNote(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		noteId = (String) value.get(Fields.noteId.name());
		internalNote = (String) value.get(Fields.internalNote.name());
	}

	public static WorkEffortNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortNote(value);
	}

	public static List<WorkEffortNote> fromValues(List<GenericValue> values) {
		List<WorkEffortNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortNote(value));
		}
		return entities;
	}
}