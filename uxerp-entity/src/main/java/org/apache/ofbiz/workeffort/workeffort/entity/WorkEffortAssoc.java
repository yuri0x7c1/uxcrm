package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Assoc
 */
public class WorkEffortAssoc implements Serializable {

	public static final long serialVersionUID = 2033855459208078336L;
	public static final String NAME = "WorkEffortAssoc";
	/**
	 * Work Effort Id From
	 */
	@Getter
	@Setter
	private String workEffortIdFrom;
	/**
	 * Work Effort Id To
	 */
	@Getter
	@Setter
	private String workEffortIdTo;
	/**
	 * Work Effort Assoc Type Id
	 */
	@Getter
	@Setter
	private String workEffortAssocTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		workEffortIdFrom, workEffortIdTo, workEffortAssocTypeId, sequenceNum, fromDate, thruDate
	}

	public WorkEffortAssoc(GenericValue value) {
		workEffortIdFrom = (String) value.get(Fields.workEffortIdFrom.name());
		workEffortIdTo = (String) value.get(Fields.workEffortIdTo.name());
		workEffortAssocTypeId = (String) value.get(Fields.workEffortAssocTypeId
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static WorkEffortAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAssoc(value);
	}

	public static List<WorkEffortAssoc> fromValues(List<GenericValue> values) {
		List<WorkEffortAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAssoc(value));
		}
		return entities;
	}
}