package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Note
 */
public class WorkEffortNote implements Serializable {

	public static final long serialVersionUID = 6962449081317332992L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		workEffortId, noteId, internalNote, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortNote(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		noteId = (String) value.get(Fields.noteId.name());
		internalNote = (String) value.get(Fields.internalNote.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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