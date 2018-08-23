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
 * Work Effort Cost Calc
 */
@FieldNameConstants
public class WorkEffortCostCalc implements Serializable {

	public static final long serialVersionUID = 6932871944456988672L;
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

	public WorkEffortCostCalc(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		costComponentTypeId = (String) value.get(FIELD_COST_COMPONENT_TYPE_ID);
		costComponentCalcId = (String) value.get(FIELD_COST_COMPONENT_CALC_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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