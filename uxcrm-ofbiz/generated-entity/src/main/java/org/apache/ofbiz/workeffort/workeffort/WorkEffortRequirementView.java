package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortRequirementView implements Serializable {

	public static final long serialVersionUID = 8529167783455087616L;
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

	public enum Fields {
		statusItemDescription, workReqFulfTypeDescription, requirementDescription, workEffortId, workReqFulfTypeId, requirementId, reason, facilityId, quantity, productId, lastModifiedDate, estimatedBudget, description, requiredByDate, requirementStartDate, requirementTypeId, useCase, lastModifiedByUserLogin, createdDate, statusId, fixedAssetId, createdByUserLogin, deliverableId
	}

	public WorkEffortRequirementView(GenericValue value) {
		statusItemDescription = (String) value.get(Fields.statusItemDescription
				.name());
		workReqFulfTypeDescription = (String) value
				.get(Fields.workReqFulfTypeDescription.name());
		requirementDescription = (String) value
				.get(Fields.requirementDescription.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		workReqFulfTypeId = (String) value.get(Fields.workReqFulfTypeId.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		reason = (String) value.get(Fields.reason.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		productId = (String) value.get(Fields.productId.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		estimatedBudget = (BigDecimal) value.get(Fields.estimatedBudget.name());
		description = (String) value.get(Fields.description.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		requirementStartDate = (Timestamp) value
				.get(Fields.requirementStartDate.name());
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		useCase = (String) value.get(Fields.useCase.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		deliverableId = (String) value.get(Fields.deliverableId.name());
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