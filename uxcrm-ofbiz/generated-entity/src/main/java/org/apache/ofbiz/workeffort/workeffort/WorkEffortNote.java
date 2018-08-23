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
 * Work Effort Note
 */
@FieldNameConstants
public class WorkEffortNote implements Serializable {

	public static final long serialVersionUID = 430346737702408192L;
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

	public WorkEffortNote(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		internalNote = (String) value.get(FIELD_INTERNAL_NOTE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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