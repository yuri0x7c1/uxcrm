package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Cost Calc
 */
public class WorkEffortCostCalc implements Serializable {

	public static final long serialVersionUID = 135907884427073536L;
	public static final String NAME = "WorkEffortCostCalc";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Cost Component Type Id
	 */
	@Getter
	@Setter
	private String costComponentTypeId;
	/**
	 * Cost Component Calc Id
	 */
	@Getter
	@Setter
	private String costComponentCalcId;
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
		workEffortId, costComponentTypeId, costComponentCalcId, fromDate, thruDate
	}

	public WorkEffortCostCalc(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		costComponentTypeId = (String) value.get(Fields.costComponentTypeId
				.name());
		costComponentCalcId = (String) value.get(Fields.costComponentCalcId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static WorkEffortCostCalc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortCostCalc(value);
	}

	public static List<WorkEffortCostCalc> fromValues(List<GenericValue> values) {
		List<WorkEffortCostCalc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortCostCalc(value));
		}
		return entities;
	}
}