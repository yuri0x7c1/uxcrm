package org.apache.ofbiz.workeffort.workeffort.entity;

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
public class WorkEffortFixedAssetAssign implements Serializable {

	public static final long serialVersionUID = 8055065543504718848L;
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

	public enum Fields {
		workEffortId, fixedAssetId, statusId, fromDate, thruDate, availabilityStatusId, allocatedCost, comments
	}

	public WorkEffortFixedAssetAssign(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		statusId = (String) value.get(Fields.statusId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		availabilityStatusId = (String) value.get(Fields.availabilityStatusId
				.name());
		allocatedCost = (BigDecimal) value.get(Fields.allocatedCost.name());
		comments = (String) value.get(Fields.comments.name());
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