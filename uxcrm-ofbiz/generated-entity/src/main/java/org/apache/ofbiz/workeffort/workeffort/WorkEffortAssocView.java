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
 * Work Effort Assoc View
 */
@FieldNameConstants
public class WorkEffortAssocView implements Serializable {

	public static final long serialVersionUID = 2575994796185612288L;
	public static final String NAME = "WorkEffortAssocView";
	/**
	 * Work Effort To Name
	 */
	@Getter
	@Setter
	private String workEffortToName;
	/**
	 * Work Effort To Setup
	 */
	@Getter
	@Setter
	private Double workEffortToSetup;
	/**
	 * Work Effort To Run
	 */
	@Getter
	@Setter
	private Double workEffortToRun;
	/**
	 * Work Effort To Parent Id
	 */
	@Getter
	@Setter
	private String workEffortToParentId;
	/**
	 * Work Effort To Current Status Id
	 */
	@Getter
	@Setter
	private String workEffortToCurrentStatusId;
	/**
	 * Work Effort To Work Effort Purpose Type Id
	 */
	@Getter
	@Setter
	private String workEffortToWorkEffortPurposeTypeId;
	/**
	 * Work Effort To Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp workEffortToEstimatedStartDate;
	/**
	 * Work Effort To Estimated Completion Date
	 */
	@Getter
	@Setter
	private Timestamp workEffortToEstimatedCompletionDate;
	/**
	 * Work Effort To Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp workEffortToActualStartDate;
	/**
	 * Work Effort To Actual Completion Date
	 */
	@Getter
	@Setter
	private Timestamp workEffortToActualCompletionDate;
	/**
	 * Work Effort Id To
	 */
	@Getter
	@Setter
	private String workEffortIdTo;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Work Effort Id From
	 */
	@Getter
	@Setter
	private String workEffortIdFrom;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Work Effort Assoc Type Id
	 */
	@Getter
	@Setter
	private String workEffortAssocTypeId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public WorkEffortAssocView(GenericValue value) {
		workEffortToName = (String) value.get(FIELD_WORK_EFFORT_TO_NAME);
		workEffortToSetup = (Double) value.get(FIELD_WORK_EFFORT_TO_SETUP);
		workEffortToRun = (Double) value.get(FIELD_WORK_EFFORT_TO_RUN);
		workEffortToParentId = (String) value
				.get(FIELD_WORK_EFFORT_TO_PARENT_ID);
		workEffortToCurrentStatusId = (String) value
				.get(FIELD_WORK_EFFORT_TO_CURRENT_STATUS_ID);
		workEffortToWorkEffortPurposeTypeId = (String) value
				.get(FIELD_WORK_EFFORT_TO_WORK_EFFORT_PURPOSE_TYPE_ID);
		workEffortToEstimatedStartDate = (Timestamp) value
				.get(FIELD_WORK_EFFORT_TO_ESTIMATED_START_DATE);
		workEffortToEstimatedCompletionDate = (Timestamp) value
				.get(FIELD_WORK_EFFORT_TO_ESTIMATED_COMPLETION_DATE);
		workEffortToActualStartDate = (Timestamp) value
				.get(FIELD_WORK_EFFORT_TO_ACTUAL_START_DATE);
		workEffortToActualCompletionDate = (Timestamp) value
				.get(FIELD_WORK_EFFORT_TO_ACTUAL_COMPLETION_DATE);
		workEffortIdTo = (String) value.get(FIELD_WORK_EFFORT_ID_TO);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		workEffortIdFrom = (String) value.get(FIELD_WORK_EFFORT_ID_FROM);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		workEffortAssocTypeId = (String) value
				.get(FIELD_WORK_EFFORT_ASSOC_TYPE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static WorkEffortAssocView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAssocView(value);
	}

	public static List<WorkEffortAssocView> fromValues(List<GenericValue> values) {
		List<WorkEffortAssocView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAssocView(value));
		}
		return entities;
	}
}