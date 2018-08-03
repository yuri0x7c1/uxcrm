package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort And Fulfillment
 */
public class WorkEffortAndFulfillment implements Serializable {

	public static final long serialVersionUID = 7636427061527182336L;
	public static final String NAME = "WorkEffortAndFulfillment";
	/**
	 * Work Effort Description
	 */
	@Getter
	@Setter
	private String workEffortDescription;
	/**
	 * Work Effort Fixed Asset Id
	 */
	@Getter
	@Setter
	private String workEffortFixedAssetId;
	/**
	 * Work Effort Facility Id
	 */
	@Getter
	@Setter
	private String workEffortFacilityId;
	/**
	 * Requirement Facility Id
	 */
	@Getter
	@Setter
	private String requirementFacilityId;
	/**
	 * Requirement Fixed Asset Id
	 */
	@Getter
	@Setter
	private String requirementFixedAssetId;
	/**
	 * Requirement Description
	 */
	@Getter
	@Setter
	private String requirementDescription;
	/**
	 * Requirement Creation Date
	 */
	@Getter
	@Setter
	private Timestamp requirementCreationDate;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Work Effort Type Id
	 */
	@Getter
	@Setter
	private String workEffortTypeId;
	/**
	 * Reserv Persons
	 */
	@Getter
	@Setter
	private BigDecimal reservPersons;
	/**
	 * Revision Number
	 */
	@Getter
	@Setter
	private Long revisionNumber;
	/**
	 * Temp Expr Id
	 */
	@Getter
	@Setter
	private String tempExprId;
	/**
	 * Show As Enum Id
	 */
	@Getter
	@Setter
	private String showAsEnumId;
	/**
	 * Info Url
	 */
	@Getter
	@Setter
	private String infoUrl;
	/**
	 * Universal Id
	 */
	@Getter
	@Setter
	private String universalId;
	/**
	 * Location Desc
	 */
	@Getter
	@Setter
	private String locationDesc;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Actual Milli Seconds
	 */
	@Getter
	@Setter
	private Double actualMilliSeconds;
	/**
	 * Quantity To Produce
	 */
	@Getter
	@Setter
	private BigDecimal quantityToProduce;
	/**
	 * Work Effort Purpose Type Id
	 */
	@Getter
	@Setter
	private String workEffortPurposeTypeId;
	/**
	 * Service Loader Name
	 */
	@Getter
	@Setter
	private String serviceLoaderName;
	/**
	 * Accommodation Spot Id
	 */
	@Getter
	@Setter
	private String accommodationSpotId;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Send Notification Email
	 */
	@Getter
	@Setter
	private String sendNotificationEmail;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;
	/**
	 * Quantity Rejected
	 */
	@Getter
	@Setter
	private BigDecimal quantityRejected;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private Long priority;
	/**
	 * Current Status Id
	 */
	@Getter
	@Setter
	private String currentStatusId;
	/**
	 * Runtime Data Id
	 */
	@Getter
	@Setter
	private String runtimeDataId;
	/**
	 * Estimated Milli Seconds
	 */
	@Getter
	@Setter
	private Double estimatedMilliSeconds;
	/**
	 * Special Terms
	 */
	@Getter
	@Setter
	private String specialTerms;
	/**
	 * Time Transparency
	 */
	@Getter
	@Setter
	private Long timeTransparency;
	/**
	 * Actual Completion Date
	 */
	@Getter
	@Setter
	private Timestamp actualCompletionDate;
	/**
	 * Reserv 2 Nd Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reserv2ndPPPerc;
	/**
	 * Total Money Allowed
	 */
	@Getter
	@Setter
	private BigDecimal totalMoneyAllowed;
	/**
	 * Estimate Calc Method
	 */
	@Getter
	@Setter
	private String estimateCalcMethod;
	/**
	 * Work Effort Parent Id
	 */
	@Getter
	@Setter
	private String workEffortParentId;
	/**
	 * Money Uom Id
	 */
	@Getter
	@Setter
	private String moneyUomId;
	/**
	 * Reserv Nth Pp Perc
	 */
	@Getter
	@Setter
	private BigDecimal reservNthPPPerc;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Accommodation Map Id
	 */
	@Getter
	@Setter
	private String accommodationMapId;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Scope Enum Id
	 */
	@Getter
	@Setter
	private String scopeEnumId;
	/**
	 * Quantity Produced
	 */
	@Getter
	@Setter
	private BigDecimal quantityProduced;
	/**
	 * Estimated Setup Millis
	 */
	@Getter
	@Setter
	private Double estimatedSetupMillis;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Source Reference Id
	 */
	@Getter
	@Setter
	private String sourceReferenceId;
	/**
	 * Last Status Update
	 */
	@Getter
	@Setter
	private Timestamp lastStatusUpdate;
	/**
	 * Percent Complete
	 */
	@Getter
	@Setter
	private Long percentComplete;
	/**
	 * Total Milli Seconds Allowed
	 */
	@Getter
	@Setter
	private Double totalMilliSecondsAllowed;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Actual Setup Millis
	 */
	@Getter
	@Setter
	private Double actualSetupMillis;
	/**
	 * Estimated Completion Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCompletionDate;
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
	 * Estimated Budget
	 */
	@Getter
	@Setter
	private BigDecimal estimatedBudget;
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Deliverable Id
	 */
	@Getter
	@Setter
	private String deliverableId;

	public enum Fields {
		workEffortDescription, workEffortFixedAssetId, workEffortFacilityId, requirementFacilityId, requirementFixedAssetId, requirementDescription, requirementCreationDate, workEffortId, recurrenceInfoId, workEffortTypeId, reservPersons, revisionNumber, tempExprId, showAsEnumId, infoUrl, universalId, locationDesc, createdByUserLogin, actualMilliSeconds, quantityToProduce, workEffortPurposeTypeId, serviceLoaderName, accommodationSpotId, estimatedStartDate, sendNotificationEmail, noteId, quantityRejected, priority, currentStatusId, runtimeDataId, estimatedMilliSeconds, specialTerms, timeTransparency, actualCompletionDate, reserv2ndPPPerc, totalMoneyAllowed, estimateCalcMethod, workEffortParentId, moneyUomId, reservNthPPPerc, workEffortName, lastModifiedByUserLogin, accommodationMapId, actualStartDate, scopeEnumId, quantityProduced, estimatedSetupMillis, lastModifiedDate, sourceReferenceId, lastStatusUpdate, percentComplete, totalMilliSecondsAllowed, createdDate, actualSetupMillis, estimatedCompletionDate, workReqFulfTypeId, requirementId, reason, quantity, productId, estimatedBudget, requiredByDate, requirementStartDate, requirementTypeId, useCase, statusId, deliverableId
	}

	public WorkEffortAndFulfillment(GenericValue value) {
		workEffortDescription = (String) value.get(Fields.workEffortDescription
				.name());
		workEffortFixedAssetId = (String) value
				.get(Fields.workEffortFixedAssetId.name());
		workEffortFacilityId = (String) value.get(Fields.workEffortFacilityId
				.name());
		requirementFacilityId = (String) value.get(Fields.requirementFacilityId
				.name());
		requirementFixedAssetId = (String) value
				.get(Fields.requirementFixedAssetId.name());
		requirementDescription = (String) value
				.get(Fields.requirementDescription.name());
		requirementCreationDate = (Timestamp) value
				.get(Fields.requirementCreationDate.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		workEffortTypeId = (String) value.get(Fields.workEffortTypeId.name());
		reservPersons = (BigDecimal) value.get(Fields.reservPersons.name());
		revisionNumber = (Long) value.get(Fields.revisionNumber.name());
		tempExprId = (String) value.get(Fields.tempExprId.name());
		showAsEnumId = (String) value.get(Fields.showAsEnumId.name());
		infoUrl = (String) value.get(Fields.infoUrl.name());
		universalId = (String) value.get(Fields.universalId.name());
		locationDesc = (String) value.get(Fields.locationDesc.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		actualMilliSeconds = (Double) value.get(Fields.actualMilliSeconds
				.name());
		quantityToProduce = (BigDecimal) value.get(Fields.quantityToProduce
				.name());
		workEffortPurposeTypeId = (String) value
				.get(Fields.workEffortPurposeTypeId.name());
		serviceLoaderName = (String) value.get(Fields.serviceLoaderName.name());
		accommodationSpotId = (String) value.get(Fields.accommodationSpotId
				.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		sendNotificationEmail = (String) value.get(Fields.sendNotificationEmail
				.name());
		noteId = (String) value.get(Fields.noteId.name());
		quantityRejected = (BigDecimal) value.get(Fields.quantityRejected
				.name());
		priority = (Long) value.get(Fields.priority.name());
		currentStatusId = (String) value.get(Fields.currentStatusId.name());
		runtimeDataId = (String) value.get(Fields.runtimeDataId.name());
		estimatedMilliSeconds = (Double) value.get(Fields.estimatedMilliSeconds
				.name());
		specialTerms = (String) value.get(Fields.specialTerms.name());
		timeTransparency = (Long) value.get(Fields.timeTransparency.name());
		actualCompletionDate = (Timestamp) value
				.get(Fields.actualCompletionDate.name());
		reserv2ndPPPerc = (BigDecimal) value.get(Fields.reserv2ndPPPerc.name());
		totalMoneyAllowed = (BigDecimal) value.get(Fields.totalMoneyAllowed
				.name());
		estimateCalcMethod = (String) value.get(Fields.estimateCalcMethod
				.name());
		workEffortParentId = (String) value.get(Fields.workEffortParentId
				.name());
		moneyUomId = (String) value.get(Fields.moneyUomId.name());
		reservNthPPPerc = (BigDecimal) value.get(Fields.reservNthPPPerc.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		accommodationMapId = (String) value.get(Fields.accommodationMapId
				.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		scopeEnumId = (String) value.get(Fields.scopeEnumId.name());
		quantityProduced = (BigDecimal) value.get(Fields.quantityProduced
				.name());
		estimatedSetupMillis = (Double) value.get(Fields.estimatedSetupMillis
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		sourceReferenceId = (String) value.get(Fields.sourceReferenceId.name());
		lastStatusUpdate = (Timestamp) value
				.get(Fields.lastStatusUpdate.name());
		percentComplete = (Long) value.get(Fields.percentComplete.name());
		totalMilliSecondsAllowed = (Double) value
				.get(Fields.totalMilliSecondsAllowed.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		actualSetupMillis = (Double) value.get(Fields.actualSetupMillis.name());
		estimatedCompletionDate = (Timestamp) value
				.get(Fields.estimatedCompletionDate.name());
		workReqFulfTypeId = (String) value.get(Fields.workReqFulfTypeId.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		reason = (String) value.get(Fields.reason.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		productId = (String) value.get(Fields.productId.name());
		estimatedBudget = (BigDecimal) value.get(Fields.estimatedBudget.name());
		requiredByDate = (Timestamp) value.get(Fields.requiredByDate.name());
		requirementStartDate = (Timestamp) value
				.get(Fields.requirementStartDate.name());
		requirementTypeId = (String) value.get(Fields.requirementTypeId.name());
		useCase = (String) value.get(Fields.useCase.name());
		statusId = (String) value.get(Fields.statusId.name());
		deliverableId = (String) value.get(Fields.deliverableId.name());
	}

	public static WorkEffortAndFulfillment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortAndFulfillment(value);
	}

	public static List<WorkEffortAndFulfillment> fromValues(
			List<GenericValue> values) {
		List<WorkEffortAndFulfillment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortAndFulfillment(value));
		}
		return entities;
	}
}