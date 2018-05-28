package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Deliverable Prod
 */
public class WorkEffortDeliverableProd implements Serializable {

	public static final long serialVersionUID = 8236752109602126848L;
	public static final String NAME = "WorkEffortDeliverableProd";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;
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
		workEffortId, deliverableId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortDeliverableProd(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		deliverableId = (String) value.get(Fields.deliverableId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortDeliverableProd fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortDeliverableProd(value);
	}

	public static List<WorkEffortDeliverableProd> fromValues(
			List<GenericValue> values) {
		List<WorkEffortDeliverableProd> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortDeliverableProd(value));
		}
		return entities;
	}
}