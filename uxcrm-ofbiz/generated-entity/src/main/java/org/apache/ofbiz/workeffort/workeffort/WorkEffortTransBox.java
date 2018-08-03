package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortTransBox implements Serializable {

	public static final long serialVersionUID = 704349004646084608L;
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

	public enum Fields {
		processWorkEffortId, toActivityId, transitionId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortTransBox(GenericValue value) {
		processWorkEffortId = (String) value.get(Fields.processWorkEffortId
				.name());
		toActivityId = (String) value.get(Fields.toActivityId.name());
		transitionId = (String) value.get(Fields.transitionId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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