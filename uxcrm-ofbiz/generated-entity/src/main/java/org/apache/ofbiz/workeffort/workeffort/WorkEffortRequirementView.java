package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Requirement View
 */
@FieldNameConstants
public class WorkEffortRequirementView implements Serializable {

	public static final long serialVersionUID = 4211621787970435072L;
	public static final String NAME = "WorkEffortRequirementView";
	/**
	 * Status Item Description
	 */
	@Getter
	@Setter
	private String statusItemDescription;
	/**
	 * Work Req Fulf Type Description
	 */
	@Getter
	@Setter
	private String workReqFulfTypeDescription;
	/**
	 * Requirement Description
	 */
	@Getter
	@Setter
	private String requirementDescription;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Work Req Fulf Type Id
	 */
	@Getter
	@Setter
	private String workReqFulfTypeId;
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Estimated Budget
	 */
	@Getter
	@Setter
	private BigDecimal estimatedBudget;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Required By Date
	 */
	@Getter
	@Setter
	private Timestamp requiredByDate;
	/**
	 * Requirement Start Date
	 */
	@Getter
	@Setter
	private Timestamp requirementStartDate;
	/**
	 * Requirement Type Id
	 */
	@Getter
	@Setter
	private String requirementTypeId;
	/**
	 * Use Case
	 */
	@Getter
	@Setter
	private String useCase;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;

	public WorkEffortRequirementView(GenericValue value) {
		statusItemDescription = (String) value
				.get(FIELD_STATUS_ITEM_DESCRIPTION);
		workReqFulfTypeDescription = (String) value
				.get(FIELD_WORK_REQ_FULF_TYPE_DESCRIPTION);
		requirementDescription = (String) value
				.get(FIELD_REQUIREMENT_DESCRIPTION);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		workReqFulfTypeId = (String) value.get(FIELD_WORK_REQ_FULF_TYPE_ID);
		requirementId = (String) value.get(FIELD_REQUIREMENT_ID);
		reason = (String) value.get(FIELD_REASON);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		estimatedBudget = (BigDecimal) value.get(FIELD_ESTIMATED_BUDGET);
		description = (String) value.get(FIELD_DESCRIPTION);
		requiredByDate = (Timestamp) value.get(FIELD_REQUIRED_BY_DATE);
		requirementStartDate = (Timestamp) value
				.get(FIELD_REQUIREMENT_START_DATE);
		requirementTypeId = (String) value.get(FIELD_REQUIREMENT_TYPE_ID);
		useCase = (String) value.get(FIELD_USE_CASE);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		deliverableId = (String) value.get(FIELD_DELIVERABLE_ID);
	}

	public static WorkEffortRequirementView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortRequirementView(value);
	}

	public static List<WorkEffortRequirementView> fromValues(
			List<GenericValue> values) {
		List<WorkEffortRequirementView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortRequirementView(value));
		}
		return entities;
	}
}