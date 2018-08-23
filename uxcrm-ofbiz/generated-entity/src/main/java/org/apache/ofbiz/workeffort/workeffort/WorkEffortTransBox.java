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
 * Work Effort Trans Box
 */
@FieldNameConstants
public class WorkEffortTransBox implements Serializable {

	public static final long serialVersionUID = 4037068570366282752L;
	public static final String NAME = "WorkEffortTransBox";
	/**
	 * Process Work Effort Id
	 */
	@Getter
	@Setter
	private String processWorkEffortId;
	/**
	 * To Activity Id
	 */
	@Getter
	@Setter
	private String toActivityId;
	/**
	 * Transition Id
	 */
	@Getter
	@Setter
	private String transitionId;
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

	public WorkEffortTransBox(GenericValue value) {
		processWorkEffortId = (String) value.get(FIELD_PROCESS_WORK_EFFORT_ID);
		toActivityId = (String) value.get(FIELD_TO_ACTIVITY_ID);
		transitionId = (String) value.get(FIELD_TRANSITION_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortTransBox fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortTransBox(value);
	}

	public static List<WorkEffortTransBox> fromValues(List<GenericValue> values) {
		List<WorkEffortTransBox> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortTransBox(value));
		}
		return entities;
	}
}