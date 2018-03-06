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
 * Work Effort Good Standard
 */
public class WorkEffortGoodStandard implements Serializable {

	public static final long serialVersionUID = 1105661143128651776L;
	public static final String NAME = "WorkEffortGoodStandard";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Work Effort Good Std Type Id
	 */
	@Getter
	@Setter
	private String workEffortGoodStdTypeId;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Estimated Quantity
	 */
	@Getter
	@Setter
	private Double estimatedQuantity;
	/**
	 * Estimated Cost
	 */
	@Getter
	@Setter
	private BigDecimal estimatedCost;

	public enum Fields {
		workEffortId, productId, workEffortGoodStdTypeId, fromDate, thruDate, statusId, estimatedQuantity, estimatedCost
	}

	public WorkEffortGoodStandard(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		productId = (String) value.get(Fields.productId.name());
		workEffortGoodStdTypeId = (String) value
				.get(Fields.workEffortGoodStdTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		estimatedQuantity = (Double) value.get(Fields.estimatedQuantity.name());
		estimatedCost = (BigDecimal) value.get(Fields.estimatedCost.name());
	}

	public static WorkEffortGoodStandard fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortGoodStandard(value);
	}

	public static List<WorkEffortGoodStandard> fromValues(
			List<GenericValue> values) {
		List<WorkEffortGoodStandard> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortGoodStandard(value));
		}
		return entities;
	}
}