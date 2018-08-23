package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Fixed Asset Assign
 */
@FieldNameConstants
public class WorkEffortFixedAssetAssign implements Serializable {

	public static final long serialVersionUID = 4054077795850277888L;
	public static final String NAME = "WorkEffortFixedAssetAssign";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Availability Status Id
	 */
	@Getter
	@Setter
	private String availabilityStatusId;
	/**
	 * Allocated Cost
	 */
	@Getter
	@Setter
	private BigDecimal allocatedCost;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public WorkEffortFixedAssetAssign(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		availabilityStatusId = (String) value.get(FIELD_AVAILABILITY_STATUS_ID);
		allocatedCost = (BigDecimal) value.get(FIELD_ALLOCATED_COST);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortFixedAssetAssign fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortFixedAssetAssign(value);
	}

	public static List<WorkEffortFixedAssetAssign> fromValues(
			List<GenericValue> values) {
		List<WorkEffortFixedAssetAssign> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortFixedAssetAssign(value));
		}
		return entities;
	}
}