package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortAssocView implements Serializable {

	public static final long serialVersionUID = 812907282040349696L;
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

	public enum Fields {
		workEffortToName, workEffortToSetup, workEffortToRun, workEffortToParentId, workEffortToCurrentStatusId, workEffortToWorkEffortPurposeTypeId, workEffortToEstimatedStartDate, workEffortToEstimatedCompletionDate, workEffortToActualStartDate, workEffortToActualCompletionDate, workEffortIdTo, fromDate, workEffortIdFrom, sequenceNum, workEffortAssocTypeId, thruDate
	}

	public WorkEffortAssocView(GenericValue value) {
		workEffortToName = (String) value.get(Fields.workEffortToName.name());
		workEffortToSetup = (Double) value.get(Fields.workEffortToSetup.name());
		workEffortToRun = (Double) value.get(Fields.workEffortToRun.name());
		workEffortToParentId = (String) value.get(Fields.workEffortToParentId
				.name());
		workEffortToCurrentStatusId = (String) value
				.get(Fields.workEffortToCurrentStatusId.name());
		workEffortToWorkEffortPurposeTypeId = (String) value
				.get(Fields.workEffortToWorkEffortPurposeTypeId.name());
		workEffortToEstimatedStartDate = (Timestamp) value
				.get(Fields.workEffortToEstimatedStartDate.name());
		workEffortToEstimatedCompletionDate = (Timestamp) value
				.get(Fields.workEffortToEstimatedCompletionDate.name());
		workEffortToActualStartDate = (Timestamp) value
				.get(Fields.workEffortToActualStartDate.name());
		workEffortToActualCompletionDate = (Timestamp) value
				.get(Fields.workEffortToActualCompletionDate.name());
		workEffortIdTo = (String) value.get(Fields.workEffortIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		workEffortIdFrom = (String) value.get(Fields.workEffortIdFrom.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		workEffortAssocTypeId = (String) value.get(Fields.workEffortAssocTypeId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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