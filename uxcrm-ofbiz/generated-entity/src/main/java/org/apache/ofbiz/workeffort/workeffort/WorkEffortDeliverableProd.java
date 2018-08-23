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
 * Work Effort Deliverable Prod
 */
@FieldNameConstants
public class WorkEffortDeliverableProd implements Serializable {

	public static final long serialVersionUID = 4349061678846765056L;
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

	public WorkEffortDeliverableProd(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		deliverableId = (String) value.get(FIELD_DELIVERABLE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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