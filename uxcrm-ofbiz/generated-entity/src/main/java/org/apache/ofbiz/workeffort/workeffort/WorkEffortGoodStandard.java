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
 * Work Effort Good Standard
 */
@FieldNameConstants
public class WorkEffortGoodStandard implements Serializable {

	public static final long serialVersionUID = 796087507908669440L;
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

	public WorkEffortGoodStandard(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		workEffortGoodStdTypeId = (String) value
				.get(FIELD_WORK_EFFORT_GOOD_STD_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		estimatedQuantity = (Double) value.get(FIELD_ESTIMATED_QUANTITY);
		estimatedCost = (BigDecimal) value.get(FIELD_ESTIMATED_COST);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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